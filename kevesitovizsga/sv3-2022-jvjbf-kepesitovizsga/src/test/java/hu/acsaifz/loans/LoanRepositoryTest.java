package hu.acsaifz.loans;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LoanRepositoryTest {

    Flyway flyway;
    LoanRepository repository;

    @BeforeEach
    void init() {
        MariaDbDataSource dataSource = new MariaDbDataSource();
        try {
            dataSource.setUrl("jdbc:mariadb://localhost:3306/exam-test?useUnicode=true");
            dataSource.setUser("teszt");
            dataSource.setPassword("teszt");
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot reach DataBase!", sqle);
        }

        flyway = Flyway.configure().cleanDisabled(false).dataSource(dataSource).load();
        flyway.clean();
        flyway.migrate();

        repository = new LoanRepository(dataSource);
    }

    @Test
    void testInsertAndGetById() {

        long id = repository.insertLoan("John Doe", 1_200_000, 5.1);

        Loan loan = repository.findLoanById(id);

        assertEquals(id, loan.getId());
        assertEquals("John Doe", loan.getName());
        assertEquals(1_200_000, loan.getDebt());
        assertEquals(5.1, loan.getInterest());
    }

    @Test
    void testUpdateDebtWithInterest() {
        long id = repository.insertLoan("John Doe", 1_200_000, 5.1);
        long id2 = repository.insertLoan("John Doe", 1_300_000, 4.9);

        repository.updateDebtWithInterest();

        Loan loan1 = repository.findLoanById(id);
        Loan loan2 = repository.findLoanById(id2);

        assertEquals(1_261_200, loan1.getDebt());
        assertEquals(1_363_700, loan2.getDebt());
    }

    @Test
    void testUpdateDebtWithPayment() {
        long id = repository.insertLoan("John Doe", 1_200_000, 5.1);
        long id2 = repository.insertLoan("John Doe", 1_300_000, 4.9);

        repository.updateDebtWithPayment(id, 200_000);

        assertEquals(1_000_000, repository.findLoanById(id).getDebt());
        assertEquals(1_300_000, repository.findLoanById(id2).getDebt());
    }

}
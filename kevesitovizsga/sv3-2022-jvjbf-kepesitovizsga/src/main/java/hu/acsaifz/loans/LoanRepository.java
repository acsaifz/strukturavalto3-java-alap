package hu.acsaifz.loans;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

public class LoanRepository {
    private JdbcTemplate jdbcTemplate;

    public LoanRepository(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public long insertLoan(String name, int debt, double interest){
        KeyHolder holder = new GeneratedKeyHolder();

        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement("INSERT INTO `loans` (`name`, `debt`, `interest`) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, name);
            ps.setInt(2, debt);
            ps.setDouble(3, interest);

            return ps;
        }, holder);

        return holder.getKey().longValue();
    }

    public Loan findLoanById(long id){
        List<Loan> result = jdbcTemplate.query("SELECT * FROM `loans` WHERE `id` = ?", new LoanMapper(), id);

        return result.get(0);
    }

    public void updateDebtWithInterest(){
        jdbcTemplate.update("UPDATE `loans` SET `debt` = `debt`*(1+`interest`/100)");
    }

    public void updateDebtWithPayment(long id, int amount){
        jdbcTemplate.update("UPDATE `loans` SET `debt` = `debt` - ? WHERE id = ?", ps -> {
            ps.setInt(1, amount);
            ps.setLong(2, id);
        });
    }

}

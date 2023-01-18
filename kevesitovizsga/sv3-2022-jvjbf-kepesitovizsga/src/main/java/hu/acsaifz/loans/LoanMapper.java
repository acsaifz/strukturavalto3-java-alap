package hu.acsaifz.loans;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoanMapper implements RowMapper<Loan> {

    @Override
    public Loan mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Loan(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getInt("debt"),
                rs.getDouble("interest")
        );
    }
}

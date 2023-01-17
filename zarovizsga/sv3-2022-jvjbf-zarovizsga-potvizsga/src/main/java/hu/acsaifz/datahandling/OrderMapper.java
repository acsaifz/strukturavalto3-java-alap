package hu.acsaifz.datahandling;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderMapper implements RowMapper<Order> {
    @Override
    public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Order(
                rs.getLong("id"),
                rs.getString("product_name"),
                rs.getInt("product_count"),
                rs.getInt("price_per_product")
        );
    }
}

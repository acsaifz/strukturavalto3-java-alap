package hu.acsaifz.datahandling;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

public class OrderRepository {
    private final JdbcTemplate jdbcTemplate;

    public OrderRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Long saveOrder(Order order) {
        KeyHolder holder = new GeneratedKeyHolder();

        jdbcTemplate.update(con -> {
           PreparedStatement ps =
                   con.prepareStatement("INSERT INTO orders(product_name, product_count, price_per_product) VALUES(?,?,?)",
                           Statement.RETURN_GENERATED_KEYS);

           ps.setString(1, order.getProductName());
           ps.setInt(2, order.getProductCount());
           ps.setInt(3, order.getPricePerProduct());

           return ps;
        }, holder);

        return holder.getKey().longValue();
    }

    public List<Order> getOrders() {
        return jdbcTemplate.query("SELECT * FROM orders ORDER BY product_name", new OrderMapper());
    }

    public int getMostExpensiveOrderPrice() {
        return jdbcTemplate.queryForObject("SELECT MAX(product_count * price_per_product) as max_order_price FROM orders", (rs, rowNum) -> rs.getInt("max_order_price"));
    }
}

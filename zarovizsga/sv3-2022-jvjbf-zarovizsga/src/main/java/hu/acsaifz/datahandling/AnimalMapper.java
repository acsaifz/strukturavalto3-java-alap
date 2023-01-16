package hu.acsaifz.datahandling;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AnimalMapper implements RowMapper<Animal> {
    @Override
    public Animal mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Animal(
                rs.getLong("id"),
                rs.getString("animal_type"),
                rs.getInt("count_of_animal"),
                rs.getDate("date_of_observation").toLocalDate()
        );
    }
}

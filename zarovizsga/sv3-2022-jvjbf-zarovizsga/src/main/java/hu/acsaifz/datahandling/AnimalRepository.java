package hu.acsaifz.datahandling;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Date;
import java.util.List;

public class AnimalRepository {
    private final JdbcTemplate jdbcTemplate;

    public AnimalRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    public void saveAnimal(Animal animal) {
        jdbcTemplate.update("INSERT INTO animals(animal_type, count_of_animal, date_of_observation) VALUES (?,?,?) ", ps -> {
            ps.setString(1, animal.getAnimalType());
            ps.setInt(2, animal.getCountOfAnimal());
            ps.setDate(3, Date.valueOf(animal.getDateOfObservation()));
        });
    }

    public List<Animal> findAllAnimals() {
        return jdbcTemplate.query("SELECT * FROM animals", new AnimalMapper());
    }

    public int countAllByAnimalType(String animalType) {
        Integer result = jdbcTemplate.queryForObject("SELECT SUM(count_of_animal) as sum FROM animals WHERE animal_type = ?",
                (rs,rowNum) -> rs.getInt("sum"), animalType
                );

        if (result == null || result == 0){
            throw new IllegalArgumentException("No animal found!");
        }

        return result;
    }
}

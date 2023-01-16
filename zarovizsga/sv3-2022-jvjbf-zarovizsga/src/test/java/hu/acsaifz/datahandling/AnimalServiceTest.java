package hu.acsaifz.datahandling;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AnimalServiceTest {

    AnimalService animalService;

    @BeforeEach
    void init() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/exam");
        dataSource.setUser("teszt");
        dataSource.setPassword("teszt");

        Flyway flyway = Flyway.configure().cleanDisabled(false).dataSource(dataSource).load();

        flyway.clean();
        flyway.migrate();

        AnimalRepository animalRepository = new AnimalRepository(dataSource);
        animalService = new AnimalService(animalRepository);
    }

    @Test
    void testSaveAnimals() {
        IllegalStateException ise = assertThrows(IllegalStateException.class, () -> animalService.saveAnimals(Path.of("xyz.csv")));
        assertEquals("Cannot reach file!", ise.getMessage());
    }

    @Test
    void testSaveAndFindAnimals() {
        animalService.saveAnimals(Path.of("src/test/resources/input.csv"));

        assertEquals(6, animalService.findAllAnimals().size());
    }

    @Test
    void testCountAllAnimals() {
        animalService.saveAnimals(Path.of("src/test/resources/input.csv"));

        assertEquals(26, animalService.countAllByAnimalType("Giraffe"));
    }
}

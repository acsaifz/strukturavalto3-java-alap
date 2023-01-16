/*
package hu.acsaifz.datahandling;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.nio.file.Path;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class AnimalServiceTest {

    AnimalService animalService;

    @BeforeEach
    void init() {
        MariaDbDataSource dataSource = new MariaDbDataSource();
        try{
            dataSource.setUrl("jdbc:mariadb://localhost:3306/mariadbtrainings?useUnicode=true");
            dataSource.setUser("training");
            dataSource.setPassword("training");
        }catch (SQLException se){
            throw new IllegalStateException("Cannot connect!", se);
        }

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
}*/

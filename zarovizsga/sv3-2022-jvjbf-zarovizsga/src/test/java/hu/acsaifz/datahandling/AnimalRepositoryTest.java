/*
package hu.acsaifz.datahandling;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AnimalRepositoryTest {

    AnimalRepository animalRepository;

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

        animalRepository = new AnimalRepository(dataSource);
    }


    @Test
    void testSaveAndGetAllAnimals() {
        animalRepository.saveAnimal(new Animal("Monkey", 12, LocalDate.of(2022, 11, 11)));

        List<Animal> animals = animalRepository.findAllAnimals();

        assertEquals(1, animals.size());
        assertEquals("Monkey", animals.get(0).getAnimalType());
    }

    @Test
    void testCountAllByAnimalType() {
        animalRepository.saveAnimal(new Animal("Monkey", 12, LocalDate.of(2022, 11, 11)));
        animalRepository.saveAnimal(new Animal("Giraffe", 11, LocalDate.of(2022, 11, 11)));
        animalRepository.saveAnimal(new Animal("Monkey", 13, LocalDate.of(2022, 11, 12)));

        int count = animalRepository.countAllByAnimalType("Monkey");

        assertEquals(25, count);
    }

    @Test
    void testCountByAnimalTypeWrongType() {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class,
                () -> animalRepository.countAllByAnimalType("Monkey"));
        assertEquals("No animal found!", iae.getMessage());
    }
}*/

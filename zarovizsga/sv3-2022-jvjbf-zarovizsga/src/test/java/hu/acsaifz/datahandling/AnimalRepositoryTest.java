package hu.acsaifz.datahandling;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AnimalRepositoryTest {

    AnimalRepository animalRepository;

    @BeforeEach
    void init() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/exam");
        dataSource.setUser("teszt");
        dataSource.setPassword("teszt");

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
}

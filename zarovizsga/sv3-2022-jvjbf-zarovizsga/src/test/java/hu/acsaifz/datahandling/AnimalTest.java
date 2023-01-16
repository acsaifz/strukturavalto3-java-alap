package hu.acsaifz.datahandling;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {

    @Test
    void testCreateAnimal() {
        Animal animal = new Animal("Monkey", 12, LocalDate.of(2022, 11, 11));

        assertEquals("Monkey", animal.getAnimalType());
        assertEquals(12, animal.getCountOfAnimal());
        assertEquals(LocalDate.of(2022, 11, 11), animal.getDateOfObservation());
    }
}

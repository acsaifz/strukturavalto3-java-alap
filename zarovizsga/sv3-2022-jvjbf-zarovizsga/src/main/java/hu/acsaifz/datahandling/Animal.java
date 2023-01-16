package hu.acsaifz.datahandling;

import java.time.LocalDate;

public class Animal {
    private long id;
    private String animalType;
    private int countOfAnimal;
    private LocalDate dateOfObservation;

    public Animal(String animalType, int countOfAnimal, LocalDate dateOfObservation) {
        this.animalType = animalType;
        this.countOfAnimal = countOfAnimal;
        this.dateOfObservation = dateOfObservation;
    }

    public Animal(long id, String animalType, int countOfAnimal, LocalDate dateOfObservation) {
        this.id = id;
        this.animalType = animalType;
        this.countOfAnimal = countOfAnimal;
        this.dateOfObservation = dateOfObservation;
    }

    public long getId() {
        return id;
    }

    public String getAnimalType() {
        return animalType;
    }

    public int getCountOfAnimal() {
        return countOfAnimal;
    }

    public LocalDate getDateOfObservation() {
        return dateOfObservation;
    }
}

package hu.acsaifz.datahandling;

import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AnimalService {
    private static final String CSV_SEPARATOR = ";";
    private AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository){
        this.animalRepository = animalRepository;
    }

    public List<Animal> findAllAnimals(){
        return animalRepository.findAllAnimals();
    }

    public void saveAnimals(Path path) {
        List<Animal> animals = loadFromFile(path);
        animals.forEach(animal -> animalRepository.saveAnimal(animal));
    }

    private List<Animal> loadFromFile(Path path) {
        try(Scanner scanner = new Scanner(path)) {
            List<Animal> result = new ArrayList<>();
            scanner.nextLine(); //Skip header

            while(scanner.hasNext()){
                result.add(processLine(scanner.nextLine()));
            }

            return result;
        } catch (IOException e) {
            throw new IllegalStateException("Cannot reach file!");
        }
    }

    private Animal processLine(String line) {
        String[] params = line.split(CSV_SEPARATOR);

        String animalType = params[0];
        int countOfAnimal = Integer.parseInt(params[1]);
        LocalDate dateOfObservation = LocalDate.parse(params[2]);

        return new Animal(animalType, countOfAnimal, dateOfObservation);
    }

    public int countAllByAnimalType(String animalType) {
        return animalRepository.countAllByAnimalType(animalType);
    }
}

package hu.acsaifz.oop;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Hotel {
    private Set<Apartment> rooms;

    public Hotel(Set<Apartment> rooms) {
        this.rooms = rooms;
    }

    public Set<Apartment> getRooms() {
        return rooms;
    }

    public void readBookings(Path path){
        try{
            List<String> bookings = Files.readAllLines(path);
            bookings
                    .stream()
                    .mapToInt(Integer::parseInt)
                    .forEach(this::bookRoom);
        } catch (IOException e) {
            throw new IllegalStateException("File not found.");
        }
    }

    public void bookRoom(int numberOfPeople){
        Apartment bookableRoom = rooms
                .stream()
                .filter(r -> r.getPeopleCanFit() >= numberOfPeople && r.isFree())
                .min(Comparator.comparingInt(Apartment::getPeopleCanFit))
                .orElseThrow(IllegalStateException::new);

        bookableRoom.rent();
    }

    public Set<Integer> getFreeRoomNumbers(){
        return rooms
                .stream()
                .filter(Apartment::isFree)
                .mapToInt(Apartment::getRoomNumber)
                .boxed()
                .collect(Collectors.toSet());
    }
}

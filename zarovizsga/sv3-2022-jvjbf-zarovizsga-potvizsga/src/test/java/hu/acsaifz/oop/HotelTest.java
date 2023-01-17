/*
package hu.acsaifz.oop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class HotelTest {

    Hotel hotel;

    @BeforeEach
    void init() {
        hotel = new Hotel(Set.of(
                new Apartment(123, 1),
                new HotelRoom(124, 3),
                new HotelRoom(125, 2),
                new HotelRoom(126, 3)
        ));
    }

    @Test
    void testCreateHotel() {
        assertEquals(4, hotel.getRooms().size());
    }

    @Test
    void testCreateHotelWithSameRoomNumber() {
        Set rooms = new HashSet();
        rooms.add(new Apartment(123, 1));
        rooms.add(new HotelRoom(123, 2));
        Hotel hotel = new Hotel(rooms);
        assertEquals(1, hotel.getRooms().size());
    }

    @Test
    void testReadBookings() {
        hotel.readBookings(Path.of("src/test/resources/input1.txt"));

        hotel.getRooms().stream()
                .forEach(
                        r -> assertFalse(r.isFree())
                );
    }

    @Test
    void testReadBookingsCantFit() {
        assertThrows(IllegalStateException.class,
                () -> hotel.readBookings(Path.of("src/test/resources/inputWrong.txt")));

    }

    @Test
    void testReadBookingsCorrectRoom() {
        hotel.readBookings(Path.of("src/test/resources/input2.txt"));

        assertFalse(hotel.getRooms().stream().filter(r -> r.getRoomNumber() == 123).toList().get(0).isFree());
        assertFalse(hotel.getRooms().stream().filter(r -> r.getRoomNumber() == 125).toList().get(0).isFree());
        assertTrue(hotel.getRooms().stream().filter(r -> r.getRoomNumber() == 124).toList().get(0).isFree());
        assertTrue(hotel.getRooms().stream().filter(r -> r.getRoomNumber() == 126).toList().get(0).isFree());
    }

    @Test
    void testReadBookingsCannotReachFile() {
        assertThrows(IllegalStateException.class,
                () -> hotel.readBookings(Path.of("input.txt")));
    }

    @Test
    void testGetFreeRoomNumbers() {
        hotel.readBookings(Path.of("src/test/resources/input2.txt"));

        assertEquals(List.of(124, 126), hotel.getFreeRoomNumbers().stream().sorted().toList());
    }
}*/

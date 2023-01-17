package hu.acsaifz.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HotelRoomTest {

    @Test
    void testCreateHotelRoomAsApartment() {
        Apartment apartment = new HotelRoom(12, 3);

        assertEquals(12, apartment.getRoomNumber());
        assertEquals(3, apartment.getPeopleCanFit());
        assertTrue(apartment.isFree());
        assertEquals(FoodServiceType.BREAKFAST, apartment.getFoodServiceType());
    }

    @Test
    void testCreateHotelRoomWithWrongPeople() {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class,
                () -> new HotelRoom(12, 4));
        assertEquals("Cannot create room with people:4", iae.getMessage());
    }

    @Test
    void testGetPrice() {
        Apartment apartment = new HotelRoom(12, 2);

        assertEquals(20_000, apartment.getPrice());
    }

    @Test
    void testGetPriceAfterUpgrade() {
        Apartment apartment = new HotelRoom(12, 2);

        apartment.upgradeService(FoodServiceType.ALL_INCLUSIVE);

        assertEquals(40_000, apartment.getPrice());

    }
}

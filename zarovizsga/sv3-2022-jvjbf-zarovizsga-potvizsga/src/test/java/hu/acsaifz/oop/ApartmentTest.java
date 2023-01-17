package hu.acsaifz.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ApartmentTest {

    Apartment apartment = new Apartment(12, 2);

    @Test
    void testCreateApartment() {
        assertEquals(12, apartment.getRoomNumber());
        assertEquals(2, apartment.getPeopleCanFit());
        assertTrue(apartment.isFree());
        assertEquals(FoodServiceType.BREAKFAST, apartment.getFoodServiceType());
    }

    @Test
    void testUpgradeFoodService() {

        apartment.upgradeService(FoodServiceType.BREAKFAST_DINNER);

        assertEquals(FoodServiceType.BREAKFAST_DINNER, apartment.getFoodServiceType());
    }

    @Test
    void testUpgradeForLower() {
        apartment.upgradeService(FoodServiceType.BREAKFAST_DINNER);

        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class,
                () -> apartment.upgradeService(FoodServiceType.BREAKFAST));
        assertEquals("Cannot upgrade lower or same!", iae.getMessage());
    }

    @Test
    void testUpgradeForSame() {
        apartment.upgradeService(FoodServiceType.ALL_INCLUSIVE);

        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class,
                () -> apartment.upgradeService(FoodServiceType.ALL_INCLUSIVE));
        assertEquals("Cannot upgrade lower or same!", iae.getMessage());
    }

    @Test
    void testGetPrice() {
        assertEquals(40_000, apartment.getPrice());
    }

    @Test
    void testGetPriceAfterUpgrade() {
        apartment.upgradeService(FoodServiceType.BREAKFAST_DINNER);

        assertEquals(50_000, apartment.getPrice());
    }

    @Test
    void testRent() {
        apartment.rent();

        assertFalse(apartment.isFree());
    }

    @Test
    void testRentNotFree() {
        apartment.rent();

        CantRentException cre = assertThrows(CantRentException.class, () -> apartment.rent());
        assertEquals("Not free!", cre.getMessage());
    }
}

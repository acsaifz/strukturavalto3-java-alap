package hu.acsaifz.oop;

public class HotelRoom extends Apartment{
    private static final int BASE_PRICE = 20_000;

    public HotelRoom(int roomNumber, int peopleCanFit) {
        super(roomNumber, peopleCanFit);
        validatePeopleCanFit(peopleCanFit);
    }

    private void validatePeopleCanFit(int peopleCanFit) {
        if (peopleCanFit > 3){
            throw new IllegalArgumentException("Cannot create room with people:" + peopleCanFit);
        }
    }

    @Override
    public int getPrice() {
        return BASE_PRICE + getFoodServiceType().getCharge();
    }
}

package hu.acsaifz.oop;

public class Apartment {
    private static final int BASE_PRICE = 40_000;
    private int roomNumber;
    private boolean free = true;
    private FoodServiceType foodServiceType = FoodServiceType.BREAKFAST;
    private int peopleCanFit;

    public Apartment(int roomNumber, int peopleCanFit) {
        this.roomNumber = roomNumber;
        this.peopleCanFit = peopleCanFit;
    }

    public void rent(){
        if (!free){
            throw new CantRentException("Not free!");
        }

        free = false;
    }

    public void upgradeService(FoodServiceType foodServiceType){
        if (this.foodServiceType.getCharge() < foodServiceType.getCharge()){
            this.foodServiceType = foodServiceType;
        } else {
            throw new IllegalArgumentException("Cannot upgrade lower or same!");
        }
    }

    public int getPrice(){
        return BASE_PRICE + foodServiceType.getCharge();
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public boolean isFree() {
        return free;
    }

    public FoodServiceType getFoodServiceType() {
        return foodServiceType;
    }

    public int getPeopleCanFit() {
        return peopleCanFit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Apartment apartment)) return false;

        return roomNumber == apartment.roomNumber;
    }

    @Override
    public int hashCode() {
        return roomNumber;
    }
}

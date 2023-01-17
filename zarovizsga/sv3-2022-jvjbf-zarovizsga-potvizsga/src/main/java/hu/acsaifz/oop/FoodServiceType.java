package hu.acsaifz.oop;

public enum FoodServiceType {
    BREAKFAST(0),
    BREAKFAST_DINNER(10_000),
    ALL_INCLUSIVE(20_000);

    private final int charge;

    FoodServiceType(int charge){
        this.charge = charge;
    }

    public int getCharge() {
        return charge;
    }
}

package hu.acsaifz.oop;

public enum StandingTicketType {
    FRONT_OF_STAGE(20),
    NORMAL(0);

    private final int percent;

    StandingTicketType(int percent){
        this.percent = percent;
    }

    public int getPercent() {
        return percent;
    }
}

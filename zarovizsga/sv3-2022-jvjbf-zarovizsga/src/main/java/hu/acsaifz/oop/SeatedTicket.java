package hu.acsaifz.oop;

public class SeatedTicket implements Ticket{
    private static final double MIN_PRICE = 2000.0;
    private BasicTicket basicTicket;
    private int row;
    private int seat;

    public SeatedTicket(BasicTicket basicTicket, int row, int seat) {
        this.basicTicket = basicTicket;
        this.row = row;
        this.seat = seat;
    }

    @Override
    public BasicTicket getBasicTicket() {
        return basicTicket;
    }

    @Override
    public double getPrice() {
        int discount = row/10*10;
        double price = basicTicket.getPrice() * (100 - discount)/100.0;
        return Math.max(price, MIN_PRICE);
    }

    public int getRow() {
        return row;
    }

    public int getSeat() {
        return seat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SeatedTicket that = (SeatedTicket) o;

        if (row != that.row) return false;
        if (seat != that.seat) return false;
        return basicTicket.equals(that.basicTicket);
    }

    @Override
    public int hashCode() {
        int result = basicTicket.hashCode();
        result = 31 * result + row;
        result = 31 * result + seat;
        return result;
    }
}

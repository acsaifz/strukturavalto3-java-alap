package hu.acsaifz.oop;

import java.time.LocalDateTime;

public class BasicTicket {
    private String event;
    private LocalDateTime date;
    private int price;

    public BasicTicket(String event, LocalDateTime date, int price) {
        this.event = event;
        this.date = date;
        this.price = price;
    }

    public String getEvent() {
        return event;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BasicTicket that = (BasicTicket) o;

        return event.equals(that.event);
    }

    @Override
    public int hashCode() {
        return event.hashCode();
    }
}

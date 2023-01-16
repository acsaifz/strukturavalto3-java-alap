package hu.acsaifz.oop;

public class StandingTicket implements Ticket{
    private BasicTicket basicTicket;
    private StandingTicketType ticketType;

    public StandingTicket(BasicTicket basicTicket, StandingTicketType ticketType) {
        this.basicTicket = basicTicket;
        this.ticketType = ticketType;
    }

    @Override
    public BasicTicket getBasicTicket() {
        return basicTicket;
    }

    @Override
    public double getPrice() {
        return basicTicket.getPrice() * (100 + ticketType.getPercent())/100.0;
    }

    public StandingTicketType getTicketType() {
        return ticketType;
    }
}

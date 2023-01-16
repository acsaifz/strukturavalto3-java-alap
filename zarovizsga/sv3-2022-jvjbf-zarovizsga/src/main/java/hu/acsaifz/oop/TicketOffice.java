package hu.acsaifz.oop;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class TicketOffice {
    private Set<Ticket> tickets = new HashSet<>();

    public void addTicket(Ticket ticket){
        tickets.add(ticket);
    }

    public Set<Ticket> getTickets() {
        return tickets;
    }

    public Ticket sellTicket(String event, int maxPrice){
        Ticket result = tickets
                .stream()
                .filter(t -> t.getBasicTicket().getEvent().equals(event) && t.getPrice() <= maxPrice)
                .max(Comparator.comparingDouble(Ticket::getPrice))
                .orElseThrow(() -> new NoTicketWithTheseParametersException("No ticket!"));

        tickets.remove(result);

        return result;
    }

    public Map<BasicTicket, Integer> collectTicketCountByEvent() {
        return tickets
                .stream()
                .collect(Collectors.groupingBy(Ticket::getBasicTicket, Collectors.summingInt(n -> 1)));
    }

    public Set<String> getEventsByDate(LocalDate date) {
        return tickets
                .stream()
                .filter(ticket -> ticket.getBasicTicket().getDate().toLocalDate().equals(date))
                .map(ticket -> ticket.getBasicTicket().getEvent()).collect(Collectors.toSet());
    }
}

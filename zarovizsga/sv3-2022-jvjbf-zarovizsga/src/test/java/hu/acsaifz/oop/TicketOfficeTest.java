package hu.acsaifz.oop;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class TicketOfficeTest {

    TicketOffice ticketOffice = new TicketOffice();
    BasicTicket basicTicket = new BasicTicket("Metallica", LocalDateTime.of(2023, 10, 11, 19, 30), 30_000);
    BasicTicket basicTicket2 = new BasicTicket("RHCP", LocalDateTime.of(2023, 10, 12, 19, 30), 28_000);
    BasicTicket basicTicket3 = new BasicTicket("Iron Maiden", LocalDateTime.of(2023, 10, 11, 18, 30), 28_000);

    @Test
    void createTicketOffice() {
        assertEquals(0, ticketOffice.getTickets().size());
    }

    @Test
    void testAddTicket() {
        ticketOffice.addTicket(new StandingTicket(basicTicket, StandingTicketType.NORMAL));
        ticketOffice.addTicket(new SeatedTicket(basicTicket, 12, 11));

        assertEquals(2, ticketOffice.getTickets().size());
    }

    @Test
    void testAddTicketSameStanding() {
        ticketOffice.addTicket(new StandingTicket(basicTicket, StandingTicketType.FRONT_OF_STAGE));
        ticketOffice.addTicket(new StandingTicket(basicTicket, StandingTicketType.FRONT_OF_STAGE));

        assertEquals(2, ticketOffice.getTickets().size());
    }

    @Test
    void testAddTicketSameEventDifferentSeat() {
        ticketOffice.addTicket(new SeatedTicket(basicTicket, 12, 11));
        ticketOffice.addTicket(new SeatedTicket(basicTicket, 12, 12));

        assertEquals(2, ticketOffice.getTickets().size());
    }

    @Test
    void testAddTicketDifferentEventSameSeat() {
        ticketOffice.addTicket(new SeatedTicket(basicTicket, 10, 11));
        ticketOffice.addTicket(new SeatedTicket(basicTicket2, 10, 11));

        assertEquals(2, ticketOffice.getTickets().size());
    }

    @Test
    void testAddTicketSameEventSameSeat() {
        ticketOffice.addTicket(new SeatedTicket(basicTicket, 10, 11));
        ticketOffice.addTicket(new SeatedTicket(basicTicket, 10, 11));

        assertEquals(1, ticketOffice.getTickets().size());
    }

    @Test
    void testSellTicketOnMaxPrice() {
        ticketOffice.addTicket(new SeatedTicket(basicTicket, 13, 11));
        ticketOffice.addTicket(new SeatedTicket(basicTicket, 9, 12));
        ticketOffice.addTicket(new StandingTicket(basicTicket2, StandingTicketType.FRONT_OF_STAGE));
        ticketOffice.addTicket(new StandingTicket(basicTicket, StandingTicketType.FRONT_OF_STAGE));

        Ticket result = ticketOffice.sellTicket("Metallica", 36_000);

        assertEquals("Metallica", result.getBasicTicket().getEvent());
        assertEquals(StandingTicketType.FRONT_OF_STAGE, ((StandingTicket) result).getTicketType());

        assertEquals(3, ticketOffice.getTickets().size());

    }

    @Test
    void testSellTicketNotOnMaxPrice() {
        ticketOffice.addTicket(new SeatedTicket(basicTicket, 13, 11));
        ticketOffice.addTicket(new SeatedTicket(basicTicket, 9, 12));
        ticketOffice.addTicket(new StandingTicket(basicTicket2, StandingTicketType.FRONT_OF_STAGE));
        ticketOffice.addTicket(new StandingTicket(basicTicket, StandingTicketType.FRONT_OF_STAGE));

        Ticket result = ticketOffice.sellTicket("Metallica", 32_000);

        assertEquals("Metallica", result.getBasicTicket().getEvent());
        assertEquals(9, ((SeatedTicket) result).getRow());

        assertEquals(3, ticketOffice.getTickets().size());

    }

    @Test
    void testSellTicketCheapestInSet() {
        ticketOffice.addTicket(new SeatedTicket(basicTicket, 13, 11));
        ticketOffice.addTicket(new SeatedTicket(basicTicket, 9, 12));
        ticketOffice.addTicket(new StandingTicket(basicTicket2, StandingTicketType.FRONT_OF_STAGE));
        ticketOffice.addTicket(new StandingTicket(basicTicket, StandingTicketType.FRONT_OF_STAGE));
        ticketOffice.addTicket(new SeatedTicket(basicTicket2, 5, 10));

        Ticket result = ticketOffice.sellTicket("Metallica", 28_000);

        assertEquals("Metallica", result.getBasicTicket().getEvent());
        assertEquals(13, ((SeatedTicket) result).getRow());

        assertEquals(4, ticketOffice.getTickets().size());
    }

    @Test
    void testSellTicketNoTicketForPrice() {
        ticketOffice.addTicket(new SeatedTicket(basicTicket, 13, 11));
        ticketOffice.addTicket(new SeatedTicket(basicTicket, 9, 12));
        ticketOffice.addTicket(new StandingTicket(basicTicket2, StandingTicketType.FRONT_OF_STAGE));
        ticketOffice.addTicket(new StandingTicket(basicTicket, StandingTicketType.FRONT_OF_STAGE));

        NoTicketWithTheseParametersException ntwtpe = assertThrows(NoTicketWithTheseParametersException.class,
                () -> ticketOffice.sellTicket("Metallica", 26_999));

        assertEquals(ntwtpe.getMessage(), "No ticket!");

        assertEquals(4, ticketOffice.getTickets().size());
    }

    @Test
    void testSellTicketNoTicketForEvent() {
        ticketOffice.addTicket(new SeatedTicket(basicTicket, 13, 11));
        NoTicketWithTheseParametersException ntwtpe = assertThrows(NoTicketWithTheseParametersException.class,
                () -> ticketOffice.sellTicket("RHCP", 28_000));

        assertEquals(ntwtpe.getMessage(), "No ticket!");

        assertEquals(1, ticketOffice.getTickets().size());
    }

    @Test
    void testCollectTicketCountByEvent() {
        ticketOffice.addTicket(new SeatedTicket(basicTicket, 13, 11));
        ticketOffice.addTicket(new SeatedTicket(basicTicket, 9, 12));
        ticketOffice.addTicket(new StandingTicket(basicTicket2, StandingTicketType.FRONT_OF_STAGE));
        ticketOffice.addTicket(new StandingTicket(basicTicket, StandingTicketType.FRONT_OF_STAGE));
        ticketOffice.addTicket(new SeatedTicket(basicTicket2, 5, 10));

        Map<BasicTicket, Integer> result = ticketOffice.collectTicketCountByEvent();

        assertEquals(2, result.keySet().size());

        assertEquals(List.of("Metallica", "RHCP"),
                result.keySet().stream().map(BasicTicket::getEvent).sorted().collect(Collectors.toList()));
    }

    @Test
    void testGetEventsByDate() {
        ticketOffice.addTicket(new SeatedTicket(basicTicket, 12, 23));
        ticketOffice.addTicket(new SeatedTicket(basicTicket2, 13, 13));
        ticketOffice.addTicket(new SeatedTicket(basicTicket3, 20, 1));

        Set<String> result = ticketOffice.getEventsByDate(LocalDate.of(2023, 10, 11));

        assertEquals(Set.of("Iron Maiden", "Metallica"), result);
    }

    @Test
    void testGetEventsByDateNoEvent() {
        ticketOffice.addTicket(new SeatedTicket(basicTicket, 12, 23));
        ticketOffice.addTicket(new SeatedTicket(basicTicket2, 13, 13));
        ticketOffice.addTicket(new SeatedTicket(basicTicket3, 20, 1));

        Set<String> result = ticketOffice.getEventsByDate(LocalDate.of(2023, 11, 11));

        assertTrue(result.isEmpty());
    }
}
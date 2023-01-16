package hu.acsaifz.oop;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class StandingTicketTest {

    BasicTicket basicTicket = new BasicTicket("Metallica", LocalDateTime.of(2023, 10, 11, 19, 30), 30_000);

    @Test
    void testCreateStandingAsTicket() {
        Ticket ticket = new StandingTicket(basicTicket, StandingTicketType.NORMAL);

        assertEquals("Metallica", ticket.getBasicTicket().getEvent());
    }

    @Test
    void testGetPriceNormal() {
        Ticket ticket = new StandingTicket(basicTicket, StandingTicketType.NORMAL);

        assertEquals(30_000.0, ticket.getPrice());
    }

    @Test
    void testGetPriceFrontOfStage() {
        Ticket ticket = new StandingTicket(basicTicket, StandingTicketType.FRONT_OF_STAGE);

        assertEquals(36_000.0, ticket.getPrice());
    }

    @Test
    void testGetPriceFrontOfStageRound() {
        BasicTicket basicTicket = new BasicTicket("RHCP", LocalDateTime.of(2023, 10, 12, 19, 30), 26942);
        Ticket ticket = new StandingTicket(basicTicket, StandingTicketType.FRONT_OF_STAGE);

        assertEquals(32330.4, ticket.getPrice(), 0.0001);
    }
}

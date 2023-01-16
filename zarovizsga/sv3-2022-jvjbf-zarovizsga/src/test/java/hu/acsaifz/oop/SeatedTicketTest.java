//package hu.acsaifz.oop;
//
//import org.junit.jupiter.api.Test;
//
//import java.time.LocalDateTime;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class SeatedTicketTest {
//
//    BasicTicket basicTicket = new BasicTicket("Metallica", LocalDateTime.of(2023, 10, 11, 19, 30), 30_000);
//
//    @Test
//    void createSeatedTicketAsTicket() {
//        Ticket ticket = new SeatedTicket(basicTicket, 6, 12);
//
//        assertEquals("Metallica", ticket.getBasicTicket().getEvent());
//    }
//
//    @Test
//    void testGetPriceNormalPrice() {
//        Ticket ticket = new SeatedTicket(basicTicket, 6, 12);
//
//        assertEquals(30_000, ticket.getPrice());
//    }
//
//    @Test
//    void testGetPriceTePercentOff() {
//        Ticket ticket = new SeatedTicket(basicTicket, 13, 11);
//
//        assertEquals(27_000.0, ticket.getPrice());
//    }
//
//    @Test
//    void testGetPriceThirtyPercentOff() {
//        Ticket ticket = new SeatedTicket(basicTicket, 30, 76);
//
//        assertEquals(21_000.0, ticket.getPrice());
//    }
//
//    @Test
//    void testGetPriceMorePercentThanBasicPrice() {
//        BasicTicket basicTicket = new BasicTicket("RHCP", LocalDateTime.of(2023, 10, 12, 19, 30), 12_000);
//
//        Ticket ticket = new SeatedTicket(basicTicket, 92, 12);
//
//        assertEquals(2_000.0, ticket.getPrice());
//    }
//}
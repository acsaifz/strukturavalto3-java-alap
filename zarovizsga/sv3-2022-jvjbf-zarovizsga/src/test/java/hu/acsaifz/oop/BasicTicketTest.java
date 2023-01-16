//package hu.acsaifz.oop;
//
//import org.junit.jupiter.api.Test;
//
//import java.time.LocalDateTime;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class BasicTicketTest {
//
//    @Test
//    void testCreateBasicTicket() {
//        BasicTicket basicTicket = new BasicTicket("Metallica", LocalDateTime.of(2023, 10, 11, 19, 30), 30_000);
//
//        assertEquals("Metallica", basicTicket.getEvent());
//        assertEquals(LocalDateTime.of(2023, 10, 11, 19, 30), basicTicket.getDate());
//        assertEquals(30_000, basicTicket.getPrice());
//    }
//}
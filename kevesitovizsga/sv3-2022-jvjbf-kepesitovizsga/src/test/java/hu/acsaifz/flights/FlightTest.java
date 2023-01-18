package hu.acsaifz.flights;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FlightTest {

    @Test
    void createFlightTest() {
        Flight flight = new Flight("KLM", "Budapest", "Amsterdam", 132);

        assertEquals("KLM", flight.getAirline());
        assertEquals("Budapest", flight.getDeparture());
        assertEquals("Amsterdam", flight.getArrival());
        assertEquals(132, flight.getNumberOfPassengers());
    }
}
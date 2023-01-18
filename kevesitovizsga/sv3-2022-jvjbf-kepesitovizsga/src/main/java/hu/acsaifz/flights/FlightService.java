package hu.acsaifz.flights;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FlightService {
    private static final String CSV_SEPARATOR = ";";
    private static final String DEPARTURE_ARRIVAL_SEPARATOR = "-";
    List<Flight> flights = new ArrayList<>();
    public FlightService(Path path){
        loadFlightsFromFile(path);
    }

    private void loadFlightsFromFile(Path path) {
        try (Scanner scanner = new Scanner(path)){
            scanner.nextLine(); // skip header
            while(scanner.hasNext()){
                Flight actualFlight = processLine(scanner.nextLine());
                flights.add(actualFlight);
            }
        } catch (IOException e) {
            throw new IllegalStateException("File not found.");
        }
    }

    private Flight processLine(String nextLine) {
        String[] params = nextLine.split(CSV_SEPARATOR);

        String airline = params[0];
        String[] departureAndArrival = params[1].split(DEPARTURE_ARRIVAL_SEPARATOR);
        String departure = departureAndArrival[0];
        String arrival = departureAndArrival[1];
        int numberOfPassengers = Integer.parseInt(params[2]);

        return new Flight(airline, departure, arrival, numberOfPassengers);
    }

    public List<Flight> getFlights() {
        return List.copyOf(flights);
    }

    public int sumOfPassengersByAirline(String airline) {
        return flights
                .stream()
                .filter(flight -> flight.getAirline().equals(airline))
                .mapToInt(Flight::getNumberOfPassengers)
                .sum();
    }
}

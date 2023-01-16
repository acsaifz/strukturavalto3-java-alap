package hu.acsaifz.oop;

public class NoTicketWithTheseParametersException extends RuntimeException{
    public NoTicketWithTheseParametersException(String message) {
        super(message);
    }
}

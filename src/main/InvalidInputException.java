package main;

public class InvalidInputException extends RuntimeException{
    public InvalidInputException(String errorMessage) {
        super(errorMessage);
    }
}

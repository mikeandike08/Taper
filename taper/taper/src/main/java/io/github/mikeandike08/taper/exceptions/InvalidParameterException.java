package io.github.mikeandike08.taper.exceptions;


/**
 * Thrown when a parameter is invalid
 */
public class InvalidParameterException extends RuntimeException{

    public InvalidParameterException(String message){
        super(message);
    }
}

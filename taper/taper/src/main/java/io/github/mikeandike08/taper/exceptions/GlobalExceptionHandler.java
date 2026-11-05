package io.github.mikeandike08.taper.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(InvalidParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleInvalidParameter(InvalidParameterException ex) {
        return ErrorResponse.of(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}

package org.alquranapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class AlquranException extends RuntimeException {
    public AlquranException(String message) {
        super(message);
    }
}

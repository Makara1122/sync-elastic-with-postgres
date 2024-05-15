package org.example.jwtday2.adviser;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

import java.util.HashMap;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class RestControllerAdiser {

    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public HashMap<String,Object> handleNoSuchElementException( NoSuchElementException ex) {
        return new HashMap<>(){{
            put("message", "There is no element !!!");
            put("status", HttpStatus.NOT_FOUND.value());
            put("payload", null);
        }};
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public HashMap<String,Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        {
            return new HashMap<String,Object>(){{
                put("message", ex.getBindingResult().getFieldErrors().stream().map(err -> new HashMap<String,Object>(){{
                    put(err.getField(),err.getDefaultMessage());
                }}).toList());

            }};
        }
    }

    @ExceptionHandler(HttpClientErrorException.Forbidden.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public HashMap<String,Object> handleForbiddenException(HttpClientErrorException.Forbidden ex) {
        return new HashMap<>(){{
            put("message", "You are not allowed to access this resource !!!");
            put("status", HttpStatus.FORBIDDEN.value());
            put("payload", null);
        }};
    }

}

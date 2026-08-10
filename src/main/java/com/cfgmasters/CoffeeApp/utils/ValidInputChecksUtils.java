package com.cfgmasters.CoffeeApp.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
public class ValidInputChecksUtils {
    //below is a generic helper method
    public static <T> void notNullCheck(T value, String fieldName) {
        if (value == null) {
            String errorMessage = fieldName + " must not be null";
            log.error("NULL client input: {}", errorMessage);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, errorMessage);
        }
    }
    //below is NOT generic - it takes in String value specifically
    public static void notBlankCheck(String value, String fieldName) {
        //null check still required to avoid trying to call null.isBlank() and getting different exception type (NullPointer)
        if (value == null ||value.isBlank()) {
            String errorMessage = fieldName + " must not be blank or null";
            log.error("BLANK/NULL client input: {}", errorMessage);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, errorMessage);
        }
    }
    public static <T> void validStrengthValueCheck(Integer strength) {
        if (strength == null || strength < 1 || strength > 5){
            String errorMessage = "Valid strength values are: 1,2,3,4 or 5";
            log.error("Invalid strength input: {}", strength);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, errorMessage);
        }
    }
    public static void nonNegativeCheck(Number value, String fieldName) {
        if (value == null || value.doubleValue() < 0) {
            String errorMessage = fieldName + " must not be negative";
            log.error("Invalid {} input: {}", fieldName, value);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, errorMessage);
        }
    }
    public static void positiveCheck(Number value, String fieldName) {
        if (value == null || value.doubleValue() <= 0) {
            String errorMessage = fieldName + " must be greater than 0";
            log.error("Invalid {} input: {}", fieldName, value);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, errorMessage);
        }
    }

}

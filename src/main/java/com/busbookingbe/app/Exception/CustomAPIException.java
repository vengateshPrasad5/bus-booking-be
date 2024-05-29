package com.busbookingbe.app.Exception;

import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Setter
@AllArgsConstructor
public class CustomAPIException extends RuntimeException {
    private HttpStatus status;
    private String message;
}

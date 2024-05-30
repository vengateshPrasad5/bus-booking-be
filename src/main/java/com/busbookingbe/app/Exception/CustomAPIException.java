package com.busbookingbe.app.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class CustomAPIException extends RuntimeException {
    private HttpStatus status;
    private String message;
}

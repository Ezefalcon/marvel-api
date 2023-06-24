package com.openpay.marvelapi.exception;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonPropertyOrder({"message", "cause", "dateTime"})
public class ErrorDto {
    private String message;
    private LocalDateTime dateTime;

    public ErrorDto(Exception exc) {
        this.message = exc.getMessage();
        this.dateTime = LocalDateTime.now();
    }
}
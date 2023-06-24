package com.openpay.marvelapi.exception;

public class CharacterNotFoundException extends RuntimeException {
    public CharacterNotFoundException() {
        super("Character with provided id not found");
    }
}

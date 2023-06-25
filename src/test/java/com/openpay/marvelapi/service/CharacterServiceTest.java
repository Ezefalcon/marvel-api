package com.openpay.marvelapi.service;

import com.openpay.marvelapi.AbstractBaseTest;
import com.openpay.marvelapi.exception.CharacterNotFoundException;
import com.openpay.marvelservice.model.dto.CharacterDto;
import com.openpay.marvelservice.model.dto.DataDto;
import com.openpay.marvelservice.model.dto.ResponseDto;
import com.openpay.marvelservice.service.CharacterConnectorService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class CharacterServiceTest extends AbstractBaseTest {
    @Mock
    private CharacterConnectorService characterConnectorService;

    @InjectMocks
    private CharacterService characterService;

    @Test
    void getCharacters_ShouldReturnDataDto() {
        // Arrange
        ResponseDto expectedDataDto = new ResponseDto();

        ResponseEntity<ResponseDto> responseEntity = new ResponseEntity<>(expectedDataDto, HttpStatus.OK);
        when(characterConnectorService.getCharacters(anyInt(), anyInt())).thenReturn(responseEntity);

        // Act
        DataDto result = characterService.getCharacters(anyInt(), anyInt());

        // Assert
        assertEquals(expectedDataDto.getData(), result);
        verify(characterConnectorService, times(1)).getCharacters(anyInt(), anyInt());
    }

    @Test
    void getCharacter_WithValidId_ShouldReturnCharacterDto() {
        // Arrange
        int id = 1;
        ResponseDto resDto = new ResponseDto();
        DataDto data = new DataDto();
        CharacterDto character = new CharacterDto();
        data.setResults(Collections.singletonList(character));
        resDto.setData(data);

        ResponseEntity<ResponseDto> responseEntity = new ResponseEntity<>(resDto, HttpStatus.OK);
        when(characterConnectorService.getCharacter(id)).thenReturn(responseEntity);

        // Act
        CharacterDto result = characterService.getCharacter(id);

        // Assert
        assertEquals(character, result);
        verify(characterConnectorService, times(1)).getCharacter(id);
    }

    @Test
    void getCharacter_WithInvalidId_ShouldThrowCharacterNotFoundException() {
        // Arrange
        int id = 1;

        when(characterConnectorService.getCharacter(id)).thenThrow(HttpClientErrorException.class);

        // Assert
        assertThrows(CharacterNotFoundException.class, () -> characterService.getCharacter(id));
        verify(characterConnectorService, times(1)).getCharacter(id);
    }
}

package com.openpay.marvelapi.service;

import com.openpay.marvelapi.exception.CharacterNotFoundException;
import com.openpay.marvelservice.model.dto.CharacterDto;
import com.openpay.marvelservice.model.dto.DataDto;
import com.openpay.marvelservice.service.CharacterConnectorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
@AllArgsConstructor
public class CharacterService {

    private final CharacterConnectorService characterService;

    public DataDto getCharacters(int offset, int limit) {
        return characterService.getCharacters(offset, limit).getBody().getData();
    }

    public CharacterDto getCharacter(int id) {
        try {
            return characterService.getCharacter(id).getBody().getData().getResults().get(0);
        } catch (HttpClientErrorException e) {
            throw new CharacterNotFoundException();
        }
    }
}

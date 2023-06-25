package com.openpay.marvelapi.controller;

import com.openpay.marvelapi.service.CharacterService;
import com.openpay.marvelservice.model.dto.CharacterDto;
import com.openpay.marvelservice.model.dto.DataDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/character")
public class CharacterController {

    @Autowired
    private CharacterService characterService;

    @GetMapping
    public DataDto getCharacters(@RequestParam(name = "offset", required = false, defaultValue = "0") Integer offset,
                                @RequestParam(name = "limit", required = false, defaultValue = "20") Integer limit) {
        return characterService.getCharacters(offset, limit);
    }

    @GetMapping("/{id}")
    public CharacterDto getCharacter(@PathVariable("id") int id) {
        return characterService.getCharacter(id);
    }
}

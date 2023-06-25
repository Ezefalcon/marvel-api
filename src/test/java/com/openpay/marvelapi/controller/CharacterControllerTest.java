package com.openpay.marvelapi.controller;
import com.openpay.marvelapi.model.LogRequest;
import com.openpay.marvelapi.repository.LogRequestRepository;
import com.openpay.marvelapi.service.CharacterService;
import com.openpay.marvelapi.service.LogRequestService;
import com.openpay.marvelservice.model.dto.CharacterDto;
import com.openpay.marvelservice.model.dto.DataDto;
import com.openpay.marvelservice.model.dto.ResponseDto;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(CharacterController.class)
public class CharacterControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CharacterService characterService;

    @MockBean
    private LogRequestService logRequestService;

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = "ADMIN")
    public void testGetCharacters() throws Exception {
        DataDto expectedData = new DataDto();
        Mockito.when(characterService.getCharacters(Mockito.anyInt(), Mockito.anyInt()))
                .thenReturn(expectedData);

        Mockito.when(logRequestService.save(Mockito.any()))
                .thenReturn(new LogRequest());

        mockMvc.perform(MockMvcRequestBuilders.get("/character"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
    }

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = "ADMIN")
    public void testGetCharacterById() throws Exception {
        CharacterDto characterDto = new CharacterDto();
        Mockito.when(characterService.getCharacter(Mockito.anyInt()))
                .thenReturn(characterDto);

        Mockito.when(logRequestService.save(Mockito.any()))
                .thenReturn(new LogRequest());

        mockMvc.perform(MockMvcRequestBuilders.get("/character/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
    }
}

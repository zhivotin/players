package com.intuit.players.controller;

import com.intuit.players.constants.Constants;
import com.intuit.players.dto.PlayerDTO;
import com.intuit.players.exception.EntityNotFoundException;
import com.intuit.players.service.PlayerService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.Collections;

import static com.intuit.players.constants.Constants.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@WebMvcTest(PlayerController.class)
@ActiveProfiles("test")
public class PlayerControllerTest {
    private final static Integer PAGE_NUMBER = 0;
    private final static Integer PAGE_SIZE = 100;
    private final static String ERROR_MSG_FIND_ALL_PAGEABLE = String.format(ERROR_MSG_FIND_ALL_PAGE, PAGE_NUMBER, PAGE_SIZE);

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PlayerService playerService;

    @Test
    public void testErrorHandling() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/error"))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(MockMvcResultMatchers.content().string(""));
    }

    @Test
    public void testGetAll() throws Exception {
        Mockito.when(playerService.findAll())
                .thenReturn(new ArrayList<>(Collections.singletonList(new PlayerDTO.Builder().build())));

        mockMvc.perform(MockMvcRequestBuilders.get(BASE_URL))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("[{}]"));
    }

    @Test
    public void testGetAll_notFound() throws Exception {
        Mockito.when(playerService.findAll()).thenThrow(new EntityNotFoundException(ERROR_MSG_FIND_ALL));

        mockMvc.perform(MockMvcRequestBuilders.get(BASE_URL)
                .param("throwError", "true")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(MockMvcResultMatchers.content().string(ERROR_MSG_FIND_ALL));
    }

    @Test
    public void getAllPageable() throws Exception {
        Page<PlayerDTO> mockPage =
                new PageImpl<>(Collections.singletonList(new PlayerDTO()), PageRequest.of(0, 100), 1L);
        when(playerService.findAllPageable(0, 100))
                .thenReturn(mockPage);

        mockMvc.perform(MockMvcRequestBuilders.get(BASE_URL + "/page")
                        .param("page", "0")
                        .param("size", "100"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("_embedded.playerDTOList").isArray())
                .andExpect(MockMvcResultMatchers.jsonPath("_embedded.playerDTOList").value(mockPage.getNumberOfElements()))
        ;
    }

    @Test
    public void getAllPageable_notFound() throws Exception {
        when(playerService.findAllPageable(PAGE_NUMBER, PAGE_SIZE))
                .thenThrow(new EntityNotFoundException(ERROR_MSG_FIND_ALL_PAGEABLE));

        mockMvc.perform(MockMvcRequestBuilders.get(BASE_URL + "/page")
                        .param("page", "0")
                        .param("size", "100")
                        .param("throwError", "true")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(MockMvcResultMatchers.content().string(ERROR_MSG_FIND_ALL_PAGEABLE));
    }

    @Test
    public void testGetById() throws Exception {
        Mockito.when(playerService.findById("1")).thenReturn(new PlayerDTO.Builder().build());

        mockMvc.perform(MockMvcRequestBuilders.get(BASE_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("{}"));
    }

    @Test
    public void testGetById_notFound() throws Exception {
        Mockito.when(playerService.findById("1")).thenThrow(new EntityNotFoundException(ERROR_MSG_FIND_BY_ID));

        mockMvc.perform(MockMvcRequestBuilders.get(BASE_URL + "/1")
                        .param("throwError", "true")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(MockMvcResultMatchers.content().string(ERROR_MSG_FIND_BY_ID));
    }
}

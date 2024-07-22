package com.intuit.players.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.intuit.players.dto.PlayerDTO;
import com.intuit.players.exception.EntityNotFoundException;
import com.intuit.players.model.Player;
import com.intuit.players.repository.PlayerDAO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ActiveProfiles;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles("test")
public class PlayerServiceTest {
    private final static String PLAYER_ID = "1";
    private final static Integer PAGE_NUMBER = 0;
    private final static Integer PAGE_SIZE = 100;

    private static Player entity;
    private static PlayerDTO dto;

    @Autowired
    private PlayerService playerService;

    @MockBean
    private PlayerDAO playerDAO;

    @BeforeAll
    public static void init() throws IOException {
        ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());

        entity = mapper.readValue(new ClassPathResource("playerEntity_allFields.json").getFile(), Player.class);
        dto = mapper.readValue(new ClassPathResource("playerDTO_allFields.json").getFile(), PlayerDTO.class);
    }

    @Test
    public void testFindAll() {
        when(playerDAO.findAll()).thenReturn(Collections.singletonList(entity));

        List<PlayerDTO> players = playerService.findAll();
        assertEquals(1, players.size());
        Assertions.assertThat(players.get(0)).usingRecursiveComparison().isEqualTo(dto);
    }

    @Test
    public void testFindAll_emptyResult() {
        when(playerDAO.findAll()).thenReturn(Collections.emptyList());

        assertThrows(EntityNotFoundException.class, () -> playerService.findAll());
    }

    @Test
    public void testFindAllPageable() {
        when(playerDAO.findAll(any(Pageable.class)))
                .thenReturn(new PageImpl<>(Collections.singletonList(entity), PageRequest.of(PAGE_NUMBER, PAGE_SIZE), 1L));

        Page<PlayerDTO> players = playerService.findAllPageable(PAGE_NUMBER, PAGE_SIZE);
        assertEquals(1, players.getContent().size());
        assertEquals(1L, players.getTotalElements());
        assertEquals(1, players.getTotalPages());
        Assertions.assertThat(players.getContent().get(0)).usingRecursiveComparison().isEqualTo(dto);
    }

    @Test
    public void testFindAllPageable_emptyResult() {
        when(playerDAO.findAll(any(Pageable.class)))
                .thenReturn(new PageImpl<>(Collections.emptyList(), PageRequest.of(PAGE_NUMBER, PAGE_SIZE), 0L));

        assertThrows(EntityNotFoundException.class, () -> playerService.findAllPageable(PAGE_NUMBER, PAGE_SIZE));
    }

    @Test
    public void testFindById() {
        when(playerDAO.findById(PLAYER_ID)).thenReturn(Optional.ofNullable(entity));

        Assertions.assertThat(playerService.findById(PLAYER_ID)).usingRecursiveComparison().isEqualTo(dto);
    }

    @Test
    public void testFindById_emptyResult() {
        when(playerDAO.findById(PLAYER_ID)).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> playerService.findById(PLAYER_ID));
    }
}

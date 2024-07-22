package com.intuit.players.service;

import com.intuit.players.dto.PlayerDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IPlayerService {

    List<PlayerDTO> findAll();

    Page<PlayerDTO> findAllPageable(Integer pageNumber, Integer pageSize);

    PlayerDTO findById(String playerId);

}

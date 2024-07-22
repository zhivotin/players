package com.intuit.players.service;

import com.intuit.players.dto.PlayerDTO;
import com.intuit.players.exception.EntityNotFoundException;
import com.intuit.players.mapper.PlayerMapper;
import com.intuit.players.model.Player;
import com.intuit.players.repository.PlayerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

import static com.intuit.players.constants.Constants.*;

@Service
public class PlayerService implements IPlayerService {

    private final PlayerDAO playerDAO;
    private final PlayerMapper playerMapper;

    @Autowired
    public PlayerService(PlayerDAO playerDAO, PlayerMapper playerMapper) {
        this.playerDAO = playerDAO;
        this.playerMapper = playerMapper;
    }

    @Override
    public List<PlayerDTO> findAll() {
        List<Player> players = playerDAO.findAll();
        if (CollectionUtils.isEmpty(players)) {
            throw  new EntityNotFoundException(ERROR_MSG_FIND_ALL);
        }
        return players.stream().map(playerMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public Page<PlayerDTO> findAllPageable(Integer pageNumber, Integer pageSize) {
        Page<Player> page = playerDAO.findAll(PageRequest.of(pageNumber, pageSize));
        if (page.getTotalElements() == 0) {
            throw new EntityNotFoundException(String.format(ERROR_MSG_FIND_ALL_PAGE, pageNumber, pageSize));
        }
        return page.map(playerMapper::toDto);
    }

    @Override
    public PlayerDTO findById(String playerId) {
        Player player = playerDAO.findById(playerId)
                .orElseThrow(() -> new EntityNotFoundException(String.format(ERROR_MSG_FIND_BY_ID, playerId)));
        return playerMapper.toDto(player);
    }
}

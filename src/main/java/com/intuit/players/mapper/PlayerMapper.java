package com.intuit.players.mapper;

import com.intuit.players.dto.PlayerDTO;
import com.intuit.players.model.Player;
import org.springframework.stereotype.Component;

@Component
public class PlayerMapper {

    public PlayerDTO toDto(Player player) {
        PlayerDTO playerDTO = new PlayerDTO();
        playerDTO.setPlayerID(player.getPlayerID());
        playerDTO.setBirthYear(player.getBirthYear());
        playerDTO.setBirthMonth(player.getBirthMonth());
        playerDTO.setBirthDay(player.getBirthDay());
        playerDTO.setBirthCountry(player.getBirthCountry());
        playerDTO.setBirthState(player.getBirthState());
        playerDTO.setBirthCity(player.getBirthCity());
        playerDTO.setDeathYear(player.getDeathYear());
        playerDTO.setDeathMonth(player.getDeathMonth());
        playerDTO.setDeathDay(player.getDeathDay());
        playerDTO.setDeathCountry(player.getDeathCountry());
        playerDTO.setDeathState(player.getDeathState());
        playerDTO.setDeathCity(player.getDeathCity());
        playerDTO.setNameFirst(player.getNameFirst());
        playerDTO.setNameLast(player.getNameLast());
        playerDTO.setNameGiven(player.getNameGiven());
        playerDTO.setWeight(player.getWeight());
        playerDTO.setHeight(player.getHeight());
        playerDTO.setBatsSide(player.getBatsSide());
        playerDTO.setThrowsSide(player.getThrowsSide());
        playerDTO.setDebut(player.getDebut());
        playerDTO.setFinalGame(player.getFinalGame());
        playerDTO.setRetroID(player.getRetroID());
        playerDTO.setBbrefID(player.getBbrefID());
        return playerDTO;
    }

}

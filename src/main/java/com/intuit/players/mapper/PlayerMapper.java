package com.intuit.players.mapper;

import com.intuit.players.dto.PlayerDTO;
import com.intuit.players.model.Player;
import org.springframework.stereotype.Component;

@Component
public class PlayerMapper {

    public PlayerDTO toDto(Player player) {
        return new PlayerDTO.Builder()
                .playerID(player.getPlayerID())
                .birthYear(player.getBirthYear())
                .birthMonth(player.getBirthMonth())
                .birthDay(player.getBirthDay())
                .birthCountry(player.getBirthCountry())
                .birthState(player.getBirthState())
                .birthCity(player.getBirthCity())
                .deathYear(player.getDeathYear())
                .deathMonth(player.getDeathMonth())
                .deathDay(player.getDeathDay())
                .deathCountry(player.getDeathCountry())
                .deathState(player.getDeathState())
                .deathCity(player.getDeathCity())
                .nameFirst(player.getNameFirst())
                .nameLast(player.getNameLast())
                .nameGiven(player.getNameGiven())
                .weight(player.getWeight())
                .height(player.getHeight())
                .batsSide(player.getBatsSide())
                .throwsSide(player.getThrowsSide())
                .debut(player.getDebut())
                .finalGame(player.getFinalGame())
                .retroID(player.getRetroID())
                .bbrefID(player.getBbrefID())
                .build();
    }

}

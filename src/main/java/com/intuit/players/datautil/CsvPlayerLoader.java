package com.intuit.players.datautil;

import com.intuit.players.model.Player;
import com.intuit.players.repository.PlayerDAO;
import com.opencsv.CSVReader;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
@Profile("!test")
public class CsvPlayerLoader implements IPlayerLoader {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    private final PlayerDAO playerDAO;

    @Autowired
    public CsvPlayerLoader(PlayerDAO playerDAO) {
        this.playerDAO = playerDAO;
    }

    @Override
    public void run(String... args) throws Exception {
        try (CSVReader reader = new CSVReader(new InputStreamReader(new ClassPathResource("player.csv").getInputStream()))) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            reader.skip(1);

            List<String[]> rows = reader.readAll();
            rows.forEach(row -> {
                        Player player = new Player();
                        player.setPlayerID(StringUtils.isNotEmpty(row[0]) ? row[0] : null);
                        player.setBirthYear(StringUtils.isNotEmpty(row[1]) ? Integer.parseInt(row[1]) : null);
                        player.setBirthMonth(StringUtils.isNotEmpty(row[2]) ? Integer.parseInt(row[2]) : null);
                        player.setBirthDay(StringUtils.isNotEmpty(row[3]) ? Integer.parseInt(row[3]) : null);
                        player.setBirthCountry(StringUtils.isNotEmpty(row[4]) ? row[4] : null);
                        player.setBirthState(StringUtils.isNotEmpty(row[5]) ? row[5] : null);
                        player.setBirthCity(StringUtils.isNotEmpty(row[6]) ? row[6] : null);
                        player.setDeathYear(StringUtils.isNotEmpty(row[7]) ? Integer.parseInt(row[7]) : null);
                        player.setDeathMonth(StringUtils.isNotEmpty(row[8]) ? Integer.parseInt(row[8]) : null);
                        player.setDeathDay(StringUtils.isNotEmpty(row[9]) ? Integer.parseInt(row[9]) : null);
                        player.setDeathCountry(StringUtils.isNotEmpty(row[10]) ? row[10] : null);
                        player.setDeathState(StringUtils.isNotEmpty(row[11]) ? row[11] : null);
                        player.setDeathCity(StringUtils.isNotEmpty(row[12]) ? row[12] : null);
                        player.setNameFirst(StringUtils.isNotEmpty(row[13]) ? row[13] : null);
                        player.setNameLast(StringUtils.isNotEmpty(row[14]) ? row[14] : null);
                        player.setNameGiven(StringUtils.isNotEmpty(row[15]) ? row[15] : null);
                        player.setWeight(StringUtils.isNotEmpty(row[16]) ? Integer.parseInt(row[16]) : null);
                        player.setHeight(StringUtils.isNotEmpty(row[17]) ? Integer.parseInt(row[17]) : null);
                        player.setBatsSide(StringUtils.isNotEmpty(row[18]) ? row[18] : null);
                        player.setThrowsSide(StringUtils.isNotEmpty(row[19]) ? row[19] : null);
                        player.setDebut(StringUtils.isNotEmpty(row[20]) ? LocalDate.parse(row[20], formatter) : null);
                        player.setFinalGame(StringUtils.isNotEmpty(row[21]) ? LocalDate.parse(row[21], formatter) : null);
                        player.setRetroID(StringUtils.isNotEmpty(row[22]) ? row[22] : null);
                        player.setBbrefID(StringUtils.isNotEmpty(row[23]) ? row[23] : null);
                        playerDAO.save(player);
                        logger.debug("Player saved to DB: {}", player);
                    }
            );
        }
    }
}

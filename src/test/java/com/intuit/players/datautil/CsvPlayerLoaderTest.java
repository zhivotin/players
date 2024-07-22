package com.intuit.players.datautil;

import com.intuit.players.repository.PlayerDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CsvPlayerLoaderTest {

    @Autowired
    private CsvPlayerLoader loader;

    @Autowired
    private PlayerDAO playerDAO;

    @Test
    public void testLoader() {
        Assertions.assertEquals(19370L, playerDAO.count());
    }

}

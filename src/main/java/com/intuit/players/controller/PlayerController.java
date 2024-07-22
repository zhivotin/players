package com.intuit.players.controller;

import com.intuit.players.dto.PlayerDTO;
import com.intuit.players.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.intuit.players.constants.Constants.*;

@RestController
@RequestMapping(BASE_URL)
public class PlayerController {

    private final PlayerService playerService;
    private final PagedResourcesAssembler<PlayerDTO> pagedResourcesAssembler;

    @Autowired
    public PlayerController(PlayerService playerService, PagedResourcesAssembler<PlayerDTO> pagedResourcesAssembler) {
        this.playerService = playerService;
        this.pagedResourcesAssembler = pagedResourcesAssembler;
    }

    @GetMapping
    public List<PlayerDTO> getAll() {
        // Do not recommend use this endpoint to prevent performance issues
        // The endpoint returns a huge amount of data
        // Instead of it use getAllPageable(page, size) endpoint
        return playerService.findAll();
    }

    @GetMapping("/page")
    public PagedModel<EntityModel<PlayerDTO>> getAllPageable(@RequestParam(name = "page") Integer pageNumber,
                                                             @RequestParam(name = "size") Integer pageSize) {

        Page<PlayerDTO> playerDTOS = playerService.findAllPageable(pageNumber, pageSize);
        return pagedResourcesAssembler.toModel(playerDTOS);
    }

    @GetMapping("/{playerId}")
    public PlayerDTO getById(@PathVariable(name = "playerId") String playerId) {
        return playerService.findById(playerId);
    }

}

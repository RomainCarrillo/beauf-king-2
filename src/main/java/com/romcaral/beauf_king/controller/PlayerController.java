package com.romcaral.beauf_king.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.romcaral.beauf_king.domain.Player;
import com.romcaral.beauf_king.service.PlayerService;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @PostMapping("/player")
    public Player createPlayer(@RequestBody Player player) {
        return playerService.createPlayer(player);
    }

    @GetMapping
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @GetMapping("/{id}")
    public Player getPlayerById(@PathVariable UUID  id) {
        return playerService.getPlayerById(id);
    }

    @PutMapping("/{id}")
    public Player updatePlayer(@PathVariable UUID  id, @RequestBody Player player) {
        return playerService.updatePlayer(id, player);
    }

    @PutMapping("/vote/{id}")
    public List<Player> votePlayer(@PathVariable UUID  id) {
    	return playerService.votePlayer(id);
    }

    @DeleteMapping("/{id}")
    public void deletePlayer(@PathVariable UUID  id) {
        playerService.deletePlayer(id);
    }
}
package com.romcaral.beauf_king.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.romcaral.beauf_king.domain.Player;
import com.romcaral.beauf_king.repository.PlayerRepository;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public Player createPlayer(Player player) {
        return playerRepository.save(player);
    }

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Player getPlayerById(UUID id) {
        return playerRepository.findById(id).orElse(null);
    }

    public Player updatePlayer(UUID id, Player player) {
        player.setId(id);
        return playerRepository.save(player);
    }

    public List<Player> votePlayer(UUID id) {
    	Player player = playerRepository.findById(id).orElse(null);
    	player.setScore(player.getScore() + 1);
    	playerRepository.save(player);
    	return this.getAllPlayers();
    }

    public void deletePlayer(UUID id) {
        playerRepository.deleteById(id);
    }
}

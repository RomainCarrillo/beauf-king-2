package com.romcaral.beauf_king.service;

import java.util.List;

import com.romcaral.beauf_king.domain.Player;

public interface PlayerService {

	Player createPlayer(Player player);

	List<Player> getAllPlayers();

	Player getPlayerById(Long id);

	Player updatePlayer(Long id, Player player);

	Player votePlayer(Long id);

	void deletePlayer(Long id);

	Player getPlayerWithHigherScore();
}

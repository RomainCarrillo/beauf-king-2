package com.romcaral.beauf_king.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.romcaral.beauf_king.domain.Player;
import com.romcaral.beauf_king.repository.PlayerRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PlayerServiceImpl implements PlayerService {

	@Autowired
	private PlayerRepository playerRepository;

	@Override
	public Player createPlayer(Player player) {
		return playerRepository.save(player);
	}

	private Player defaultPlayer = Player.builder().name("En attente...").score(0).imageName("Default player")
			.imagePath("images/logo.png").build();

	@Override
	@Cacheable(value = "allPlayers")
	public List<Player> getAllPlayers() {
		List<Player> players = playerRepository.findAll();
		players = players.stream().sorted(Comparator.comparingInt(Player::getScore).reversed()) // Sort players by score																								// in descending order
				.skip(1) // Skip the first player (highest score)
				.toList(); // Collect the remaining players into a list
		return players;
	}

	@Override
	public Player getPlayerById(Long i) {
		return playerRepository.findById(i).orElse(null);
	}

	@Override
	public Player updatePlayer(Long id, Player player) {
		player.setId(id);
		return playerRepository.save(player);
	}

	@Override
	public Player votePlayer(Long id) {
		Player player = playerRepository.findById(id).orElse(null);
		player.setScore(player.getScore() + 1);
		return playerRepository.save(player);
	}

	@Override
	public void deletePlayer(Long id) {
		playerRepository.deleteById(id);
	}

	
	@Override
	@Cacheable(value = "bestPlayer")
	public Player getPlayerWithHigherScore() {
		List<Player> players = playerRepository.findAll();
		Optional<Player> player = players.stream().sorted(Comparator.comparingInt(Player::getScore).reversed()) // Descending
																												// order
				.findFirst();
		if (player.isEmpty()) {
			log.info("No best player found return default player");
			return defaultPlayer;
		}
		log.info("Found best player : {}", player.get().getName());
		return player.get();
	}

	@Override
	public Player getPlayerByName(String name) {
		return playerRepository.findByName(name);
	}

}

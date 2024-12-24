package com.romcaral.beauf_king.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.romcaral.beauf_king.domain.Player;
import com.romcaral.beauf_king.service.PlayerServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class PlayerController {

	@Autowired
	private PlayerServiceImpl playerService;

	@GetMapping("players")
	public String getAllPlayers(Model model) {
		log.info("Loading all players for view");
		List<Player> playersList = playerService.getAllPlayers();
		Player bestPlayer = playerService.getPlayerWithHigherScore();
		model.addAttribute("players", playersList); // Add players list to the model for Thymeleaf
		model.addAttribute("best", bestPlayer);
		return "index"; // Return the view name, e.g., players.html
	}

	@GetMapping("player/{id}")
	public String getPlayerById(@PathVariable Long id, Model model) {
		log.info("Loading player details for view with ID: %s".formatted(id));
		Player player = playerService.getPlayerById(id);
		model.addAttribute("player", player); // Add player details to the model
		return "player-detail"; // Return a specific view, e.g., player-detail.html
	}

	@PostMapping("player/vote/{id}")
	public String votePlayer(@PathVariable Long id) {
		log.info("Voting for player with ID: %s".formatted(id));
		Player player = playerService.votePlayer(id);
		log.info("Player {} now have {} points", player.getName(), player.getScore());
	    return "redirect:/players"; // Redirect the user to /players
	}

	

//    @PostMapping
//    public String createPlayer(@ModelAttribute Player player, Model model) {
//        log.info("Creating new player: %s".formatted(player.getName()));
//        playerService.createPlayer(player);
//        return "redirect:/players"; // Redirect to the list of players
//    }

//    @PutMapping("/{id}")
//    public String updatePlayer(@PathVariable Long id, @ModelAttribute Player player, Model model) {
//        log.info("Updating player with ID: %s".formatted(id));
//        playerService.updatePlayer(id, player);
//        return "redirect:/players/" + id; // Redirect to updated player’s page
//    }

//    @DeleteMapping("/{id}")
//    public String deletePlayer(@PathVariable Long id) {
//        log.info("Deleting player with ID: %s".formatted(id));
//        playerService.deletePlayer(id);
//        return "redirect:/players"; // Redirect back to the players list
//    }
}

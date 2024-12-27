package com.romcaral.beauf_king.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.romcaral.beauf_king.domain.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

	public Player findByName(String name);

	@Query(value="SELECT * FROM player ORDER BY score DESC LIMIT 1", nativeQuery=true)
	public Optional<Player> getPlayerWithHigherScore();
}
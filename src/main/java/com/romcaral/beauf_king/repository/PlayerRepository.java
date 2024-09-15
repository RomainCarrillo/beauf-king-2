package com.romcaral.beauf_king.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.romcaral.beauf_king.domain.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, UUID> {
}
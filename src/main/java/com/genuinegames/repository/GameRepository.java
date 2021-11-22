package com.genuinegames.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.genuinegames.entity.Game;
import com.genuinegames.entity.User;

@Repository
public interface GameRepository extends JpaRepository<Game, Long>{

	Game findByName(String nombre);
}

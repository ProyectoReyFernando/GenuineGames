package com.genuinegames.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.genuinegames.entity.Comments;
import com.genuinegames.entity.Game;
import com.genuinegames.entity.User;

@Repository
public interface CommentRepository extends JpaRepository<Comments, Long>{
	Collection<Comments> findByGame(Game game);
	Collection<Comments> findByUser(User user);

}

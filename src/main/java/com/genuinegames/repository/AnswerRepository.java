package com.genuinegames.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.genuinegames.entity.Answer;
import com.genuinegames.entity.Comments;
import com.genuinegames.entity.User;
@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {

	Object findByUserId(Long id);

	Collection<Answer> findByUser(User user);
}

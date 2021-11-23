package com.genuinegames.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.genuinegames.entity.Comments;

@Repository
public interface CommentRepository extends JpaRepository<Comments, Long>{

}

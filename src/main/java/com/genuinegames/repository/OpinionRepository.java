package com.genuinegames.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.genuinegames.entity.Opinion;

@Repository
public interface OpinionRepository extends JpaRepository<Opinion, Long>{

}

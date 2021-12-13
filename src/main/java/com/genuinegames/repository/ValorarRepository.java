package com.genuinegames.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.genuinegames.entity.Valorar;
@Repository
public interface ValorarRepository extends JpaRepository<Valorar, Long> {

}

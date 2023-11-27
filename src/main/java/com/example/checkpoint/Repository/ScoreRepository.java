package com.example.checkpoint.Repository;

import com.example.checkpoint.Entity.ScoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ScoreRepository extends JpaRepository<ScoreEntity, Integer> {

    List<ScoreEntity> findAll ();

    List<ScoreEntity> findByScore(Double score);
}

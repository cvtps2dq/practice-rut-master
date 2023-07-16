package com.example.practice.repositories;

import com.example.practice.models.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository <Game, Integer>{

    public Game findGameByName(String name);

    @Query("SELECT g FROM Game g JOIN g.reviews r WHERE r.user.id = :userId")
    List<Game> findGamesByUserId(@Param("userId") long userId);
}

package com.example.practice.repositories;

import com.example.practice.models.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository <Game, Integer>{

    public Game findGameByName(String name);
}

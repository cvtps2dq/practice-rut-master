package com.example.practice.repositories;

import com.example.practice.models.Game;
import com.example.practice.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository <Item, Integer>{
    public Item findItemByName(String name);

    @Query("SELECT i FROM Item i JOIN i.userEntity u JOIN i.game g WHERE g.genre = 'Шутер' AND u.id = :userId")
    List<Item> findShooterItemsByUserId(@Param("userId") long userId);
}

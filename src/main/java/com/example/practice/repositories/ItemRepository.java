package com.example.practice.repositories;

import com.example.practice.models.Game;
import com.example.practice.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository <Item, Integer>{
    public Item findItemByName(String name);

    List<Item> findItemsByGameGenreAndUserId(String genre, long userId);
}

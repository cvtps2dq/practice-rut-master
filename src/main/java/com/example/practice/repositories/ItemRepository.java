package com.example.practice.repositories;

import com.example.practice.models.Game;
import com.example.practice.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository <Item, Integer>{
    public Item findItemByName(String name);
}

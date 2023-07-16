package com.example.practice.Services;

import com.example.practice.models.Item;
import org.springframework.stereotype.Service;
import com.example.practice.repositories.ItemRepository;

import java.util.List;

@Service
public class ItemService {

    private final ItemRepository repository;

    public ItemService(ItemRepository repository) {
        this.repository = repository;
    }

    public List<Item> getAll() {
        return repository.findAll();
    }

    public List<Item> getItemsByGameGenreAndUserId(String genre, long userId) {
        return repository.findShooterItemsByUserId(userId);
    }
    public Item getItemById(int id) {
        if (repository.findById(id).isPresent())
            return repository.findById(id).get();
        else
            throw new IllegalArgumentException("no such item");
    }

    public Item getItemByName(String name) {
        return repository.findItemByName(name);
    }

    public Item saveItem(Item item) {
        return repository.save(item);
    }

    public Item editItem(Item updatedItem, int id) {
        return repository.findById(id)
                .map(item -> {
                    item.setQuality(updatedItem.getQuality());
                    item.setDesc(updatedItem.getDesc());
                    item.setName(updatedItem.getName());
                    return repository.save(item);
                })
                .orElseThrow(() -> new IllegalArgumentException("Can't update item: no such item"));
    }

    public void deleteItem(int id) {
        repository.deleteById(id);
    }
}

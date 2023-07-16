package com.example.practice.Controllers;

import com.example.practice.Services.GameService;
import com.example.practice.Services.ItemService;
import com.example.practice.Services.ReviewEntityService;
import com.example.practice.Services.UserEntityService;
import com.example.practice.models.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/item")
public class ItemController {

    private final GameService gameService;

    private final UserEntityService userEntityService;

    private final ItemService itemService;

    private final ReviewEntityService reviewEntityService;

    @Autowired
    public ItemController(GameService gameService, UserEntityService userEntityService, ItemService itemService, ReviewEntityService reviewEntityService) {
        this.gameService = gameService;
        this.userEntityService = userEntityService;
        this.itemService = itemService;
        this.reviewEntityService = reviewEntityService;
    }

    @GetMapping
    public List<Item> getAllItem() {
        return itemService.getAll();
    }

    @GetMapping("/{id}")
    public Item getItemById(@PathVariable int id) {
        return itemService.getItemById(id);
    }

    @GetMapping("/genre/{genre}/user/{userId}")
    public List<Item> getItemsByGameGenreAndUserId(@PathVariable String genre, @PathVariable long userId) {
        return itemService.getItemsByGameGenreAndUserId(genre, userId);
    }

    @GetMapping("/name/{name}")
    public Item getItemByName(@PathVariable String name) {
        return itemService.getItemByName(name);
    }

    @PostMapping
    public Item addItem(@RequestBody Item item) {
        return itemService.saveItem(item);
    }

    @PutMapping("/{id}")
    public Item updateItem(@PathVariable int id, @RequestBody Item item) {
        return itemService.editItem(item, id);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable int id) {
        itemService.deleteItem(id);
    }
}
package com.example.practice.Controllers;

import com.example.practice.Services.GameService;
import com.example.practice.Services.ItemService;
import com.example.practice.Services.ReviewEntityService;
import com.example.practice.Services.UserEntityService;
import com.example.practice.models.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/game")
public class GameController {

    private final GameService gameService;

    private final UserEntityService userEntityService;

    private final ItemService itemService;

    private final ReviewEntityService reviewEntityService;

    @Autowired
    public GameController(GameService gameService, UserEntityService userEntityService, ItemService itemService, ReviewEntityService reviewEntityService) {
        this.gameService = gameService;
        this.userEntityService = userEntityService;
        this.itemService = itemService;
        this.reviewEntityService = reviewEntityService;
    }

    @GetMapping
    public List<Game> getAllGame() {
        return gameService.getAll();
    }

    @GetMapping("/{id}")
    public Game getGameById(@PathVariable int id) {
        return gameService.getGameById(id);
    }

    @GetMapping("/name/{name}")
    public Game getGameByName(@PathVariable String name) {
        return gameService.getGameByName(name);
    }

    @GetMapping("/user/{userId}")
    public List<Game> getGamesByUserId(@PathVariable long userId) {
        return gameService.getGamesByUserId(userId);
    }

    @PostMapping
    public Game addGame(@RequestBody Game game) {
        return gameService.saveGame(game);
    }

    @PutMapping("/{id}")
    public Game updateGame(@PathVariable int id, @RequestBody Game game) {
        return gameService.editGame(game, id);
    }

    @DeleteMapping("/{id}")
    public void deleteGame(@PathVariable int id) {
        gameService.deleteGame(id);
    }
}
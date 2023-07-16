package com.example.practice.Controllers;

import com.example.practice.Services.GameService;
import com.example.practice.Services.ItemService;
import com.example.practice.Services.ReviewEntityService;
import com.example.practice.Services.UserEntityService;
import com.example.practice.models.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    /*@GetMapping("/{id}")
    public List<Game> getAllGame() {
        return gameService.getAllGame();
    }
*/
    @GetMapping("/{id}")
    public Game getGameById(@PathVariable int id) {
        return gameService.getGameById(id);
    }

    /*@PostMapping("/{id}")
    public Game addGameWithItemId(@RequestBody GameDto gameDto) {
        return null;

    }

     */
}
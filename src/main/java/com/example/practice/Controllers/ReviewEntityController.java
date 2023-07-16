package com.example.practice.Controllers;

import com.example.practice.Services.GameService;
import com.example.practice.Services.ItemService;
import com.example.practice.Services.ReviewEntityService;
import com.example.practice.Services.UserEntityService;
import com.example.practice.models.ReviewEntity;
import com.example.practice.models.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/review")
public class ReviewEntityController {

    private final GameService gameService;

    private final UserEntityService userEntityService;

    private final ItemService itemService;

    private final ReviewEntityService reviewEntityService;

    @Autowired
    public ReviewEntityController(GameService gameService, UserEntityService userEntityService, ItemService itemService, ReviewEntityService reviewEntityService) {
        this.gameService = gameService;
        this.userEntityService = userEntityService;
        this.itemService = itemService;
        this.reviewEntityService = reviewEntityService;
    }


    @GetMapping
    public List<ReviewEntity> getAllReviews() {
        return reviewEntityService.getAll();
    }

    @GetMapping("/{id}")
    public ReviewEntity getReviewById(@PathVariable int id) {
        return reviewEntityService.getGameById(id);
    }

    @GetMapping("/author/{author}")
    public ReviewEntity getReviewByAuthor(@PathVariable String author) {
        return reviewEntityService.getUserEntityByAuthor(author);
    }

    @PostMapping
    public ReviewEntity addReview(@RequestBody ReviewEntity reviewEntity) {
        return reviewEntityService.saveGame(reviewEntity);
    }

    @GetMapping("/user/{userId}/date/{date}")
    public List<ReviewEntity> getReviewsByUserAndDate(@PathVariable int userId, @PathVariable Date date) {
        UserEntity user = userEntityService.getUserEntityById(userId);
        return reviewEntityService.getReviewsByUserAndDate(user, date);
    }


    @PutMapping("/{id}")
    public ReviewEntity updateReview(@PathVariable int id, @RequestBody ReviewEntity reviewEntity) {
        return reviewEntityService.editReviewEntity(reviewEntity, id);
    }

    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable int id) {
        reviewEntityService.deleteReviewEntity(id);
    }
}

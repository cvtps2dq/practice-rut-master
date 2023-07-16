package com.example.practice.services;

import com.example.practice.models.ReviewEntity;
import com.example.practice.models.UserEntity;
import org.springframework.stereotype.Service;
import com.example.practice.repositories.ReviewEntityRepository;

import java.util.List;

import java.util.Date;

@Service
public class ReviewEntityService {

    private final ReviewEntityRepository repository;

    public ReviewEntityService(ReviewEntityRepository repository) {
        this.repository = repository;
    }

    public List<ReviewEntity> getAll() {
        return repository.findAll();
    }

    public ReviewEntity getGameById(int id) {
        if (repository.findById(id).isPresent())
            return repository.findById(id).get();
        else
            throw new IllegalArgumentException("no such review");
    }

    public ReviewEntity getUserEntityByAuthor(String author) {
        return repository.findReviewEntityByAuthor(author);
    }

    public ReviewEntity saveGame(ReviewEntity userEntity) {
        return repository.save(userEntity);
    }

    public List<ReviewEntity> getReviewsByUserAndDate(UserEntity user, Date date) {
        return repository.findReviewsByUserAndDate(user.getId(), date);
    }

    public ReviewEntity editReviewEntity(ReviewEntity updatedReviewEntity, int id) {
        return repository.findById(id)
                .map(reviewEntity -> {
                    reviewEntity.setRating(updatedReviewEntity.getRating());
                    reviewEntity.setSentDate(updatedReviewEntity.getSentDate());
                    reviewEntity.setAuthor(updatedReviewEntity.getAuthor());
                    reviewEntity.setText(updatedReviewEntity.getText());
                    return repository.save(reviewEntity);
                })
                .orElseThrow(() -> new IllegalArgumentException("Can't update review: no such review"));
    }

    public void deleteReviewEntity(int id) {
        repository.deleteById(id);
    }
}

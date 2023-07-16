package com.example.practice.repositories;

import com.example.practice.models.Game;
import com.example.practice.models.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewEntityRepository extends JpaRepository <ReviewEntity, Integer>{
    public ReviewEntity findReviewEntityByAuthor(String author);
}

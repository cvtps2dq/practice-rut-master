package com.example.practice.repositories;

import com.example.practice.models.Game;
import com.example.practice.models.ReviewEntity;
import com.example.practice.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Date;

@Repository
public interface ReviewEntityRepository extends JpaRepository <ReviewEntity, Integer>{
    public ReviewEntity findReviewEntityByAuthor(String author);

    List<ReviewEntity> findReviewsByUserAndDate(UserEntity user, Date date);
}

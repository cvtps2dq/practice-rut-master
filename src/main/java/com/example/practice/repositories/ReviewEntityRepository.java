package com.example.practice.repositories;

import com.example.practice.models.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Date;

@Repository
public interface ReviewEntityRepository extends JpaRepository <ReviewEntity, Integer>{
    public ReviewEntity findReviewEntityByAuthor(String author);

    @Query("SELECT r FROM ReviewEntity r WHERE r.userEntity.id = :userId AND r.sentDate = :date")
    List<ReviewEntity> findReviewsByUserAndDate(@Param("userId") long userId, @Param("date") Date date);
}

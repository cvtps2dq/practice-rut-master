package com.example.practice.repositories;

import com.example.practice.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserEntityRepository extends JpaRepository <UserEntity, Integer>{
    public UserEntity findUserEntityByNickname(String nickname);
}

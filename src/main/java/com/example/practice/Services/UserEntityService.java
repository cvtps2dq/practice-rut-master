package com.example.practice.Services;

import com.example.practice.models.UserEntity;
import org.springframework.stereotype.Service;
import com.example.practice.repositories.UserEntityRepository;

import java.util.List;

@Service
public class UserEntityService {

    private final UserEntityRepository repository;

    public UserEntityService(UserEntityRepository repository) {
        this.repository = repository;
    }

    public List<UserEntity> getAll() {
        return repository.findAll();
    }

    public UserEntity getGameById(int id) {
        if (repository.findById(id).isPresent())
            return repository.findById(id).get();
        else
            throw new IllegalArgumentException("no such user");
    }

    public UserEntity getUserEntityByNickname(String nickname) {
        return repository.findUserEntityByNickname(nickname);
    }

    public UserEntity saveGame(UserEntity userEntity) {
        return repository.save(userEntity);
    }

    public UserEntity editArtist(UserEntity updatedUserEntity, int id) {
        return repository.findById(id)
                .map(userEntity -> {
                    userEntity.setRegDate(updatedUserEntity.getRegDate());
                    userEntity.setEmail(updatedUserEntity.getEmail());
                    userEntity.setNickname(updatedUserEntity.getNickname());
                    userEntity.setPassword(updatedUserEntity.getPassword());
                    return repository.save(userEntity);
                })
                .orElseThrow(() -> new IllegalArgumentException("Can't update user: no such user"));
    }

    public void deleteUserEntity(int id) {
        repository.deleteById(id);
    }
}

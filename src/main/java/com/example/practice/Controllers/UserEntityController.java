package com.example.practice.Controllers;

import com.example.practice.Services.UserEntityService;
import com.example.practice.models.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserEntityController {

    private final UserEntityService userEntityService;

    @Autowired
    public UserEntityController(UserEntityService userEntityService) {
        this.userEntityService = userEntityService;
    }

    @GetMapping
    public List<UserEntity> getAllUsers() {
        return userEntityService.getAll();
    }

    @GetMapping("/{id}")
    public UserEntity getUserById(@PathVariable int id) {
        return userEntityService.getUserEntityById(id);
    }

    @GetMapping("/nickname/{nickname}")
    public UserEntity getUserByNickname(@PathVariable String nickname) {
        return userEntityService.getUserEntityByNickname(nickname);
    }

    @PostMapping
    public UserEntity addUser(@RequestBody UserEntity userEntity) {
        return userEntityService.saveUserEntity(userEntity);
    }

    @PutMapping("/{id}")
    public UserEntity updateUser(@PathVariable int id, @RequestBody UserEntity userEntity) {
        return userEntityService.editUserEntity(userEntity, id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        userEntityService.deleteUserEntity(id);
    }
}
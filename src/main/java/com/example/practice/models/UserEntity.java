package com.example.practice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;

import java.util.Date;
import java.util.Set;

@Entity
public class UserEntity extends BaseEntity{
    @ManyToMany(mappedBy = "userEntities", targetEntity = Game.class)
    private Set<Game> games;
    private String email;
    private String password;
    private String nickname;
    private Date regDate;

    protected UserEntity() {
    }

    public UserEntity(Set<Game> games, String email, String password, String nickname, Date regDate) {
        this.games = games;
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.regDate = regDate;
    }

    public Set<Game> getGames() {
        return games;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getNickname() {
        return nickname;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setGames(Set<Game> games) {
        this.games = games;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }
}

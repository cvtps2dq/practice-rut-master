package com.example.practice.models;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Game extends BaseEntity {
    @OneToMany(mappedBy = "game", targetEntity = ReviewEntity.class, cascade = CascadeType.ALL)
    private Set <ReviewEntity> reviews;
    @ManyToMany
    @JoinTable(name = "shop",
            joinColumns = @JoinColumn(name = "game_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"))
    private Set <UserEntity> userEntities;
    @OneToMany(mappedBy = "game", targetEntity = Item.class, cascade = CascadeType.ALL)
    private Set <Item> items;
    private String name;
    private String description;
    private Double price;
    private String genre;

    protected Game() {
    }

    public Game(Set<ReviewEntity> reviews, Set<UserEntity> userEntities, Set<Item> items, String name,
                String description, Double price, String genre) {
        this.reviews = reviews;
        this.userEntities = userEntities;
        this.items = items;
        this.name = name;
        this.description = description;
        this.price = price;
        this.genre = genre;
    }

    public Set<ReviewEntity> getReviews() {
        return reviews;
    }

    public void setReviews(Set<ReviewEntity> reviews) {
        this.reviews = reviews;
    }

    public Set<UserEntity> getUsers() {
        return userEntities;
    }

    public void setUsers(Set<UserEntity> userEntities) {
        this.userEntities = userEntities;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String desc) {
        this.description = desc;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}

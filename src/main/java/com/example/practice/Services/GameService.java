package com.example.practice.Services;

import com.example.practice.models.Game;
import org.springframework.stereotype.Service;
import com.example.practice.repositories.GameRepository;

import java.util.List;

@Service
public class GameService {

    private final GameRepository repository;

    public GameService(GameRepository repository) {
        this.repository = repository;
    }

    public List<Game> getAll() {
        return repository.findAll();
    }

    public Game getGameById(int id) {
        if (repository.findById(id).isPresent())
            return repository.findById(id).get();
        else
            throw new IllegalArgumentException("no such game");
    }

    public Game getGameByName(String name) {
        return repository.findGameByName(name);
    }

    public Game saveGame(Game game) {
        return repository.save(game);
    }

    public Game editArtist(Game updatedGame, int id) {
        return repository.findById(id)
                .map(game -> {
                    game.setPrice(updatedGame.getPrice());
                    game.setName(updatedGame.getName());
                    game.setDescription(updatedGame.getDescription());
                    game.setGenre(updatedGame.getGenre());
                    return repository.save(game);
                })
                .orElseThrow(() -> new IllegalArgumentException("Can't update game: no such game"));
    }

    public void deleteGame(int id) {
        repository.deleteById(id);
    }
}

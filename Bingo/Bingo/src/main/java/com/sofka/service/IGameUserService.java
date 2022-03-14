package com.sofka.service;

import com.sofka.domain.GameUser;

import java.util.List;
import java.util.Optional;

public interface IGameUserService {
    public List<GameUser> list();

    public GameUser save(GameUser gameUser);

    public GameUser update(Long id, GameUser gameUser);

    public void delete(GameUser gameUser);

    public Optional<GameUser> findGameUser(GameUser gameUser);
}

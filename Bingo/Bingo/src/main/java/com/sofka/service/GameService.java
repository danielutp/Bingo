package com.sofka.service;

import com.sofka.dao.GameDao;
import com.sofka.domain.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class GameService implements IGameService {

    @Autowired //Para inyectar gameDao
    private GameDao gameDao;

    /**
     * Servicio de listar
     * @return (List<Game>)
     */
    @Override
    @Transactional(readOnly = true)
    public List<Game> list() {
        return (List<Game>) gameDao.findAll();
    }

    /**
     * Servicio para guardar
     * @param game
     * @return game
     */
    @Override
    @Transactional
    public Game save(Game game) {
        return gameDao.save(game);
    }

    /**
     * Servicio para actualizar
     * @param id
     * @param game
     * @return game
     */
    @Override
    @Transactional
    public Game update(Long id,Game game) {
        game.setId(id);
        return gameDao.save(game);
    }


    /**
     * Servicio para borrar
     * @param game
     */
    @Override
    @Transactional
    public void delete(Game game) {
        gameDao.delete(game);
    }

    /**
     * Servicio para encontrar
     * @param game
     * @return game
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<Game> findGame(Game game) {
        return gameDao.findById(game.getId());
    }
}

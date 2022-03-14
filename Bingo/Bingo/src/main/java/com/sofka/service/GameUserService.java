package com.sofka.service;

import com.sofka.dao.GameUserDao;
import com.sofka.domain.GameUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class GameUserService implements IGameUserService {

    @Autowired //Para inyectar gameUserDao
    private GameUserDao gameUserDao;

    /**
     * Servicio de listar
     * @return (List<GameUser>)
     */
    @Override
    @Transactional(readOnly = true)
    public List<GameUser> list() {
        return (List<GameUser>) gameUserDao.findAll();
    }

    /**
     * Servicio para guardar
     * @param gameUser
     * @return gameUser
     */
    @Override
    @Transactional
    public GameUser save(GameUser gameUser) {
        return gameUserDao.save(gameUser);
    }

    /**
     * Servicio para actualizar
     * @param id
     * @param gameUser
     * @return gameUser
     */
    @Override
    @Transactional
    public GameUser update(Long id, GameUser gameUser) {
        gameUser.setId(id);
        return gameUserDao.save(gameUser);
    }


    /**
     * Servicio para borrar un usuario
     * @param gameUser
     */
    @Override
    @Transactional
    public void delete(GameUser gameUser) {
        gameUserDao.delete(gameUser);
    }

    /**
     * Servicio para encontrar un usuario
     * @param gameUser
     * @return gameUser
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<GameUser> findGameUser(GameUser gameUser) {
        return gameUserDao.findById(gameUser.getId());
    }
}

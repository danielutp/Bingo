package com.sofka.service;

import com.sofka.dao.UserDao;
import com.sofka.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired //Para inyectar UserDao
    private UserDao userDao;

    /**
     * Servicio de listar usuairos
     * @return (List<User>)
     */
    @Override
    @Transactional(readOnly = true)
    public List<User> list() {
        return (List<User>) userDao.findAll();
    }

    /**
     * Servicio para guardar un usuario
     * @param user
     * @return user
     */
    @Override
    @Transactional
    public User save(User user) {
        return userDao.save(user);
    }

    /**
     * Servicio para actualizar un usuario
     * @param id
     * @param user
     * @return user
     */
    @Override
    @Transactional
    public User update(Long id, User user) {
        user.setId(id);
        return userDao.save(user);
    }


    /**
     * Servicio para borrar un usuario
     * @param user
     */
    @Override
    @Transactional
    public void delete(User user) {
        userDao.delete(user);
    }

    /**
     * Servicio para encontrar un usuario
     * @param user
     * @return user
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<User> findUser(User user) {
        return userDao.findById(user.getId());
    }
}

package com.sofka.service;

import com.sofka.dao.TableUserDao;
import com.sofka.domain.TableUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TableUserService implements ITableUserService {

    @Autowired //Para inyectar tableUserDao
    private TableUserDao tableUserDao;

    /**
     * Servicio de listar usuairos
     * @return (List<User>)
     */
    @Override
    @Transactional(readOnly = true)
    public List<TableUser> list() {
        return (List<TableUser>) tableUserDao.findAll();
    }

    /**
     * Servicio para guardar una tabla tableUser
     * @param tableUser
     * @return tableUser
     */
    @Override
    @Transactional
    public TableUser save(TableUser tableUser) {
        return tableUserDao.save(tableUser);
    }

    /**
     * Servicio para actualizar un usuario
     * @param id
     * @param tableUser
     * @return tableUser
     */
    @Override
    @Transactional
    public TableUser update(Long id, TableUser tableUser) {
        tableUser.setId(id);
        return tableUserDao.save(tableUser);
    }


    /**
     * Servicio para borrar una tabla de usuario
     * @param tableUser
     */
    @Override
    @Transactional
    public void delete(TableUser tableUser) {
        tableUserDao.delete(tableUser);
    }

    /**
     * Servicio para encontrar un tabla de usuario
     * @param tableUser
     * @return tableUser
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<TableUser> findTableUser(TableUser tableUser) {
        return tableUserDao.findById(tableUser.getId());
    }
}

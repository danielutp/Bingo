package com.sofka.service;

import com.sofka.dao.NumberDao;
import com.sofka.domain.Number;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class NumberService implements INumberService {

    @Autowired //Para inyectar NumberDao
    private NumberDao numberDao;

    /**
     * Servicio de listar numberos correspondientes a cara usuario
     * @return (List<Number>)
     */
    @Override
    @Transactional(readOnly = true)
    public List<Number> list() {
        return (List<Number>) numberDao.findAll();
    }

    /**
     * Servicio para guardar un number correspondiente a una tabla
     * @param number
     * @return number
     */
    @Override
    @Transactional
    public Number save(Number number) {
        return numberDao.save(number);
    }

    /**
     * Servicio para actualizar un number de una tabla
     * @param id
     * @param number
     * @return number
     */
    @Override
    @Transactional
    public Number update(Long id, Number number) {
        number.setId(id);
        return numberDao.save(number);
    }


    /**
     * Servicio para borrar un number de una tabla
     * @param number
     */
    @Override
    @Transactional
    public void delete(Number number) {
        numberDao.delete(number);
    }

    /**
     * Servicio para encontrar un usuario
     * @param number
     * @return number
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<Number> findNumber(Number number) {
        return numberDao.findById(number.getId());
    }
}

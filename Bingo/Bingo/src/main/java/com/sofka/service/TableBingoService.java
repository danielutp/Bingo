package com.sofka.service;

import com.sofka.dao.TableBingoDao;
import com.sofka.domain.TableBingo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TableBingoService implements ITableBingoService {

    @Autowired //Para inyectar tableBingoDao
    private TableBingoDao tableBingoDao;

    /**
     * Servicio de listar usuairos
     * @return (List<TableBingo>)
     */
    @Override
    @Transactional(readOnly = true)
    public List<TableBingo> list() {
        return (List<TableBingo>) tableBingoDao.findAll();
    }

    /**
     * Servicio para guardar un usuario
     * @param tableBingo
     * @return tableBingo
     */
    @Override
    @Transactional
    public TableBingo save(TableBingo tableBingo) {
        return tableBingoDao.save(tableBingo);
    }

    /**
     * Servicio para actualizar un usuario
     * @param id
     * @param tableBingo
     * @return TableBingo
     */
    @Override
    @Transactional
    public TableBingo update(Long id, TableBingo tableBingo) {
        tableBingo.setId(id);
        return tableBingoDao.save(tableBingo);
    }


    /**
     * Servicio para borrar un usuario
     * @param tableBingo
     */
    @Override
    @Transactional
    public void delete(TableBingo tableBingo) {
        tableBingoDao.delete(tableBingo);
    }

    @Override
    public Optional<TableBingo> findTableBingo(TableBingo tableBingo) {
        return tableBingoDao.findById(tableBingo.getId());
    }
}
package com.sofka.service;

import com.sofka.domain.TableBingo;
import java.util.List;
import java.util.Optional;

public interface ITableBingoService {
    public List<TableBingo> list();

    public TableBingo save(TableBingo tableBingo);

    public TableBingo update(Long id, TableBingo tableBingo);

    public void delete(TableBingo tableBingo);

    public Optional<TableBingo> findTableBingo(TableBingo tableBingo);
}

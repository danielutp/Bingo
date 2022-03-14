package com.sofka.service;

import com.sofka.domain.TableUser;

import java.util.List;
import java.util.Optional;

public interface ITableUserService {
    public List<TableUser> list();

    public TableUser save(TableUser tableUser);

    public TableUser update(Long id, TableUser tableUser);

    public void delete(TableUser tableUser);

    public Optional<TableUser> findTableUser(TableUser tableUser);
}

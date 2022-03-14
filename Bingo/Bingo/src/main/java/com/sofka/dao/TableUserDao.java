package com.sofka.dao;

import com.sofka.domain.TableUser;
import org.springframework.data.repository.CrudRepository;

public interface TableUserDao extends CrudRepository<TableUser, Long> {

}
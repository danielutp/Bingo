package com.sofka.dao;

import com.sofka.domain.Number;
import org.springframework.data.repository.CrudRepository;

public interface NumberDao extends CrudRepository<Number, Long> {

}
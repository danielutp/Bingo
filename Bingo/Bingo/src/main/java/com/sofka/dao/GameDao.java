package com.sofka.dao;

import com.sofka.domain.Game;
import org.springframework.data.repository.CrudRepository;

public interface GameDao extends CrudRepository<Game, Long> {

}
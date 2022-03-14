package com.sofka.dao;

import com.sofka.domain.GameUser;
import org.springframework.data.repository.CrudRepository;

public interface GameUserDao extends CrudRepository<GameUser, Long> {

}
package com.sofka.domain;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GenerationType;
import javax.persistence.Temporal;
import javax.persistence.Table;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "table_user")
public class TableUser implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Modelo que representa tabla de usuario
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id_table_gamer")
    private Long id;
    @Column(name ="user_id_user")
    private String id_user;
    @Column(name ="game_id_game")
    private String id_game;
}

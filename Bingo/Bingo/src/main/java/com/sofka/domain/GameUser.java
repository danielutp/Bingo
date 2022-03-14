package com.sofka.domain;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "user_has_game")
public class GameUser implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Modelo que representa la tabla de usuario con el juego
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id_user_has_game")
    private Long id;
    @Column(name ="user_id_user")
    private String idUser;
    @Column(name ="game_id_game")
    private String idGame;
}
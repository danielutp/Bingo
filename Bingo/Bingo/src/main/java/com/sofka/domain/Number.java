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
@Table(name = "numbers")
public class Number implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Modelo que representa la tabla del bingo
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_numbers")
    private Long id;
    @Column(name = "numbers")
    private String numbersB;
    @Column(name = "table_user_id_table_gamer")
    private String idTableUser;
}
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
@Table(name = "table_bingo")
public class TableBingo implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Modelo que representa la tabla del bingo
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_table_bingo")
    private Long id;
    @Column(name = "id_bingo")
    private String idBingo;
    @Column(name = "numbers_bingo")
    private String numbers_bingo;
}
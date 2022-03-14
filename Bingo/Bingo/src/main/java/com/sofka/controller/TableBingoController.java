package com.sofka.controller;

import com.sofka.domain.TableBingo;
import com.sofka.service.TableBingoService;
import com.sofka.util.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Slf4j
@RestController
public class TableBingoController {

    @Autowired
    private TableBingoService tableBingoService;
    private Response response = new Response();

    /**
     * Metodo para mostrar la lista de contactos
     * @return
     */
    @GetMapping(path ="/tablebingos")
    @CrossOrigin()
    public Response list(){
        try {
            response.data= tableBingoService.list();
        } catch (Exception exc) {
            response.error = true;
            response.message = exc.getMessage();
            response.status = "ERROR";
        }
        return response;
    }

    /**
     * Metodo para crear tabla del bingo
     * @param tableBingo
     * @return
     */
    @PostMapping(path ="/tablebingo/create")
    @CrossOrigin()
    public ResponseEntity<Response> create(TableBingo tableBingo) {
        log.info("Tabla del bingo a crear: {}", tableBingo);
        tableBingoService.save(tableBingo);
        return new ResponseEntity<Response>(response, HttpStatus.CREATED);
    }

    /**
     * Metodo para borrar un tabla del bingo
     * @param tableBingo
     * @return
     */
    @DeleteMapping(path ="/tablebingo/delete/{id}")
    @CrossOrigin()
    public ResponseEntity<TableBingo> delete( TableBingo tableBingo){
        log.info("Tabla del bingo a borrar {}",tableBingo);
        tableBingoService.delete(tableBingo);
        return new ResponseEntity<>(tableBingo, HttpStatus.OK);
    }
    /**
     * Metodo para actualizar una tabla del bingo
     * @param tableBingo
     * @param id
     * @return
     */
    @PutMapping(path ="/tablebingo/update/{id}")
    @CrossOrigin()
    public ResponseEntity update(TableBingo tableBingo, @PathVariable("id") Long id){
        tableBingoService.update(id,tableBingo);
        log.info("Tabla del bingo a modificar {}",tableBingo);
        return new ResponseEntity<>(tableBingo, HttpStatus.OK);
    }
}
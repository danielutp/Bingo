package com.sofka.controller;

import com.sofka.domain.Number;
import com.sofka.service.NumberService;
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
public class NumberController {

    @Autowired
    private NumberService numberService;
    private Response response = new Response();

    /**
     * Metodo para mostrar la lista de contactos
     * @return
     */
    @GetMapping(path ="/numbers")
    @CrossOrigin()
    public Response list(){
        try {
            response.data= numberService.list();
        } catch (Exception exc) {
            response.error = true;
            response.message = exc.getMessage();
            response.status = "ERROR";
        }
        return response;
    }

    /**
     * Metodo para crear tabla del bingo
     * @param number
     * @return
     */
    @PostMapping(path ="/number/create")
    @CrossOrigin()
    public ResponseEntity<Response> create(Number number) {
        log.info("Tabla del bingo a crear: {}", number);
        numberService.save(number);
        return new ResponseEntity<Response>(response, HttpStatus.CREATED);
    }

    /**
     * Metodo para borrar un tabla del bingo
     * @param number
     * @return
     */
    @DeleteMapping(path ="/number/delete/{id}")
    @CrossOrigin()
    public ResponseEntity<Number> delete(Number number){
        log.info("El numero de la tabla a borrar {}",number);
        numberService.delete(number);
        return new ResponseEntity<>(number, HttpStatus.OK);
    }
    /**
     * Metodo para actualizar una tabla del bingo
     * @param number
     * @param id
     * @return
     */
    @PutMapping(path ="/number/update/{id}")
    @CrossOrigin()
    public ResponseEntity update(Number number, @PathVariable("id") Long id){
        numberService.update(id,number);
        log.info("El numero de la tabla a modificar {}",number);
        return new ResponseEntity<>(number, HttpStatus.OK);
    }
}
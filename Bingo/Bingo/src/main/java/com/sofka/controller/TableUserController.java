package com.sofka.controller;

import com.sofka.domain.TableUser;
import com.sofka.service.TableUserService;
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
public class TableUserController {

    @Autowired
    private TableUserService tableUserService;
    private Response response = new Response();

    /**
     * Metodo para mostrar
     * @return
     */
    @GetMapping(path ="/tableUsers")
    @CrossOrigin()
    public Response list(){
        try {
            response.data= tableUserService.list();
        } catch (Exception exc) {
            response.error = true;
            response.message = exc.getMessage();
            response.status = "ERROR";
        }
        return response;
    }

    /**
     * Metodo para crear
     * @param tableUser
     * @return
     */
    @PostMapping(path ="/tableUser/create")
    @CrossOrigin()
    public ResponseEntity<Response> create(TableUser tableUser) {
        log.info("Tabla creada: {}", tableUser);
        tableUserService.save(tableUser);
        return new ResponseEntity<Response>(response, HttpStatus.CREATED);
    }

    /**
     * Metodo para borrar
     * @param tableUser
     * @return
     */
    @DeleteMapping(path ="/tableUser/delete/{id}")
    @CrossOrigin()
    public ResponseEntity<TableUser> delete( TableUser tableUser){
        log.info("tabla borrada {}",tableUser);
        tableUserService.delete(tableUser);
        return new ResponseEntity<>(tableUser, HttpStatus.OK);
    }
    /**
     * Metodo para actualizar
     * @param tableUser
     * @param id
     * @return
     */
    @PutMapping(path ="/tableUser/update/{id}")
    @CrossOrigin()
    public ResponseEntity update(TableUser tableUser, @PathVariable("id") Long id){
        tableUserService.update(id,tableUser);
        log.info("Modificado {}",tableUser);
        return new ResponseEntity<>(tableUser, HttpStatus.OK);
    }
}
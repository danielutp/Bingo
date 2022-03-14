package com.sofka.controller;

import com.sofka.domain.GameUser;
import com.sofka.service.GameUserService;
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
public class GameUserController {

    @Autowired
    private GameUserService gameUserService;
    private Response response = new Response();

    /**
     * Metodo para mostrar la lista
     * @return gameUser
     */
    @GetMapping(path ="/gameusers")
    @CrossOrigin()
    public Response list(){
        try {
            response.data= gameUserService.list();
        } catch (Exception exc) {
            response.error = true;
            response.message = exc.getMessage();
            response.status = "ERROR";
        }
        return response;
    }

    /**
     * Metodo para crear
     * @param gameUser
     * @return
     */
    @PostMapping(path ="/gameuser/create")
    @CrossOrigin()
    public ResponseEntity<Response> create(GameUser gameUser) {
        log.info("Lista a crear: {}", gameUser);
        gameUserService.save(gameUser);
        return new ResponseEntity<Response>(response, HttpStatus.CREATED);
    }

    /**
     * Metodo para borrar un contacto
     * @param gameUser
     * @return
     */
    @DeleteMapping(path ="/gameuser/delete/{id}")
    @CrossOrigin()
    public ResponseEntity<GameUser> delete(GameUser gameUser){
        log.info("Lista a borrar {}",gameUser);
        gameUserService.delete(gameUser);
        return new ResponseEntity<>(gameUser, HttpStatus.OK);
    }
    /**
     * Metodo para actualizar
     * @param gameUser
     * @param id
     * @return
     */
    @PutMapping(path ="/gameuser/update/{id}")
    @CrossOrigin()
    public ResponseEntity update(GameUser gameUser, @PathVariable("id") Long id){
        gameUserService.update(id,gameUser);
        log.info("Lista modificar {}",gameUser);
        return new ResponseEntity<>(gameUser, HttpStatus.OK);
    }
}
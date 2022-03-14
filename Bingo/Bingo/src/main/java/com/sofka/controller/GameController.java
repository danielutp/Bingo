package com.sofka.controller;

import com.sofka.domain.Game;
import com.sofka.service.GameService;
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
public class GameController {

    @Autowired
    private GameService gameService;
    private Response response = new Response();

    /**
     * Metodo para mostrar la lista
     * @return game
     */
    @GetMapping(path ="/games")
    @CrossOrigin()
    public Response list(){
        try {
            response.data= gameService.list();
        } catch (Exception exc) {
            response.error = true;
            response.message = exc.getMessage();
            response.status = "ERROR";
        }
        return response;
    }

    /**
     * Metodo para crear
     * @param game
     * @return
     */
    @PostMapping(path ="/game/create")
    @CrossOrigin()
    public ResponseEntity<Response> create(Game game) {
        log.info("Juego a crear: {}", game);
        gameService.save(game);
        return new ResponseEntity<Response>(response, HttpStatus.CREATED);
    }

    /**
     * Metodo para borrar un contacto
     * @param game
     * @return
     */
    @DeleteMapping(path ="/game/delete/{id}")
    @CrossOrigin()
    public ResponseEntity<Game> delete(Game game){
        log.info("Juego a borrar {}",game);
        gameService.delete(game);
        return new ResponseEntity<>(game, HttpStatus.OK);
    }
    /**
     * Metodo para actualizar
     * @param game
     * @param id
     * @return
     */
    @PutMapping(path ="/game/update/{id}")
    @CrossOrigin()
    public ResponseEntity update(Game game, @PathVariable("id") Long id){
        gameService.update(id,game);
        log.info("Juego a modificar {}",game);
        return new ResponseEntity<>(game, HttpStatus.OK);
    }
}
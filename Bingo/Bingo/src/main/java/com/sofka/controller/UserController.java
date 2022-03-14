package com.sofka.controller;

import com.sofka.domain.User;
import com.sofka.service.UserService;
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
public class UserController {

    @Autowired
    private UserService userService;
    private Response response = new Response();

    /**
     * Metodo para mostrar la lista de contactos
     * @return
     */
    @GetMapping(path ="/users")
    @CrossOrigin()
    public Response list(){
        try {
            response.data= userService.list();
        } catch (Exception exc) {
            response.error = true;
            response.message = exc.getMessage();
            response.status = "ERROR";
        }
        return response;
    }

    /**
     * Metodo para crear un usuario
     * @param user
     * @return
     */
    @PostMapping(path ="/user/create")
    @CrossOrigin()
    public ResponseEntity<Response> create(User user) {
            log.info("Usuario a crear: {}", user);
            userService.save(user);
            return new ResponseEntity<Response>(response, HttpStatus.CREATED);
    }

    /**
     * Metodo para borrar un contacto por su id
     * @param user
     * @return
     */
    @DeleteMapping(path ="/contact/delete/{id}")
    @CrossOrigin()
    public ResponseEntity<User> delete( User user){
        log.info("Usuario a borrar {}",user);
        userService.delete(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    /**
     * Metodo para actualizar contacto
     * @param user
     * @param id
     * @return
     */
    @PutMapping(path ="/contact/update/{id}")
    @CrossOrigin()
    public ResponseEntity update(User user, @PathVariable("id") Long id){
        userService.update(id,user);
        log.info("Contacto a modificar {}",user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
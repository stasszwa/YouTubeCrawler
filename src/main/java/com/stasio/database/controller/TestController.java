package com.stasio.database.controller;

import com.stasio.database.model.Film;
import com.stasio.database.model.Transaction;
import com.stasio.database.model.User;
import com.stasio.database.service.FilmService;
import com.stasio.database.service.TransactionService;
import com.stasio.database.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/")
public class TestController {


    private final UserService userService;
    private final FilmService filmService;
    private final TransactionService transactionService;

    @Autowired
    public TestController(UserService userService, FilmService filmService, TransactionService transactionService) {
        this.userService = userService;
        this.filmService = filmService;
        this.transactionService = transactionService;
    }

    @RequestMapping(value = "/name/{name}/details", method = RequestMethod.GET)
    public ResponseEntity<User> getUserByName(@PathVariable String name) {
        User user = userService.getUserByName(name);
        return new ResponseEntity<>(user, new HttpHeaders(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{userId}/details", method = RequestMethod.GET)
    public ResponseEntity<User> getUserById(@PathVariable Long userId) {
        User user = userService.getUserById(userId);
        return new ResponseEntity<>(user, new HttpHeaders(), HttpStatus.OK);
    }

    @RequestMapping(value = "name/{id}/video", method = RequestMethod.GET)
    public ResponseEntity<Set<Film>> getUsersFilms(@PathVariable Long id) {
        User user = userService.getUserById(id);
        Set<Film> films = filmService.getAllByUser(user);
//        System.err.println(filmService.countFilmByUser(user));
        return new ResponseEntity<>(films, new HttpHeaders(), HttpStatus.OK);
    }

    @RequestMapping(value = "/video/{id}/details", method = RequestMethod.GET)
    public ResponseEntity<Film> getFilmById(@PathVariable Long id) {
        Film film = filmService.getFilmById(id);
        return new ResponseEntity<>(film, new HttpHeaders(), HttpStatus.OK);
    }

    @RequestMapping(value = "/transaction/{id}/details")
    public ResponseEntity<Transaction> getTransactionById(@PathVariable Long id) {
        Transaction transaction = transactionService.getTransactionById(id);
        return new ResponseEntity<>(transaction, new HttpHeaders(), HttpStatus.OK);
    }

    @RequestMapping(value = "/allFilms")
    public ResponseEntity<Set<Film>> getAllFilms() {
        Set<Film> films = filmService.getAll();
        return new ResponseEntity<>(films, new HttpHeaders(), HttpStatus.OK);
    }



}

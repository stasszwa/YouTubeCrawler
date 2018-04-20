package com.stasio.database.service;

import com.stasio.database.model.Film;
import com.stasio.database.model.Tag;
import com.stasio.database.model.User;
import com.stasio.database.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service("filmService")
public class FilmService {

    private final FilmRepository filmRepository;

    @Autowired
    public FilmService(FilmRepository filmRepository) {

        this.filmRepository = filmRepository;
    }

    @Transactional
    public void addFilm(Film film) {
        filmRepository.save(film);
    }

    @Transactional
    public Set<Film> getAllByUser(User user) {
        return filmRepository.getAllByUser(user);
    }

    @Transactional
    public Set<Film> getAllByTags(Tag tag) {
        return filmRepository.getAllByTags(tag);
    }

    @Transactional
    public Set<Film> getAllByUserAndTags(User user, Tag tag) {
        return filmRepository.getAllByUserAndTags(user, tag);
    }

    @Transactional
    public Film getFilmById(Long id) {
        return filmRepository.getFilmById(id);
    }


    @Transactional
    public Set<Film> getAll() {
        return filmRepository.getAll();
    }

    public int countFilmByUser(User user) {
        return getAllByUser(user).size();
    }
}

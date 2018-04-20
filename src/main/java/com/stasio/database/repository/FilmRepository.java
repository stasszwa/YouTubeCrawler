package com.stasio.database.repository;

import com.stasio.database.model.Film;
import com.stasio.database.model.Tag;
import com.stasio.database.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {
    Set<Film> getAllByUser(User user);

    Set<Film> getAllByTags(Tag tag);

    Set<Film> getAllByUserAndTags(User user, Tag tag);

    Film getFilmById(Long id);

    @Query(value = "SELECT t.* FROM tniewiel.film t", nativeQuery = true)
    Set<Film> getAll();


}

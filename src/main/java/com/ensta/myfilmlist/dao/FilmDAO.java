package com.ensta.myfilmlist.dao;

import java.util.List;
import java.util.Optional;

import com.ensta.myfilmlist.model.Film;




public interface FilmDAO {

    List<Film> findAll();
    /* To add a film in the DB */
    Film save(Film film);
    Optional<Film> findById(long id);
    void delete(Film film);
    List<Film> findByRealisateurId(long realisateurId);

}

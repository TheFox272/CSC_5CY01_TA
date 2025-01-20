package com.ensta.myfilmlist.dao;

import com.ensta.myfilmlist.model.Film;
import com.ensta.myfilmlist.model.Realisateur;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RealisateurDAO {
    /* interface pour l'implementation du DAO de realisateurs
     */

    List<Realisateur> findAll();
    Realisateur findByNomAndPrenom(String nom, String prenom) throws EmptyResultDataAccessException, RuntimeException;
    Optional<Realisateur> findById(long id);
    Realisateur update(Realisateur realisateur);
    Realisateur save(Realisateur realisateur);

}

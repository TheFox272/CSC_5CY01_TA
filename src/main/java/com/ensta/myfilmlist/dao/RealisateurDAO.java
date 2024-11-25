package com.ensta.myfilmlist.dao;

import com.ensta.myfilmlist.model.Realisateur;
import org.springframework.dao.EmptyResultDataAccessException;
import java.util.List;
import java.util.Optional;

public interface RealisateurDAO {
    /* interface pour l'implementation du DAO de realisateurs
     */

    List<Realisateur> findall();
    Realisateur findByNomAndPrenom(String nom, String prenom) throws EmptyResultDataAccessException, RuntimeException;
    Optional<Realisateur> findById(int id);

}

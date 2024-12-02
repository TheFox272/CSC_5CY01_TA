package com.ensta.myfilmlist.dao.impl;
import com.ensta.myfilmlist.dao.RealisateurDAO;
import com.ensta.myfilmlist.model.Realisateur;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import com.ensta.myfilmlist.persistence.ConnectionManager;
import java.util.Optional;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class JdbcRealisateurDAO implements RealisateurDAO{

    /*
    DAO = data access object
    Contient toute le tableau des réalisateurs
     */

// attributs
    private JdbcTemplate jdbcTemplate =
        ConnectionManager.getJdbcTemplate();

    // Le mapping permet de créer des objets Réalisateur à partir du résulta de la query
    private final RowMapper<Realisateur> realisateurRowMapper = new RowMapper<>() {
        @Override
        public Realisateur mapRow(ResultSet rs, int rowNum) throws SQLException {
            Realisateur realisateur = new Realisateur();
            realisateur.setId(rs.getLong("id"));
            realisateur.setNom(rs.getString("nom"));
            realisateur.setPrenom(rs.getString("prenom"));
            realisateur.setDateNaissance(rs.getDate("date_naissance").toLocalDate());
            realisateur.setCelebre(rs.getBoolean("celebre"));

            // La liste des films devra être chargée séparément (pas incluse ici)
            realisateur.setFilmRealises(List.of()); // Placeholder pour les films : réservé temporairement pour ajouter la liste de films
            return realisateur;
        }
    };

    // Récupérer tous les réalisateurs
    @Override
    public List<Realisateur> findAll() {
        String sql = "SELECT * FROM realisateur";
        return jdbcTemplate.query(sql, realisateurRowMapper);
    }

    // Trouver un réalisateur par nom et prénom
    @Override
    public Realisateur findByNomAndPrenom(String nom, String prenom) {
        String sql = "SELECT * FROM realisateur WHERE nom = ? AND prenom = ?";

        try {
            return jdbcTemplate.queryForObject( // remarque : queryforobject permet de recup un seul  enregistrement
                    sql,
                    realisateurRowMapper,
                    nom, prenom // paramètres de  la requête sql
            );
        } catch (EmptyResultDataAccessException e) {
            return null; // Aucun réalisateur trouvé
        }
    }

    // Trouver un réalisateur par ID
    @Override
    public Optional<Realisateur> findById(long id) {
        String sql = "SELECT * FROM realisateur WHERE id = ?";

        try {
            Realisateur realisateur = jdbcTemplate.queryForObject(
                    "SELECT * FROM realisateur WHERE id = ?",
                    realisateurRowMapper,
                    id
            );
            return Optional.ofNullable(realisateur);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty(); // Aucun réalisateur trouvé
        }
    }
    }
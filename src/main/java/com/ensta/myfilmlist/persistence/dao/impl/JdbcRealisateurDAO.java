package com.ensta.myfilmlist.persistence.dao.impl;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

import com.ensta.myfilmlist.persistence.dao.FilmDAO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ensta.myfilmlist.persistence.ConnectionManager;
import com.ensta.myfilmlist.persistence.dao.RealisateurDAO;
import com.ensta.myfilmlist.model.Realisateur;

@Repository
public class JdbcRealisateurDAO implements RealisateurDAO{

    /*
    DAO = data access object
    Contient toute le tableau des réalisateurs
     */

// attributs
    //private JdbcTemplate jdbcTemplate =
    //    ConnectionManager.getJdbcTemplate();
    
    @Autowired
    private JdbcTemplate jdbcTemplate = ConnectionManager.getJdbcTemplate();

    private FilmDAO filmDAO;

    public JdbcRealisateurDAO() {
        this.filmDAO = new JdbcFilmDAO();
    }


    // Le mapping permet de créer des objets Réalisateur à partir du résulta de la query
    private final RowMapper<Realisateur> realisateurRowMapper = new RowMapper<>() {
        @Override
        public Realisateur mapRow(ResultSet rs, int rowNum) throws SQLException {
            Realisateur realisateur = new Realisateur();
            long id = rs.getLong("id");
            realisateur.setId(id);
            realisateur.setNom(rs.getString("nom"));
            realisateur.setPrenom(rs.getString("prenom"));
            realisateur.setDateNaissance(rs.getDate("date_naissance").toLocalDate());
            realisateur.setCelebre(rs.getBoolean("celebre"));

            // La liste des films devra être chargée séparément (pas incluse ici)
            realisateur.setFilmRealises(filmDAO.findByRealisateurId(id)); // Placeholder pour les films : réservé temporairement pour ajouter la liste de films
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


    public Realisateur update(Realisateur realisateur){
        // Realisateur UpdatedRealisateur=findById(realisateur.getId()).get();
        // le .get() permet de récupérer le réalisateur s'il en trouve un dans l'optionnel et fait une erreur sinon
        // UpdatedRealisateur.setNom(realisateur.getNom());
        // UpdatedRealisateur.setPrenom(realisateur.getPrenom());
        // UpdatedRealisateur.setDateNaissance(realisateur.getDateNaissance());
        // UpdatedRealisateur.setCelebre(realisateur.isCelebre());
        // UpdatedRealisateur.setFilmRealises(realisateur.getFilmRealises());
        // UpdatedRealisateur.setDateNaissance(realisateur.getDateNaissance());

        jdbcTemplate.update("UPDATE REALISATEUR SET NOM =?, PRENOM =? ,DATE_NAISSANCE = ?, CELEBRE=?  WHERE id = ?",
                realisateur.getNom(),
                realisateur.getPrenom(),
                realisateur.getDateNaissance(),
                realisateur.isCelebre(),
                realisateur.getId()
        );
        return realisateur;
        }

    @Override
    public Realisateur save(Realisateur realisateur) {
        String CREATE_REALISATEUR_QUERY = "INSERT INTO REALISATEUR (nom, prenom, date_naissance, celebre) VALUES (?, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        PreparedStatementCreator creator = conn -> {
            PreparedStatement statement = conn.prepareStatement(
                    CREATE_REALISATEUR_QUERY,
                    Statement.RETURN_GENERATED_KEYS
            );
            statement.setString(1, realisateur.getNom());
            statement.setString(2, realisateur.getPrenom());
            statement.setDate(3, java.sql.Date.valueOf(realisateur.getDateNaissance()));
            statement.setBoolean(4, realisateur.isCelebre());
            return statement;
        };

        // Exécute la requête d'insertion
        jdbcTemplate.update(creator, keyHolder);

        // Récupère l'ID généré et l'affecte au réalisateur
        realisateur.setId(keyHolder.getKey().longValue());

        return realisateur;
    }


}


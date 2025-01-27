package com.ensta.myfilmlist.persistence.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.ensta.myfilmlist.persistence.dao.FilmDAO;
import com.ensta.myfilmlist.model.Film;
import com.ensta.myfilmlist.model.Realisateur;
import com.ensta.myfilmlist.persistence.ConnectionManager;


@Repository
public class JdbcFilmDAO implements FilmDAO {
    /*
    private DataSource dataSource = ConnectionManager.getDataSource(); (plus utile)
    */
    //private JdbcTemplate jdbcTemplate =
    //        ConnectionManager.getJdbcTemplate();
    @Autowired
    private JdbcTemplate jdbcTemplate = ConnectionManager.getJdbcTemplate();


/*
    @Override
    public List<Film> findAll() {
        List<Film> films = new ArrayList<>();
        String requete = "SELECT id, titre, duree FROM FILM";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(requete);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()){
                Film film = new Film();
                film.setId(resultSet.getLong("id"));
                film.setTitre(resultSet.getString("titre"));
                film.setDuree(resultSet.getInt("duree"));
                films.add(film);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return films;}}
*/

    public class FilmRowMapper implements RowMapper<Film> {
        @Override
        public Film mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            Film film = new Film();
            film.setId(resultSet.getLong("id"));
            film.setTitre(resultSet.getString("titre"));
            film.setDuree(resultSet.getInt("duree"));

            Long realisateurId = resultSet.getLong("realisateur_id");
            if (!resultSet.wasNull()) { // Si le champ n'est pas NULL
                Realisateur realisateur = new Realisateur();
                realisateur.setId(realisateurId);
                realisateur.setNom(resultSet.getString("realisateur_nom"));
                realisateur.setPrenom(resultSet.getString("realisateur_prenom"));
                realisateur.setDateNaissance(resultSet.getTimestamp("realisateur_date_naissance").toLocalDateTime().toLocalDate());
                realisateur.setCelebre(resultSet.getBoolean("realisateur_celebre"));

                film.setRealisateur(realisateur);
            }

            return film;
        }
    }

    @Override
    public List<Film> findAll() {
        String sql = "SELECT " +
                "f.id AS film_id, f.titre AS film_titre, f.duree AS film_duree, " +
                "r.id AS realisateur_id, r.nom AS realisateur_nom, r.prenom AS realisateur_prenom, " +
                "r.date_naissance AS realisateur_date_naissance, r.celebre AS realisateur_celebre " +
                "FROM FILM f " +
                "LEFT JOIN REALISATEUR r ON f.realisateur_id = r.id";



        return jdbcTemplate.query(sql, new FilmRowMapper());
    }

    @Override
    public Film save(Film film) {
        String CREATE_FILM_QUERY = "INSERT INTO FILM (titre, duree, realisateur_id) VALUES (?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        PreparedStatementCreator creator = conn -> {
            PreparedStatement statement = conn.prepareStatement(
                    CREATE_FILM_QUERY,
                    Statement.RETURN_GENERATED_KEYS
            );
            statement.setString(1, film.getTitre());
            statement.setInt(2, film.getDuree());
            statement.setLong(3, film.getRealisateur().getId());
            return statement;
        };
        // ici insertion
        jdbcTemplate.update(creator, keyHolder);
        film.setId(keyHolder.getKey().longValue());
        return film;
    }

    @Override
    public Optional<Film> findById(long id) {
        String sql = "SELECT f.id AS film_id, f.titre AS film_titre, f.duree AS film_duree, " +
                    "r.id AS realisateur_id, r.nom AS realisateur_nom, r.prenom AS realisateur_prenom, " +
                    "r.date_naissance AS realisateur_date_naissance, r.celebre AS realisateur_celebre " +
                    "FROM FILM f " +
                    "LEFT JOIN REALISATEUR r ON f.realisateur_id = r.id " +
                    "WHERE f.id = ?";
        
        List<Film> films = jdbcTemplate.query(sql, new FilmRowMapper(), id);
        if (films.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(films.get(0));
    }

    @Override
    public void delete(Film film) {
        String sql = "DELETE FROM FILM WHERE id = ?";
        jdbcTemplate.update(sql, film.getId());
    }


    @Override
    public List<Film> findByRealisateurId(long realisateurId) {
        String sql = "SELECT " +
                "f.id AS film_id, f.titre AS film_titre, f.duree AS film_duree, " +
                "r.id AS realisateur_id, r.nom AS realisateur_nom, r.prenom AS realisateur_prenom, " +
                "r.date_naissance AS realisateur_date_naissance, r.celebre AS realisateur_celebre " +
                "FROM FILM f " +
                "LEFT JOIN REALISATEUR r ON f.realisateur_id = r.id " +
                "WHERE r.id = ?";

        return jdbcTemplate.query(sql, new FilmRowMapper(), realisateurId);
    }

}


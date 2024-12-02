package com.ensta.myfilmlist.dao.impl;

import com.ensta.myfilmlist.dao.FilmDAO;
import com.ensta.myfilmlist.exception.ServiceException;
import com.ensta.myfilmlist.model.Realisateur;
import java.lang.Math;

import java.sql.*;
import java.util.List;
import java.util.stream.Stream;
import java.util.Arrays;
import java.util.ArrayList;

import com.ensta.myfilmlist.exception.ServiceException;
import com.ensta.myfilmlist.model.Film;
import com.ensta.myfilmlist.exception.ServiceException;
import com.ensta.myfilmlist.model.Realisateur;
import com.ensta.myfilmlist.persistence.ConnectionManager;
import com.ensta.myfilmlist.service.MyFilmsService;
import org.hibernate.sql.Select;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import javax.xml.transform.Result;
import org.springframework.jdbc.core.RowMapper;


import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public class JdbcFilmDAO implements FilmDAO {
    /*
    private DataSource dataSource = ConnectionManager.getDataSource(); (plus utile)
    */
    private JdbcTemplate jdbcTemplate =
            ConnectionManager.getJdbcTemplate();

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
            return film;
        }
    }

    @Override
    public List<Film> findAll() {
        String sql = "SELECT id, titre, duree FROM FILM";
        return jdbcTemplate.query(sql, new FilmRowMapper());
    }

    @Override
    public Film save(Film film) {
        String CREATE_FILM_QUERY = "INSERT INTO FILM (titre, duree) VALUES (?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        PreparedStatementCreator creator = conn -> {
            PreparedStatement statement = conn.prepareStatement(
                    CREATE_FILM_QUERY,
                    Statement.RETURN_GENERATED_KEYS
            );
            statement.setString(1, film.getTitre());
            statement.setInt(2, film.getDuree());
            return statement;
        };
        // ici insertion
        jdbcTemplate.update(creator, keyHolder);
        film.setId(keyHolder.getKey().longValue());
        return film;
    }
}


package com.ensta.myfilmlist.dao.impl;

import com.ensta.myfilmlist.dao.FilmDAO;
import com.ensta.myfilmlist.exception.ServiceException;
import com.ensta.myfilmlist.model.Realisateur;
import java.lang.Math;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

import javax.sql.DataSource;
import javax.xml.transform.Result;

public class JdbcFilmDAO implements FilmDAO {
    private DataSource dataSource = ConnectionManager.getDataSource();

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


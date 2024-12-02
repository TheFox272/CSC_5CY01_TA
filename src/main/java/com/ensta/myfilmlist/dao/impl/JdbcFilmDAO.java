package com.ensta.myfilmlist.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import com.ensta.myfilmlist.dao.FilmDAO;
import com.ensta.myfilmlist.model.Film;
import com.ensta.myfilmlist.persistence.ConnectionManager;

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
        return films;}


    @Override
    public Optional<Film> findById(long id) {
        String requete = "SELECT id, titre, duree FROM films WHERE id = ?";
        try (Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(requete)) {
            
            preparedStatement.setLong(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Film film = new Film();
                    film.setId(resultSet.getLong("id"));
                    film.setTitre(resultSet.getString("titre"));
                    film.setDuree(resultSet.getInt("duree"));
                    return Optional.of(film);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();}

    @Override
    public void delete(Film film) {
        String requete = "DELETE FROM films WHERE id = ?";
        try (Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(requete)) {
            preparedStatement.setLong(1, film.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Film> findByRealisateurId(long realisateurId) {
        List<Film> films = new ArrayList<>();
        String requete = "SELECT id, titre, duree FROM films WHERE realisateur = ?";
        try (Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(requete)) {
            preparedStatement.setLong(1, realisateurId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Film film = new Film();
                    film.setId(resultSet.getLong("id"));
                    film.setTitre(resultSet.getString("titre"));
                    film.setDuree(resultSet.getInt("duree"));
                    films.add(film);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return films;
    }


}
    

package com.ensta.myfilmlist.dao;

import com.ensta.myfilmlist.exception.ServiceException;
import com.ensta.myfilmlist.model.Realisateur;
import java.lang.Math;

import java.util.List;
import java.util.stream.Stream;
import java.util.Arrays;

import com.ensta.myfilmlist.exception.ServiceException;
import com.ensta.myfilmlist.model.Film;
import com.ensta.myfilmlist.exception.ServiceException;
import com.ensta.myfilmlist.model.Realisateur;
import com.ensta.myfilmlist.persistence.ConnectionManager;
import com.ensta.myfilmlist.service.MyFilmsService;

import javax.sql.DataSource;




public interface FilmDAO {

    List<Film> findAll();
    /* To add a film in the DB */
    Film save(Film film);

}

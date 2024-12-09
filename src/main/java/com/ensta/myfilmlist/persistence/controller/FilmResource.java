package com.ensta.myfilmlist.persistence.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ensta.myfilmlist.dto.FilmDTO;
import com.ensta.myfilmlist.exception.ControllerException;

public interface FilmResource {
    public ResponseEntity<List<FilmDTO>> getAllFilms() throws ControllerException;
    public ResponseEntity<FilmDTO> getFilmById(long id) throws ControllerException;
}

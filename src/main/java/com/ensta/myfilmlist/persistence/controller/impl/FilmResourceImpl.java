package com.ensta.myfilmlist.persistence.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ensta.myfilmlist.dto.FilmDTO;
import com.ensta.myfilmlist.exception.ControllerException;
import com.ensta.myfilmlist.exception.ServiceException;
import com.ensta.myfilmlist.persistence.controller.FilmResource;
import com.ensta.myfilmlist.service.MyFilmsService;

@RestController
@RequestMapping("/film")
public class FilmResourceImpl implements FilmResource {

    private final MyFilmsService filmService;

    @Autowired
    public FilmResourceImpl(MyFilmsService filmService) {
        this.filmService = filmService;
    }

    @GetMapping
    public ResponseEntity<List<FilmDTO>> getAllFilms() throws ControllerException{
        try {
            return ResponseEntity.status(HttpStatus.OK).body(filmService.findAllFilms());
        } catch (ServiceException e) {
            throw new ControllerException(e);
        }

    }

    @GetMapping("/{id}") // Mapping pour une URL de type /film/{id}
    public ResponseEntity<FilmDTO> getFilmById(@PathVariable("id") long id) throws ControllerException{
        try {
            FilmDTO responseFilm = filmService.findFilmById(id);
            if (responseFilm == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseFilm);
            return ResponseEntity.status(HttpStatus.OK).body(responseFilm);
        } catch (ServiceException e) {
            throw new ControllerException(e);
        }
    }


}

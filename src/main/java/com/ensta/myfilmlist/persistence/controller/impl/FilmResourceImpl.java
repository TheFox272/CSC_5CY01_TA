package com.ensta.myfilmlist.persistence.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ensta.myfilmlist.dto.FilmDTO;
import com.ensta.myfilmlist.exception.ControllerException;
import com.ensta.myfilmlist.exception.ServiceException;
import com.ensta.myfilmlist.form.FilmForm;
import com.ensta.myfilmlist.persistence.controller.FilmResource;
import com.ensta.myfilmlist.service.MyFilmsService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/film")
public class FilmResourceImpl implements FilmResource {

    private final MyFilmsService filmService;

    @Autowired
    public FilmResourceImpl(MyFilmsService filmService) {
        this.filmService = filmService;
    }

    @CrossOrigin(origins = "http://localhost:3000")
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

    @PostMapping
    public ResponseEntity<FilmDTO> createFilm(@RequestBody FilmForm filmForm) throws ControllerException {
        try {
            // Appel au service pour créer le film
            FilmDTO createdFilm = filmService.createFilm(filmForm);

            // Retourne une réponse 201 Created avec le film créé
            return new ResponseEntity<>(createdFilm, HttpStatus.CREATED);
        } catch (ServiceException e) {
            // En cas d'erreur, on lève une ControllerException
            throw new ControllerException("Erreur lors de la création du film : " + e.getMessage(), e);
        }
    }


}

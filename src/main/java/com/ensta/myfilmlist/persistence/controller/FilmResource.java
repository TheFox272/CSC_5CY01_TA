package com.ensta.myfilmlist.persistence.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.ensta.myfilmlist.dto.FilmDTO;
import com.ensta.myfilmlist.exception.ControllerException;
import com.ensta.myfilmlist.form.FilmForm;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import javax.validation.Valid;

// L’API s’appelle « Film » et utilise le Tag « Film »
// Le tag « Film » contient la description de l’API
@Api(tags = "Film") 
@Tag(name = "Film", description = "Opération sur les films")


public interface FilmResource {

    @ApiOperation(value = "Lister les films", notes = "Permet de renvoyer la liste de tous les films.", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
		@ApiResponse(code = 200, message = "La liste des films a été renvoyée correctement")
    })


    public ResponseEntity<List<FilmDTO>> getAllFilms() throws ControllerException;
    public ResponseEntity<FilmDTO> getFilmById(long id) throws ControllerException;
    public ResponseEntity<FilmDTO> createFilm(@Valid FilmForm filmForm) throws ControllerException;
}

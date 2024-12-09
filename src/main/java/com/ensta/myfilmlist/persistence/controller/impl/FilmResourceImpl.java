package com.ensta.myfilmlist.persistence.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ensta.myfilmlist.dto.FilmDTO;
import com.ensta.myfilmlist.exception.ControllerException;
import com.ensta.myfilmlist.exception.ServiceException;
import com.ensta.myfilmlist.persistence.controller.FilmResource;
import com.ensta.myfilmlist.service.MyFilmsService;
import org.springframework.web.bind.annotation.CrossOrigin;

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


}

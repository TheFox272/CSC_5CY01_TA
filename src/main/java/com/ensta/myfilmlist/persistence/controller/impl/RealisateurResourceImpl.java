package com.ensta.myfilmlist.persistence.controller.impl;

import java.util.List;

import com.ensta.myfilmlist.form.RealisateurForm;
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
import com.ensta.myfilmlist.service.MyFilmsService;
import com.ensta.myfilmlist.dto.RealisateurDTO;


import io.swagger.v3.oas.annotations.parameters.RequestBody;

import com.ensta.myfilmlist.persistence.controller.RealisateurResource;

@RestController
@RequestMapping("/realisateur")
public class RealisateurResourceImpl implements RealisateurResource{
    private final MyFilmsService filmService;

    @Autowired
    public RealisateurResourceImpl(MyFilmsService filmService) {
        this.filmService = filmService;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    public ResponseEntity<List<RealisateurDTO>> getAllRealisateurs() throws ControllerException{
        try {
            return ResponseEntity.status(HttpStatus.OK).body(filmService.findAllRealisateurs());
        } catch (ServiceException e) {
            throw new ControllerException(e);
        }

    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/{id}") // Mapping pour une URL de type /realisateur/{id}
    public ResponseEntity<RealisateurDTO> getRealisateurById(@PathVariable("id") long id) throws ControllerException{
        try {
            RealisateurDTO responseRealisateur = filmService.findRealisateurById(id);
            if (responseRealisateur == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseRealisateur);
            return ResponseEntity.status(HttpStatus.OK).body(responseRealisateur);
        } catch (ServiceException e) {
            throw new ControllerException(e);
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping
    public ResponseEntity<RealisateurDTO> createRealisateur(@RequestBody RealisateurForm realisateurform) throws ControllerException {
        try {

            // Appel au service pour créer le réalisateur --> j'ai aj la méthode après
            RealisateurDTO createdFilm = filmService.createRealisateur(realisateurform);

            // Retourne une réponse 201 Created avec le film créé
            return new ResponseEntity<>(createdFilm, HttpStatus.CREATED);
        } catch (ServiceException e) {
            throw new ControllerException("Erreur lors de la création du film : " + e.getMessage(), e);
        }
    }



    
}

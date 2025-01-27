package com.ensta.myfilmlist.controller;

import java.util.List;

import com.ensta.myfilmlist.form.RealisateurForm;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.ensta.myfilmlist.dto.FilmDTO;
import com.ensta.myfilmlist.dto.RealisateurDTO;
import com.ensta.myfilmlist.exception.ControllerException;
import com.ensta.myfilmlist.form.FilmForm;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

// L’API s’appelle « Realisateur » et utilise le Tag « Realisateur »
// Le tag « Realisateur » contient la description de l’API
@Api(tags = "Realisateur") 
@Tag(name = "Realisateur", description = "Opération sur les réalisateurs (format date attendu : dd-MM-yyyy)")


public interface RealisateurResource {

    // Pour swagger
    @ApiOperation(value = "Lister les réalisateurs", notes = "Permet de renvoyer la liste de tous les réalisateurs. Format de dates attendu : dd-MM-yyyy", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
	@ApiResponse(code = 200, message = "La liste des réalisateurs a été renvoyée correctement")
    })


    public ResponseEntity<List<RealisateurDTO>> getAllRealisateurs() throws ControllerException;
    public ResponseEntity<RealisateurDTO> getRealisateurById(long id) throws ControllerException;
    public ResponseEntity<RealisateurDTO> createRealisateur(RealisateurForm realisateurForm) throws ControllerException;
    
}

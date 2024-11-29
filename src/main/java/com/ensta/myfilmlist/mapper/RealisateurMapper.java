package com.ensta.myfilmlist.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.ensta.myfilmlist.dto.RealisateurDTO;
import com.ensta.myfilmlist.model.Realisateur;

/**
 * Effectue les conversions des Réalisateurs entre les couches de l'application.
 */
public class RealisateurMapper {

    /**
     * Convertit une liste de réalisateurs en liste de DTO.
     *
     * @param realisateurs la liste des réalisateurs
     * @return Une liste non nulle de DTO construite à partir de la liste des réalisateurs.
     */
    public static List<RealisateurDTO> convertRealisateurToRealisateurDTOs(List<Realisateur> realisateurs) {
        return realisateurs.stream()
                .map(RealisateurMapper::convertRealisateurToRealisateurDTO)
                .collect(Collectors.toList());
    }

    /**
     * Convertit un réalisateur en DTO.
     *
     * @param realisateur le réalisateur à convertir
     * @return Un DTO construit à partir des données du réalisateur.
     */
    public static RealisateurDTO convertRealisateurToRealisateurDTO(Realisateur realisateur) {
        RealisateurDTO realisateurDTO = new RealisateurDTO();
        realisateurDTO.setId(realisateur.getId());
        realisateurDTO.setNom(realisateur.getNom());
        realisateurDTO.setPrenom(realisateur.getPrenom());
        realisateurDTO.setDateNaissance(realisateur.getDateNaissance());
        realisateurDTO.setCelebre(realisateur.isCelebre());

        // L'attribut filmRealises n'est pas inclus ici, il peut être ajouté ultérieurement si nécessaire
        return realisateurDTO;
    }

    /**
     * Convertit un DTO en réalisateur.
     *
     * @param realisateurDTO le DTO à convertir
     * @return Un Réalisateur construit à partir des données du DTO.
     */
    public static Realisateur convertRealisateurDTOToRealisateur(RealisateurDTO realisateurDTO) {
        Realisateur realisateur = new Realisateur();
        realisateur.setId(realisateurDTO.getId());
        realisateur.setNom(realisateurDTO.getNom());
        realisateur.setPrenom(realisateurDTO.getPrenom());
        realisateur.setDateNaissance(realisateurDTO.getDateNaissance());
        realisateur.setCelebre(realisateurDTO.isCelebre());

        // L'attribut filmRealises n'est pas inclus ici, il peut être ajouté ultérieurement si nécessaire
        return realisateur;
    }

    /*
    // je ne vois pas la mention de réalisateur form, faut il aj ??
     * Convertit un Form en réalisateur.
     *
     * @param realisateurForm le Form à convertir
     * @return Un Réalisateur construit à partir des données du Form.

    public static Realisateur convertRealisateurFormToRealisateur(RealisateurForm realisateurForm) {
        Realisateur realisateur = new Realisateur();
        realisateur.setNom(realisateurForm.getNom());
        realisateur.setPrenom(realisateurForm.getPrenom());
        realisateur.setDateNaissance(realisateurForm.getDateNaissance());
        realisateur.setCelebre(realisateurForm.isCelebre());

        // L'attribut filmRealises n'est pas inclus ici, il peut être ajouté ultérieurement si nécessaire
        return realisateur;
    }
     */
}

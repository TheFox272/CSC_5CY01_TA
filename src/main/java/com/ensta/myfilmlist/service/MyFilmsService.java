package com.ensta.myfilmlist.service;

import java.util.List;

import com.ensta.myfilmlist.exception.ServiceException;
import com.ensta.myfilmlist.model.Realisateur;
import com.ensta.myfilmlist.model.Film;

//********************************************************************************************************************

public interface MyFilmsService {
    
    /**
     * Met à jour la célébrité d'un réalisateur (en fonction du nombre de films réalisés)
     * @param realisateur le réalisateur à mettre à jour
     * @return le réalisateur mis à jour
     */
    Realisateur updateRealisateurCelebre(Realisateur realisateur) throws ServiceException;

    /*
     * Calcule la durée totale des films
     */
    int calculerDureeTotale(List<Film> listeFilms) throws ServiceException;

    /*
     * Calcule la note moyenne des films et retourne la note moyenne, arrondie à 2 chiffres après la virgule, ou 0 par défaut si la liste des notes est vide
     */
    double calculerNoteMoyenne(double[] tableauNotes) throws ServiceException;

    /*
     * Met à jour la célébrité de plusieurs réalisateurs (en fonction du nombre de films réalisés)
     * @param realisateurs la liste des réalisateurs à mettre à jour
     * @return la liste des réalisateurs célébres parmi les réalisateurs mis à jour
     */
    List<Realisateur> updateRealisateurCelebres(List<Realisateur> realisateurs) throws ServiceException;

}

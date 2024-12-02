package com.ensta.myfilmlist.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.ensta.myfilmlist.dao.FilmDAO;
import com.ensta.myfilmlist.dao.RealisateurDAO;
import com.ensta.myfilmlist.dao.impl.JdbcFilmDAO;
import com.ensta.myfilmlist.dao.impl.JdbcRealisateurDAO;
import com.ensta.myfilmlist.dto.FilmDTO;
import com.ensta.myfilmlist.dto.RealisateurDTO;
import com.ensta.myfilmlist.exception.ServiceException;
import com.ensta.myfilmlist.mapper.FilmMapper;
import com.ensta.myfilmlist.mapper.RealisateurMapper;
import com.ensta.myfilmlist.model.Film;
import com.ensta.myfilmlist.model.Realisateur;
import com.ensta.myfilmlist.service.MyFilmsService;



//********************************************************************************************************************

public class MyFilmsServiceImpl implements MyFilmsService {

    // Constantes
    public static final int NB_FILMS_MIN_REALISATEUR_CELEBRE = 3;
    public FilmDAO filmDAO;
    public RealisateurDAO realisateurDAO;


    public MyFilmsServiceImpl() {
        this.filmDAO = new JdbcFilmDAO();
        this.realisateurDAO = new JdbcRealisateurDAO();
    }

    @Override
    public Realisateur updateRealisateurCelebre(Realisateur realisateur) throws ServiceException {
        // Realisateur non null
        if (realisateur == null) {
            throw new ServiceException("Le réalisateur ne peut pas être null");
        }

        // Liste des films réalisés non null
        List<Film> filmRealises = realisateur.getFilmRealises();
        if (filmRealises == null) {
            throw new ServiceException("La liste des films réalisés par le réalisateur ne peut pas être null");
        }

        // Mise à jour de la célébrité du réalisateur
        if (filmRealises.size() >= NB_FILMS_MIN_REALISATEUR_CELEBRE) {
            realisateur.setCelebre(true);
        }
        else {
            realisateur.setCelebre(false);
        }

        return realisateur;
    }

    @Override
    public int calculerDureeTotale(List<Film> listeFilms) throws ServiceException {
        // Liste des films non null
        if (listeFilms == null) {
            throw new ServiceException("La liste des films ne peut pas être null");
        }

        // Calcul de la durée totale des films
        return listeFilms.stream()
            .peek(film -> {
                if (film == null) {
                    throw new RuntimeException(new ServiceException("Un film de la liste ne peut pas être null"));
                }
            })
            .mapToInt(Film::getDuree)
            .sum();

        // // Calcul de la durée totale des films (ancienne méthode)
        // int dureeTotale = 0;
        // for (Film film : listeFilms) {
        //     if (film == null) {
        //         throw new ServiceException("Un film de la liste ne peut pas être null");
        //     }
        //     dureeTotale += film.getDuree();
        // }
        // return dureeTotale;
    }

    @Override
    public double calculerNoteMoyenne(double[] tableauNotes) throws ServiceException {
        // Tableau des notes non null
        if (tableauNotes == null) {
            throw new ServiceException("Le tableau des notes ne peut pas être null");
        }

        // Calcul de la note moyenne
        return Math.round(Arrays.stream(tableauNotes).average().orElse(0) * 100.0) / 100.0;


        // // Calcul de la note moyenne (ancienne méthode)
        // double noteMoyenne = 0;
        // if (tableauNotes.length > 0) {
        //     double sommeNotes = 0;
        //     for (double note : tableauNotes) {
        //          if (note < 0 || note > 20) {
        //              throw new ServiceException("La note doit être comprise entre 0 et 20");
        //          }
        //         sommeNotes += note;
        //     }
        //     noteMoyenne = sommeNotes / tableauNotes.length;
        //     // On arrondit à 2 chiffres après la virgule
        //     noteMoyenne = Math.round(noteMoyenne * 100.0) / 100.0;
        // }

        // return noteMoyenne;
    }

    @Override
    public List<Realisateur> updateRealisateurCelebres(List<Realisateur> realisateurs) throws ServiceException {
        // Liste des réalisateurs non null
        if (realisateurs == null) {
            throw new ServiceException("La liste des réalisateurs ne peut pas être null");
        }

        // Mise à jour de la célébrité des réalisateurs
        return realisateurs.stream()
            .map(realisateur -> {
                try {
                    return updateRealisateurCelebre(realisateur);
                } catch (ServiceException e) {
                    throw new RuntimeException(e);
                }
            })
            .filter(realisateur -> realisateur.isCelebre())
            .toList();
    }
    @Override
    public List<FilmDTO> findAllFilms() throws ServiceException {
        try {
            List<Film> films = filmDAO.findAll();
            return films.stream().map(FilmMapper::convertFilmToFilmDTO).collect(Collectors.toList());



        } catch (Exception e) {
            throw new ServiceException("Problème lors de la récupération", e);
        }
    }
    @Override
    public List<RealisateurDTO> findAllRealisateurs() throws ServiceException {
        try {
            List<Realisateur> realisateurs = this.realisateurDAO.findAll();
            return RealisateurMapper.convertRealisateurToRealisateurDTOs(realisateurs);
        } catch (Exception e) {
            throw new ServiceException("Erreur lors de la récupération de la liste des réalisateurs", e);
        }
    }

    @Override
    public RealisateurDTO findRealisateurByNomAndPrenom(String nom, String prenom) throws ServiceException {
        try {
            Realisateur realisateur = this.realisateurDAO.findByNomAndPrenom(nom, prenom);
            return RealisateurMapper.convertRealisateurToRealisateurDTO(realisateur);
        } catch (Exception e) {
            throw new ServiceException("Erreur lors de la récupération du réalisateur", e);
        }
    }

    @Override
    public FilmDTO findFilmById(long id) throws ServiceException {
        try {
            Optional<Film> optionalFilm = this.filmDAO.findById(id);
                return FilmMapper.convertFilmToFilmDTO(optionalFilm.get());
            
        } catch (Exception e) {
            throw new ServiceException("Erreur lors de la récupération du film", e);
        }
    }

    @Override
    public void deleteFilm(long id) throws ServiceException{
        try {
        Optional<Film> optionalFilm = filmDAO.findById(id);
        filmDAO.delete(optionalFilm.get());}
        catch (Exception e) {
            throw new ServiceException("Erreur lors de la suppression du film", e);
        }
    }



}
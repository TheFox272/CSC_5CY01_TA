package com.ensta.myfilmlist.form;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;


/**
 * Contient les donnees pour requeter un film.
 */
public class EditFilmForm {
    @Positive
    @Min(value=1)
    @NotNull
    private long id;
    private String titre;
    @Positive
    @Min(value=1)
    private int duree;
    @Positive
    @Min(value=1)
    private long realisateurId;

    public long getId() {
        return id;
    }

    public void setId(long filmId) {
        this.id = filmId;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public long getRealisateurId() {
        return realisateurId;
    }

    public void setRealisateurId(long realisateurId) {
        this.realisateurId = realisateurId;
    }

}


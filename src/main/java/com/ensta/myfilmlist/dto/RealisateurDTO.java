package com.ensta.myfilmlist.dto;

import java.time.LocalDate;
import java.util.List;

/**
 * Contient les donnees d'un Réalisateur.
 */

// remarque : la classe DTO est exactement la même que la classe model
// mais sans les méthodes liées à la logique métier
// et avec l'utilisation d'un DTO pour l'attribut film
public class RealisateurDTO {

    // Attributs
    private long id;
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
    private List<FilmDTO> filmRealises; // difference ici car on ut un DTO au lieu du model film
    private boolean celebre;

    // Constructeurs
    public RealisateurDTO() {
    }

    public RealisateurDTO(long id, String nom, String prenom, LocalDate dateNaissance, List<FilmDTO> filmRealises, boolean celebre) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.filmRealises = filmRealises;
        this.celebre = celebre;
    }

    // Getters et Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public List<FilmDTO> getFilmRealises() {
        return filmRealises;
    }

    public void setFilmRealises(List<FilmDTO> filmRealises) {
        this.filmRealises = filmRealises;
    }

    public boolean isCelebre() {
        return celebre;
    }

    public void setCelebre(boolean celebre) {
        this.celebre = celebre;
    }

    // Méthode toString pour affichage
    @Override
    public String toString() {
        return "RealisateurDTO{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", dateNaissance=" + dateNaissance +
                ", filmRealises=" + filmRealises +
                ", celebre=" + celebre +
                '}';
    }
}

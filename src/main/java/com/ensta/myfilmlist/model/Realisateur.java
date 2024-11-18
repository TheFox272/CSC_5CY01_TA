package com.ensta.myfilmlist.model;

import java.time.LocalDate;
import java.util.List;

/**
 * Représente un Réalisateur.
 */
public class Realisateur {

    private long id;
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
    private List<Film> filmRealises; // Liste des films réalisés par le réalisateur
    private boolean celebre;

    // Constructeurs
    public Realisateur() {
    }

    public Realisateur(long id, String nom, String prenom, LocalDate dateNaissance, List<Film> filmRealises, boolean celebre) {
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

    public List<Film> getFilmRealises() {
        return filmRealises;
    }

    public void setFilmRealises(List<Film> filmRealises) {
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
        return "Realisateur{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", dateNaissance=" + dateNaissance +
                ", filmRealises=" + filmRealises +
                ", celebre=" + celebre +
                '}';
    }
}


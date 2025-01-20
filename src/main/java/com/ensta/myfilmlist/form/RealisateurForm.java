package com.ensta.myfilmlist.form;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 * Contient les données pour requêter un réalisateur.
 */
public class RealisateurForm {

    private String nom;
    private String prenom;
    private LocalDate dateNaissance;

    // Getters et Setters
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

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
}

package com.ensta.myfilmlist.model;

//********************************************************************************************************************

/**
 * Représente un utilisateur
 */
public class Utilisateur {

    // Attributs
    private long id;
    private String nom;
    private String prenom;

    // Constructeurs
    public Utilisateur() {
    }

    public Utilisateur(long id, String nom, String prenom) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
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
}

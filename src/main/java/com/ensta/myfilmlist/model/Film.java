package com.ensta.myfilmlist.model;

import com.ensta.myfilmlist.model.Realisateur;

//********************************************************************************************************************

/**
 * Représente un film
 */
public class Film {

	// Attributs
	private long id;
	private String titre;
	private int duree;
	private Realisateur realisateur;

	// Constructeurs
	public Film() {
	}

	public Film(long id, String titre, int duree, Class Realisateur) {
		this.id = id;
		this.titre = titre;
		this.duree = duree;
		this.realisateur = realisateur;
	}

	// Getters et Setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public Realisateur getRealisateur(){
		return realisateur;
	}

	public void setRealisateur(Realisateur realisateur){
		this.realisateur = realisateur;
	}


	public String toString(){return titre;}

}

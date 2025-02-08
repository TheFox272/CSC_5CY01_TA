package com.ensta.myfilmlist.dto;

import com.ensta.myfilmlist.model.Realisateur;

/**
 * Contient les donnees d'un Film.
 */
public class FilmDTO {

	private long id;

	private String titre;
	private String description;

	private int duree;

	private RealisateurDTO realisateur;

	public RealisateurDTO getRealisateur() {
		return realisateur;
	}
	public void setRealisateur(RealisateurDTO realisateur) {
		this.realisateur = realisateur;
	}

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	@Override
	public String toString() {
		return "FilmDTO [id=" + id + ", titre=" + titre + ", duree=" + duree + ",  description=" + description + "]";
	}

}

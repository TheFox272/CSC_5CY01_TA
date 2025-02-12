import axios from 'axios';

const FILM_URI = 'http://localhost:8080/film'

export function getAllFilms(){
	return axios.get(FILM_URI);
}

export function postFilm(film){
	return axios.post(FILM_URI + '?realisateurId=' + film.realisateurId + '&titre=' + film.titre + '&duree=' + film.duree + '&description=' + film.description);
}

export function putFilm(film){
	return axios.put(FILM_URI + '?id=' + film.id + '&realisateurId=' + film.realisateurId + '&titre=' + film.titre + '&duree=' + film.duree + '&description=' + film.description);
}

export function deleteFilm(filmId){
	return axios.delete(`${FILM_URI}/${filmId}`);
}

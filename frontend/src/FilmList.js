import React from 'react';
import { useState, useEffect } from 'react';
import FilmCard from './FilmCard';
import { getAllFilms } from './api/FilmApi';

export default function FilmList() {
    const [films, setFilms] = useState([]);

    useEffect(() => {
    getAllFilms().then(reponse => {
        setFilms(reponse.data);
    }).catch(err => {
        console.log(err);
    })
    }, []);

    // debug
    console.log(films);

	return films.map((film)=> {
    	return <FilmCard key={film.id} film={film} />
    })
}
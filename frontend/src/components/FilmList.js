import React from 'react';
import FilmCard from './FilmCard';

//********************************************************************************************************************


export default function FilmList(props) {

    // debug
    console.log(props.films);

	return props.films.map(film => {
    	return <FilmCard key={film.id} film={film} />
    })
}
import React from 'react';
import FilmCard from './FilmCard';

//********************************************************************************************************************


export default function FilmList(props) {

    // debug
    console.log(props.films);

    const half = Math.ceil(props.films.length / 2);
    const firstHalf = props.films.slice(0, half);
    const secondHalf = props.films.slice(half);

    return (
        <div style={{ display: 'flex' }}>
            <div style={{ flex: 1 }}>
                {firstHalf.map(film => (
                    <FilmCard key={film.id} film={film} />
                ))}
            </div>
            <div style={{ flex: 1 }}>
                {secondHalf.map(film => (
                    <FilmCard key={film.id} film={film} />
                ))}
            </div>
        </div>
    );
}
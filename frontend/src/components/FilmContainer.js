import { useState, useEffect } from 'react';
import { getAllFilms, postFilm } from '../api/FilmApi';
import FilmForm from './FilmForm';
import FilmList from './FilmList';

//********************************************************************************************************************

export default function FilmContainer() {
    const [films, setFilms] = useState([]);

    useEffect(() => {
        getAllFilms().then(reponse => {
            setFilms(reponse.data);
        }).catch(err => {
            console.log(err);
        })
    }, []);

    const createFilm = () => {
        // debug
        console.log('createFilm');

        // récupérer les valeurs des champs titre, durée et réalisateur
        const titre = document.getElementById('titre').value;
        const duree = document.getElementById('duree').value;
        const realisateurId = document.getElementById('realisateur').value;

        // créer un objet film
        const film = {
            titre: titre,
            duree: duree,
            realisateurId: realisateurId
        }

        // appeler la méthode createFilm de l'API
        postFilm(film).then(reponse => {
            console.log(reponse.data);
        }).catch(err => {
            console.log(err);
        })
    }

    return (
        <>
            <FilmList films={films} />
            <FilmForm onSubmit={createFilm} />
        </>
    )
}

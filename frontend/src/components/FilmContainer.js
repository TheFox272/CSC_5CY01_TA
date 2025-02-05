import { useState, useEffect } from 'react';
import { getAllFilms, postFilm } from '../api/FilmApi';
import FilmForm from './FilmForm';
import FilmList from './FilmList';
import mockFilms from '../mock/FilmMock';

//********************************************************************************************************************
export default function FilmContainer({ className }) {
    const [films, setFilms] = useState([]);
    const [selectedRealisateur, setSelectedRealisateur] = useState('');
    
    const handleRealisateurChange = (event) => {
        setSelectedRealisateur(event.target.value);
    };

    useEffect(() => {
        getAllFilms().then(reponse => {
            setFilms(mockFilms);
            console.log(films);
        }).catch(err => {
            console.log(err);
        })
    }, []);

    const createFilm = () => {
        console.log('createFilm');
        const titre = document.getElementById('titre').value;
        const description = document.getElementById('description').value;
        const duree = document.getElementById('duree').value;
        const realisateurId = selectedRealisateur;

        const film = {
            titre,
            duree: parseInt(duree, 10),
            realisateurId,
            description
        }

        postFilm(film).then(reponse => {
            console.log(reponse.data);
            // actualiser la liste des films
            setFilms([...films, reponse.data]);
        }).catch(err => {
            console.log(err);
        })
    }

    return (
        <div>
        <div className={`filmcontainer-container ${className}`}>
            <FilmForm onSubmit={createFilm} handleRealisateurChange={handleRealisateurChange} />
        </div>
        <div>
            <FilmList films={films} />
        </div>
        </div>

    );
}

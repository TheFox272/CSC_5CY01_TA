import React, { useState, useEffect } from 'react';
import { getAllFilms } from '../api/FilmApi';
import FilmList from './FilmList';
import SearchBar from './SearchBar';

export default function FilmListWithSearch() {
    const [films, setFilms] = useState([]);
    const [filteredFilms, setFilteredFilms] = useState([]);
    const [searchTerm, setSearchTerm] = useState('');

    // Récupère les films depuis l'API
    useEffect(() => {
        getAllFilms()
            .then(response => {
                setFilms(response.data);  // Stocke tous les films
                setFilteredFilms(response.data);  // Affiche tous les films au début
            })
            .catch(error => console.log(error));
    }, []);

    // Fonction pour gérer la recherche
    const handleSearch = (term) => {
        setSearchTerm(term);
        const filtered = films.filter(film =>
            film.titre.toLowerCase().includes(term.toLowerCase())  // Recherche par titre
        );
        setFilteredFilms(filtered);
    };

    return (
        <div>
            <SearchBar onSearch={handleSearch} />
            {filteredFilms.length > 0 ? (
                <FilmList films={filteredFilms} />
            ) : (
                <p>Aucun film trouvé pour "{searchTerm}"</p>
            )}
        </div>
    );
}

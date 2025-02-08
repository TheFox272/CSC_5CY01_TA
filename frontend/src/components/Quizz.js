import React, { useEffect, useState } from 'react';
import { Card, CardContent, Typography, Box, Button, Select, MenuItem } from '@mui/material';
import { getAllFilms } from '../api/FilmApi';
import mockFilms from '../mock/FilmMock';
import starWarsImage from '../Image_accueil.png';

export default function Quizz({ className }) {
    const [films, setFilms] = useState([]);
    const [film, setFilm] = useState({});
    const [selectedFilm, setSelectedFilm] = useState("");
    const [result, setResult] = useState("");
    const [showTitle, setShowTitle] = useState(false);
    const [firstTryWins, setFirstTryWins] = useState(0);

    useEffect(() => {
        getAllFilms()
            .then(() => {
                setFilms(mockFilms);
                chooseFilm(mockFilms);
            })
            .catch((err) => {
                console.log(err);
            });
    }, []);

    const chooseFilm = (listeFilms) => {
        const randomIndex = Math.floor(Math.random() * listeFilms.length);
        setFilm(listeFilms[randomIndex]);
        setSelectedFilm(""); // Réinitialise le choix
        setResult(""); // Réinitialise le résultat
        setShowTitle(false); // Masque le titre au début
    };

    const checkAnswer = () => {
        if (selectedFilm === film.titre) {
            if (result === "") {
                setResult("Trop fort, du premier coup !");
                setFirstTryWins(firstTryWins + 1);
            } else {
                setResult("Gagné !");
            }
        } else {
            setResult("Perdu, réessaie ou donne ta langue au chat !");
            setFirstTryWins(0);
        }
    };

    const handleRejouer = () => {
        chooseFilm(films);
    };

    return (
        <Box className={`quizz-container ${className}`}>
            <Card sx={{ boxShadow: 3, maxWidth: 350, p: 2 }}>
                <CardContent>
                    <Typography sx={{
                        flexGrow: 1,
                        color: "black",
                        fontFamily: "'Starjedi', sans-serif"
                    }}>
                        Description à deviner :
                    </Typography>
                    <Typography variant="body1">
                        "{film.description || "Chargement..."}"
                    </Typography>

                    {/* Sélecteur de film */}
                    <Select
                        value={selectedFilm}
                        onChange={(e) => setSelectedFilm(e.target.value)}
                        displayEmpty
                        fullWidth
                        sx={{ mt: 2, backgroundColor: 'white' }}
                    >
                        <MenuItem value="" disabled>Choisissez un film</MenuItem>
                        {films.map((f) => (
                            <MenuItem key={f.titre} value={f.titre}>{f.titre}</MenuItem>
                        ))}
                    </Select>

                    {/* Bouton pour valider */}
                    <Button 
                        variant="contained" 
                        sx={{ 
                            mt: 2, 
                            backgroundColor: 'yellow', 
                            color: 'black', 
                            '&:hover': { backgroundColor: 'gold' } 
                        }} 
                        onClick={checkAnswer}
                        disabled={!selectedFilm}
                    >
                        Valider
                    </Button>

                    {/* Affichage du résultat */}
                    {result && (
                        <Typography sx={{ mt: 2, fontWeight: 'bold' }}>
                            {result}
                        </Typography>
                    )}

                    {/* Bouton Donner sa langue au chat */}
                    {result === "Perdu, réessaie ou donne ta langue au chat !" && (
                        <Button 
                            variant="contained" 
                            sx={{ 
                                mt: 2, 
                                backgroundColor: 'yellow', 
                                color: 'black', 
                                '&:hover': { backgroundColor: 'gold' } 
                            }} 
                            onClick={() => setShowTitle(true)}
                        >
                            Donner sa langue au chat
                        </Button>
                    )}

                    {/* Affichage du titre */}
                    {showTitle && (
                        <Typography sx={{
                            flexGrow: 1,
                            color: "black",
                            fontFamily: "'Starjedi', sans-serif",
                            mt: 2
                        }}>
                            {film.titre} !
                        </Typography>
                    )}

                    {/* Bouton Rejouer quand c'est gagné */}
                    {(result === "Gagné !" || result === "Trop fort, du premier coup !") && (
                        <Button 
                            variant="contained" 
                            sx={{ 
                                mt: 2, 
                                backgroundColor: 'yellow', 
                                color: 'black', 
                                '&:hover': { backgroundColor: 'gold' } 
                            }} 
                            onClick={handleRejouer}
                        >
                            Rejouer
                        </Button>
                    )}
                    <Typography sx={{ mt: 2, fontWeight: 'bold' }}>
                        Série de victoires du 1er coup : {firstTryWins}
                    </Typography>
                </CardContent>
            </Card>
        </Box>
    );
}

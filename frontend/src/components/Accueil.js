// src/components/Accueil.js
import React from 'react';
import { Button, Typography, Box } from '@mui/material';
import starWarsImage from '../Image_accueil.png';

export default function Accueil() {
    return (
        <Box
            sx={{
                display: 'flex',
                flexDirection: 'column',
                alignItems: 'center',
                justifyContent: 'center',
                minHeight: '100vh',
                backgroundImage: `url(${starWarsImage})`,
                backgroundSize: 'cover',
                backgroundPosition: 'center',
                backgroundRepeat: 'no-repeat',
                color: 'white',
                textShadow: '2px 2px 4px rgba(0,0,0,0.7)',
            }}
        >
            <Typography
                variant="h1"
                gutterBottom
                sx={{
                    color: 'yellow', // Bleu sombre mais doux
                    WebkitTextStroke: '5px black', // Bord blanc autour du texte
                    textStroke: '5px white',
                    fontWeight: 800,
                    // Pour la compatibilité avec tous les navigateurs
                }}
            >
                Bienvenue sur My Films
            </Typography>

            <Typography variant="h5" paragraph>
                Fabien Laura Ghislain Blandine
            </Typography>
            <Button
                variant="contained"
                color="primary"
                href="/films"
                sx={{ marginBottom: '10px' }}
            >
                Voir les films
            </Button>
            <Button variant="contained"
                    color="secondary"
                    href="/quizz">
                Participer au quizz
            </Button>
        </Box>
    );
}

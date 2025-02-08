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
                    color: 'yellow',
                    WebkitTextStroke: '5px black',
                    textStroke: '5px white',
                    fontWeight: 800,
                }}
            >
                Bienvenue sur My Films
            </Typography>

            <Typography variant="h5" paragraph>
                Fabien Laura Ghislain Blandine
            </Typography>
            <Button
                variant="contained"
                color="warning"
                href="/films"
                sx={{
                    backgroundColor: '#FFD700',
                    '&:hover': { backgroundColor: '#FFC107' },
                    marginRight: '10px',
                }}
            >
                Voir les films
            </Button>

            <Button
                variant="contained"
                sx={{
                    backgroundColor: '#FFD700',
                    '&:hover': { backgroundColor: '#FFCC00' },
                }}
                href="/quizz"
            >
                Accéder au quizz
            </Button>


        </Box>
    );
}

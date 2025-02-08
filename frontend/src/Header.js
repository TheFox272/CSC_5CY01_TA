import React from 'react';
import AppBar from '@mui/material/AppBar';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';

// ajout pour le routing

import { Link } from 'react-router-dom';
import Button from '@mui/material/Button';
import Box from '@mui/material/Box';

export default function Header() {
    return (
        <AppBar position="static" sx={{ backgroundColor: "black" }}>
            <Toolbar>
                <Typography
                    variant="h6"
                    component="div"
                    sx={{
                        flexGrow: 1,
                        color: "yellow",
                        fontFamily: "'Starjedi', sans-serif"
                    }}
                >
                    My Films
                </Typography>

                <Box>
                    <Button component={Link} to="/" sx={{ color: "yellow" }}>Accueil</Button>
                    <Button component={Link} to="/films" sx={{ color: "yellow" }}>Films</Button>
                    <Button component={Link} to="/quizz" sx={{ color: "yellow" }}>Quizz</Button>
                </Box>
            </Toolbar>
        </AppBar>
    );
}


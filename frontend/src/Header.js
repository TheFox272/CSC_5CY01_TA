import React from 'react';
import AppBar from '@mui/material/AppBar';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';


export default function Header() {
    return (
        <AppBar position="static" sx={{ backgroundColor: "black" }}>
            <Toolbar>
                <Typography
                    variant="h6"
                    component="div"
                    sx={{
                      flexGrow: 1,
                      color: "yellow", // Couleur du texte en jaune
                      fontFamily: "'Starjedi', sans-serif", // Police Star Jedi
                  }}
                >
                    My Films
                </Typography>
            </Toolbar>
        </AppBar>
    );
}

import React, { useState } from 'react';
import { postRealisateur } from '../api/RealisateurApi';
import { Box, TextField, Button, Typography } from '@mui/material';

const RealisateurForm = (props) => {
    const [name, setName] = useState('');
    const [firstname, setFirstname] = useState('');
    const [birthdate, setBirthdate] = useState('');

    const handleSubmit = () => {
        const realisateur = {
            nom: name,
            prenom: firstname,
            dateNaissance: birthdate,
        };

        console.log(realisateur);

        postRealisateur(realisateur)
            .then((response) => {
                console.log(response.data);
                props.setOpenEdit(false);
                window.location.reload();
            })
            .catch((err) => {
                console.error(err);
            });
    };

    return (
        <Box
        component="form"
        sx={{
            display: "flex",
            flexDirection: "column",
            gap: 2, // Espace entre les champs
            width: "100%", // Ajuste la largeur si nécessaire
            maxWidth: 350, // Largeur maximale
            margin: "0 auto", // Centrer horizontalement
            py: 2,
            backgroundImage: "url('/fond_etoilé.jpg')",
            backgroundSize: "cover", // Réduit l'image pour qu'elle s'adapte à l'espace
            backgroundRepeat: "no-repeat", // Pas de répétition
            backgroundPosition: "top center",
            color: "white", // Appliquer couleur blanche au texte par défaut
            borderRadius: 2, // Ajoute des bords arrondis
            boxShadow: 3, // Ajoute une ombre
        }}
    >
        <Typography
                variant="h6"
                component="div"
                sx={{
                  ml: 4,
                  flexGrow: 1,
                  color: "yellow", // Couleur du texte en jaune
                  fontFamily: "'Starjedi', sans-serif", // Police Star Jedi
              }}
            >
            {"Ajouter un réalisateur"}
        </Typography>
        <TextField
            id="nom"
            label="Nom"
            variant="outlined"
            value={name}
            onChange={(e) => setName(e.target.value)}
            sx={{
                color: "white", // Appliquer la couleur du texte ici
                "& .MuiInputLabel-root": {
                    color: "white", // Appliquer la couleur blanche au label
                },
                "& .MuiOutlinedInput-root": {
                    color: "white", // Texte du champ en blanc
                    "& fieldset": {
                        borderColor: "white", // Bordure du champ en blanc
                    },
                },
            }}
        />
        <TextField
            id="prenom"
            label="Prénom"
            variant="outlined"
            value={firstname}
            onChange={(e) => setFirstname(e.target.value)}
            sx={{
                color: "white", // Appliquer la couleur du texte ici
                "& .MuiInputLabel-root": {
                    color: "white", // Appliquer la couleur blanche au label
                },
                "& .MuiOutlinedInput-root": {
                    color: "white", // Texte du champ en blanc
                    "& fieldset": {
                        borderColor: "white", // Bordure du champ en blanc
                    },
                },
            }}
        />
        <TextField
            id="birthdate"
            label="Date de naissance"
            type="date"
            InputLabelProps={{
                shrink: true,
            }}
            value={birthdate}
            onChange={(e) => setBirthdate(e.target.value)}
            sx={{
                color: "white", // Appliquer la couleur du texte ici
                "& .MuiInputLabel-root": {
                    color: "white", // Appliquer la couleur blanche au label
                },
                "& .MuiOutlinedInput-root": {
                    color: "white", // Texte du champ en blanc
                    "& fieldset": {
                        borderColor: "white", // Bordure du champ en blanc
                    },
                },
            }}
        />
        <Button variant="contained" color="primary" onClick={handleSubmit}
            sx={{
                backgroundColor: "white", // Fond du bouton en blanc
                color: "black", // Texte du bouton en noir
                "&:hover": {
                    backgroundColor: "gray", // Couleur de fond au survol
                },
            }}>
            {"Ajouter"}
        </Button>
    </Box>
    );
};

export default RealisateurForm;
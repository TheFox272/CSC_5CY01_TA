import { Button, Select, TextField, MenuItem, Box } from "@mui/material";
import { useState, useEffect } from "react";
import { getAllRealisateur } from "../api/RealisateurApi";

export default function FilmForm(props) {
    const [realisateurs, setRealisateurs] = useState([]);

    useEffect(() => {
        getAllRealisateur()
            .then((reponse) => {
                setRealisateurs(reponse.data);
            })
            .catch((err) => {
                console.log(err);
            });
    }, []);

    return (
        <Box
            component="form"
            sx={{
                display: "flex",
                flexDirection: "column",
                gap: 2, // Espace entre les champs
                width: "100%", // Ajuste la largeur si nécessaire
                maxWidth: 400, // Largeur maximale
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
<<<<<<< HEAD
            <TextField id="titre" label="Titre" variant="outlined" defaultValue={props.film ? props.film.titre : ''} />
            <TextField id="duree" label="Durée" variant="outlined" defaultValue={props.film ? props.film.duree : ''} />

            <Select
                labelId="realisateur"
                id="realisateur"
                defaultValue={props.film ? props.film.realisateur.id : ''}
                label="Réalisateur"
                onChange={props.handleRealisateurChange}
=======
            <TextField
                id="titre"
                label="Titre"
                variant="outlined"
                defaultValue={props.film ? props.film.titre : ""}
                InputLabelProps={{
                    style: { color: "white" }, // Couleur du label en blanc
                }}
                InputProps={{
                    style: { color: "white" }, // Couleur du texte saisi en blanc
                }}
                sx={{
                    input: {
                        color: "white", // Applique la couleur du texte dans l'input
                    },
                    label: {
                        color: "white", // Applique la couleur du label
                    }
                }}
            />

            <TextField
                id="duree"
                label="Durée"
                variant="outlined"
                defaultValue={props.film ? props.film.duree : ""}
                InputLabelProps={{
                    style: { color: "white" }, // Couleur du label en blanc
                }}
                InputProps={{
                    style: { color: "white" }, // Couleur du texte saisi en blanc
                }}
                sx={{
                    input: {
                        color: "white", // Applique la couleur du texte dans l'input
                    },
                    label: {
                        color: "white", // Applique la couleur du label
                    }
                }}
            />

            <Select
                labelId="realisateur-label"
                id="realisateur"
                defaultValue={props.film ? props.film.realisateur.id : ""}
                displayEmpty
                variant="outlined"
>>>>>>> 9388e7b025ef48420396ce2596c49a932db6d138
                sx={{
                    color: "white", // Texte du champ Select en blanc
                    ".MuiSelect-icon": {
                        color: "white", // Couleur de l'icône déroulante
                    },
                    "& .MuiOutlinedInput-root .MuiOutlinedInput-notchedOutline": {
                        borderColor: "white", // Bordure du select en blanc
                    },
                }}
            >
<<<<<<< HEAD
                {
                    realisateurs.map((realisateur) => {
                        return <MenuItem key={realisateur.id} value={realisateur.id}>{realisateur.prenom} {realisateur.nom}</MenuItem>
                    })
                }
            </Select>

            <Button variant="contained" color="primary" onClick={props.onSubmit} sx={{
=======
                <MenuItem value="" disabled>
                    Sélectionnez un réalisateur
                </MenuItem>
                {realisateurs.map((realisateur) => (
                    <MenuItem key={realisateur.id} value={realisateur.id}>
                        {realisateur.prenom} {realisateur.nom}
                    </MenuItem>
                ))}
            </Select>

            <Button
                variant="contained"
                color="primary"
                onClick={props.onSubmit}
                sx={{
>>>>>>> 9388e7b025ef48420396ce2596c49a932db6d138
                    backgroundColor: "white", // Fond du bouton en blanc
                    color: "black", // Texte du bouton en noir
                    "&:hover": {
                        backgroundColor: "gray", // Couleur de fond au survol
                    },
<<<<<<< HEAD
                }}>
                {
                    props.film ?
                    "Editer"
                    :
                    "Créer"
                }
=======
                }}
            >
                {props.film ? "Editer" : "Créer"}
>>>>>>> 9388e7b025ef48420396ce2596c49a932db6d138
            </Button>
        </Box>
    );
}


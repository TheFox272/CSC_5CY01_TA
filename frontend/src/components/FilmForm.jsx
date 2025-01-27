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
                <TextField
                    id="titre"
                    label="Titre"
                    variant="outlined"
                    defaultValue={props.film ? props.film.titre : ''}
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
                    id="duree"
                    label="Durée"
                    variant="outlined"
                    defaultValue={props.film ? props.film.duree : ''}
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

            <Select
                labelId="realisateur"
                id="realisateur"
                defaultValue={props.film ? props.film.realisateur.id : ''}
                label="Réalisateur"
                onChange={props.handleRealisateurChange}
                sx={{
                    color: "white", // Texte du champ Select en blanc
                    "& .MuiSelect-icon": {
                        color: "white", // Couleur de l'icône déroulante
                    },
                    "& .MuiOutlinedInput-root": {
                        color: "white", // Texte du champ en blanc
                        "& fieldset": {
                            borderColor: "white", // Bordure du champ en blanc
                        },
                    },
                    "& .MuiInputLabel-root": {
                        color: "white", // Label "Réalisateur" en blanc
                    },
                }}
            >
                {
                    realisateurs.map((realisateur) => {
                        return <MenuItem key={realisateur.id} value={realisateur.id} sx={{ color: "black" }}>
                            {realisateur.prenom} {realisateur.nom}
                        </MenuItem>
                    })
                }
            </Select>

            <Button variant="contained" color="primary" onClick={props.onSubmit} sx={{
                    backgroundColor: "white", // Fond du bouton en blanc
                    color: "black", // Texte du bouton en noir
                    "&:hover": {
                        backgroundColor: "gray", // Couleur de fond au survol
                    },
                }}>
                {
                    props.film ?
                    "Editer"
                    :
                    "Créer"
                }
            </Button>
        </Box>
    );
}


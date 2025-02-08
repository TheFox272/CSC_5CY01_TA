import { Button, Select, TextField, MenuItem, Box, Typography } from "@mui/material";
import FormControl from '@mui/material/FormControl';
import InputLabel from '@mui/material/InputLabel';
import { useState, useEffect } from "react";
import { getAllRealisateur } from "../api/RealisateurApi";
import { postFilm, putFilm } from "../api/FilmApi";

export default function FilmForm(props) {
    const [realisateurs, setRealisateurs] = useState([]);
    const [filmId, setFilmId] = useState('');
    const [titre, setTitre] = useState('');
    const [duree, setDuree] = useState('');
    const [realisateurId, setRealisateurId] = useState('');
    const [description, setDescription] = useState('');

    useEffect(() => {
        getAllRealisateur()
            .then((reponse) => {
                setRealisateurs(reponse.data);
            })
            .catch((err) => {
                console.log(err);
            });

        if (props.film) {
            setFilmId(props.film.id);
            setTitre(props.film.titre);
            setDuree(props.film.duree);
            setRealisateurId(props.film.realisateur.id);
            if (props.film.description)
                setDescription(props.film.description);
        }
    }, []);

    const editFilmRequest = () => {
        // debug
        console.log('editFilmRequest');

        // Déclaration des variables
        let apiMethod;
        let film;

        if (filmId) {
            film = {
                id: filmId,
                titre: titre,
                duree: parseInt(duree, 10),
                realisateurId: realisateurId,
                description: description
            };
            apiMethod = putFilm;
        } else {
            film = {
                titre: titre,
                duree: parseInt(duree, 10),
                realisateurId: realisateurId,
                description: description
            };
            apiMethod = postFilm;
        }

        // appeler la méthode
        apiMethod(film).then(reponse => {
            console.log(reponse.data);
            props.setOpenEdit(false);
            // actualiser la page
            window.location.reload();
        }).catch(err => {
            console.log(err);
        });
    }

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
                {filmId ? "Editer un film" : "Créer un film"}
            </Typography>
                <TextField
                    id="titre"
                    label="Titre"
                    variant="outlined"
                    value={titre}
                    onChange={(e) => setTitre(e.target.value)}
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
                    value={duree}
                    onChange={(e) => setDuree(e.target.value)}
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
            <FormControl sx={{ width: "100%"}}>
                <InputLabel id="demo-select-small-label" sx={{ color: "white" }}>Réalisateur</InputLabel>
                <Select
                    labelId="Réalisateur"
                    label="Réalisateur"
                    value={realisateurId}
                    onChange={(e) => setRealisateurId(e.target.value)}
                    sx={{ 
                        color: "white", 
                        "& .MuiOutlinedInput-notchedOutline": { borderColor: "white" }
                    }}
                >
                    {realisateurs.map((realisateur) => (
                        <MenuItem key={realisateur.id} value={realisateur.id} sx={{ color: "black" }}>
                            {realisateur.prenom} {realisateur.nom}
                        </MenuItem>
                    ))}
                </Select>
            </FormControl>
            <TextField
                    id="description"
                    label="Description"
                    variant="outlined"
                    value={description}
                    onChange={(e) => setDescription(e.target.value)}
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
            <Button variant="contained" color="primary" onClick={editFilmRequest}
                sx={{
                    backgroundColor: "white", // Fond du bouton en blanc
                    color: "black", // Texte du bouton en noir
                    "&:hover": {
                        backgroundColor: "gray", // Couleur de fond au survol
                    },
                }}>
                {filmId ? "Editer" : "Créer"}
            </Button>
        </Box>
    );
}


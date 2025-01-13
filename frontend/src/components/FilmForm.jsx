import { Button, Select, TextField, MenuItem, useThemeProps } from "@mui/material";
import { useState, useEffect } from 'react';
import { getAllRealisateur } from "../api/RealisateurApi";

//********************************************************************************************************************

export default function FilmForm(props) {
    const [realisateurs, setRealisateurs] = useState([]);

    useEffect(() => {
        getAllRealisateur().then(reponse => {
            setRealisateurs(reponse.data);
        }).catch(err => {
            console.log(err);
        })
    }, []);

    return (
        <div>
            
            {
                props.film ?
                <TextField id="titre" label="Titre" variant="outlined" defaultValue={props.film.titre} />
                :
                <TextField id="titre" label="Titre" variant="outlined" />
            }
            {
                props.film ?
                <TextField id="duree" label="Durée" variant="outlined" defaultValue={props.film.duree} />
                :
                <TextField id="duree" label="Durée" variant="outlined" />
            }
            
            {
                props.film ?
                <Select
                    labelId="realisateur"
                    id="realisateur"
                    defaultValue={props.film.realisateur.id}
                    label="Réalisateur"
                >
                {
                    realisateurs.map((realisateur) => {
                        return <MenuItem key={realisateur.id} value={realisateur.id}>{realisateur.prenom} {realisateur.nom}</MenuItem>
                    })
                }
                </Select>
                :
                <Select
                    labelId="realisateur"
                    id="realisateur"
                >
                {
                    realisateurs.map((realisateur) => {
                        return <MenuItem key={realisateur.id} value={realisateur.id}>{realisateur.prenom} {realisateur.nom}</MenuItem>
                    })
                }
                </Select>
            }
            <Button variant="contained" color="primary" onClick={props.onSubmit}>
                {
                    props.film ?
                    "Editer"
                    :
                    "Créer"
                }
            </Button>

        </div>
    )
}

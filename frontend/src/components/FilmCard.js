import { useState } from 'react';
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import Typography from '@mui/material/Typography';
import IconButton from '@mui/material/IconButton';
import DeleteIcon from '@mui/icons-material/Delete';
import EditIcon from '@mui/icons-material/Edit';
import Dialog from '@mui/material/Dialog';
import DialogTitle from '@mui/material/DialogTitle';
import DialogContent from '@mui/material/DialogContent';
import FilmForm from './FilmForm';
import { putFilm, deleteFilm } from '../api/FilmApi';

//********************************************************************************************************************


export default function FilmCard(props) {
    const handleClickOnDeleteButton = () => {
        // debug
        console.log('deleteFilm');
        
        deleteFilm(props.film.id).then(reponse => {
            console.log(reponse.data);
        }
        ).catch(err => {
            console.log(err);
        })
    }

    const editFilm = () => {
        // debug
        console.log('editFilm');

        // récupérer les valeurs des champs titre, durée et réalisateur
        const titre = document.getElementById('titre').value;
        const duree = document.getElementById('duree').value;
        const realisateurId = document.getElementById('realisateur').value;

        // créer un objet film
        const film = {
            titre: titre,
            duree: duree,
            realisateurId: realisateurId
        }

        // appeler la méthode createFilm de l'API
        putFilm(film).then(reponse => {
            console.log(reponse.data);
        }).catch(err => {
            console.log(err);
        })
    }

    const [open, setOpen] = useState(false);

    const handleClose = () => {
        setOpen(false);
    }

    const handleClickOnEditButton = () => {
        setOpen(true);
    }

    return (
        <Card variant="outlined">
            <CardContent>
                <Typography variant="h5" gutterBottom>
                    {props.film.titre}
                </Typography>
                <Typography variant="body1">
                        {props.film.duree} minutes
                </Typography>
                <Dialog onClose={handleClose} open={open}>
                    <DialogTitle>Editer un film</DialogTitle>
                    <DialogContent>
                        <FilmForm film={props.film} onSubmit={editFilm} />
                    </DialogContent>
                </Dialog>
                <IconButton onClick={handleClickOnDeleteButton}>
                    <DeleteIcon/>
                </IconButton>
                <IconButton onClick={handleClickOnEditButton}>
                    <EditIcon/>
                </IconButton>
            </CardContent>
        </Card>
    )
}

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
import DialogActions from '@mui/material/DialogActions';
import Button from '@mui/material/Button';
import FilmForm from './FilmForm';
import { deleteFilm } from '../api/FilmApi';

//********************************************************************************************************************

export default function FilmCard(props) {
    const [openEdit, setOpenEdit] = useState(false);
    const [openDetails, setOpenDetails] = useState(false);

    const handleClickOnDeleteButton = () => {
        console.log('deleteFilm');
        deleteFilm(props.film.id)
            .then(response => {
                console.log(response.data);
                window.location.reload();
            })
            .catch(err => console.log(err));
    };

    return (
        <Card className="film-card" variant="outlined">
            <CardContent className="film-card-content">
                {/* Clique sur le titre pour ouvrir les détails */}
                <Typography 
                    onClick={() => setOpenDetails(true)}
                    sx={{
                        flexGrow: 1,
                        color: "black",
                        textDecoration: "underline",
                        cursor: "pointer",
                        fontFamily: "'Starjedi', sans-serif"
                    }}
                >
                    {props.film.titre}
                </Typography>

                <Typography variant="body1" className="film-duration">
                    <img src="/SabreLaser.png" className="saber-image" alt="Sabre Laser" />
                    {props.film.duree} minutes
                </Typography>

                <div className="action-buttons">
                    <IconButton onClick={handleClickOnDeleteButton} color="error">
                        <DeleteIcon />
                    </IconButton>
                    <IconButton onClick={() => setOpenEdit(true)} color="primary">
                        <EditIcon />
                    </IconButton>
                </div>
            </CardContent>

            {/* Fenêtre modale pour afficher les détails du film */}
            <Dialog open={openDetails} onClose={() => setOpenDetails(false)}>
                <DialogTitle>Détails du film</DialogTitle>
                <DialogContent>
                    <Typography><strong>Titre :</strong> {props.film.titre}</Typography>
                    <Typography><strong>Durée :</strong> {props.film.duree} minutes</Typography>
                    <Typography>
                        <strong>Réalisateur :</strong> {props.film.realisateur.prenom} {props.film.realisateur.nom}
                    </Typography>
                    <Typography><strong>Description :</strong> {props.film.description}</Typography>

                </DialogContent>
                <DialogActions>
                    <Button onClick={() => setOpenDetails(false)} color="primary">Fermer</Button>
                </DialogActions>
            </Dialog>

            {/* Fenêtre modale pour éditer un film */}
            <Dialog open={openEdit} onClose={() => setOpenEdit(false)}>
                <DialogTitle className="starjedi-title">Éditer un film</DialogTitle>
                <DialogContent>
                    <FilmForm film={props.film} setOpenEdit={setOpenEdit}/>
                </DialogContent>
            </Dialog>
        </Card>
    );
}

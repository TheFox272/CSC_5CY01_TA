import { useState, useEffect } from 'react';
import { getAllFilms } from '../api/FilmApi';
import FilmForm from './FilmForm';
import FilmList from './FilmList';
import Dialog from '@mui/material/Dialog';
import DialogTitle from '@mui/material/DialogTitle';
import DialogContent from '@mui/material/DialogContent';
import { Button } from '@mui/material';
import RealisateurForm from './RealisateurForm';

//********************************************************************************************************************
export default function FilmContainer({ className }) {
    const [films, setFilms] = useState([]);
    // const [realisateurs, setRealisateurs] = useState([]);
    const [openAdd, setOpenAdd] = useState(false);
    const [openRealisateur, setOpenRealisateur] = useState(false);

    useEffect(() => {
        getAllFilms().then(response => {
            // setFilms(mockFilms);  // 
            setFilms(response.data);
            console.log(films);
        }).catch(err => {
            console.log(err);
        })
    }, []);

    return (
        <div>
            {/* Bouton d'ajout de film */}
            <Button onClick={() => setOpenAdd(true)} variant="contained">Ajouter un film</Button>
            {/* Formulaire d'ajout de film */}
            <Dialog open={openAdd} onClose={() => setOpenAdd(false)}>
                <DialogContent>
                    <FilmForm setOpenEdit={setOpenAdd} />
                </DialogContent>
            </Dialog>

            {/* Bouton d'ajout de realisateur */}
            <Button onClick={() => setOpenRealisateur(true)} variant="contained">Ajouter un realisateur</Button>
            {/* Formulaire d'ajout de realisateur */}
            <Dialog open={openRealisateur} onClose={() => setOpenRealisateur(false)}>
                <DialogContent>
                    <RealisateurForm setOpenEdit={setOpenRealisateur} />
                </DialogContent>
            </Dialog>

            {/* Liste des films */}
            <div>
                <FilmList films={films} />
            </div>
        </div>

    );
}

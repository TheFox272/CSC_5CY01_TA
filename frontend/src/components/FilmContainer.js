import { useState, useEffect } from 'react';
import { getAllFilms } from '../api/FilmApi';
import FilmForm from './FilmForm';
import FilmList from './FilmList';
import Dialog from '@mui/material/Dialog';
import DialogTitle from '@mui/material/DialogTitle';
import DialogContent from '@mui/material/DialogContent';
import { Button } from '@mui/material';

//********************************************************************************************************************
export default function FilmContainer({ className }) {
    const [films, setFilms] = useState([]);
    const [openAdd, setOpenAdd] = useState(false);

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
            {/* Boutton d'ajout de film */}
            <Button onClick={() => setOpenAdd(true)} variant="contained">Ajouter un film</Button>
            {/* Formulaire d'ajout de film */}
            <Dialog open={openAdd} onClose={() => setOpenAdd(false)}>
                <DialogTitle className="starjedi-title">Ajouter un film</DialogTitle>
                <DialogContent>
                    <FilmForm setOpenEdit={setOpenAdd} />
                </DialogContent>
            </Dialog>
            
            {/* Liste des films */}
            <div>
                <FilmList films={films} />
            </div>
        </div>

    );
}

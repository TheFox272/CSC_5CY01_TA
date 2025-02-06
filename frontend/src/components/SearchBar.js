import React, { useState } from 'react';
import { TextField } from '@mui/material';

const SearchBar = ({ onSearch }) => {
    const [searchTerm, setSearchTerm] = useState('');

    const handleSearch = (event) => {
        const value = event.target.value;
        setSearchTerm(value);
        if (onSearch) {  // Vérifie que la fonction onSearch existe
            onSearch(value);  // Appel de la fonction onSearch
        }
    };

    return (
        <TextField
            placeholder="Rechercher un film..."
            value={searchTerm}
            onChange={handleSearch}
            variant="outlined"
            fullWidth
            sx={{ width: 300 }}
        />
    );
};

export default SearchBar;

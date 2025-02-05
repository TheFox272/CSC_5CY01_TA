import logo from './logo.svg';
import './App.css';
import Header from './Header';
import FilmContainer from './components/FilmContainer';
import Quizz from './components/Quizz';

// pour le routing
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';

//********************************************************************************************************************



function App() {
    return (
        <Router>
            <Header />
            <Routes>
                <Route path="/" element={<h1>Accueil</h1>} />
                <Route path="/films" element={<FilmContainer />} />
                <Route path="/quizz" element={<Quizz />} />
            </Routes>
        </Router>
    );
}

export default App;

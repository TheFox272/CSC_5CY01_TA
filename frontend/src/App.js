import logo from './logo.svg';
import './App.css';
import Header from './Header';
import FilmContainer from './components/FilmContainer';
import Quizz from './components/Quizz';
import Accueil from './components/Accueil';

// pour le routing
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';

//********************************************************************************************************************



function App() {
    return (
        <Router>
            <Header />
            <Routes>
                <Route path="/" element={<Accueil />} />
                <Route path="/films" element={<FilmContainer />} />
                <Route path="/quizz" element={<Quizz />} />
            </Routes>
        </Router>
    );
}

export default App;

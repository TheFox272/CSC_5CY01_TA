import logo from './logo.svg';
import './App.css';
import Header from './Header';
import FilmContainer from './components/FilmContainer';
import Quizz from './components/Quizz';
import SearchBar from './components/SearchBar';

//********************************************************************************************************************

function App() {
  return (
    <>
      <Header />
      <SearchBar />
      <FilmContainer />
      <Quizz />
    </>
  );
}

export default App;

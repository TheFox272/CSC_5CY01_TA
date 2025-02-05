import logo from './logo.svg';
import './App.css';
import Header from './Header';
import FilmContainer from './components/FilmContainer';
import Quizz from './components/Quizz';

//********************************************************************************************************************

function App() {
  return (
    <>
      <Header />
      <FilmContainer />
      <Quizz />
    </>
  );
}

export default App;

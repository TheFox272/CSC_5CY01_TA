// On créer une liste de films dans l'objet mockFilms

const mockFilms = [
    {
        id: 1,
        titre: "Le Seigneur des Anneaux",
        duree: 201,
        realisateur: {
            id: 1,
            nom: "Jackson",
            prenom: "Peter",
            dateNaissance: "1961-10-31",
            filmsRealises: 2,
            celebre: false
        }
    },
    {
        id: 2,
        titre: "Le Hobbit",
        duree: 169,
        realisateur: {
            id: 1,
            nom: "Jackson",
            prenom: "Peter",
            dateNaissance: "1961-10-31",
            filmsRealises: 2,
            celebre: false
        }
    },
    {
        id: 3,
        titre: "Star Wars",
        duree: 125,
        realisateur: {
            id: 2,
            nom: "Lucas",
            prenom: "George",
            dateNaissance: "1944-05-14",
            filmsRealises: 1,
            celebre: true
        }
    }
]
export default mockFilms;





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
        },
        description: "Une personne de petite taille se fait des amis grâce à un bijou."
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
        },
        description: "Un apprenti voleur réveille celui qu'il cambriole."
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
        },
        description: "Un mec prend des cours de baston donnés par mini-Shrek."
    }
]
export default mockFilms;





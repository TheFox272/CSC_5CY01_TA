import axios from 'axios';

const REALISATEUR_URI = 'http://localhost:8080/realisateur'

export function getAllRealisateur(){
    // return axios.get(REALISATEUR_URI);

    //mock
    return new Promise((resolve, reject) => {
        resolve({
            data: [
                {
                    id: 1,
                    nom: "Jackson",
                    prenom: "Peter",
                    dateNaissance: "1961-10-31",
                    filmsRealises: 2,
                    celebre: false
                },
                {
                    id: 2,
                    nom: "Lucas",
                    prenom: "George",
                    dateNaissance: "1944-05-14",
                    filmsRealises: 1,
                    celebre: true
                },
                {
                    id: 3,
                    nom: "Spielberg",
                    prenom: "Steven",
                    dateNaissance: "1946-12-18",
                    filmsRealises: 3,
                    celebre: true
                }
            ]
        });
    });
}
    

export function postRealisateur(realisateur){
	return axios.post(REALISATEUR_URI, realisateur);
}


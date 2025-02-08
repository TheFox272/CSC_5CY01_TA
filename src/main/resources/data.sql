CREATE TABLE IF NOT EXISTS Realisateur(id INT primary key auto_increment, nom VARCHAR(100), prenom VARCHAR(100), date_naissance TIMESTAMP, celebre BOOLEAN);
INSERT INTO Realisateur(nom, prenom, date_naissance, celebre) VALUES('Cameron', 'James', '1954-08-16', false);
INSERT INTO Realisateur(nom, prenom, date_naissance, celebre) VALUES('Jackson', 'Peter', '1961-10-31', true);

CREATE TABLE IF NOT EXISTS Film(id INT primary key auto_increment, titre VARCHAR(100), duree INT, realisateur_id INT, description VARCHAR(100));
INSERT INTO Film(titre, duree, realisateur_id,description) VALUES('avatar', 162, 1,'homme bleue');
INSERT INTO Film(titre, duree, realisateur_id,description) VALUES('La communauté de l''anneau', 178, 2,'adieu sean');
INSERT INTO Film(titre, duree, realisateur_id,description) VALUES('Les deux tours', 179, 2,'les elfes sont quand même stylés');
INSERT INTO Film(titre, duree, realisateur_id,description) VALUES('Le retour du roi', 201, 2,'sam a ramené une poele en fonte');

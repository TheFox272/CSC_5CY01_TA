CREATE TABLE IF NOT EXISTS Realisateur(id INT primary key auto_increment, nom VARCHAR(100), prenom VARCHAR(100), date_naissance TIMESTAMP, celebre BOOLEAN);
INSERT INTO Realisateur(nom, prenom, date_naissance, celebre) VALUES('Cameron', 'James', '1954-08-16', false);
INSERT INTO Realisateur(nom, prenom, date_naissance, celebre) VALUES('Jackson', 'Peter', '1961-10-31', true);
INSERT INTO Realisateur(nom, prenom, date_naissance, celebre) VALUES('Burton', 'Tim', '1958-08-25', true);
INSERT INTO Realisateur(nom, prenom, date_naissance, celebre) VALUES('Trousdale', 'Gary', '1960-06-08', false);
INSERT INTO Realisateur(nom, prenom, date_naissance, celebre) VALUES('Fincher', 'David', '1962-08-28', false);
INSERT INTO Realisateur(nom, prenom, date_naissance, celebre) VALUES('Penn', 'Sean', '1960-08-17', false);
INSERT INTO Realisateur(nom, prenom, date_naissance, celebre) VALUES('Colombus', 'Chris', '1958-09-10', false);
INSERT INTO Realisateur(nom, prenom, date_naissance, celebre) VALUES('Wachowsky', 'Lana', '1965-06-21', false);
INSERT INTO Realisateur(nom, prenom, date_naissance, celebre) VALUES('Lucas', 'George', '1944-05-14', false);
INSERT INTO Realisateur(nom, prenom, date_naissance, celebre) VALUES('Adamson', 'Andrew', '1966-12-01', false);
INSERT INTO Realisateur(nom, prenom, date_naissance, celebre) VALUES('Six', 'Tom', '1973-08-29', false);
INSERT INTO Realisateur(nom, prenom, date_naissance, celebre) VALUES('Morel', 'Pierre', '1964-05-12', false);
INSERT INTO Realisateur(nom, prenom, date_naissance, celebre) VALUES('Spielberg', 'Steven', '1946-12-18', false);


CREATE TABLE IF NOT EXISTS Film(id INT primary key auto_increment, titre VARCHAR(100), duree INT, realisateur_id INT, description VARCHAR(1000));
INSERT INTO Film(titre, duree, realisateur_id,description) VALUES('avatar', 162, 1,'Pocahontas mais dans l''espace');
INSERT INTO Film(titre, duree, realisateur_id,description) VALUES('La communauté de l''anneau', 178, 2,'Sean Bean se fait encore fait fumer');
INSERT INTO Film(titre, duree, realisateur_id,description) VALUES('Les deux tours', 179, 2,'Un soleil rouge se lève, beaucoup de sang a du couler cette nui');
INSERT INTO Film(titre, duree, realisateur_id,description) VALUES('Le retour du roi', 201, 2,'Un mec trouve un anneau, son neveu le rapporte à l''usine');
INSERT INTO Film(titre, duree, realisateur_id,description) VALUES('Titanic', 201, 1,'Une vieille dame moribonde parle à ses enfants de son amour de jeunesse.');
INSERT INTO Film(titre, duree, realisateur_id,description) VALUES('Batman', 126, 3,'Un milliardaire fait du cosplay et tabasse des criminels');
INSERT INTO Film(titre, duree, realisateur_id,description) VALUES('La Belle et la Bête', 147, 4,'Le syndrome de stockholm mais avec un animal');
INSERT INTO Film(titre, duree, realisateur_id,description) VALUES('The social network', 120, 5,'Un film où tu as accès à la vie privée de Mark Zuckerberg au lieu de l''inverse');
INSERT INTO Film(titre, duree, realisateur_id,description) VALUES('Into the wild', 148, 6,'Il cuisine des champignons ca tourne mal');
INSERT INTO Film(titre, duree, realisateur_id,description) VALUES('Harry potter', 152, 7,'Un mec sans nez a une obsession malsaine pour un adolescent');
INSERT INTO Film(titre, duree, realisateur_id,description) VALUES('Matrix', 146, 8,'Un employé de bureau déprimé rejoint une secte et destabilise le gouvernement');
INSERT INTO Film(titre, duree, realisateur_id,description) VALUES('Star Wars prélogie', 146, 9,'Des prêtres achetent un enfant pour le former au culte et il se marie avec une politicienne de deux fois son age');
INSERT INTO Film(titre, duree, realisateur_id,description) VALUES('Narnia', 143, 10,'Les enfants sortent du placard');
INSERT INTO Film(titre, duree, realisateur_id,description) VALUES('The Human centipede', 92, 11,'Un médecin d''une petite ville décide de rapprocher les gens');
INSERT INTO Film(titre, duree, realisateur_id,description) VALUES('Taken', 93, 12,'Liam Neeson doit aller chercher sa fille');
INSERT INTO Film(titre, duree, realisateur_id,description) VALUES('E.T', 120, 13,'Un immigré clandestin est poursuivi par les forces de l''ordre');
INSERT INTO Film(titre, duree, realisateur_id,description) VALUES('Charlie et la chocolaterie', 115, 3,'Un chocolatier lunatique tue lentement des enfants devant leur parents');







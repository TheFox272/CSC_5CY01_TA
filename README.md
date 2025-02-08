# CSC_5CY01_TA

Site de Films Star Wars. Equipe : Blandine, Fabien, Ghislain, Laura


## Setup

Il faut lancer cette commande à la racine du projet juste après avoir cloné le répertoire github :
```
mvn -N io.takari:maven:wrapper
```


## Modifier les tests

Voir le fichier `src/test/java/com/ensta/myfilmlist/MyfilmlistApplicationTests.java`.


## Lancer le build / serve / test

Pour rebuild depuis 0, ce qui s'avère souvent utile à cause des anciens builds qui cachent les nouvelles erreurs :
```
./mvnw clean compile
```

Pour servir le back :
```
./mvnw spring-boot:run
```

Pour faire les tests:
```
./mvnw test
```

## Frontend notes
! depuis le frontend !

npm install @mui/material @emotion/react @emotion/styled
npm install @mui/icons-material
npm install react-router-dom

package com.ensta.myfilmlist.handler;

import com.ensta.myfilmlist.exception.ControllerException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import org.springframework.validation.BindException;

@RestControllerAdvice
public class ExceptionsHandlers {

    @ExceptionHandler(ControllerException.class) // ControllerException : erreurs remontées par la couche service
    public ResponseEntity<String> handleException(ControllerException exception, WebRequest webRequest) {
        String errorMessage = "Une erreur s'est produite au niveau de la couche service. \n";

        // On ajoute des détails pour savoir plus précisement ce qui s'est passé
        String exceptionMessage = exception.getMessage();
        if (exceptionMessage != null && !exceptionMessage.isEmpty()) {
            if (!errorMessage.contains(exceptionMessage)) {
                errorMessage += "Détails : " + exceptionMessage;
            }
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
    }

    @ExceptionHandler(BindException.class)
    public ResponseEntity<String> handleBindException(BindException exception, WebRequest webRequest) {
        StringBuilder errorMessage = new StringBuilder("Paramètres invalides : une des données choisies pour la création est invalide. \n ");

        // Cas particulier : Pour la mauvaise date lors de la création d'un réalisateur
        exception.getFieldErrors().forEach(error -> {
            if (error.getDefaultMessage() != null && error.getDefaultMessage().contains("Failed to convert")) {
                errorMessage.append(error.getField())
                        .append(" : ")
                        .append("Format invalide pour la valeur fournie '")
                        .append(error.getRejectedValue()) // La valeur qui a échoué
                        .append("'. Format attendu : yyyy-MM-dd\n");
            } else {
                errorMessage.append(error.getField())
                        .append(" : ")
                        .append(error.getDefaultMessage())
                        .append("\n");
            }
        });

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage.toString());
    }

    // Si jamais on tombe sur une nouvelle exception
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleAllExceptions(Exception exception, WebRequest webRequest) {
        String errorMessage = "Exception interceptée : " + exception.getClass().getName();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
    }

}

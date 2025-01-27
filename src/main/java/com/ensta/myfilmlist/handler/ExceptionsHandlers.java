package com.ensta.myfilmlist.handler;

import com.ensta.myfilmlist.exception.ControllerException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.net.BindException;

@RestControllerAdvice
public class ExceptionsHandlers {

    @ExceptionHandler(ControllerException.class) // ControllerException : erreurs remontées par la couche service
    public ResponseEntity<String> handleException(ControllerException exception, WebRequest webRequest) {
        // Décommenter si on veut ajouter des infos contenus dans la requête dans le message d'erreur
        // String requestURL = webRequest.getDescription(false);
        String errorMessage = "Une erreur s'est produite au niveau de la couche service " + exception.getMessage();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
    }

    @ExceptionHandler(BindException.class)
    public ResponseEntity<String> handleBindException(BindException exception, WebRequest webRequest) {
        // Extract and format validation errors from BindException
        String errorMessage = " L'un des paramètres n'est pas valide" + exception.getMessage();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
    }
}

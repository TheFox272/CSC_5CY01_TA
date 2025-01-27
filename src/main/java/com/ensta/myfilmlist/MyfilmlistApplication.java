package com.ensta.myfilmlist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.ensta.myfilmlist.MyfilmlistTests;
/**
 * Lancement de l'application Spring Boot et du serveur d'application.
 */
@SpringBootApplication
public class MyfilmlistApplication {

	public static void main(String[] args) {
		System.out.println("Command-line arguments: " + String.join(" ", args));
		SpringApplication.run(MyfilmlistApplication.class, args);

	}

}

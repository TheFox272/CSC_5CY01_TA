package com.ensta.myfilmlist;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MyfilmlistApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void testMyFilmList() {
		MyfilmlistTests myFilmListTests = new MyfilmlistTests();
		myFilmListTests.updateRealisateurCelebreTest();
		myFilmListTests.calculerDureeTotaleTest();
		myFilmListTests.calculerNoteMoyenneTest();
		myFilmListTests.findAllFilmsTest();
		myFilmListTests.createFilmTest();
		myFilmListTests.findFilmByIdTest();
		myFilmListTests.deleteFilmByIdTest();
		myFilmListTests.updateRealisateurCelebre();
	}

}

package PokeZoo.JUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.Test;

import PokeZoo.bbdd.manager.ManagerFile;

class FileTest {
	
	private ManagerFile managerFile = new ManagerFile();

	@Test
	void testFileCreationAndRead() {
		try {
			File newFile = managerFile.createFile(5, 5.0);
			
			String textFromFile = managerFile.readFile(newFile);
			
			String expectedText = "Cantidad de entradas: 5Precio: 25.0€";
			
			assertEquals(textFromFile, expectedText);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}

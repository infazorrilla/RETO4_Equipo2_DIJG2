package PokeZoo.JUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import PokeZoo.bbdd.manager.ManagerFile;

class FileTest {
	
	private ManagerFile managerFile = new ManagerFile();

	@Test
	void testFileCreationAndRead() {
		try {
			File newFile = managerFile.createFile(5, 9.99);
			
			String textFromFile = managerFile.readFile(newFile);
			
			String expectedText = "Cantidad de entradas: 5Precio: 25€";
			
			assertEquals(textFromFile, expectedText);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void testFileCreationWithArrayListAndRead() {
		try {
			ArrayList<Double> listPrices = new ArrayList<Double>();
			listPrices.add(9.99);
			listPrices.add((double) 10);
			
			File newFile = managerFile.createFileWithArrayList(2, listPrices);
			
			String textFromFile = managerFile.readFile(newFile);
			
			String expectedText = "Cantidad de entradas: 2"
					+ "Precio: 9.99€"
					+ "Cantidad de entradas: 2"
					+ "Precio: 10.0€";
			
			assertEquals(textFromFile, expectedText);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}

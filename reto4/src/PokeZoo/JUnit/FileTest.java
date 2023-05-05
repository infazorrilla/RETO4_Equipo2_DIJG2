package PokeZoo.JUnit;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import PokeZoo.bbdd.manager.ManagerFile;

class FileTest {
	
	private ManagerFile managerFile = new ManagerFile();

	@Test
	void testFileCreationAndRead() {
		try {
			managerFile.createFile(0);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

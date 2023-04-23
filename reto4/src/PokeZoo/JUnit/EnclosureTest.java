package PokeZoo.JUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import PokeZoo.bbdd.manager.ManagerEnclosure;
import PokeZoo.bbdd.pojo.Enclosure;

class EnclosureTest {
	
	private ManagerEnclosure manager = null;

	@Test
	public void testGettersAndSetterWithDataFromBBDD() {
		if(null == manager) {
			manager = new ManagerEnclosure();
		}
		
		try {
			Enclosure fistEnclosureFromBBDD = manager.selectEnclosureById(1);
			
			Enclosure expectedEnclosure = new Enclosure();
			expectedEnclosure.setIdEnclosure(1);
			expectedEnclosure.setTypeEn("Bicho");
			expectedEnclosure.setNumberEn(1);
			
			assertEquals(fistEnclosureFromBBDD, expectedEnclosure);			
		} catch (Exception e) {
			// Nothing
		}
	}

	@Test
	public void testInsertNewEnclosure() {
		Enclosure newEnclosuseInsertTest = new Enclosure();
		
		newEnclosuseInsertTest.setIdEnclosure(40);
		newEnclosuseInsertTest.setTypeEn("prueba");
		newEnclosuseInsertTest.setNumberEn(40);
		
		try {
			manager.insert(newEnclosuseInsertTest);
			
			Enclosure expectedEnclosure = manager.selectEnclosureById(40);
			
			assertEquals(newEnclosuseInsertTest, expectedEnclosure);
		} catch (Exception e) {
			// Nothing
		}
	}
	
	@Test
	public void testDeleteEnclosure() {
		Enclosure enclosureToBeDelete = new Enclosure();
		
		enclosureToBeDelete.setIdEnclosure(40);
		enclosureToBeDelete.setTypeEn("prueba");
		enclosureToBeDelete.setNumberEn(40);
		
		try {
			manager.delete(enclosureToBeDelete);
			
			Enclosure expectedEnclosure = manager.selectEnclosureById(40);
			
			assertEquals(null, expectedEnclosure); // selectEnclosureById returns null if nothing was found
		} catch (Exception e) {
			// Nothing
		}
	}
}

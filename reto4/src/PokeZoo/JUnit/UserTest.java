package PokeZoo.JUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import PokeZoo.bbdd.manager.ManagerUser;
import PokeZoo.bbdd.pojo.User;

class UserTest {

	private ManagerUser manager = null;
	
	@Test
	void testGettersAndSetterWithDataFromBBDD() {
		if(null == manager) {
			manager = new ManagerUser();
		}
		
		try {
			User fistUserFromBBDD = manager.selectUserById(1);
			
			User expectedUser = new User();
			expectedUser.setIdUser(1);
			expectedUser.setAdmin(true);
			expectedUser.setUsername("admin");
			expectedUser.setPasswd("admin1234");
			
			assertEquals(fistUserFromBBDD, expectedUser);
			
		} catch (Exception e) {
			// Nothing
		}
	}
	
	@Test
	public void testInsertNewShop() {
		User newUserInsertTest = new User();
		
		newUserInsertTest.setIdUser(10);
		newUserInsertTest.setAdmin(false);
		newUserInsertTest.setUsername("prueba");
		newUserInsertTest.setPasswd("prueba");
		
		try {
			manager.insert(newUserInsertTest);
			
			User expectedUser = manager.selectUserById(10);
			
			assertEquals(newUserInsertTest, expectedUser);
		} catch (Exception e) {
			// Nothing
		}
	}
	
	@Test
	public void testDeletePokemon() {
		User userToDelete = new User();
		
		userToDelete.setIdUser(10);
		userToDelete.setAdmin(false);
		userToDelete.setUsername("prueba");
		userToDelete.setPasswd("prueba");
		
		try {
			manager.delete(userToDelete);
			
			User expectedProduct = manager.selectUserById(10);
			
			assertEquals(null, expectedProduct); // selectUserById returns null if nothing was found
		} catch (Exception e) {
			// Nothing
		}
	}

}

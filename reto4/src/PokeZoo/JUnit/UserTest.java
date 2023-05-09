package PokeZoo.JUnit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

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
			expectedUser.setPasswd("admin");
			
			assertEquals(fistUserFromBBDD, expectedUser);
			
		} catch (Exception e) {
			// Nothing
		}
	}
	
	@Test
	public void testInsertNewUser() {
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
	public void testDeleteUser() {
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
	
	// sacar todos los usuarios arraylist
		@Test
		public void testAccesoABaseDeDatosEInclusionAArrayList() {
			if (null == manager) {
				manager = new ManagerUser();
			}
			ArrayList<User> bbddAllUser = null;

			try {
				bbddAllUser = manager.selectAll();
			} catch (Exception e) {
				e.printStackTrace();
			}

			ArrayList<User> expectedUsers = new ArrayList<>();

			User user1 = new User();

			user1.setIdUser(1);
			user1.setAdmin(true);
			user1.setUsername("admin");
			user1.setPasswd("admin");

			expectedUsers.add(user1);

			User user2 = new User();

			user2.setIdUser(2);
			user2.setAdmin(false);
			user2.setUsername("iker");
			user2.setPasswd("Iker1234");

			expectedUsers.add(user2);

			User user3 = new User();

			user3.setIdUser(3);
			user3.setAdmin(false);
			user3.setUsername("juanma");
			user3.setPasswd("Juanma1234");

			expectedUsers.add(user3);

			User user4 = new User();

			user4.setIdUser(4);
			user4.setAdmin(false);
			user4.setUsername("dani");
			user4.setPasswd("Dani1234");

			expectedUsers.add(user4);

			User user5 = new User();

			user5.setIdUser(5);
			user5.setAdmin(false);
			user5.setUsername("ana");
			user5.setPasswd("pepe");

			expectedUsers.add(user5);

			// Check
			assertEquals(bbddAllUser, expectedUsers);

		}

}

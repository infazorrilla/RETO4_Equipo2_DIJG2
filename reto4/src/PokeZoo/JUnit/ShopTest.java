package PokeZoo.JUnit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import PokeZoo.bbdd.manager.ManagerShop;
import PokeZoo.bbdd.pojo.Shop;

class ShopTest {

	private ManagerShop manager = null;
	
	@Test
	void testGettersAndSetterWithDataFromBBDD() {
		if(null == manager) {
			manager = new ManagerShop();
		}
		
		try {
			ArrayList<Shop> fistShopFromBBDD = manager.selectAll();
			
			Shop expectedShop = new Shop();
			expectedShop.setIdShop(1);
			expectedShop.setNameSh("Poke-Recuerdos");
			expectedShop.setCapacitySh(40);
			
			assertEquals(fistShopFromBBDD.get(0), expectedShop);
			
		} catch (Exception e) {
			// Nothing
		}
	}
	
	@Test
	public void testInsertNewShop() {
		Shop newShopInsertTest = new Shop();
		
		newShopInsertTest.setIdShop(100);
		newShopInsertTest.setNameSh("prueba");
		newShopInsertTest.setCapacitySh(100);
		
		try {
			manager.insert(newShopInsertTest);
			
			Shop expectedShop = manager.selectShopById(100);
			
			assertEquals(newShopInsertTest, expectedShop);
		} catch (Exception e) {
			// Nothing
		}
	}
	
	@Test
	public void testDeletePokemon() {
		Shop shopToDelete = new Shop();
		
		shopToDelete.setIdShop(100);
		shopToDelete.setNameSh("prueba");
		shopToDelete.setCapacitySh(100);
		
		try {
			manager.delete(shopToDelete);
			
			Shop expectedProduct = manager.selectShopById(100);
			
			assertEquals(null, expectedProduct); // selectProductById returns null if nothing was found
		} catch (Exception e) {
			// Nothing
		}
	}
}

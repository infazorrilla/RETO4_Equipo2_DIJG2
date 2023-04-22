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
	void test2() {
		// ¯\_(ツ)_/¯
	}

}

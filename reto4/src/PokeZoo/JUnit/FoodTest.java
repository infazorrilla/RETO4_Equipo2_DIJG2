package PokeZoo.JUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import PokeZoo.bbdd.manager.ManagerFood;
import PokeZoo.bbdd.pojo.Food;

class FoodTest {

	private ManagerFood manager = null;
	
	@Test
	public void testGettersAndSetterWithDataFromBBDD() {
		if(null == manager) {
			manager = new ManagerFood();
		}
		
		try {
			Food fistFoodFromBBDD = manager.selectFoodById(1);
			
			Food expectedFood = new Food();
			expectedFood.setIdFood(1);
			expectedFood.setQuantityFo(500);
			expectedFood.setDailyConsumeFo(100);
			expectedFood.setNameFo("Baya");
			expectedFood.setDescriptionFo("Restaura 10 PS");
			expectedFood.setCaretaker(null);
			
			assertEquals(fistFoodFromBBDD, expectedFood);
			
		} catch (Exception e) {
			// Nothing
		}
	}
	
	@Test
	public void test2() {
		// hmmmmm
	}
}

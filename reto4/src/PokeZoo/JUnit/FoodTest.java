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
	public void testInsertNewFood() {
		Food newFoodInsertTest = new Food();
		
		newFoodInsertTest.setIdFood(100);
		newFoodInsertTest.setQuantityFo(500);
		newFoodInsertTest.setDailyConsumeFo(100);
		newFoodInsertTest.setNameFo("prueba");
		newFoodInsertTest.setDescriptionFo("prueba");
		
		try {
			manager.insert(newFoodInsertTest);
			
			Food expectedFood = manager.selectFoodById(100);
			
			assertEquals(newFoodInsertTest, expectedFood);
		} catch (Exception e) {
			// Nothing
		}
	}
	
	@Test
	public void testDeleteFood() {
		Food foodToDelete = new Food();
		
		foodToDelete.setIdFood(100);
		foodToDelete.setQuantityFo(500);
		foodToDelete.setDailyConsumeFo(100);
		foodToDelete.setNameFo("prueba");
		foodToDelete.setDescriptionFo("prueba");
		
		try {
			manager.delete(foodToDelete);
			
			Food expectedFood = manager.selectFoodById(40);
			
			assertEquals(null, expectedFood); // selectFoodById returns null if nothing was found
		} catch (Exception e) {
			// Nothing
		}
	}
}

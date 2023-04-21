package PokeZoo.JUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import PokeZoo.bbdd.pojo.Food;

class FoodTest {

	@Test
	public void test1() {
	Food food = new Food();
	int numFood = food.getIdFood();
	assertEquals(numFood, 0);
	}
	
	@Test
	public void test2() {
		Food food = new Food();
		int numQuantity = food.getQuantity();
		assertEquals(numQuantity,0);
	}
	
	@Test
	public void test3() {
		Food food = new Food();
		int numDailyConsume = food.getDailyConsume();
		assertEquals(numDailyConsume,0);
	}
	
	@Test
	public void test4() {
		Food food = new Food();
		String woName = food.getNameFo();
		assertEquals(woName,null);
	}
	
	@Test
	public void test5() {
		Food food = new Food();
		String woDescription = food.getDescriptionFo();
		assertEquals(woDescription,null);
	}
}

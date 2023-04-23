package PokeZoo.JUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import PokeZoo.bbdd.manager.ManagerPokemon;
import PokeZoo.bbdd.pojo.Food;
import PokeZoo.bbdd.pojo.Pokemon;

class PokemonTest {
	
	private ManagerPokemon manager = null;

	@Test
	void testGettersAndSetterWithDataFromBBDD() {
		if(null == manager) {
			manager = new ManagerPokemon();
		}
		
		try {
			Pokemon fistPokemonFromBBDD = manager.selectPokemonById(1);
			
			Pokemon expectedPokemon = new Pokemon();
			expectedPokemon.setIdPokemon(1);
			expectedPokemon.setNamePo("Bulbasaur");
			expectedPokemon.setTypeP("Planta");
			expectedPokemon.setTypeS("Veneno");
			expectedPokemon.setDescriptionPo("Una extraña semilla fue plantada en su espalda al nacer. Las plantas brotan y crecen con este Pokémon.");
			expectedPokemon.setNumPokedex(1);
			expectedPokemon.setPhotopo(null);
			expectedPokemon.setFood(null);
			
			assertEquals(fistPokemonFromBBDD, expectedPokemon);			
		} catch (Exception e) {
			// Nothing
		}
	}
	
	@Test
	public void testInsertNewPokemon() {
		Pokemon newPokemonInsertTest = new Pokemon();
		
		newPokemonInsertTest.setIdPokemon(100);
		newPokemonInsertTest.setNamePo("prueba");
		newPokemonInsertTest.setTypeP("prueba");
		newPokemonInsertTest.setTypeS("prueba");
		newPokemonInsertTest.setDescriptionPo("prueba");
		newPokemonInsertTest.setNumPokedex(100);
		newPokemonInsertTest.setPhotopo(null);
		Food pokemonTestFood = new Food();
		pokemonTestFood.setIdFood(100);
		newPokemonInsertTest.setFood(pokemonTestFood);
		
		try {
			manager.insert(newPokemonInsertTest);
			
			Pokemon expectedPokemon = manager.selectPokemonById(100);
			
			assertEquals(newPokemonInsertTest, expectedPokemon);
		} catch (Exception e) {
			// Nothing
		}
	}
	
	@Test
	public void testDeletePokemon() {
		Pokemon foodToDelete = new Pokemon();
		
		foodToDelete.setIdPokemon(100);
		foodToDelete.setNamePo("prueba");
		foodToDelete.setTypeP("prueba");
		foodToDelete.setTypeS("prueba");
		foodToDelete.setDescriptionPo("prueba");
		foodToDelete.setNumPokedex(100);
		foodToDelete.setPhotopo(null);
		Food pokemonTestFood = new Food();
		pokemonTestFood.setIdFood(100);
		foodToDelete.setFood(pokemonTestFood);
		
		try {
			manager.delete(foodToDelete);
			
			Pokemon expectedFood = manager.selectPokemonById(100);
			
			assertEquals(null, expectedFood); // selectPokemonById returns null if nothing was found
		} catch (Exception e) {
			// Nothing
		}
	}

}

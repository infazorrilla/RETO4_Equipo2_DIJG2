package PokeZoo.JUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import PokeZoo.bbdd.manager.ManagerPokemon;
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
	void test2() {
		fail("Not yet implemented");
	}

}

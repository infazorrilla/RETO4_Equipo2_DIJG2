package PokeZoo.JUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import PokeZoo.bbdd.manager.ManagerProduct;
import PokeZoo.bbdd.pojo.Product;

class ProductTest {

	private ManagerProduct manager = null;
	
	@Test
	void testGettersAndSetterWithDataFromBBDD() {
		if(null == manager) {
			manager = new ManagerProduct();
		}
		
		try {
			Product fistProductFromBBDD = manager.selectProductById(1);
			
			Product expectedProduct = new Product();
			expectedProduct.setIdProduct(1);
			expectedProduct.setNamePr("Oshawott: Peluche Sentado");
			expectedProduct.setDescriptionPr("Este peluche del tamaño de la palma de la mano es una forma divertida y encantadora de presumir de uno de tus Pokémon favoritos de tipo Agua, descubierto originalmente en Unova");
			expectedProduct.setPhotoPr(null);
			expectedProduct.setValuePr(11.99);
			expectedProduct.setQuantityPr(30);
			expectedProduct.setShop(null);
			
			assertEquals(fistProductFromBBDD, expectedProduct);
			
		} catch (Exception e) {
			// Nothing
		}
	}
	
	@Test
	void test2() {
		// ¯\_(ツ)_/¯
	}

}

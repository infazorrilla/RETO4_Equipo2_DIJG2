package PokeZoo.JUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import PokeZoo.bbdd.manager.ManagerProduct;
import PokeZoo.bbdd.pojo.Product;
import PokeZoo.bbdd.pojo.Shop;

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
	public void testInsertNewProduct() {
		Product newProductInsertTest = new Product();
		
		newProductInsertTest.setIdProduct(100);
		newProductInsertTest.setNamePr("prueba");
		newProductInsertTest.setDescriptionPr("prueba");
		newProductInsertTest.setPhotoPr(null);
		newProductInsertTest.setValuePr(0);
		newProductInsertTest.setQuantityPr(0);
		Shop shop = new Shop();
		shop.setIdShop(1);
		newProductInsertTest.setShop(shop);
		
		try {
			manager.insert(newProductInsertTest);
			
			Product expectedProduct = manager.selectProductById(100);
			
			assertEquals(newProductInsertTest, expectedProduct);
		} catch (Exception e) {
			// Nothing
		}
	}
	
	@Test
	public void testDeletePokemon() {
		Product productToDelete = new Product();
		
		productToDelete.setIdProduct(100);
		productToDelete.setNamePr("prueba");
		productToDelete.setDescriptionPr("prueba");
		productToDelete.setPhotoPr(null);
		productToDelete.setValuePr(0);
		productToDelete.setQuantityPr(0);
		Shop shop = new Shop();
		shop.setIdShop(1);
		productToDelete.setShop(shop);
		
		try {
			manager.delete(productToDelete);
			
			Product expectedProduct = manager.selectProductById(100);
			
			assertEquals(null, expectedProduct); // selectProductById returns null if nothing was found
		} catch (Exception e) {
			// Nothing
		}
	}
}

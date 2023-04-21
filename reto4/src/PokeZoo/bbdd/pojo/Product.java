package PokeZoo.bbdd.pojo;

import java.io.Serializable;

public class Product implements Serializable{

	private static final long serialVersionUID = 237001453545700048L;
	
	// attributes
	private int idProduct = 0; 
	private String namePr = "";
	private String descriptionPr = "";
	private double valuePr = 0;
	private Shop shop = null;
	
}

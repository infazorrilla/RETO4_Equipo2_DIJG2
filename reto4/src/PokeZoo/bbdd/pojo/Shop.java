package PokeZoo.bbdd.pojo;

import java.io.Serializable;

public class Shop implements Serializable{

	private static final long serialVersionUID = 3575584049443846919L;

	// attributes
	private int idShop = 0;
	private String nameS = "";
	private int capacityS = 0;
	//private Admin admin = null;
	
	// Getters ans Setters
	public int getIdShop() {
		return idShop;
	}
	public void setIdShop(int idShop) {
		this.idShop = idShop;
	}
	public String getNameS() {
		return nameS;
	}
	public void setNameS(String nameS) {
		this.nameS = nameS;
	}
	public int getCapacityS() {
		return capacityS;
	}
	public void setCapacityS(int capacityS) {
		this.capacityS = capacityS;
	}
	
}

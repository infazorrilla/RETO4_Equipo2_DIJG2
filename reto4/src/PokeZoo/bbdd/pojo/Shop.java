package PokeZoo.bbdd.pojo;

import java.io.Serializable;
import java.util.Objects;

public class Shop implements Serializable{

	private static final long serialVersionUID = 3575584049443846919L;

	// attributes
	private int idShop = 0;
	private String nameSh = "";
	private int capacitySh = 0;
	//private Admin admin = null;
	
	// Getters ans Setters
	public int getIdShop() {
		return idShop;
	}
	public void setIdShop(int idShop) {
		this.idShop = idShop;
	}
	public String getNameSh() {
		return nameSh;
	}
	public void setNameSh(String nameS) {
		this.nameSh = nameS;
	}
	public int getCapacitySh() {
		return capacitySh;
	}
	public void setCapacitySh(int capacityS) {
		this.capacitySh = capacityS;
	}
	
	@Override
	public String toString() {
		return "Shop [idShop=" + idShop + ", nameSh=" + nameSh + ", capacitySh=" + capacitySh + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(capacitySh, idShop, nameSh);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Shop other = (Shop) obj;
		return capacitySh == other.capacitySh && idShop == other.idShop && Objects.equals(nameSh, other.nameSh);
	}
	
}

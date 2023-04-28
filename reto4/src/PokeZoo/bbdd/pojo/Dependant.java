package PokeZoo.bbdd.pojo;

import java.util.Objects;

public class Dependant extends Worker{

	private static final long serialVersionUID = 8891819425817276748L;

	private int idDependant = 0;
	
	// Links Dependant Table with it Shop Table
	private Shop shop = null;

	// Getters and Setters
	public int getIdDependant() {
		return idDependant;
	}

	public void setIdDependant(int idDependant) {
		this.idDependant = idDependant;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(idDependant, shop);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dependant other = (Dependant) obj;
		return idDependant == other.idDependant && Objects.equals(shop, other.shop);
	}

	@Override
	public String toString() {
		return "Dependant [idDependant=" + idDependant + ", shop=" + shop + "]";
	}
}

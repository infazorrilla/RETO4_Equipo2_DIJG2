package PokeZoo.bbdd.pojo;

import java.io.Serializable;
import java.util.Objects;

public class Enclosure implements Serializable {

	// Primary key
	private int idEnclosure = 0;

	// Atrib
	private String typeEn = null;
	private int numberEn = 0;
	
	// link
		// private Cleaner cleaner = null;

	public int getIdEnclosure() {
		return idEnclosure;
	}

	public void setIdEnclosure(int idEnclosure) {
		this.idEnclosure = idEnclosure;
	}

	public String getTypeEn() {
		return typeEn;
	}

	public void setTypeEn(String typeEn) {
		this.typeEn = typeEn;
	}

	public int getNumberEn() {
		return numberEn;
	}

	public void setNumberEn(int numberEn) {
		this.numberEn = numberEn;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idEnclosure, numberEn, typeEn);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Enclosure other = (Enclosure) obj;
		return idEnclosure == other.idEnclosure && numberEn == other.numberEn && Objects.equals(typeEn, other.typeEn);
	}

	@Override
	public String toString() {
		return "Enclosure [idEnclosure=" + idEnclosure + ", typeEn=" + typeEn + ", numberEn=" + numberEn + "]";
	}

	

}

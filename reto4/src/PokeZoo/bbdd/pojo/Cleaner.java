package PokeZoo.bbdd.pojo;

import java.util.Objects;

public class Cleaner extends Employee{
	
	private static final long serialVersionUID = -8286591345047737015L;

	//link Cleaner Table with Enclosure Table
	private Enclosure enclosure = null;

	// Gettes and Setters
	public Enclosure getEnclosure() {
		return enclosure;
	}

	public void setEnclosure(Enclosure enclosure) {
		this.enclosure = enclosure;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(enclosure);
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
		Cleaner other = (Cleaner) obj;
		return Objects.equals(enclosure, other.enclosure);
	}

	@Override
	public String toString() {
		return "Cleaner [enclosure=" + enclosure + "]";
	}
}

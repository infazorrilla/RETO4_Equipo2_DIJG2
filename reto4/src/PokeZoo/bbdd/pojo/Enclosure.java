package PokeZoo.bbdd.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Enclosure implements Serializable {

	private static final long serialVersionUID = 8303174678516409123L;

	// Primary key
	private int idEnclosure = 0;

	// Atrib
	private String typeEn = null;
	private int numberEn = 0;

	// link Enclosure with cleaner
	// private Cleaner cleaner = null;

	// link Enclosure with Pokemon
	private ArrayList<Pokemon> pokemon = null;

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

	public ArrayList<Pokemon> getPokemon() {
		return pokemon;
	}

	public void setPokemon(ArrayList<Pokemon> pokemon) {
		this.pokemon = pokemon;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idEnclosure, numberEn, pokemon, typeEn);
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
		return idEnclosure == other.idEnclosure && numberEn == other.numberEn && Objects.equals(pokemon, other.pokemon)
				&& Objects.equals(typeEn, other.typeEn);
	}

	@Override
	public String toString() {
		return "Enclosure [idEnclosure=" + idEnclosure + ", typeEn=" + typeEn + ", numberEn=" + numberEn + ", pokemon="
				+ pokemon + "]";
	}

}

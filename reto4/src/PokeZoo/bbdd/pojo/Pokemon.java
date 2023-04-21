package PokeZoo.bbdd.pojo;

import java.io.Serializable;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.Objects;

public class Pokemon implements Serializable {

	private static final long serialVersionUID = 4268344699422278647L;

	// primary key
	private int idPokemon = 0;

	// Atrib
	private Blob photopo = null;
	private String namePo = null;
	private String typeP = null;
	private String typeS = null;
	private int numPokedex = 0;
	private String descriptionPo = null;

	// link Pokemon with Food
	private ArrayList<Food> food = null;

	// link Pokemon with Enclosure
	private ArrayList<Enclosure> enclosure = null;

	public int getIdPokemon() {
		return idPokemon;
	}

	public void setIdPokemon(int idPokemon) {
		this.idPokemon = idPokemon;
	}

	public Blob getPhotopo() {
		return photopo;
	}

	public void setPhotopo(Blob photopo) {
		this.photopo = photopo;
	}

	public String getNamePo() {
		return namePo;
	}

	public void setNamePo(String namePo) {
		this.namePo = namePo;
	}

	public String getTypeP() {
		return typeP;
	}

	public void setTypeP(String typeP) {
		this.typeP = typeP;
	}

	public String getTypeS() {
		return typeS;
	}

	public void setTypeS(String typeS) {
		this.typeS = typeS;
	}

	public int getNumPokedex() {
		return numPokedex;
	}

	public void setNumPokedex(int numPokedex) {
		this.numPokedex = numPokedex;
	}

	public String getDescriptionPo() {
		return descriptionPo;
	}

	public void setDescriptionPo(String descriptionPo) {
		this.descriptionPo = descriptionPo;
	}

	public ArrayList<Food> getFood() {
		return food;
	}

	public void setFood(ArrayList<Food> food) {
		this.food = food;
	}

	public ArrayList<Enclosure> getEnclosure() {
		return enclosure;
	}

	public void setEnclosure(ArrayList<Enclosure> enclosure) {
		this.enclosure = enclosure;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(descriptionPo, enclosure, food, idPokemon, namePo, numPokedex, photopo, typeP, typeS);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pokemon other = (Pokemon) obj;
		return Objects.equals(descriptionPo, other.descriptionPo) && Objects.equals(enclosure, other.enclosure)
				&& Objects.equals(food, other.food) && idPokemon == other.idPokemon
				&& Objects.equals(namePo, other.namePo) && numPokedex == other.numPokedex
				&& Objects.equals(photopo, other.photopo) && Objects.equals(typeP, other.typeP)
				&& Objects.equals(typeS, other.typeS);
	}

	@Override
	public String toString() {
		return "Pokemon [idPokemon=" + idPokemon + ", photopo=" + photopo + ", namePo=" + namePo + ", typeP=" + typeP
				+ ", typeS=" + typeS + ", numPokedex=" + numPokedex + ", descriptionPo=" + descriptionPo + ", food="
				+ food + ", enclosure=" + enclosure + "]";
	}

}

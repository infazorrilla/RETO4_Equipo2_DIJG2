package PokeZoo.bbdd.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Food implements Serializable {

	private static final long serialVersionUID = -5466144742054535258L;

	// Primary key
	private int idFood = 0;

	// Atrib
	private int quantityFo = 0;
	private int dailyConsumeFo = 0;
	private String nameFo = null;
	private String descriptionFo = null;

	// link food with pokemon
	// private Pokemon pokemon = null;

	// link food with caretaker
	private ArrayList<Caretaker> caretaker = null;

	public int getIdFood() {
		return idFood;
	}

	public void setIdFood(int idFood) {
		this.idFood = idFood;
	}

	public int getQuantityFo() {
		return quantityFo;
	}

	public void setQuantityFo(int quantity) {
		this.quantityFo = quantity;
	}

	public int getDailyConsumeFo() {
		return dailyConsumeFo;
	}

	public void setDailyConsumeFo(int dailyConsume) {
		this.dailyConsumeFo = dailyConsume;
	}

	public String getNameFo() {
		return nameFo;
	}

	public void setNameFo(String nameFo) {
		this.nameFo = nameFo;
	}

	public String getDescriptionFo() {
		return descriptionFo;
	}

	public void setDescriptionFo(String descriptionFo) {
		this.descriptionFo = descriptionFo;
	}

	public ArrayList<Caretaker> getCaretaker() {
		return caretaker;
	}

	public void setCaretaker(ArrayList<Caretaker> caretaker) {
		this.caretaker = caretaker;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(caretaker, dailyConsumeFo, descriptionFo, idFood, nameFo, quantityFo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Food other = (Food) obj;
		return Objects.equals(caretaker, other.caretaker) && dailyConsumeFo == other.dailyConsumeFo
				&& Objects.equals(descriptionFo, other.descriptionFo) && idFood == other.idFood
				&& Objects.equals(nameFo, other.nameFo) && quantityFo == other.quantityFo;
	}

	@Override
	public String toString() {
		return "Food [idFood=" + idFood + ", quantity=" + quantityFo + ", dailyConsume=" + dailyConsumeFo + ", nameFo="
				+ nameFo + ", descriptionFo=" + descriptionFo + ", caretaker=" + caretaker + "]";
	}

}

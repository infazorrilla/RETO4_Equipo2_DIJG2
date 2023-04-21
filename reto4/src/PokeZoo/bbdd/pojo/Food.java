package PokeZoo.bbdd.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Food implements Serializable {

	private static final long serialVersionUID = -5466144742054535258L;

	// Primary key
	private int idFood = 0;

	// Atrib
	private int quantity = 0;
	private int dailyConsume = 0;
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getDailyConsume() {
		return dailyConsume;
	}

	public void setDailyConsume(int dailyConsume) {
		this.dailyConsume = dailyConsume;
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
		return Objects.hash(caretaker, dailyConsume, descriptionFo, idFood, nameFo, quantity);
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
		return Objects.equals(caretaker, other.caretaker) && dailyConsume == other.dailyConsume
				&& Objects.equals(descriptionFo, other.descriptionFo) && idFood == other.idFood
				&& Objects.equals(nameFo, other.nameFo) && quantity == other.quantity;
	}

	@Override
	public String toString() {
		return "Food [idFood=" + idFood + ", quantity=" + quantity + ", dailyConsume=" + dailyConsume + ", nameFo="
				+ nameFo + ", descriptionFo=" + descriptionFo + ", caretaker=" + caretaker + "]";
	}

}

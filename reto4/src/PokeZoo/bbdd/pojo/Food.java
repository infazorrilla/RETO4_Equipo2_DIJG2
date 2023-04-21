package PokeZoo.bbdd.pojo;

import java.util.ArrayList;
import java.util.Objects;

public class Food {

	// Primary key
	private int idFood = 0;

	// Atrib
	private int quantity = 0;
	private int dailyConsume = 0;
	private String name = null;
	private String description = null;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ArrayList<Caretaker> getCaretaker() {
		return caretaker;
	}

	public void setCaretaker(ArrayList<Caretaker> caretaker) {
		this.caretaker = caretaker;
	}

	@Override
	public int hashCode() {
		return Objects.hash(caretaker, dailyConsume, description, idFood, name, quantity);
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
				&& Objects.equals(description, other.description) && idFood == other.idFood
				&& Objects.equals(name, other.name) && quantity == other.quantity;
	}

	@Override
	public String toString() {
		return "Food [idFood=" + idFood + ", quantity=" + quantity + ", dailyConsume=" + dailyConsume + ", name=" + name
				+ ", description=" + description + ", caretaker=" + caretaker + "]";
	}

}

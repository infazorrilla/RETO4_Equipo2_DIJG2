package PokeZoo.bbdd.pojo;

import java.util.ArrayList;
import java.util.Objects;

public class Caretaker extends Employee{

	private static final long serialVersionUID = -6508944650395536291L;

	//link caretaker with food
	private ArrayList<Food> food = null;

	// Getters and Setters
	public ArrayList<Food> getFood() {
		return food;
	}

	public void setFood(ArrayList<Food> food) {
		this.food = food;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(food);
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
		Caretaker other = (Caretaker) obj;
		return Objects.equals(food, other.food);
	}

	@Override
	public String toString() {
		return "Caretaker [food=" + food + "]";
	}
}

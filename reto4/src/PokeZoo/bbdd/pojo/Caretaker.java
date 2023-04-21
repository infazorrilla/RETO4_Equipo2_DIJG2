package PokeZoo.bbdd.pojo;

import java.util.ArrayList;
import java.util.Objects;

public class Caretaker {

	//link caretaker with food
	private ArrayList<Food> food = null;

	@Override
	public String toString() {
		return "Caretaker [food=" + food + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(food);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Caretaker other = (Caretaker) obj;
		return Objects.equals(food, other.food);
	}

	public ArrayList<Food> getFood() {
		return food;
	}

	public void setFood(ArrayList<Food> food) {
		this.food = food;
	}
}

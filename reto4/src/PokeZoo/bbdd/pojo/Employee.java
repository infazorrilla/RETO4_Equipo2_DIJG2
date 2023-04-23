package PokeZoo.bbdd.pojo;

import java.util.Objects;

public class Employee extends Worker{

	private static final long serialVersionUID = -1438995998386231744L;

	private int idEmployee = 0;

	// Getters and Setters
	public int getIdEmployee() {
		return idEmployee;
	}

	public void setIdEmployee(int idEmployee) {
		this.idEmployee = idEmployee;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(idEmployee);
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
		Employee other = (Employee) obj;
		return idEmployee == other.idEmployee;
	}

	@Override
	public String toString() {
		return "Employee [idEmployee=" + idEmployee + "]";
	}
	
}

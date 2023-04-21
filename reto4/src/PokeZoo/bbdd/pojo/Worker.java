package PokeZoo.bbdd.pojo;

import java.io.Serializable;
import java.util.Objects;

public class Worker implements Serializable{

	private static final long serialVersionUID = 7668215370937135696L;

	// Attributes
	private String dni = "";
	private String nameW = "";
	private String surnameW = "";
	private String phoneW = "";
	private User user = null;
	
	// Getters and Setters	
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNameW() {
		return nameW;
	}
	public void setNameW(String nameW) {
		this.nameW = nameW;
	}
	public String getSurnameW() {
		return surnameW;
	}
	public void setSurnameW(String surnameW) {
		this.surnameW = surnameW;
	}
	public String getPhoneW() {
		return phoneW;
	}
	public void setPhoneW(String phoneW) {
		this.phoneW = phoneW;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	// To String
	@Override
	public String toString() {
		return "Worker [dni=" + dni + ", nameW=" + nameW + ", surnameW=" + surnameW + ", phoneW=" + phoneW + ", user="
				+ user + "]";
	}
	
	// HashCode
	@Override
	public int hashCode() {
		return Objects.hash(dni, nameW, phoneW, surnameW, user);
	}
	
	// Equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Worker other = (Worker) obj;
		return Objects.equals(dni, other.dni) && Objects.equals(nameW, other.nameW)
				&& Objects.equals(phoneW, other.phoneW) && Objects.equals(surnameW, other.surnameW)
				&& Objects.equals(user, other.user);
	}
	
}

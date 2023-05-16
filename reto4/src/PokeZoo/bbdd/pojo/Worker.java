package PokeZoo.bbdd.pojo;

import java.io.Serializable;
import java.util.Objects;

public abstract class Worker implements Serializable{

	private static final long serialVersionUID = 7668215370937135696L;

	// Attributes
	private String dni = "";
	private String nameWo = "";
	private String surnameWo = "";
	private String phoneWo = "";
	
	// 
	private User user = null;

	
	// Getters and Setters	
	public String getDni() {
		return dni;
	}	
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNameWo() {
		return nameWo;
	}
	public void setNameWo(String nameW) {
		this.nameWo = nameW;
	}
	public String getSurnameWo() {
		return surnameWo;
	}
	public void setSurnameWo(String surnameW) {
		this.surnameWo = surnameW;
	}
	public String getPhoneWo() {
		return phoneWo;
	}
	public void setPhoneWo(String phoneW) {
		this.phoneWo = phoneW;
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
		return "Worker [dni=" + dni + ", nameW=" + nameWo + ", surnameW=" + surnameWo + ", phoneW=" + phoneWo + ", user="
				+ user + "]";
	}
	
	// HashCode
	@Override
	public int hashCode() {
		return Objects.hash(dni, nameWo, phoneWo, surnameWo, user);
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
		return Objects.equals(dni, other.dni) && Objects.equals(nameWo, other.nameWo)
				&& Objects.equals(phoneWo, other.phoneWo) && Objects.equals(surnameWo, other.surnameWo)
				&& Objects.equals(user, other.user);
	}
	
}

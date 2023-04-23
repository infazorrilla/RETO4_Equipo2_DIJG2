package PokeZoo.bbdd.pojo;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable{

	private static final long serialVersionUID = 2653832574755415879L;

	// attributes
	private int idUser = 0;
	private boolean isAdmin = false;
	private String username = "";
	private String passwd = "";
	
	// Getters and Setters
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(idUser, isAdmin, passwd, username);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return idUser == other.idUser && isAdmin == other.isAdmin && Objects.equals(passwd, other.passwd)
				&& Objects.equals(username, other.username);
	}
	
	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", isAdmin=" + isAdmin + ", username=" + username + ", passwd=" + passwd
				+ "]";
	}
	
}

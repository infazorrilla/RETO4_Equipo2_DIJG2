package PokeZoo.bbdd.pojo;

import java.io.Serializable;

public class User implements Serializable{

	private static final long serialVersionUID = 2653832574755415879L;

	// attributes
	private int idUser = 0;
	private boolean isAdmin = false;
	private String username = "";
	private String passwd = "";
	private Worker worker = null;
	
}

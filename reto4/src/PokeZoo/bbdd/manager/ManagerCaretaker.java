package PokeZoo.bbdd.manager;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.security.auth.login.AccountNotFoundException;

import PokeZoo.bbdd.pojo.Caretaker;

public class ManagerCaretaker implements ManagerInterface<Caretaker>{

	@Override
	public ArrayList<Caretaker> selectAll() throws SQLException, AccountNotFoundException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Caretaker t) throws SQLException, Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Caretaker t) throws SQLException, Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Caretaker t) throws SQLException, Exception {
		// TODO Auto-generated method stub
		
	}

}

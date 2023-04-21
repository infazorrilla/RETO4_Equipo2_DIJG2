package PokeZoo.bbdd.manager;

import java.sql.SQLException;
import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

import PokeZoo.bbdd.pojo.Pokemon;

public class ManagerPokemon implements managerGeneral<Pokemon>{

	@Override
	public List<Pokemon> selectAll() throws SQLException, AccountNotFoundException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Pokemon t) throws SQLException, Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Pokemon t) throws SQLException, Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Pokemon t) throws SQLException, Exception {
		// TODO Auto-generated method stub
		
	}

}

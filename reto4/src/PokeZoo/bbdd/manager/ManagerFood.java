package PokeZoo.bbdd.manager;

import java.sql.SQLException;
import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

import PokeZoo.bbdd.pojo.Food;

public class ManagerFood implements managerGeneral<Food>{

	@Override
	public List<Food> selectAll() throws SQLException, AccountNotFoundException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Food t) throws SQLException, Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Food t) throws SQLException, Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Food t) throws SQLException, Exception {
		// TODO Auto-generated method stub
		
	}

}

package PokeZoo.bbdd.manager;

import java.sql.SQLException;
import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

import PokeZoo.bbdd.pojo.Product;

public class ManagerProduct implements managerGeneral<Product>{

	@Override
	public List<Product> selectAll() throws SQLException, AccountNotFoundException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Product t) throws SQLException, Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Product t) throws SQLException, Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Product t) throws SQLException, Exception {
		// TODO Auto-generated method stub
		
	}

}

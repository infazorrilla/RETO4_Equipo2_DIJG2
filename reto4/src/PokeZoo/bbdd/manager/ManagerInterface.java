package PokeZoo.bbdd.manager;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.security.auth.login.AccountNotFoundException;

/**
 * Cada manager debe de implementar estos metodos
 */
public interface ManagerInterface <T>{

	/**
	 * Return all instances of T in Data Base
	 * 
	 * @return All instances of T
	 * @throws SQLException
	 * @throws NotFoundException
	 * @throws Exception
	 */
	public ArrayList <T> selectAll () throws SQLException, AccountNotFoundException, Exception;
	
	/**
	 * Insert a new T on Data Base
	 * 
	 * @param t
	 */
	public void insert (T t) throws SQLException, Exception;

	/**
	 * Updates a T on Data Base 
	 * 
	 * @param t
	 */
	public void update (T t) throws SQLException, Exception;
	
	/**
	 * Delete a T on Data Base 
	 * 
	 * @param t
	 */
	public void delete (T t) throws SQLException, Exception;
	
	
}

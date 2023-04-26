package PokeZoo.bbdd.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.security.auth.login.AccountNotFoundException;

import PokeZoo.bbdd.pojo.Dependent;
import PokeZoo.bbdd.pojo.User;
import PokeZoo.bbdd.utils.DBUtils;

public class ManagerDependent implements ManagerInterface<Dependent>{

	@Override
	public ArrayList<Dependent> selectAll() throws SQLException, AccountNotFoundException, Exception {
		ArrayList<Dependent> ret = null;

		String sql = "SELECT dni, nameDe, surnameDe, phoneDe, e.idUser, isAdmin, username, passwd\r\n"
				+ "FROM Dependent AS e \r\n" + "JOIN User AS u ON e.idUser = u.idUser;";

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				if (null == ret) {
					ret = new ArrayList<Dependent>();
				}

				Dependent dependent = new Dependent();

				// añadir datos de Shop aqui
				dependent.setDni(resultSet.getString("dni"));
				dependent.setNameWo(resultSet.getString("nameDe"));
				dependent.setSurnameWo(resultSet.getString("surnameDe"));
				dependent.setPhoneWo(resultSet.getString("phoneDe"));

				User user = new User();
				user.setIdUser(resultSet.getInt("idUser"));
				user.setAdmin(resultSet.getBoolean("isAdmin"));
				user.setUsername(resultSet.getString("username"));
				user.setPasswd(resultSet.getString("passwd"));

				dependent.setUser(user);

				ret.add(dependent);
			}
		} catch (SQLException sqle) {
			System.out.println("Error con la BBDD - " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error generico - " + e.getMessage());
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
			} catch (Exception e) {
				// Nothing
			}
			try {
				if (statement != null)
					statement.close();
			} catch (Exception e) {
				// Nothing
			}
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				// Nothing
			}
		}
		return ret;
	}

	@Override
	public void insert(Dependent t) throws SQLException, Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Dependent t) throws SQLException, Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Dependent t) throws SQLException, Exception {
		// TODO Auto-generated method stub
		
	}

}

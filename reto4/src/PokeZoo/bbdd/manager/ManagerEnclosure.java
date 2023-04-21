package PokeZoo.bbdd.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

import PokeZoo.bbdd.pojo.Enclosure;
import PokeZoo.bbdd.utils.DBUtils;

public class ManagerEnclosure implements managerGeneral<Enclosure>{

	@Override
	public List<Enclosure> selectAll() throws SQLException, AccountNotFoundException, Exception {
		ArrayList<Enclosure> ret = null;

		String sql = "select * from Enclosure";

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
					ret = new ArrayList<Enclosure>();
				}

				Enclosure enclo = new Enclosure();

				// añadir datos del Pokemon aqui
				enclo.setIdEnclosure(resultSet.getInt("idEnclosure"));
				enclo.setTypeEn(resultSet.getString("typeEn"));
				enclo.setNumberEn(resultSet.getInt("numberEn"));
				
				ret.add(enclo);
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

			}
			try {
				if (statement != null)
					statement.close();
			} catch (Exception e) {

			}
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {

			}
		}
		return ret;
		
	}

	@Override
	public void insert(Enclosure t) throws SQLException, Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Enclosure t) throws SQLException, Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Enclosure t) throws SQLException, Exception {
		// TODO Auto-generated method stub
		
	}

}

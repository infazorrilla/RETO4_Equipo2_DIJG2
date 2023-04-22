package PokeZoo.bbdd.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.security.auth.login.AccountNotFoundException;

import PokeZoo.bbdd.pojo.Shop;
import PokeZoo.bbdd.utils.DBUtils;

public class ManagerShop implements managerGeneral<Shop>{

	@Override
	public ArrayList<Shop> selectAll() throws SQLException, AccountNotFoundException, Exception {
		ArrayList<Shop> ret = null;

		String sql = "select * from Shop";

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
					ret = new ArrayList<Shop>();
				}

				Shop shop = new Shop();

				// añadir datos del Pokemon aqui
				shop.setIdShop(resultSet.getInt("idShop"));
				shop.setNameSh(resultSet.getString("nameSh"));
				shop.setCapacitySh(resultSet.getInt("capacitySh"));

				ret.add(shop);
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
	public void insert(Shop t) throws SQLException, Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Shop t) throws SQLException, Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Shop t) throws SQLException, Exception {
		// TODO Auto-generated method stub
		
	}

}

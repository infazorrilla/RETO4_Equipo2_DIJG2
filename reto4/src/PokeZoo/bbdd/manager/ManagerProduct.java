package PokeZoo.bbdd.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

import PokeZoo.bbdd.pojo.Product;
import PokeZoo.bbdd.utils.DBUtils;

public class ManagerProduct implements managerGeneral<Product> {

	@Override
	public List<Product> selectAll() throws SQLException, AccountNotFoundException, Exception {
		ArrayList<Product> ret = null;

		String sql = "select * from Product";

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
					ret = new ArrayList<Product>();
				}

				Product product = new Product();

				// añadir datos del Pokemon aqui
				product.setIdProduct(resultSet.getInt("idProduct"));
				product.setNamePr(resultSet.getString("namePr"));
				product.setDescriptionPr(resultSet.getString("descripcionPr"));
				product.setValuePr(resultSet.getDouble("valuePr"));

				ret.add(product);
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

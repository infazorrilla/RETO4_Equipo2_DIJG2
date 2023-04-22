package PokeZoo.bbdd.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.security.auth.login.AccountNotFoundException;

import PokeZoo.bbdd.pojo.Product;
import PokeZoo.bbdd.utils.DBUtils;

public class ManagerProduct implements managerGeneral<Product> {

	@Override
	public ArrayList<Product> selectAll() throws SQLException, AccountNotFoundException, Exception {
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
	public void insert(Product t) throws SQLException, Exception {
		Connection connection = null;
		Statement statement = null;

		try {
			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			statement = connection.createStatement();
			String sql = "INSERT INTO Product (namePr, descriptionPr, photoPr, valuePr, quantityPr, idShop) "
					+ "VALUES ('" + t.getNamePr() + "', '" + t.getDescriptionPr() + "', '" + t.getPhotoPr() + "'"
					+ ", '" + t.getValuePr() + "', '" + t.getQuantityPr() + "', '" + t.getShop().getIdShop() + "', NULL);";

			statement.executeUpdate(sql);

		} catch (SQLException sqle) {
			System.out.println("Error con la BBDD - " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error generico - " + e.getMessage());
		} finally {
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
	}

	@Override
	public void update(Product t) throws SQLException, Exception {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			Class.forName(DBUtils.DRIVER);
			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			String sql = "UPDATE Product SET namePr = ?, descriptionPr = ?, valuePr = ?, quantityPr  = ? WHERE idProduct = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, t.getNamePr());
			preparedStatement.setString(2, t.getDescriptionPr());
			preparedStatement.setDouble(3, t.getValuePr());
			preparedStatement.setInt(4, t.getQuantityPr());
			preparedStatement.setInt(5, t.getIdProduct());

			preparedStatement.executeUpdate();
		} catch (SQLException sqle) {
			System.out.println("Error con la BBDD - " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error generico - " + e.getMessage());
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (Exception e) {
				// Nothing
			}
			;
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				// Nothing
			};
		}
	}

	@Override
	public void delete(Product t) throws SQLException, Exception {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			String sql = "DELETE FROM Product WHERE idProduct = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, t.getIdProduct());

			preparedStatement.executeUpdate();
		} catch (SQLException sqle) {
			System.out.println("Error con la BBDD - " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error generico - " + e.getMessage());
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (Exception e) {
				// Nothing
			};
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				// Nothing
			};
		}
	}

}

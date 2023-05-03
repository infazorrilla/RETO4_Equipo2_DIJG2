package PokeZoo.bbdd.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.security.auth.login.AccountNotFoundException;

import PokeZoo.bbdd.exception.NotFoundException;
import PokeZoo.bbdd.pojo.Shop;
import PokeZoo.bbdd.utils.DBUtils;

public class ManagerShop implements ManagerInterface<Shop>{

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
			
			if (resultSet.next() == false) {
				throw new NotFoundException("No hay resultados para Tiendas");
			} else {
				do {
					if (null == ret) {
						ret = new ArrayList<Shop>();
					}
					Shop shop = new Shop();

					// añadir datos de Shop aqui
					shop.setIdShop(resultSet.getInt("idShop"));
					shop.setNameSh(resultSet.getString("nameSh"));
					shop.setCapacitySh(resultSet.getInt("capacitySh"));

					ret.add(shop);
				}while(resultSet.next());
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

	public Shop selectShopById(int id) {
		Shop ret = null;

		String sql = "SELECT * FROM Shop WHERE idShop = " + id;

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);

			if (resultSet.next() == false) {
				throw new NotFoundException("No hay resultados para Tiendas");
			} else {
				do {
					if (null == ret) {
						ret = new Shop();
					}
					// añadir datos del Pokemon aqui
					ret.setIdShop(resultSet.getInt("idShop"));
					ret.setNameSh(resultSet.getString("nameSh"));
					ret.setCapacitySh(resultSet.getInt("capacitySh"));
				}while(resultSet.next());
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
		Connection connection = null;
		Statement statement = null;
		
		String sql = "";
		
		try {
			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			statement = connection.createStatement();
			if(t.getIdShop() == 0) {
				sql = "INSERT INTO Shop (nameSh, capacitySh) "
						+ "VALUES ('" + t.getNameSh() + "', '" + t.getCapacitySh() + ");";
			}else {
				sql = "INSERT INTO Shop (idShop, nameSh, capacitySh) "
						+ "VALUES ('" + t.getIdShop() + "', '" + t.getNameSh() + "', '" + t.getCapacitySh() + ");";
			}
			
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
				// Nothing
			}
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				// Nothing
			}
		}
	}

	@Override
	public void update(Shop t) throws SQLException, Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Shop t) throws SQLException, Exception {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			String sql = "DELETE FROM Shop WHERE idShop = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, t.getIdShop());

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

}

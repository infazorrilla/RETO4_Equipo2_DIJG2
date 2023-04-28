package PokeZoo.bbdd.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.security.auth.login.AccountNotFoundException;

import PokeZoo.bbdd.pojo.Food;
import PokeZoo.bbdd.utils.DBUtils;

public class ManagerFood implements ManagerInterface<Food>{

	@Override
	public ArrayList<Food> selectAll() throws SQLException, AccountNotFoundException, Exception {
		ArrayList<Food> ret = null;

		String sql = "select * from Food";

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
					ret = new ArrayList<Food>();
				}

				Food food = new Food();

				// añadir datos del Pokemon aqui
				food.setIdFood(resultSet.getInt("idFood"));
				food.setQuantityFo(resultSet.getInt("quantityFo"));
				food.setDailyConsumeFo(resultSet.getInt("dailyConsumeFo"));
				food.setNameFo(resultSet.getString("nameFo"));
				food.setDescriptionFo(resultSet.getString("descriptionFo"));
				
				ret.add(food);
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
	
	public Food selectFoodById(int id) throws SQLException, AccountNotFoundException, Exception {
		Food ret = null;
		
		String sql = "SELECT * FROM Food WHERE idFood = " + id;

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);

			if (resultSet.next()) {
				if (null == ret) {
					ret = new Food();
				}
				// añadir datos del Pokemon aqui
				ret.setIdFood(resultSet.getInt("idFood"));
				ret.setQuantityFo(resultSet.getInt("quantityFo"));
				ret.setDailyConsumeFo(resultSet.getInt("dailyConsumeFo"));
				ret.setNameFo(resultSet.getString("nameFo"));
				ret.setDescriptionFo(resultSet.getString("descriptionFo"));
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
	public void insert(Food t) throws SQLException, Exception {
		Connection connection = null;
		Statement statement = null;

		String sql = "";
		try {
			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			statement = connection.createStatement();
			if(t.getIdFood() == 0) {
				sql = "INSERT INTO Food (quantityFo, dailyConsumeFo, nameFo, descriptionFo) "
						+ "VALUES ('" + t.getQuantityFo() + "', '" + t.getDailyConsumeFo() + "', '" + t.getNameFo() + "'"
						+ ", '" + t.getDescriptionFo() + "');";
			}else {
				sql = "INSERT INTO Food (idFood, quantityFo, dailyConsumeFo, nameFo, descriptionFo) "
						+ "VALUES ('" + t.getIdFood() + "', '" + t.getQuantityFo() + "', '" + t.getDailyConsumeFo() + "', '" + t.getNameFo() + "'"
						+ ", '" + t.getDescriptionFo() + "');";
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
	public void update(Food t) throws SQLException, Exception {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			Class.forName(DBUtils.DRIVER);
			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			String sql = "UPDATE Food SET quantityFo = ?, dailyConsumeFo = ?, nameFo = ?, descriptionFo  = ? WHERE idFood = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, t.getQuantityFo());
			preparedStatement.setInt(2, t.getDailyConsumeFo());
			preparedStatement.setString(3, t.getNameFo());
			preparedStatement.setString(4, t.getDescriptionFo());
			preparedStatement.setInt(5, t.getIdFood());

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
	public void delete(Food t) throws SQLException, Exception {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			String sql = "DELETE FROM Food WHERE idFood = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, t.getIdFood());

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

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

			if (resultSet.next() == false) {
				throw new NotFoundException("No hay resultados para Comida");
			} else {
				do {
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
	
	/**
	 * Method that checks the food name that will be add does not exist
	 * @param foodToInsert to be selected
	 * @return true if the name is the same as the database name or false if the name does not exist
	 */
	public boolean checkFoodNameExist(Food foodToInsert) {
		boolean ret = false;

		String sql = "SELECT * FROM Food WHERE nameFo = '" + foodToInsert.getNameFo() + "'";

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);

			if (resultSet.next()) {
				ret = true;
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
	
	/**
	 * Selects all foods mameFo from Food table in data base (for ComboBox)
	 * @return ArrayList<String> with all nameFo
	 */
	public ArrayList<String> selectAllFoodNames() {
		ArrayList<String> ret = null;

		String sql = "SELECT nameFo FROM Food ORDER BY idFood";

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);

			if (resultSet.next() == false) {
				throw new NotFoundException("No hay resultados para Comida");
			} else {
				do {
					if (null == ret) {
						ret = new ArrayList<String>();
					}				
					ret.add(resultSet.getString("nameFo"));
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
	
	/**
	 * returns a Food object that matches the id param, if none match return null
	 * @param id to be checked
	 * @return null if no food matches param, Food object if param matches idFood
	 * @throws SQLException
	 * @throws AccountNotFoundException
	 * @throws Exception
	 */
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

			if (resultSet.next() == false) {
				throw new NotFoundException("No hay resultados para Comida");
			} else {
				do {
					if (null == ret) {
						ret = new Food();
					}
					// añadir datos del Pokemon aqui
					ret.setIdFood(resultSet.getInt("idFood"));
					ret.setQuantityFo(resultSet.getInt("quantityFo"));
					ret.setDailyConsumeFo(resultSet.getInt("dailyConsumeFo"));
					ret.setNameFo(resultSet.getString("nameFo"));
					ret.setDescriptionFo(resultSet.getString("descriptionFo"));
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
	
	/**
	 * returns a Enclosure object that matches the nameFo param, if none match return null
	 * @param nameFood String to be checked
	 * @return null if no food matches param, Food object if param matches idFood
	 */
	public Food selectFoodByName(String nameFood) {
		Food ret = null;
		
		String sql = "SELECT * FROM Food WHERE nameFo = '" + nameFood + "'";

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);

			if (resultSet.next() == false) {
				throw new NotFoundException("No hay resultados para Comida");
			} else {
				do {
					if (null == ret) {
						ret = new Food();
					}
					// añadir datos del Pokemon aqui
					ret.setIdFood(resultSet.getInt("idFood"));
					ret.setQuantityFo(resultSet.getInt("quantityFo"));
					ret.setDailyConsumeFo(resultSet.getInt("dailyConsumeFo"));
					ret.setNameFo(resultSet.getString("nameFo"));
					ret.setDescriptionFo(resultSet.getString("descriptionFo"));
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

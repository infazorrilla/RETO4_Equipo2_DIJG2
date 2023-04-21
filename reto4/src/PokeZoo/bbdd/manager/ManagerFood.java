package PokeZoo.bbdd.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

import PokeZoo.bbdd.pojo.Food;
import PokeZoo.bbdd.utils.DBUtils;

public class ManagerFood implements managerGeneral<Food>{

	@Override
	public List<Food> selectAll() throws SQLException, AccountNotFoundException, Exception {
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
				food.setIdFood(resultSet.getInt("idEnclosure"));
				food.setQuantity(resultSet.getInt("typeEn"));
				food.setDailyConsume(resultSet.getInt("numberEn"));
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
	public void insert(Food t) throws SQLException, Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Food t) throws SQLException, Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Food t) throws SQLException, Exception {
		// TODO Auto-generated method stub
		
	}

}

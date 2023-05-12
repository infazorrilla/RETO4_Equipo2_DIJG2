package PokeZoo.bbdd.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.security.auth.login.AccountNotFoundException;

import PokeZoo.bbdd.exception.NotFoundException;
import PokeZoo.bbdd.pojo.Caretaker;
import PokeZoo.bbdd.pojo.Food;
import PokeZoo.bbdd.pojo.User;
import PokeZoo.bbdd.utils.DBUtils;

public class ManagerCaretaker implements ManagerInterface<Caretaker> {
	@Override
	public ArrayList<Caretaker> selectAll() throws SQLException, AccountNotFoundException, Exception {
		ArrayList<Caretaker> ret = null;

		String sql = "SELECT e.idEmployee, dni, nameEm, surnameEm, phoneEm, e.idUser, isAdmin, username, passwd, isBlock\r\n"
				+ "FROM Employee AS e \r\n" + "JOIN User AS u ON e.idUser = u.idUser\r\n"
				+ "JOIN Caretaker AS c ON e.idEmployee = c.idEmployee;";

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);

			if (resultSet.next() == false) {
				throw new NotFoundException("No hay resultados para Cuidadores");
			} else {
				do {
					if (null == ret) {
						ret = new ArrayList<Caretaker>();
					}
					Caretaker caretaker = new Caretaker();

					// añadir datos de Shop aqui
					caretaker.setIdEmployee(resultSet.getInt("IdEmployee"));
					caretaker.setDni(resultSet.getString("dni"));
					caretaker.setNameWo(resultSet.getString("nameEm"));
					caretaker.setSurnameWo(resultSet.getString("surnameEm"));
					caretaker.setPhoneWo(resultSet.getString("phoneEm"));

					User user = new User();
					user.setIdUser(resultSet.getInt("idUser"));
					user.setAdmin(resultSet.getBoolean("isAdmin"));
					user.setUsername(resultSet.getString("username"));
					user.setPasswd(resultSet.getString("passwd"));
					user.setIsBlocked(resultSet.getBoolean("isBlock"));

					caretaker.setUser(user);

					caretaker.setFood(selecAllFoodOfCaretakerByIdEmployee(caretaker.getIdEmployee()));

					ret.add(caretaker);
				} while (resultSet.next());
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
	 * Selects all food where the param equals employee table idEmployee
	 * @param idEmployee int used to select the food that concord with employee table idEmployee
	 * @return ArrayList<Food> of all foods that idEmployee is responsible of
	 */
	private ArrayList<Food> selecAllFoodOfCaretakerByIdEmployee(int idEmployee) {
		ArrayList<Food> ret = null;

		String sql = "SELECT f.* FROM Food AS f\r\n " + "JOIN care_food AS cf ON f.idFood = cf.idFood\r\n "
				+ "JOIN Caretaker AS c ON cf.idCaretaker = c.idCaretaker\r\n "
				+ "JOIN Employee AS e ON c.idEmployee = e.idEmployee\r\n " + "WHERE e.idEmployee =  " + idEmployee;

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);

			if (resultSet.next() == false) {
				throw new NotFoundException("No hay resultados para Cuidadores");
			} else {
				do {
					if (null == ret) {
						ret = new ArrayList<Food>();
					}
					Food food = new Food();

					food.setIdFood(resultSet.getInt("idFood"));
					food.setNameFo(resultSet.getString("nameFo"));
					food.setQuantityFo(resultSet.getInt("quantityFo"));
					food.setDailyConsumeFo(resultSet.getInt("dailyConsumeFo"));
					food.setDescriptionFo(resultSet.getString("descriptionFo"));

					ret.add(food);
				} while (resultSet.next());
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
	public void insert(Caretaker t) throws SQLException, Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Caretaker t) throws SQLException, Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Caretaker t) throws SQLException, Exception {
		// TODO Auto-generated method stub

	}

}

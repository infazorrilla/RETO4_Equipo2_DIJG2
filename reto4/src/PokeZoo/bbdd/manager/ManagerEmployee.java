package PokeZoo.bbdd.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.security.auth.login.AccountNotFoundException;

import PokeZoo.bbdd.pojo.Employee;
import PokeZoo.bbdd.pojo.User;
import PokeZoo.bbdd.utils.DBUtils;

public class ManagerEmployee implements managerGeneral<Employee> {

	@Override
	public ArrayList<Employee> selectAll() throws SQLException, AccountNotFoundException, Exception {
		ArrayList<Employee> ret = null;

		String sql = "SELECT dni, nameWo, surnameWo, phoneWo, w.idUser, isAdmin, username, passwd\r\n"
				+ "FROM Worker AS w \r\n" + "JOIN User AS u ON w.idUser = u.idUser;";

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
					ret = new ArrayList<Employee>();
				}

				Employee employee = new Employee();

				// añadir datos de Shop aqui
				employee.setDni(resultSet.getString("dni"));
				employee.setNameWo(resultSet.getString("nameWo"));
				employee.setSurnameWo(resultSet.getString("surnameWo"));
				employee.setPhoneWo(resultSet.getString("phoneWo"));

				User user = new User();
				user.setIdUser(resultSet.getInt("idUser"));
				user.setAdmin(resultSet.getBoolean("isAdmin"));
				user.setUsername(resultSet.getString("username"));
				user.setPasswd(resultSet.getString("passwd"));

				employee.setUser(user);

				ret.add(employee);
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

	public Employee selectEmployeeByDni(String dni) {
		Employee ret = null;

		String sql = "SELECT dni, nameWo, surnameWo, phoneWo, w.idUser, isAdmin, username, passwd\r\n"
				+ "FROM Worker AS w \r\n" + "JOIN User AS u ON w.idUser = u.idUser WHERE dni = '" + dni + ";";

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
					ret = new Employee();
				}
				// añadir datos de Shop aqui
				ret.setDni(resultSet.getString("dni"));
				ret.setNameWo(resultSet.getString("nameWo"));
				ret.setSurnameWo(resultSet.getString("surnameWo"));
				ret.setPhoneWo(resultSet.getString("phoneWo"));

				User user = new User();
				user.setIdUser(resultSet.getInt("idUser"));
				user.setAdmin(resultSet.getBoolean("isAdmin"));
				user.setUsername(resultSet.getString("username"));
				user.setPasswd(resultSet.getString("passwd"));

				ret.setUser(user);
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
	public void insert(Employee t) throws SQLException, Exception {
		Connection connection = null;
		Statement statement = null;

		try {
			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			statement = connection.createStatement();

			String sql = "INSERT INTO Worker (dni, nameWo, surnameWo, phoneWo) " + "VALUES ('" + t.getDni() + "', '" + t.getNameWo()
					+ ", '" + t.getSurnameWo() + "', '" + t.getPhoneWo() + "');";

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
	public void update(Employee t) throws SQLException, Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Employee t) throws SQLException, Exception {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			String sql = "DELETE FROM Worker WHERE dni = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, t.getDni());

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
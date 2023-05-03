package PokeZoo.bbdd.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.security.auth.login.AccountNotFoundException;

import PokeZoo.bbdd.exception.NotFoundException;
import PokeZoo.bbdd.pojo.Cleaner;
import PokeZoo.bbdd.pojo.Enclosure;
import PokeZoo.bbdd.pojo.User;
import PokeZoo.bbdd.utils.DBUtils;

public class ManagerCleaner implements ManagerInterface<Cleaner> {

	@Override
	public ArrayList<Cleaner> selectAll() throws SQLException, AccountNotFoundException, Exception {
		ArrayList<Cleaner> ret = null;

		String sql = "SELECT dni, nameEm, surnameEm, phoneEm, e.idUser, isAdmin, username, passwd, isBlock, en.idEnclosure, en.typeEn\r\n"
				+ "FROM Employee AS e \r\n" + "JOIN User AS u ON e.idUser = u.idUser\r\n"
				+ "JOIN Cleaner AS c ON e.idEmployee = c.idEmployee\r\n"
				+ "JOIN Enclosure AS en ON en.idEnclosure = c.idEnclosure;";

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);

			if (resultSet.next() == false) {
				throw new NotFoundException("No hay resultados para Limpiadores");
			} else {
				do {
					if (null == ret) {
						ret = new ArrayList<Cleaner>();
					}
					Cleaner cleaner = new Cleaner();

					// añadir datos de Shop aqui
					cleaner.setDni(resultSet.getString("dni"));
					cleaner.setNameWo(resultSet.getString("nameEm"));
					cleaner.setSurnameWo(resultSet.getString("surnameEm"));
					cleaner.setPhoneWo(resultSet.getString("phoneEm"));

					User user = new User();
					user.setIdUser(resultSet.getInt("idUser"));
					user.setAdmin(resultSet.getBoolean("isAdmin"));
					user.setUsername(resultSet.getString("username"));
					user.setPasswd(resultSet.getString("passwd"));
					user.setIsBlocked(resultSet.getBoolean("isBlock"));

					cleaner.setUser(user);

					Enclosure enclosure = new Enclosure();
					enclosure.setIdEnclosure(resultSet.getInt("idEnclosure"));
					enclosure.setTypeEn(resultSet.getString("typeEn"));

					cleaner.setEnclosure(enclosure);

					ret.add(cleaner);
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

	public Cleaner selectCleanerByDni(String dni) {
		Cleaner ret = null;

		String sql = "SELECT dni, nameEm, surnameEm, phoneEm, e.idUser, isAdmin, username, passwd, isBlock, en.idEnclosure, en.typeEn\r\n "
				+ "FROM Employee AS e \r\n " + "JOIN User AS u ON e.idUser = u.idUser\r\n "
				+ "JOIN Cleaner AS c ON e.idEmployee = c.idEmployee\r\n "
				+ "JOIN Enclosure AS en ON en.idEnclosure = c.idEnclosure " + "WHERE dni = '" + dni + "'";

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);

			if (resultSet.next() == false) {
				throw new NotFoundException("No hay resultados para Limpiadores");
			} else {
				do {
					if (null == ret) {
						ret = new Cleaner();
					}
					// añadir datos de Shop aqui
					ret.setDni(resultSet.getString("dni"));
					ret.setNameWo(resultSet.getString("nameEm"));
					ret.setSurnameWo(resultSet.getString("surnameEm"));
					ret.setPhoneWo(resultSet.getString("phoneEm"));

					User user = new User();
					user.setIdUser(resultSet.getInt("idUser"));
					user.setAdmin(resultSet.getBoolean("isAdmin"));
					user.setUsername(resultSet.getString("username"));
					user.setPasswd(resultSet.getString("passwd"));

					ret.setUser(user);

					Enclosure enclosure = new Enclosure();
					enclosure.setIdEnclosure(resultSet.getInt("idEnclosure"));
					enclosure.setTypeEn(resultSet.getString("typeEn"));

					ret.setEnclosure(enclosure);
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
	public void insert(Cleaner t) throws SQLException, Exception {
		Connection connection = null;
		Statement statement = null;
		try {
			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			statement = connection.createStatement();

			String sql = "INSERT INTO Cleaner (idEmployee, idEnclosure) " + "VALUES (" + t.getIdEmployee() + ", "
					+ t.getEnclosure().getIdEnclosure() + ");";
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
	public void update(Cleaner t) throws SQLException, Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Cleaner t) throws SQLException, Exception {
		// TODO Auto-generated method stub

	}

}

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
import PokeZoo.bbdd.pojo.Enclosure;
import PokeZoo.bbdd.utils.DBUtils;

public class ManagerEnclosure implements ManagerInterface<Enclosure> {

	@Override
	public ArrayList<Enclosure> selectAll() throws SQLException, AccountNotFoundException, Exception {
		ArrayList<Enclosure> ret = null;

		String sql = "select * from Enclosure";

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);

			if (resultSet.next() == false) {
				throw new NotFoundException("No hay resultados para Recintos");
			} else {
				do {
					if (null == ret) {
						ret = new ArrayList<Enclosure>();
					}

					Enclosure enclo = new Enclosure();

					// añadir datos del Pokemon aqui
					enclo.setIdEnclosure(resultSet.getInt("idEnclosure"));
					enclo.setTypeEn(resultSet.getString("typeEn"));
					enclo.setNumberEn(resultSet.getInt("numberEn"));

					ret.add(enclo);
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
	 * returns a Enclosure object that matches the id param, if none match return null
	 * @param id to be selected
	 * @return Enclosure object with all data from data base
	 */
	public Enclosure selectEnclosureById(int id) {
		Enclosure ret = null;
		String sql = "SELECT * FROM Enclosure WHERE idEnclosure = " + id;

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);

			if (resultSet.next() == false) {
				throw new NotFoundException("No hay resultados para Recintos");
			} else {
				do {
					if (null == ret) {
						ret = new Enclosure();
					}
					// añadir datos del Pokemon aqui
					ret.setIdEnclosure(resultSet.getInt("idEnclosure"));
					ret.setTypeEn(resultSet.getString("typeEn"));
					ret.setNumberEn(resultSet.getInt("numberEn"));
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
	 * Selects a enclosure from data base with para typeEn
	 * @param to be selected
	 * @return Enclosure object with all data from data base
	 */
	public Enclosure selectEnclosureByTypeEn(String typeEn) {
		Enclosure ret = null;
		String sql = "SELECT * FROM Enclosure WHERE typeEn = '" + typeEn + "'";

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
					ret = new Enclosure();
				}
				// añadir datos del Pokemon aqui
				ret.setIdEnclosure(resultSet.getInt("idEnclosure"));
				ret.setTypeEn(resultSet.getString("typeEn"));
				ret.setNumberEn(resultSet.getInt("numberEn"));
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
	 * Selects a enclosure from data base with para numberEn
	 * @param number to be selected
	 * @return Enclosure object with all data from data base
	 */
	public Enclosure selectEnclosureByNumber(int number) {
		Enclosure ret = null;
		String sql = "SELECT * FROM Enclosure WHERE numberEn = '" + number + "'";

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
					ret = new Enclosure();
				}
				// añadir datos del Pokemon aqui
				ret.setIdEnclosure(resultSet.getInt("idEnclosure"));
				ret.setTypeEn(resultSet.getString("typeEn"));
				ret.setNumberEn(resultSet.getInt("numberEn"));
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
	 * Method that checks if the Enclosure that is going to be inserted has duplicated data
	 * @param enclosureToInsert to be selected
	 * @return true if a Enclosure exists with the same TypeEn, false if not
	 */
	public boolean checkEnclosureTypeExists(Enclosure enclosureToInsert) {
		boolean ret = false;

		String sql = "SELECT * FROM Enclosure WHERE typeEn = '" + enclosureToInsert.getTypeEn() + "'";

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
	 * Method that checks if the Enclosure that is going to be inserted has duplicated data
	 * @param enclosureToInsert to be selected
	 * @return true if a Enclosure exists with the same numberEn, false if not
	 */
	public boolean checkEnclosureNumberExists(Enclosure enclosureToInsert) {
		boolean ret = false;

		String sql = "SELECT * FROM Enclosure WHERE numberEn = '" + enclosureToInsert.getNumberEn() + "'";

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

	@Override
	public void insert(Enclosure t) throws SQLException, Exception {
		Connection connection = null;
		Statement statement = null;
		String sql = "";

		try {
			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			statement = connection.createStatement();
			if (t.getIdEnclosure() == 0) {
				sql = "INSERT INTO Enclosure (typeEn, numberEn)" + "VALUES ('" + t.getTypeEn() + "', '"
						+ t.getNumberEn() + "');";
			} else {
				sql = "INSERT INTO Enclosure (idEnclosure, typeEn, numberEn)" + "VALUES ('" + t.getIdEnclosure()
						+ "', '" + t.getTypeEn() + "', '" + t.getNumberEn() + "');";
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
	public void update(Enclosure t) throws SQLException, Exception {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			Class.forName(DBUtils.DRIVER);
			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			String sql = "UPDATE Enclosure SET typeEn = ?, numberEn = ? WHERE idEnclosure = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, t.getTypeEn());
			preparedStatement.setInt(2, t.getNumberEn());
			preparedStatement.setInt(3, t.getIdEnclosure());

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
			}
			;
		}
	}

	@Override
	public void delete(Enclosure t) throws SQLException, Exception {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			String sql = "DELETE FROM Enclosure WHERE idEnclosure = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, t.getIdEnclosure());

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
			}
			;
		}
	}	

}

package PokeZoo.bbdd.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.security.auth.login.AccountNotFoundException;

import PokeZoo.bbdd.pojo.Pokemon;
import PokeZoo.bbdd.utils.DBUtils;

public class ManagerPokemon implements ManagerInterface<Pokemon> {

	@Override
	public ArrayList<Pokemon> selectAll() throws SQLException, AccountNotFoundException, Exception {
		ArrayList<Pokemon> ret = null;

		String sql = "select * from Pokemon";

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
					ret = new ArrayList<Pokemon>();
				}
				Pokemon poke = new Pokemon();

				// añadir datos del Pokemon aqui
				poke.setIdPokemon(resultSet.getInt("idPokemon"));
				poke.setFood(null);
				poke.setNamePo(resultSet.getString("namePo"));
				poke.setTypeP(resultSet.getString("typeP"));
				poke.setTypeS(resultSet.getString("typeS"));
				poke.setDescriptionPo(resultSet.getString("descriptionPo"));
				poke.setNumPokedex(resultSet.getInt("numPokedex"));
				poke.setPhotoPo(resultSet.getBlob("photoPo"));

				ret.add(poke);
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

	public Pokemon getPokemonById(int id) {
		Pokemon ret = null;
		String sql = "select * from Pokemon WHERE idPokemon = " + id;

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
					ret = new Pokemon();
				}
				// añadir datos del Pokemon aqui
				ret.setIdPokemon(resultSet.getInt("idPokemon"));
				ret.setNamePo(resultSet.getString("namePo"));
				ret.setTypeP(resultSet.getString("typeP"));
				ret.setTypeS(resultSet.getString("typeS"));
				ret.setDescriptionPo(resultSet.getString("descriptionPo"));
				ret.setNumPokedex(resultSet.getInt("numPokedex"));
				ret.setPhotoPo(resultSet.getBlob("photoPo"));
				ret.setFood(null);
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

	public Pokemon getPokemonByNumPokedex(int numPokedex) {
		Pokemon ret = null;
		String sql = "select * from Pokemon WHERE numPokedex = " + numPokedex;

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
					ret = new Pokemon();
				}
				// añadir datos del Pokemon aqui
				ret.setIdPokemon(resultSet.getInt("idPokemon"));
				ret.setNamePo(resultSet.getString("namePo"));
				ret.setEggGroup(resultSet.getString("alias"));
				ret.setTypeP(resultSet.getString("typeP"));
				ret.setTypeS(resultSet.getString("typeS"));
				ret.setDescriptionPo(resultSet.getString("descriptionPo"));
				ret.setNumPokedex(resultSet.getInt("numPokedex"));
				ret.setPhotoPo(resultSet.getBlob("photoPo"));
				ret.setFood(null);
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

	public Pokemon getPokemonByName(String namePo) {
		Pokemon ret = null;
		String sql = "select * from Pokemon WHERE namePo = '" + namePo + "'";

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
					ret = new Pokemon();
				}
				// añadir datos del Pokemon aqui
				ret.setIdPokemon(resultSet.getInt("idPokemon"));
				ret.setNamePo(resultSet.getString("namePo"));
				ret.setEggGroup(resultSet.getString("alias"));
				ret.setTypeP(resultSet.getString("typeP"));
				ret.setTypeS(resultSet.getString("typeS"));
				ret.setDescriptionPo(resultSet.getString("descriptionPo"));
				ret.setNumPokedex(resultSet.getInt("numPokedex"));
				ret.setPhotoPo(resultSet.getBlob("photoPo"));
				ret.setFood(null);
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
	public void insert(Pokemon t) throws SQLException, Exception {
		Connection connection = null;
		Statement statement = null;

		String sql = "";

		try {
			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			statement = connection.createStatement();
			if (t.getIdPokemon() == 0) {
				sql = "INSERT INTO Pokemon (codFood, namePo, typeP, typeS, descriptionPo, numPokedex, photoPo) "
						+ "VALUES ('" + t.getFood().getIdFood() + "', '" + t.getNamePo() + "', '" + t.getTypeP() + "'"
						+ ", '" + t.getTypeS() + "', '" + t.getDescriptionPo() + "', '" + t.getNumPokedex()
						+ "', NULL);";
			} else {
				sql = "INSERT INTO Pokemon (idPokemon, codFood, namePo, typeP, typeS, descriptionPo, numPokedex, photoPo) "
						+ "VALUES ('" + t.getIdPokemon() + "', '" + t.getFood().getIdFood() + "', '" + t.getNamePo()
						+ "', '" + t.getTypeP() + "'" + ", '" + t.getTypeS() + "', '" + t.getDescriptionPo() + "', '"
						+ t.getNumPokedex() + "', NULL);";
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
	public void update(Pokemon t) throws SQLException, Exception {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			Class.forName(DBUtils.DRIVER);
			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			String sql = "UPDATE Pokemon SET codFood = ?, namePo = ?, typeP = ?, typeS = ?, descriptionPo = ?, numPokedex = ? WHERE idPokemon = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, t.getFood().getIdFood());
			preparedStatement.setString(2, t.getNamePo());
			preparedStatement.setString(3, t.getTypeP());
			preparedStatement.setString(4, t.getTypeS());
			preparedStatement.setString(5, t.getDescriptionPo());
			preparedStatement.setInt(6, t.getNumPokedex());
			preparedStatement.setInt(7, t.getIdPokemon());

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
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				// Nothing
			}
		}
	}

	@Override
	public void delete(Pokemon t) throws SQLException, Exception {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			String sql = "DELETE FROM Pokemon WHERE idPokemon = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, t.getIdPokemon());

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
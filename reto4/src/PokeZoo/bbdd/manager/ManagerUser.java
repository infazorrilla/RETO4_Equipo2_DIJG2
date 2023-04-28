package PokeZoo.bbdd.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.security.auth.login.AccountNotFoundException;

import PokeZoo.bbdd.pojo.User;
import PokeZoo.bbdd.utils.DBUtils;

public class ManagerUser implements ManagerInterface<User>{

	@Override
	public ArrayList<User> selectAll() throws SQLException, AccountNotFoundException, Exception {
		ArrayList<User> ret = null;

		String sql = "SELECT * FROM User";

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
					ret = new ArrayList<User>();
				}

				User user = new User();

				// añadir datos de Shop aqui
				user.setIdUser(resultSet.getInt("idUser"));
				user.setAdmin(resultSet.getBoolean("isAdmin"));
				user.setUsername(resultSet.getString("username"));
				user.setPasswd(resultSet.getString("passwd"));
				
				ret.add(user);
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

	public User selectUserById(int id) {
		User ret = null;

		String sql = "SELECT * FROM User WHERE idUser = " + id;

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
					ret = new User();
				}
				// añadir datos de Shop aqui
				ret.setIdUser(resultSet.getInt("idUser"));
				ret.setAdmin(resultSet.getBoolean("isAdmin"));
				ret.setUsername(resultSet.getString("username"));
				ret.setPasswd(resultSet.getString("passwd"));
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
	
	public User selectUserByUsernameAndPasswd(String username, String passwd) {
		User ret = null;

		String sql = "SELECT * FROM User WHERE username = '" + username + "' AND passwd = '" + passwd + "'";

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
					ret = new User();
				}
				// añadir datos de Shop aqui
				ret.setIdUser(resultSet.getInt("idUser"));
				ret.setAdmin(resultSet.getBoolean("isAdmin"));
				ret.setUsername(resultSet.getString("username"));
				ret.setPasswd(resultSet.getString("passwd"));
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
	public void insert(User t) throws SQLException, Exception {
		Connection connection = null;
		Statement statement = null;
		
		String sql = "";
		
		try {
			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			statement = connection.createStatement();
			if(t.getIdUser() == 0) {
				sql = "INSERT INTO User (username, passwd) "
						+ "VALUES ('" + t.getUsername() + "', '" + t.getPasswd() + "');";
			}else {
				sql = "INSERT INTO User (idUser, isAdmin, username, passwd) "
						+ "VALUES ('" + t.getIdUser() + "', '" + t.isAdmin() + "', '" + t.getUsername() + ", '" + t.getPasswd() + "');";
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
	public void update(User t) throws SQLException, Exception {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			Class.forName(DBUtils.DRIVER);
			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			String sql = "UPDATE User SET username = ?, passwd = ?, isBlock  = ? WHERE idUser = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, t.getUsername());
			preparedStatement.setString(2, t.getPasswd());
			preparedStatement.setBoolean(3, t.getIsBlocked());
			preparedStatement.setInt(4, t.getIdUser());

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
	public void delete(User t) throws SQLException, Exception {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			String sql = "DELETE FROM User WHERE idUser = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, t.getIdUser());

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
	
	/**
	 * 
	 * @param userName String to be check in database
	 * @param passwd String to be check in database
	 * @return 0 if user Not Found, 1 if user Found and is not admin, 2 if user exists and is admin, 3 if user exists and is Blocked
	 */
	public int checkUserExists(String userName, String passwd) {
		int ret = 0;
		
		String sql = "SELECT * FROM User WHERE username = '" + userName + "' AND passwd = '" + passwd + "'";

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);

			if (resultSet.next()) {
				if(resultSet.getInt("isBlock") == 1) {
					ret = 3;
				}else if(resultSet.getInt("isAdmin") == 1) {
					ret = 2;
				}else {
					ret = 1;
				}
			}
		} catch (SQLException sqle) {
			System.out.println("Error con la BBDD - " + sqle.getMessage());
			sqle.printStackTrace();
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

}

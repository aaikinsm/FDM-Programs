package com.fdmgroup;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JdbcApp {

	private static final String DATABASE_PASSWORD = "!QAZSE4";
	private static final String DATABASE_USERNAME = "trainee1";
	private static final String DATABASE_URL = "jdbc:oracle:thin:@localhost:1521:xe";

	public static void main(String[] args) {
		//testStatement();
		//testResultSet();
		//testpreparedStatement();
		//testpreparedStatement2();	
		//testPreparedStatementBatch();
		//testCallableStatement();
		testCallableStatement2();
	}
	
	private static void testCallableStatement2() {
		Connection connection = null;
		CallableStatement callableStatement = null;
		ResultSet resultSet = null;
		
		try {
			String sql = ("CALL findByPassword(?, ?)");
			//connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
			connection = com.fdmgroup.DataSource.getInstance().getConnection();
			callableStatement = connection.prepareCall(sql);
			callableStatement.setString(1, "%1234%");
			callableStatement.registerOutParameter(2, oracle.jdbc.OracleTypes.CURSOR);
			
			callableStatement.execute();
			resultSet = (ResultSet) callableStatement.getObject(2);
			
			while (resultSet.next()){
				int id = resultSet.getInt("user_id"); //resultSet.getInt(1);
				String username = resultSet.getString(2);
				String password = resultSet.getString(3);
				String firstname = resultSet.getString("firstname");
				String lastname = resultSet.getString(5);
				
				System.out.println(id + ") "+firstname+" "+lastname+" -->  "+username+", "+password );
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(resultSet);
			close(callableStatement);
			close(connection);
		}
	}

	private static void testCallableStatement() {
		Connection connection = null;
		CallableStatement callableStatement = null;
		
		try {
			String sql = ("CALL getUsername(?, ?)");
			connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
			callableStatement = connection.prepareCall(sql);
			callableStatement.setInt(1, 9);
			callableStatement.registerOutParameter(2, oracle.jdbc.OracleTypes.CURSOR);
			
			callableStatement.execute();
			

			System.out.println(callableStatement.getString(2));
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(callableStatement);
			close(connection);
		}
	}

	private static void testPreparedStatementBatch() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			String sql = ("INSERT INTO TBL_USER(user_id, username, pw, firstname, lastname) VALUES(?, ?, ?, ?, ?)");
			connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
			preparedStatement = connection.prepareStatement(sql);

			connection.setAutoCommit(false);
			
			preparedStatement.setInt(1, 7);
			preparedStatement.setString(2, "jleung");
			preparedStatement.setString(3, "32455345");
			preparedStatement.setString(4, "Jennifer");
			preparedStatement.setString(5, "Leung");
			preparedStatement.addBatch();
			
			preparedStatement.setInt(1, 8);
			preparedStatement.setString(2, "blee");
			preparedStatement.setString(3, "234567345");
			preparedStatement.setString(4, "Barady");
			preparedStatement.setString(5, "Lee");
			preparedStatement.addBatch();
			
			preparedStatement.setInt(1, 9);
			preparedStatement.setString(2, "thussain");
			preparedStatement.setString(3, "456553443");
			preparedStatement.setString(4, "Taha");
			preparedStatement.setString(5, "Hussain");
			preparedStatement.addBatch();
			
			preparedStatement.executeBatch();
			
			connection.commit();
			
			System.out.println("Users Added");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(preparedStatement);
			close(connection);
		}
		
	}

	private static void testpreparedStatement2() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			String sql = ("INSERT INTO TBL_USER(user_id, username, pw, firstname, lastname) VALUES(?, ?, ?, ?, ?)");
			connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, "%123%");

			resultSet = preparedStatement.executeQuery();
			

			while (resultSet.next()){
				System.out.println(resultSet.getInt(1)+") "+resultSet.getString(2)+"  "+resultSet.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(resultSet);
			close(preparedStatement);
			close(connection);
		}
	}

	private static void testpreparedStatement() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			String sql = ("SELECT user_id, firstname, lastname FROM TBL_USER where pw LIKE ?");
			connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, 6);
			preparedStatement.setString(2, "mmingi");
			preparedStatement.setString(3, "32455");
			preparedStatement.setString(4, "Michelle");
			preparedStatement.setString(5, "Mingi");
			int rVal = preparedStatement.executeUpdate();
			System.out.println(rVal+" rows affected");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(preparedStatement);
			close(connection);
		}
	}

	private static void testResultSet() {
		
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		try {
			connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);	
			statement.executeQuery("SELECT user_id, username, pw, firstname, lastname FROM TBL_USER");
			resultSet = statement.getResultSet();
			
			while (resultSet.next()){
				int id = resultSet.getInt("user_id"); //resultSet.getInt(1);
				String username = resultSet.getString(2);
				String password = resultSet.getString(3);
				String firstname = resultSet.getString("firstname");
				String lastname = resultSet.getString(5);
				
				resultSet.updateString("pw", "123456");
				resultSet.updateRow();
				
				System.out.println(id + ") "+firstname+" "+lastname+" -->  "+username+", "+password );
			}
			
			System.out.println("______________________________________");
			DatabaseMetaData md = connection.getMetaData();
			System.out.println(md.getDriverMajorVersion());
			System.out.println(md.getDriverName());
			System.out.println(md.getSQLKeywords());
			System.out.println(md.getTimeDateFunctions());

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(statement);
			close(connection);
		}
	}

	private static void testStatement() {
		Connection connection = null;
		Statement statement = null;
		try {
			connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
			statement = connection.createStatement();
			/*statement.execute(
					"CREATE TABLE TBL_USER(user_id NUMBER(6) PRIMARY KEY, username VARCHAR2(50), pw VARCHAR2(50), firstname VARCHAR2(50), lastname VARCHAR2(50))");
			statement.executeUpdate("INSERT INTO TBL_USER(user_id, username, pw, firstname, lastname) VALUES(1, 'jDoe', 1233, 'John', 'Doe')");
			statement.executeUpdate("INSERT INTO TBL_USER(user_id, username, pw, firstname, lastname) VALUES(2, 'seth', 4357, 'Sethelina', 'Adusei')");
			statement.executeUpdate("INSERT INTO TBL_USER(user_id, username, pw, firstname, lastname) VALUES(3, 'aam', 1643, 'Albert', 'Aikins')");
			statement.executeUpdate("INSERT INTO TBL_USER(user_id, username, pw, firstname, lastname) VALUES(5, 'menLuc', 2474, 'Lucas', 'Men')");
			statement.executeUpdate("INSERT INTO TBL_USER(user_id, username, pw, firstname, lastname) VALUES(5, 'menLuc', 2474, 'Lucas', 'Men')");
*/			
			statement.executeUpdate("UPDATE TBL_USER SET pw = '6393' WHERE user_id = 3");
			System.out.println("update complete");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(statement);
			close(connection);
		}

	}

	private static void close(AutoCloseable closeable) {
		try {
			if (closeable != null) {
				closeable.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

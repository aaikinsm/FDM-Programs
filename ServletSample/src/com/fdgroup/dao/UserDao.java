package com.fdgroup.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

	private DataAccessObject dao;
	
	public boolean checkUsernameAndPassword(String username, String password){
		dao = DataAccessObject.getInstance();
		Connection connection = dao.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		try{
			preparedStatement = connection.prepareStatement("SELECT * FROM TBL_USER where username = ? AND pw = ?");
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			rs = preparedStatement.executeQuery();
			if (rs.next()){
				return true;
			}
		}catch (SQLException e){
			e.printStackTrace();
		}
		finally{
			try {
				rs.close();
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
}

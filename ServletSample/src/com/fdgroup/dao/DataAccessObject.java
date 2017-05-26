package com.fdgroup.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DataAccessObject {

	private static DataAccessObject dao = null;
	
	
	
	private DataAccessObject(){
		init();
	}

	private void init() {
		
	}
	
	public static DataAccessObject getInstance(){
		if(dao==null)
			dao = new DataAccessObject();
		return dao;
	}
	
	public Connection getConnection(){
		InitialContext ic =null;
		Connection con = null;
		try{
			ic = new InitialContext();
			DataSource ds = (DataSource) ic.lookup("java:comp/env/jdbc/testdatasource");
			con = ds.getConnection();
			return con;
		}catch(NamingException e){
			e.printStackTrace();
		}catch (SQLException e){
			e.printStackTrace();
		}
		finally{
			try{
				ic.close();
			}catch(NamingException e ){
				e.printStackTrace();
			}
		}
		return con;
	}
}

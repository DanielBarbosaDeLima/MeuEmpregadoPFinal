package com.meuempregado.dao;

import java.sql.Connection;
import java.sql.SQLException;

public class Dao {
	private ConnectEmpregado db = new ConnectEmpregado();
	protected Connection connect;
	
	public void openConnection() throws ClassNotFoundException, SQLException{
		connect = db.getConnection();
	}
	
	public void closeConnection() {
		if(connect != null) {
			try {
				connect.close();
			} catch(SQLException e) {
				System.out.println("Error on Closing Connection");
			}
		}
	}
}

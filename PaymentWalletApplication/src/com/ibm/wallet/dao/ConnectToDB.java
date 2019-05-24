package com.ibm.wallet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectToDB {
    Connection dbCon;
	public Connection connectToDb() {
		boolean success = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			dbCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/paymentwalletdb", "root", "");
			// check whether successful
			if (this.dbCon != null) {
				success = true;
			} 
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Some issues found: " + e);
		}
		return dbCon;
	}

}

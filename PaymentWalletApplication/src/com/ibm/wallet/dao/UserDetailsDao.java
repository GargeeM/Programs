package com.ibm.wallet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

import com.ibm.wallet.bean.Transaction;

public class UserDetailsDao implements UserDetailsDaoInterface {
    Connection dbCon = new ConnectToDB().connectToDb();
    Random random = new Random();
    PreparedStatement prepStmt;
	@Override
	public Integer createUser(String userName, String password, String mail, String contactNo, Double balance) {
		String accNo = Integer.toString(random.nextInt(99999999));
		String insertQry = "insert into user(accNo, userName, password, mail, contactNo, balance) values(?, ?, ?, ?, ?, ?)";
		//boolean success = false;
		Integer UID = 0;
		try {
			this.prepStmt = this.dbCon.prepareStatement(insertQry);
			this.prepStmt.setString(1, accNo);
			this.prepStmt.setString(2, userName);
			this.prepStmt.setString(3, password);
			this.prepStmt.setString(4, mail);
			this.prepStmt.setString(5, contactNo);
			this.prepStmt.setDouble(6, balance);
			
			if(this.prepStmt.executeUpdate() > 0) {
				String uidQuery = "select user.UID from user where username = ?";
				this.prepStmt = this.dbCon.prepareStatement(uidQuery);
				this.prepStmt.setString(1, userName);
				ResultSet rs = prepStmt.executeQuery();
				while(rs.next())
					UID = rs.getInt("UID");
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		return UID;
	}

	@Override
	public boolean createTransaction(Integer UID, String transactionType, Double amount) {
		String transactDetailsQuery = "Select user.accNo, user.userName from user where user.UID = ?";
		
		String insertQry = "insert into transaction(UID, accNo, accHolderName, transactionType, amount) values(?, ?, ?, ?, ?)";
		boolean success = false;
		String accNo = "", accHolderName = "";
		try {
			//fetching details from user table
			this.prepStmt = this.dbCon.prepareStatement(transactDetailsQuery);
			this.prepStmt.setInt(1, UID);
			ResultSet rs = this.prepStmt.executeQuery();
			while(rs.next()) {
				accNo = rs.getString("accNo");
				accHolderName = rs.getString("userName");
			}
			
			//inserting into transaction table
			this.prepStmt = this.dbCon.prepareStatement(insertQry);
			this.prepStmt.setInt(1, UID);
			this.prepStmt.setString(2, accNo);
			this.prepStmt.setString(3, accHolderName);
			this.prepStmt.setString(4, transactionType);
			this.prepStmt.setDouble(5, amount);
			
			if(this.prepStmt.executeUpdate() > 0)
				success = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return success;
	}
	
    @Override
	public boolean login(Integer UID, String checkPassword) {
		String loginQuery = "select * from user where user.UID = ? and user.password = ?";
		boolean loginSuccess = false;
		try {
			this.prepStmt = this.dbCon.prepareStatement(loginQuery);
			this.prepStmt.setInt(1, UID);
			this.prepStmt.setString(2, checkPassword);
			ResultSet rs = this.prepStmt.executeQuery();
			loginSuccess = rs.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		return loginSuccess;
	}

    @Override
	public Double checkBalance(Integer UID) {
		Double balance = 0.0;
		String checkBalQry = "select balance from user where user.UID = ?";
		try {
			this.prepStmt = this.dbCon.prepareStatement(checkBalQry);
			this.prepStmt.setInt(1, UID);
			ResultSet rs = this.prepStmt.executeQuery();
			while(rs.next())
				balance = rs.getDouble("balance");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		return balance;
	}

	@Override
	public boolean updateBalance(Integer UID, Double depMoney) {
		boolean success = false;
		String updateBalQry = "update user set balance = ? where user.UID = ?";
		try {
			this.prepStmt = this.dbCon.prepareStatement(updateBalQry);
			this.prepStmt.setDouble(1, depMoney);
			this.prepStmt.setInt(2, UID);
			
			if(this.prepStmt.executeUpdate() > 0) {
				success = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
		return success;
	}

	@Override
	public boolean checkUID(Integer transferUID) {
		boolean success = false;
		String checkIDQuery = "select * from user where user.UID = ?";
		try {
			this.prepStmt = this.dbCon.prepareStatement(checkIDQuery);
			this.prepStmt.setInt(1, transferUID);
			
			ResultSet rs = this.prepStmt.executeQuery();
			success =rs.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		return success;
	}

	@Override
	public ArrayList<Transaction> getTransactionRecord(Integer UID) {
		ArrayList<Transaction> transactionList = new ArrayList<>();
		String transactionRecQry = "Select * from transaction where transaction.UID = ?";
		try {
			this.prepStmt = this.dbCon.prepareStatement(transactionRecQry);
			this.prepStmt.setInt(1, UID);
			ResultSet rs = this.prepStmt.executeQuery();
			while(rs.next()) {
	           Transaction t = new Transaction(rs.getInt("UID"), rs.getInt("transactionID"), rs.getString("timestamp"), 
	        		   rs.getString("accNo"), rs.getString("accHolderName"), rs.getString("transactionType"), rs.getDouble("amount"));
	           transactionList.add(t);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		return transactionList;
	}

	@Override
	public String getUserName(Integer targetUID) {
		String name = "";
		String getNameQry = "select userName from user where user.UID = ?";
		try {
			this.prepStmt = this.dbCon.prepareStatement(getNameQry);
			this.prepStmt.setInt(1, targetUID);
			ResultSet rs = this.prepStmt.executeQuery();
			while(rs.next())
                name = rs.getString("userName");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return name;
	}

}

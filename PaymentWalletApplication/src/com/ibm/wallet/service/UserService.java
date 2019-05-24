package com.ibm.wallet.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.ibm.wallet.bean.Transaction;
import com.ibm.wallet.dao.ConnectToDB;
import com.ibm.wallet.dao.UserDetailsDao;
import com.ibm.wallet.dao.UserDetailsDaoInterface;


public class UserService implements UserServiceInterface {
    UserDetailsDaoInterface dao = new UserDetailsDao();
    ConnectToDB con = new ConnectToDB();
    
    @Override
    public boolean validateName(String userName) {
		if(userName.matches(namePattern))
			return true;
		else
			return false;
	}
    
    @Override
    public boolean validateChoice(String choice) {
    	
		if(choice.matches(switchPattern))
			return true;
		else
			return false;
	}
    
	@Override
	public Integer createUserAccount(String userName, String password, String mail, String contactNo, Double balance) 
	{
		Integer success = dao.createUser(userName, password, mail, contactNo, balance);
		return success;
	}

	@Override
	public boolean connectToDB() {
		Connection conn = con.connectToDb();
		return true;
	}

	@Override
	public boolean login(Integer UID, String checkPassword) {
		boolean loginSuccess = dao.login(UID, checkPassword);
		return loginSuccess;
	}

	@Override
	public Double checkBalance(Integer UID) {
		Double balance = dao.checkBalance(UID);
		return balance;
	}

	@Override
	public boolean depositMoney(Integer UID, Double depMoney, Integer targetUID) {
		boolean success = false;
		String transactionType = "";
		if(dao.checkBalance(UID) > 0.0) {
			Double finalBalance = dao.checkBalance(UID) + depMoney;
			success = dao.updateBalance(UID, finalBalance);
			String name = dao.getUserName(UID);
			String targetName = dao.getUserName(targetUID);
			
			if(name.equalsIgnoreCase(targetName))
				  transactionType = "Deposited by Self";
			else
				  transactionType = "Deposited by " + targetName;

			dao.createTransaction(UID, transactionType, depMoney);
		 }
		else
		    success = dao.updateBalance(UID, depMoney);
		return success;
	}

	@Override
	public boolean withdrawMoney(Integer UID, Double wdrawMoney, Integer targetUID) {
		Double finalBalance = dao.checkBalance(UID) - wdrawMoney; 
		boolean success = false;
		String transferType = "";
		if(finalBalance >= 0.0) {
			if(dao.updateBalance(UID, finalBalance));{
			  success = true;
			  String name = dao.getUserName(UID);
			  String targetName = dao.getUserName(targetUID);
			  if(name.equalsIgnoreCase(targetName))
				  transferType = "Withdrawl by Self";
			  else
				  transferType = "Transferred to " + targetName;
			dao.createTransaction(UID, transferType, wdrawMoney);
			}
		}
		return success;
	}

	@Override
	public boolean checkUID(Integer transferUID) {
		boolean success = dao.checkUID(transferUID);
		return success;
	}

	@Override
	public ArrayList<Transaction> getTransactionRecord(Integer UID) {
		ArrayList<Transaction> transactionList = new ArrayList<>();
		transactionList = dao.getTransactionRecord(UID);
		//System.out.println("From service layer:" + transactionList);
		return transactionList;
	}
}

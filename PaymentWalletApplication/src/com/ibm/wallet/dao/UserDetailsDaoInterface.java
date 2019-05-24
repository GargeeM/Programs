package com.ibm.wallet.dao;

import java.util.ArrayList;

import com.ibm.wallet.bean.Transaction;

public interface UserDetailsDaoInterface {
	 Integer createUser(String userName, String password, String mail, String contactNo, Double balance);
     boolean createTransaction(Integer UID, String transactionType, Double amount);
     public boolean login(Integer UID, String checkPassword);
	 Double checkBalance(Integer UID);
	 boolean updateBalance(Integer uID, Double depMoney);
	 boolean checkUID(Integer transferUID);
	 ArrayList<Transaction> getTransactionRecord(Integer uID);
	 String getUserName(Integer targetUID);
     
}

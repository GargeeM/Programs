package com.ibm.wallet.service;

import java.util.ArrayList;

import com.ibm.wallet.bean.Transaction;

public interface UserServiceInterface {
   boolean connectToDB();
   String namePattern = "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$";
   String switchPattern = "\\d+";
   boolean validateChoice(String choice);
   boolean validateName(String userName);
   Integer createUserAccount(String userName, String password, String mail, String contactNo, Double balance);
   boolean login(Integer UID, String checkPassword);
   Double checkBalance(Integer UID);
   boolean depositMoney(Integer UID, Double depMoney, Integer targetUID);
   boolean withdrawMoney(Integer UID, Double wdrawMoney, Integer targetUID);
   boolean checkUID(Integer transferUID);
   ArrayList<Transaction> getTransactionRecord(Integer uID);
   
}

package com.ibm.wallet.ui;

import java.util.ArrayList;
import java.util.Scanner;

import com.ibm.wallet.bean.Transaction;
import com.ibm.wallet.service.UserService;
import com.ibm.wallet.service.UserServiceInterface;

public class PaymentWalletDriver {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean loginSuccess = false;
		String userName ="";
		Integer ch = 0, UID = 0;
		UserServiceInterface service = new UserService();
		if (service.connectToDB()) {
			while(true) {
			System.out.println("Welcome to PayEasy Wallet! \nPress 1 to Create Account \t Press 2 to Login");
			String strch = sc.nextLine();
			if(service.validateChoice(strch)) {
			   ch = Integer.parseInt(strch);
			   if(ch == 1 || ch == 2) 
				  break;
			   else
				  System.out.println("Wrong choice! Try Again\n");
			}
			else
				System.out.println("Please enter numbers only!");
			}
			switch (ch) {
			case 1: // attempt to create account
				while (true) {
					while(true) {
					   System.out.print("Enter Name: ");
					   userName = sc.nextLine();
					   if(service.validateName(userName))
						   break;
					   else
						   System.out.println("Name cannot contain anything other than alphabets! Try Again");
					}
					System.out.print("Enter Password: ");
					String password = sc.nextLine();
					System.out.print("Enter Mail: ");
					String mail = sc.nextLine();
					System.out.print("Enter Contact No.: ");
					String contactNo = sc.nextLine();
					System.out.println("Enter opening balance (Min. balance: 5,000): ");
					Double balance = sc.nextDouble();
					sc.nextLine();
				    UID = service.createUserAccount(userName, password, mail, contactNo, balance);
					if (UID > 0) {
						System.out.println("Account has been created! Your User ID is: " + UID + "\n");
						loginSuccess = true;
						break;
					} else {
						System.out.println("Account creation failed! Try Again\n");
					}
				}
				break;

			case 2: // attempt to login
				while (true) {
					System.out.print("Enter UID: ");
					UID = sc.nextInt();
					sc.nextLine();
					System.out.print("Enter Password: ");
					String checkPassword = sc.nextLine();
					loginSuccess = service.login(UID, checkPassword);
					if (loginSuccess) {
						System.out.println("\nLogin Successful!\n");
						break;
					} else
						System.out.println("\nIncorrect UID or Password! Try Again\n");
				}
				break;

			default:System.out.println("Wrong choice! Try Again\n");
			
			}
			//if Login is successful
			ArrayList<Transaction> transactionList = new ArrayList<>();
			if(loginSuccess) {
				while(true) {
					while(true) {
				System.out.println("Press 1 to Check Balance \nPress 2 to Deposit Money \nPress 3 to Withdraw money "
						+ "\nPress 4 to Transfer Funds \nPress 5 to Print Transactions \nPress 6 to Logout");
				
				String strch = sc.nextLine();
				if(service.validateChoice(strch)) {
				   ch = Integer.parseInt(strch);
				   if(ch ==1 || ch == 2 || ch == 3 || ch == 4 || ch == 5 || ch == 6) 
					  break;
				   else
					  System.out.println("Wrong choice! Try Again\n");
				}
				else
					System.out.println("Please enter numbers only!");
			    }
				
				switch(ch) {
				case 1: System.out.println("Current balance in account: " + service.checkBalance(UID) + "\n");
				        break;
				      
				case 2: while(true) {
					    System.out.print("Enter the amount of money you want to deposit: ");
				        Double depMoney = sc.nextDouble();
				        sc.nextLine();
				        boolean success = service.depositMoney(UID, depMoney, UID);
				        if(success) {
				        	System.out.println("Amount has been deposited successfully! Current balance in account: " 
				                                + service.checkBalance(UID) + "\n");
				        	break;
				        }
				        else
				        	System.out.println("Amount could not be added! Try Again");
				        }
				        break;
				        
				case 3: while(true) {
					    System.out.print("Enter the amount of money you want to withdraw: ");
				        Double wdrawMoney = sc.nextDouble();
				        sc.nextLine();
				        boolean success = service.withdrawMoney(UID, wdrawMoney, UID);
				        if(success) {
				        	System.out.println("Amount has been withdrawn successfully! Current balance in account: " 
				                                + service.checkBalance(UID) + "\n");
				        	break;
				        }
				        else {
				        	System.out.println("Insufficient Funds! Please withdraw within account balance. "
				        			+ "Current balance in account: " + service.checkBalance(UID) + "\n");
				            System.out.println("Press 1 to go back to Main Menu or press anything to continue..");
				            String exit = sc.nextLine();
				            if(exit.equalsIgnoreCase("1"))
				            	break;
				        }
				        }
				        break;
				        
				case 4: while(true) {
					    System.out.print("Enter the UID of the account to transfer funds: ");
				        Integer targetUID = sc.nextInt();
				        sc.nextLine();
				        if(service.checkUID(targetUID)) {
				        	System.out.print("Enter the amount of money to transfer: ");
				        	Double depMoney = sc.nextDouble();
				        	sc.nextLine();
				        	boolean success = service.withdrawMoney(UID, depMoney, targetUID);
				        	if(success) {
				        	  service.depositMoney(targetUID, depMoney, UID);
				        	  System.out.println("\nFunds have been transferred successfully! Current balance in account: " 
				        	                    + service.checkBalance(UID) + "\n");
				        	  break;
				        	}
				        	else {
				        		System.out.print("Insufficient Funds! Please transfer within account balance. Current balance in account: "
				        	                    + service.checkBalance(UID) + "\n");
				        		System.out.println("Press 1 to go back to Main Menu or press anything to continue..");
					            String exit = sc.nextLine();
					            if(exit.equalsIgnoreCase("1"))
					            	break;
				        	}
				        }
				        else
				        	System.out.println("Invalid UID! Try Again with a valid UID\n");
				        }
				        break;
				        
				case 5: System.out.println("\nComplete Transaction Record: \n");
				        transactionList = service.getTransactionRecord(UID);
				        //System.out.println(transactionList);
				        for(Transaction t : transactionList)
				        	System.out.println(t + "\n");
				        break;
				
				        	
				        
				case 6: System.out.println("Logging off! Thank you for your time.");
					    System.exit(0);
				        
				default: System.out.println("Wrong choice! Try Again");
				
				}
				}
			}
		} 
		else {
			System.out.println("This application cannot establish connection to the Database! Try later");
			System.exit(0);
		}
	}

	}

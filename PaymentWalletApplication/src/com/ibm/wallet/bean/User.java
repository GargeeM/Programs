package com.ibm.wallet.bean;

public class User {
    private Integer UID;
    private String userName, password, mail, contactNo, accNo;
    private Double balance;
    
	public User() {
		super();
	}

	public User(Integer uID, String userName, String accNo, String password, String mail, String contactNo, Double balance) {
		super();
		UID = uID;
		this.accNo = accNo;
		this.userName = userName;
		this.password = password;
		this.mail = mail;
		this.contactNo = contactNo;
		this.balance = balance;
	}

	public Integer getUID() {
		return UID;
	}
	
	public String getAccNo() {
		return accNo;
	}
    
	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public String getMail() {
		return mail;
	}

	public String getContactNo() {
		return contactNo;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}
    
    
}

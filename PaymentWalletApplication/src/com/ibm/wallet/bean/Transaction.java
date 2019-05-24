package com.ibm.wallet.bean;

public class Transaction {
	private Integer UID, transactionID;
	private String transactionType, timestamp, accNo, accHolderName;
	private Double amount;

	public Transaction() {
		super();
	}

	public Transaction(Integer UID, Integer transactionID, String timestamp, String accNo,
			String accHolderName, String transactionType, Double amount) {
		super();
		this.UID = UID;
		this.transactionID = transactionID;
		this.transactionType = transactionType;
		this.timestamp = timestamp;
		this.accNo = accNo;
		this.accHolderName = accHolderName;
		this.amount = amount;
	}

	public Integer getUID() {
		return UID;
	}

	public Integer getTransactionID() {
		return transactionID;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public String getAccNo() {
		return accNo;
	}

	public String getAccHolderName() {
		return accHolderName;
	}

	public Double getAmount() {
		return amount;
	}

	@Override
	public String toString() {
		return "UID: " + UID + "\nTransaction ID: " + transactionID + "\nTransaction Type: " + transactionType
				+ "\nTimestamp: " + timestamp + "\nAccount No.: " + accNo + "\nAccount Holder Name: " + accHolderName + "\nAmount: "
				+ amount;
	}

	
	

}

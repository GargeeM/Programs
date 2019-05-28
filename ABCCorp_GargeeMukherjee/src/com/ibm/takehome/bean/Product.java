package com.ibm.takehome.bean;

public class Product {
    private Integer productID;
    private String productName, productCategory;
    private Integer productPrice;
    
    public Product() {}
    
	public Product(Integer productID, String productName, String productCategory, Integer productPrice) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.productCategory = productCategory;
		this.productPrice = productPrice;
	}
	public Integer getProductID() {
		return productID;
	}
	public String getProductName() {
		return productName;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public Integer getProductPrice() {
		return productPrice;
	}

	@Override
	public String toString() {
		return "\nProduct ID: \t\t" + productID + "\nProduct Name: \t\t" + productName + "\nProduct Category: \t" + productCategory + 
				 "\nProduct Price(Rs): \t" + productPrice;
	}
	

}

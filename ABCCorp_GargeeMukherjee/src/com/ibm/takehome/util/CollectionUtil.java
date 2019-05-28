package com.ibm.takehome.util;

import java.util.HashMap;
import java.util.Map;

import com.ibm.takehome.bean.Product;

public class CollectionUtil {

	private static Map<Integer, Product> products = new HashMap<>();
	static {
		getProducts().put(1001, new Product(1001, "iPhone", "Electronics", 35000));
		getProducts().put(1002, new Product(1002, "LEDTV", "Electronics", 45000));
		getProducts().put(1003, new Product(1003, "Teddy", "Toys", 800));
		getProducts().put(1004, new Product(1004, "Telescope", "Toys", 5000));
		
	}
	public static Map<Integer, Product> getProducts() {
		return products;
	}
	public static void setProducts(Map<Integer, Product> products) {
		CollectionUtil.products = products;
	}
}

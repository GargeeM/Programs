package com.ibm.takehome.service;

import com.ibm.takehome.bean.Product;
import com.ibm.takehome.exception.InvalidProductCodeException;
import com.ibm.takehome.exception.ProductCodeLengthException;

public interface IProductService {

	Product getProductDetails (Integer productCode);
	boolean validateProductCode(Integer productCode) throws ProductCodeLengthException, InvalidProductCodeException;
	Integer calculateBill(Integer productCode, Integer quantity);

}

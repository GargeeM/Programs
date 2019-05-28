package com.ibm.takehome.service;

import com.ibm.takehome.bean.Product;
import com.ibm.takehome.dao.IProductDao;
import com.ibm.takehome.dao.ProductDao;
import com.ibm.takehome.exception.InvalidProductCodeException;
import com.ibm.takehome.exception.ProductCodeLengthException;

public class ProductService implements IProductService {
    
	IProductDao dao = new ProductDao();
	Product product = new Product();
	
	@Override
	public Product getProductDetails(Integer productCode) {
		Product product =  dao.getProductDetails(productCode);
		return product;
	}

	@Override
	public boolean validateProductCode(Integer productCode) throws ProductCodeLengthException, InvalidProductCodeException {
	    boolean valid = false;
        String strCode = Integer.toString(productCode);
        if(strCode.length() != 4)
	       throw new ProductCodeLengthException();
		if(dao.validateProductCode(productCode) == false)
			throw new InvalidProductCodeException();
		else
			valid = true;
		return valid;
	}

	@Override
	public Integer calculateBill(Integer productCode, Integer quantity) {
		Integer lineTotal = 0;
		lineTotal = dao.getProductPrice(productCode) * quantity;
		//System.out.println("From service: " + lineTotal);
		return lineTotal;
	}

}

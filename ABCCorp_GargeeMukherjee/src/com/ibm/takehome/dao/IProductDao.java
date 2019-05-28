package com.ibm.takehome.dao;

import com.ibm.takehome.bean.Product;

public interface IProductDao {

	Product getProductDetails (Integer productCode);

	boolean validateProductCode(Integer productCode);
	
	Integer getProductPrice(Integer productCode);

}

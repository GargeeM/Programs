package com.ibm.takehome.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.ibm.takehome.dao.IProductDao;
import com.ibm.takehome.dao.ProductDao;

class ProductTest {
	
	IProductDao pd;
	
	@BeforeEach
	void beforeEach() {
		pd = new ProductDao();
	}
    
	@ParameterizedTest
	@ValueSource(ints = {1001, 1234, -22345, 9087, 0000})
	void checkValidateProductCode(int value) {
		assertEquals(true, pd.validateProductCode(value) );
	}
}

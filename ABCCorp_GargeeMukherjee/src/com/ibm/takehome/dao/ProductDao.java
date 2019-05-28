package com.ibm.takehome.dao;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.ibm.takehome.bean.Product;
import com.ibm.takehome.util.CollectionUtil;

public class ProductDao implements IProductDao{
    
	private Map<Integer, Product> productMap = CollectionUtil.getProducts();
	@Override
	public Product getProductDetails(Integer productCode) {

		Product product = productMap.get(productCode);
		return product;
	}
	@Override
	public boolean validateProductCode(Integer productCode) {
		boolean valid = false;
		
		Set set = productMap.entrySet();
        Iterator it = set.iterator();
        while(it.hasNext()){
     	  Map.Entry me = (Map.Entry)it.next();
     	  if(productMap.containsKey(productCode))
     	    valid = true;     	 
     	  else
     		valid = false;
        }
        
		return valid;
	}
	@Override
	public Integer getProductPrice(Integer productCode) {
		Integer productPrice = 0;
		
		Set set = productMap.entrySet();
        Iterator it = set.iterator();
        while(it.hasNext()){
     	  Map.Entry me = (Map.Entry)it.next();
     	 Product p = (Product) me.getValue(); 
     	 productPrice = p.getProductPrice();
        }
        //System.out.println("From dao price: " + productPrice);
		return productPrice;
	}
	
	

}

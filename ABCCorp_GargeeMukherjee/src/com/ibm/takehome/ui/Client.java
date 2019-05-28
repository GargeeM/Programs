package com.ibm.takehome.ui;

import java.util.Scanner;

import com.ibm.takehome.exception.InvalidProductCodeException;
import com.ibm.takehome.exception.ProductCodeLengthException;
import com.ibm.takehome.service.IProductService;
import com.ibm.takehome.service.ProductService;

public class Client {

	public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       IProductService service = new ProductService();
       Integer productCode;
       //entering loop of accepting choice from user
       while(true) {
       System.out.println("1) Generate Bill by entering Product Code and Quantity\n\n2) Exit");
       int choice = sc.nextInt();
       sc.nextLine();
       //Entering switch case
       switch(choice) {
       case 1: while(true) { 
    	         System.out.print("Enter Product Code: ");
                 productCode = sc.nextInt();
                 sc.nextLine();

    	            try {
						if(service.validateProductCode(productCode));
						  break;
					} catch (ProductCodeLengthException e) {
						System.out.println("Please enter Product Code of length 4 only! Try Again");
					} catch (InvalidProductCodeException e) {
						 System.out.println("This Product Code is not available! Try Again");
					}
                    
        
               } 
               System.out.print("Enter Quantity: ");
               Integer quantity = sc.nextInt();
               sc.nextLine();
               
               System.out.println(service.getProductDetails(productCode));
               System.out.println("Quantity:\t\t" + quantity);
               System.out.println("Line Total(Rs):\t\t" + service.calculateBill(productCode, quantity) + "\n");
               break;
               
       case 2: System.out.println("Thank you for your time!");
               System.exit(0);
               
       default: System.out.println("Wrong choice! Try Again");
       }
       //sc.close();
	}
    
	}
}	



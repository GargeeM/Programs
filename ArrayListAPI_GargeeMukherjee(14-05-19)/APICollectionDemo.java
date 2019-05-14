
import java.util.ArrayList;

//POJO class
class Laptop{
	private Integer ramSize, hddSize;
	private String uid, brand;

	Laptop(String uid, int ramSize, int hddSize, String brand ){
		this.uid = uid;
		this.ramSize = ramSize;
		this.hddSize = hddSize;
		this.brand = brand;
	}

	//Creating the getters
	public String getUid(){
		return this.uid;
	}

	public Integer getRamSize(){
		return this.ramSize;
	}

	public Integer getHddSize(){
		return this.hddSize;
	}

	public String getBrand(){
		return this.brand;
	}
    
    //creating the setters
	public void setRamSize(int ramSize){
		this.ramSize = ramSize;
	}

	public void setHddSize(int hddSize){
		this.hddSize = hddSize;
	}

	public void setBrand(String brand){
		this.brand = brand;
	}
    
    //Overriding toString method
    @Override
    public String toString(){
    	return "UID: " + this.uid + "\nRAM Size: " + this.ramSize + "\nHDD Size: " + this.hddSize + "\nBrand Name: " + this.brand + "\n";
    }

}

class LaptopCRUDOperations{
    java.util.Scanner sc = new java.util.Scanner(System.in);
	void userChoice(int choice, java.util.ArrayList list){
	    
	  String s = "";
	  do{
	    //switching according to user choice 
        switch(choice){
        	case 1: addLaptop(list);
        	        break;

        	case 2: viewLaptops(list);
        	        break; 

        	case 3: searchLaptops(list);
        	        break; 

        	case 4: deleteLaptop(list);
        	        break; 

        	case 5: modifyLaptop(list);
        	        break; 

        	default: System.out.println("Invalid choice! Try Again."); 
        }
        //checking whether user wants to exit the program
        System.out.println("Do you want to continue? \n Press Y/N");
        s = sc.next();
        //for input Y
        if(s.equalsIgnoreCase("Y")){
          System.out.println("Press 1 to donate a Laptop \n Press 2 to view existing Laptop details \n Press 3 to Search for a particular Laptop \n Press 4 to delete an existing Laptop \n Press 5 to update Laptop details");
          choice = sc.nextInt(); 
          //sc.next();
        }
        //handling input other than Y/N
        if(!s.equalsIgnoreCase("Y") && !s.equalsIgnoreCase("N")){
        	System.out.println("Please enter only Y/N");
        	System.out.println("Do you want to continue? \n Press Y/N");
            s = sc.next();
        }
        
      }while(!s.equalsIgnoreCase("N"));
    }

	void addLaptop(java.util.ArrayList list){
        //accepting new Laptop details from User
        System.out.println("Enter UID: ");
        String uid = sc.nextLine();
        System.out.println("Enter Ram Size: ");
        int ramSize = sc.nextInt();
        System.out.println("Enter HDD Size: ");
        int hddSize = sc.nextInt();
        System.out.println("Enter Brand Name: ");
        String brand = sc.next();
        
        //creating new Laptop
        Laptop laptop = new Laptop(uid, ramSize, hddSize, brand);
        list.add(laptop);
        System.out.println("New Laptop with UID " + laptop.getUid() + " added successfully!");
	}

	void viewLaptops(java.util.ArrayList list){
		//printing Laptop objects stored in list using for each
		for (Object ob : list) {
			System.out.println(ob);
		}
	}

	void searchLaptops(java.util.ArrayList list){
		System.out.println("Press 1 to search by UID \n Press 2 to search by RAM Size \n Press 3 to search by HDD Size \n Press 4 to search by Brand");
        int ch = sc.nextInt();
        //using user's choice to select which method to search with
        switch(ch){
        	case 1: searchByUid(list);
        	        break;

        	case 2: searchByRamSize(list);
        	        break;

        	case 3: searchByHDDSize(list);
        	        break;

        	case 4: searchByBrand(list);
        	        break;

        	default: System.out.println("Invalid Choice! Try Again.");
        } 
	}

	void searchByUid(java.util.ArrayList list){
	   //accepting uid to search from user
       System.out.println("Enter UID: ");
       String uid = sc.next();
       for (Object ob : list) {
       	 if(((Laptop)ob).getUid().equals(uid))
       	 	System.out.println("\n" + ob);
       }
	}

	void searchByRamSize(java.util.ArrayList list){
	   //accepting ramSize to search from user
       System.out.println("Enter RAM Size: ");
       int ramSize = sc.nextInt();
       for (Object ob : list) {
       	 if(((Laptop)ob).getRamSize() == ramSize)
       	 	System.out.println("\n" + ob);
       }
	}

	void searchByHDDSize(java.util.ArrayList list){
	   //accepting hddSize to search from user
       System.out.println("Enter HDD Size: ");
       int hddSize = sc.nextInt();
       for (Object ob : list) {
       	 if(((Laptop)ob).getHddSize() == hddSize)
       	 	System.out.println("\n" + ob);
       }
	}

	void searchByBrand(java.util.ArrayList list){
       //accepting brand to search from user
       System.out.println("Enter Brand: ");
       String brand = sc.next();

       for (Object ob : list) {
       	 if(((Laptop)ob).getBrand().equalsIgnoreCase(brand))
       	 	System.out.println("\n" + ob);
       }
	}

	void deleteLaptop(java.util.ArrayList list){
		//accepting uid from user to remove laptop
		System.out.println("Enter UID: ");
        String uid = sc.nextLine();
        int index = 0;
        for (Object ob : list ) {
        	if(((Laptop)ob).getUid().equalsIgnoreCase(uid)){
        	   index = list.indexOf(ob);
               break;
        	}
        }

        list.remove(index);
        System.out.println("Laptop with UID " + uid + "has been removed successfully!");
	}

	void modifyLaptop(java.util.ArrayList list){
		System.out.println("Enter UID of the laptop whose details you want to modify: ");
		String uid = sc.next();
		int index = 0;
        for (Object ob : list ) {
        	if(((Laptop)ob).getUid().equalsIgnoreCase(uid)){
        	   index = list.indexOf(ob);
               break;
        	}
        }
        if(index == 0)
        	System.out.println("Not a valid UID! Try Again.");
        else{
           Laptop l = (Laptop)list.get(index);
           System.out.println("Press 1 to modify Ram Size \n Press 2 to modify HDD Size \n Press 3 to modify Brand \n");
           int ch = sc.nextInt();
           switch(ch){
           	
           	   case 1: modifyByRamSize(list, index, l);
           	           break;
   
           	   case 2: modifyByHDDSize(list, index, l);
           	           break;
   
           	   case 3: modifyByBrand(list, index, l);
           	           break;
   
           	   default: System.out.println("Wrong choice!");
        	        
           } 
       }
	}

	void modifyByRamSize(java.util.ArrayList list, int index, Laptop l){
       System.out.println("Enter new RAM Size: ");
       int ramSize = sc.nextInt();
       l.setRamSize(ramSize);
       System.out.println("RAM Size has been modified successfully!");
	}

	void modifyByHDDSize(java.util.ArrayList list, int index, Laptop l){
       System.out.println("Enter new HDD Size: ");
       int hddSize = sc.nextInt();
       l.setHddSize(hddSize);
       System.out.println("HDD Size has been modified successfully!");
	}

	void modifyByBrand(java.util.ArrayList list, int index, Laptop l){
      System.out.println("Enter new Brand: ");
       String brand = sc.next();
       l.setBrand(brand);
       System.out.println("Brand has been modified successfully!");
	}   
}

//user defined exception for handling inputs other than a number
class NotANumberException extends Exception{
   NotANumberException(String s){
      super(s);
   }
}

//user defined exception for handling null inputs
class NullInputException extends Exception{
   NullInputException(String s){
      super(s);
   }
}

//Driver Class
class APICollectionDemo{
	public static void main(String[] args){
        java.util.Scanner scan = new java.util.Scanner(System.in);
        LaptopCRUDOperations crud = new LaptopCRUDOperations();
		ArrayList list = new ArrayList();
        Laptop l = new Laptop("23F", 8, 600, "Lenovo");

		//Store a Laptop object in the list
		list.add(new Laptop("54Y", 4, 500, "IBM"));
		list.add(new Laptop("67L", 8, 800, "IBM"));
		list.add(new Laptop("32N", 6, 500, "Sony"));
        list.add(l);

        //creating User Menu in console
        System.out.println("Welcome to The Laptop Store! \n Press 1 to donate a Laptop \n Press 2 to view existing Laptop details \n Press 3 to Search for a particular Laptop \n Press 4 to delete an existing Laptop \n Press 5 to update Laptop details");
        
        //using nested try catch block for handling exceptions while taking input from user
        try{
        	String strChoice = scan.nextLine();
        	try{
        		int choice = Integer.parseInt(strChoice);
        		crud.userChoice(choice, list);
        	}catch(java.util.NoSuchElementException e){
                throw new NullInputException("Input cannot be Empty!");
            }
        	catch(NumberFormatException e){
                throw new NotANumberException("Anything other than numbers are invalid!");
        	}        	
        }
        catch(NotANumberException e){
            e.printStackTrace();
        }
        catch(NullInputException e){
            e.printStackTrace();
        }
	}
}
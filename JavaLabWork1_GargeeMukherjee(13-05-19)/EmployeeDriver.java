// Write a Java Program to validate the full name of an employee. Create and throw a
// user defined exception if firstName and lastName is blank

class Employee{
	void validateEmployeeName(String firstName, String lastName){
       if(firstName.equalsIgnoreCase("Meera") && lastName.equalsIgnoreCase("Reed"))
       	System.out.println("Full name has been validated");
       else
       	System.out.println("Full name could not be validated");
	}
}

class NameException extends Exception{
	NameException(String s){
      System.out.println(s);
	}
}

class EmployeeDriver{
	public static void main(String[] args) throws NameException{
		java.util.Scanner scan = new java.util.Scanner(System.in);
		System.out.println("Enter first name of Employee: ");
		String firstName = scan.nextLine();
		System.out.println("Enter last name of Employee: ");
		String lastName = scan.nextLine();
		if(firstName.length() == 0 || lastName.length() == 0)
			throw new NameException("You can't enter null value! Try Again.");

        new Employee().validateEmployeeName(firstName, lastName);
	}
}
// Create an Exception class named as “EmployeeException”(User defined Exception) in a package named as “com.cg.eis.exception” and throw 
// an exception if salary of an employee is below than 3000. Use Exception Handling mechanism to handle exception properly


import com.cg.eis.exception.EmployeeException;

class EmployeeSalaryDriver{
	public static void main(String[] args) throws EmployeeException {
		java.util.Scanner scan = new java.util.Scanner(System.in);
		System.out.println("Enter your Salary: ");
		int salary = scan.nextInt();
		if(salary < 0)
			throw new NegativeException("Salary cannot be in negative! Try Again");
		else if(salary < 3000)
			throw new EmployeeException("Sorry! Salary is below average Payscale.");
		else
			System.out.println("Salary is above average Payscale.");
	}
}
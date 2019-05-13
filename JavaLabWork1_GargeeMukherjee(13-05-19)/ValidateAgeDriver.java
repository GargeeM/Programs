// Validate the age of a person and display proper message by using user defined exception. Age of a person should be above 15.

class UnderageException extends Exception{
	UnderageException(String s){
		System.out.println(s);
	}
}

class NegativeException extends Exception{
	NegativeException(String s){
		System.out.println(s);
	}
}

class ValidateAgeDriver{
    public static void main(String[] args) throws UnderageException, NegativeException {
    	java.util.Scanner scan = new java.util.Scanner(System.in);
		System.out.println("Enter your age to validate: ");
		int age = scan.nextInt();
		if(age < 0)
			throw new NegativeException("Age cannot be in negative! Try Again");
		else if(age <= 15)
			throw new UnderageException("Sorry! Your age could not be validated. Age has to be above 15.");
		else
			System.out.println("Congratulations! Your age has been validated!");
    }
}
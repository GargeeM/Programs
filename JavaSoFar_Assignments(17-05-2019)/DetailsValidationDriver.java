// Exercise 4: You are asked to create an application for registering the details of jobseeker. The requirement is:
// Username should always end with _job and there should be at least minimum of 8 characters to the left of _job. Write a function to validate the same. 
// Return true in case the validation is passed. In case of validation failure return false.

class DetailsValidation{
	void validateUsername(String userName){
		String nameArr[] = userName.split("_");
		if(nameArr.length == 2 || nameArr[1].equals("job")){
			int counter = 0;
			String name[] = nameArr[0].split("");
			if(name.length >= 8)
				System.out.println("True");
			else
				System.out.println("False");
		}	
		else{			
           System.out.println("Wrong name format! Username should end with _job");
		}

	}
}

class DetailsValidationDriver{
	public static void main(String[] args) {
		java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.println("Please enter user name: ");
        String userName = sc.nextLine();
        DetailsValidation ob = new DetailsValidation();
        ob.validateUsername(userName);
	}
}
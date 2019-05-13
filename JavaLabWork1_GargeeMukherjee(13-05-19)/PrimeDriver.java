// Write a Java program that prompts the user fo
// r an integer and then prints out all the prime
// numbers up to that Integer?

class PrimeNumbers{
	void printPrime(int n){
	   int count = 0;
	   System.out.println("Prime numbers till " + n + " :");
       for (int i = 2; i <= n ; i++ ) {
       	   for (int j =2 ; j <= i  ; j++) {
       	   	  if(i%j == 0)
                count++;
       	   }
       	   if(count == 1)
       	   	 System.out.println(i);
       	   count = 0;
       }
	}
}

//creating custom Exception classes
class NullNumberException extends Exception{
    NullNumberException(String s){
    	System.out.println(s);
    }
}

class NegativeNumberException extends Exception{
    NegativeNumberException(String s){
    	System.out.println(s);
    }
}

class PrimeDriver{
	public static void main(String[] args) throw NegativeNumberException  {
		java.util.Scanner scan = new java.util.Scanner(System.in);
		System.out.println("Enter an Integer: ");
		int num = scan.nextInt();
        
        //handling Custom Exception
		// if(num == 0)
		// 	throw new NullNumberException("Null values not allowed!");
		if(num < 0)
			throw new NegativeNumberException("Negative values are not allowed!");

        //calling method of PrimeNumbers class using object
        new PrimeNumbers().printPrime(num);
	}
}
// The Fibonacci sequence is defined by the following rule. The first 2 values in the
// sequence
// are 1, 1. Every subsequent value is the sum of the 2 values preceding it. Write a Java
// program that uses both recursive and nonrecursive functions to print the nth value of the Fibonacci
// sequence?

class Fibonacci{
     void chooseFibonacci(int n, int choice){
     	switch(choice){
           case 1: System.out.println(recursiveFibo(n));
                   break;
           case 2: System.out.println(nonRecursiveFibo(n));
                   break;  
     	}
     }
     int recursiveFibo(int n){
          
           if (n <= 1) 
              return n; 
           return recursiveFibo(n-1) + recursiveFibo(n-2); 
          
     }
     int nonRecursiveFibo(int n){
          
             int a = 0, b = 1, c; 
             if (n == 0) 
                 return a; 
             for (int i = 2; i <= n; i++) 
             { 
                 c = a + b; 
                 a = b; 
                 b = c; 
             } 
             return b; 
          
     }
}

class FibonacciDriver{
	public static void main(String[] args) {
		java.util.Scanner scan = new java.util.Scanner(System.in);

    	System.out.println("Welcome to Fibonacci! \n Enter the nth value to display:");
    	int n = scan.nextInt();

    	System.out.println("Enter 1 for a Recursive path \n Enter 2 for a Non-Recursive path");
    	int choice = scan.nextInt();

    	Fibonacci f = new Fibonacci();
    	f.chooseFibonacci(n, choice);
	}
}
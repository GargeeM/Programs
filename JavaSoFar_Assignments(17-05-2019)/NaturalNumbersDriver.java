// Exercise 9: Create a class with a method which can calculate the sum of first n natural numbers which are divisible by 3 or 5.

class NaturalNumbers{
	void sumOfNaturalNumbers(int n){
		int sum = 0;
		for (int i = 1; i <= n ; i++ ) {
			if(i%3 == 0 || i%5 == 0)
               sum = sum + i;
		}
		System.out.println("Sum of natural numbers divisible by 3 or 5: " + sum);
	}
}

class NaturalNumbersDriver{
	public static void main(String[] args) {
		java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.println("Please enter limit: ");
        int n = sc.nextInt();
                
        NaturalNumbers ob = new NaturalNumbers();
        ob.sumOfNaturalNumbers(n);
	}
}
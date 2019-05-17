// Exercise 12: Create a method to check if a number is a power of two or not

class PowerOfTwo{
	void checkNumber(double n){
        double sq = Math.sqrt(n);
        //int square = Math.floor(sq*sq);
        if(Math.pow(sq, 2.0) == n)
          System.out.println("This is a Power of Two!");
        else
          System.out.println("This is not a Power of Two!");
	}
}

class PowerOfTwoDriver{
	public static void main(String[] args) {
		java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.println("Please enter a number: ");
        double n = sc.nextInt();
                
        PowerOfTwo ob = new PowerOfTwo();
        ob.checkNumber(n);
	}
}
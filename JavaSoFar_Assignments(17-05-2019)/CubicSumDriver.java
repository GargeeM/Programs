// Exercise 5: Create a method to find the sum of the cubes of the digits of an n digit number

class CubicSum{
	void calcCubicSum(String n){
		String num[] = n.split("");
		int number, sum = 0;
		for (String s : num) {
            number = Integer.parseInt(s);
			sum = sum + (number*number*number);
		}
		System.out.println("Sum of cubes of digits of the given number is: " + sum);     
	}
}

class CubicSumDriver{
	public static void main(String[] args) {
		java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.println("Please enter a number: ");
        String n = sc.nextLine();
        CubicSum ob = new CubicSum();
        ob.calcCubicSum(n);
	}
}
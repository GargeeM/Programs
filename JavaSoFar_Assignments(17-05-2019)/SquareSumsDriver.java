// Exercise 10: Create a class with a method to find the difference between the sum of the squares and the square of
// the sum of the first n natural numbers.
class SquareSums{
	void calculateDifference(int n){
        int sum = 0, squareOfSum = 0, sumOfSquares = 0;
		for (int i = 1; i <= n ; i++ ) {
			sum = sum + i;
			sumOfSquares = sumOfSquares + (i*i);
		}
		squareOfSum = sum * sum;

		//calculating difference
	    int diff = 0;
		if(sumOfSquares > squareOfSum)
		  diff = (sumOfSquares - squareOfSum);
		else
		  diff = (squareOfSum - sumOfSquares);
        System.out.println("Difference between the sum of the squares and the square of the sum: " + diff);
	}
}

class SquareSumsDriver{
	public static void main(String[] args) {
		java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.println("Please enter limit: ");
        int n = sc.nextInt();
                
        SquareSums ob = new SquareSums();
        ob.calculateDifference(n);
	}
}

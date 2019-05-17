// Exercise 7: Create a method which accepts an integer array, reverse the numbers in the
// array and returns the resulting array in sorted order

class ReverseArray{
	void reverseNumbers(Integer[] userInput){
		int reverse = 0;
        for (int i = 0; i < userInput.length ; i++) {
        	while(userInput[i] != 0)
            {
                reverse = reverse * 10;
                reverse = reverse + userInput[i]%10;
                userInput[i] = userInput[i]/10;
            }
            userInput[i] = reverse;
            reverse = 0;
        }
        java.util.Arrays.sort(userInput);
        System.out.println("Sorted array with reversed Numbers: ");
        for (Integer k : userInput) {
        	System.out.println(k);
        }
	}
}

class ReverseArrayDriver{
	public static void main(String[] args) {
		java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.println("Please enter limit: ");
        Integer n = sc.nextInt();
        Integer userInput[] = new Integer[n];
        System.out.println("Please enter some numbers: ");
        for (int i = 0; i < n ; i++) {
        	userInput[i] = sc.nextInt();
        }            
        ReverseArray ob = new ReverseArray();
        ob.reverseNumbers(userInput);
	}
}
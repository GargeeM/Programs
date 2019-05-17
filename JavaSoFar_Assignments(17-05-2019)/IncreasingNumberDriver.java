// Exercise 11: Create a method to check if a number is an increasing number

class IncreasingNumber{
	void checkNumber(Integer[] number){
      Integer testNumber[] = new Integer[number.length];
      for(int i = 0; i < testNumber.length; i++ ){
      	testNumber[i] = number[i];
      }
      java.util.Arrays.sort(testNumber);
      if(java.util.Arrays.equals(number, testNumber))
      	System.out.println("It is an Increasing Number!");
      else
      	System.out.println("It is not an Increasing Number!");
	}
}

class IncreasingNumberDriver{
	public static void main(String[] args) {
		java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.println("Please enter a number: ");
        String userInput = sc.nextLine();
        String nums[] = userInput.split("");
        Integer number[] = new Integer[nums.length];
        for (int i = 0; i < nums.length ; i++ ) {
             number[i] = Integer.parseInt(nums[i]);
        }      
        IncreasingNumber ob = new IncreasingNumber();
        ob.checkNumber(number);
	}
}
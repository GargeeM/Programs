// Exercise 8: Create a method which accepts an array of integer elements and return the second smallest element in the array

class ArraySort{
	void findSecondSmallest(Integer[] numbers){
       java.util.Arrays.sort(numbers);
       System.out.println("Second smallest element: " + numbers[1]);
	}
}

class ArraySortDriver{
	public static void main(String[] args) {
		java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.println("Please enter limit: ");
        Integer n = sc.nextInt();
        Integer userInput[] = new Integer[n];
        System.out.println("Please enter some numbers: ");
        for (int i = 0; i < n ; i++) {
        	userInput[i] = sc.nextInt();
        }            
        ArraySort ob = new ArraySort();
        ob.findSecondSmallest(userInput);
	}
}
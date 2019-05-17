// Exercise 1 : Write a Java program that reads a line of integers and then displays each integer and the
// sum of all integers. (Use StringTokenizer class)?

class AddLineOfInteger{
     
     void addIntegers(String numbers){
         java.util.StringTokenizer st = new java.util.StringTokenizer(numbers, " ");
         int sum = 0;
         while(st.hasMoreTokens()){
         	String s =st.nextToken();
         	System.out.println(s);
         	sum = sum + Integer.parseInt(s);
         }
         System.out.println("Sum of the string of numbers: " + sum);
     }
}

class AddLineOfIntegerDriver{
	public static void main(String[] args) {
		java.util.Scanner sc = new java.util.Scanner(System.in);
		System.out.println("Enter a string of numbers: ");
		String numbers = sc.nextLine();
        AddLineOfInteger ob = new AddLineOfInteger();
        ob.addIntegers(numbers);
	}
}
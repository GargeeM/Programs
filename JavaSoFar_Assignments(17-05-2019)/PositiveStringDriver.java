// Exercise 2: Create a method that accepts a String and checks if it
// is a positive string. A string is considered a positive string, if on moving from left to right each character in the String 
//comes after the previous characters in the Alphabetical order. For Example: ANT is a positive String (Since T comes
// after N and N comes after A). The method should return true if the entered string is positive.

class PositiveString{
      void checkPositiveString(String testString){
      	String str[] = testString.split("");
      	String finalStr = "";
      	java.util.Arrays.sort(str);
      	for(String s: str)
           finalStr += s;
      	if(finalStr.equals(testString))
      		System.out.println("Positive!");
      	else 
      		System.out.println("Negative!");
      }
}

class PositiveStringDriver{
	public static void main(String[] args) {
		java.util.Scanner sc = new java.util.Scanner(System.in);
		System.out.println("Enter a string: ");
		String testString = sc.nextLine();
        PositiveString ob = new PositiveString();
        ob.checkPositiveString(testString);
		
	}
}
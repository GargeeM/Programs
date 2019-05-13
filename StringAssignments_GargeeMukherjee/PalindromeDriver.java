// 1. Take a string from user at runtime and then check, print whether the string entered is a palindrome or not

class Palindrome{

	void checkForPalindrome(String s){
		String rev="";
		String ar[] = new String[s.length()];
		ar = s.split("");
        for (int i = s.length() - 1 ; i >= 0 ; i-- ) {
        	rev = rev + ar[i];
        }
        if(rev.equalsIgnoreCase(s))
        	System.out.println("It's a palindrome!");
        else
        	System.out.println("It's not a palindrome!");
	}

}

class PalindromeDriver{
	public static void main(String[] args) {
		java.util.Scanner scan = new java.util.Scanner(System.in);
		System.out.println("Enter a String to check for Palindromes: ");
		String s = scan.nextLine();
		new Palindrome().checkForPalindrome(s);
	}
}
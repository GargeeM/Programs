// Take a string from user at runtime and then print it's reverse

class Reverse{
	void reverseString(String s){
		String rev="";
		String ar[] = new String[s.length()];
		ar = s.split("");
        for (int i = s.length() - 1 ; i >= 0 ; i-- ) {
        	rev = rev + ar[i];
        }
        System.out.println("Reversed string: " + rev);
	}

}

class ReverseDriver{
	public static void main(String[] args) {
		java.util.Scanner scan = new java.util.Scanner(System.in);
		System.out.println("Enter a String to reverse: ");
		String s = scan.nextLine();
		new Reverse().reverseString(s);
	}
}
 // Take a string from user at runtime and then check, print the number of vowels in the string
class Vowels{
     void findVowels(String s){

     	int count = 0;
     	for(int i = s.length() - 1 ; i >= 0 ; i--){
			char ch = s.charAt(i);
			if(ch == 'a' || ch == 'A' || ch == 'e' || ch == 'E' || ch == 'i' || ch == 'o' || ch =='O' || ch == 'I' || ch == 'u' || ch == 'U')
							count++;
		}
		System.out.println("No. of vowels present: " + count);
     }
}

class VowelsDriver{
	public static void main(String[] args) {
		java.util.Scanner scan = new java.util.Scanner(System.in);
		System.out.println("Enter a String to search for vowels: ");
		String s = scan.nextLine();
		new Vowels().findVowels(s);
	}
}
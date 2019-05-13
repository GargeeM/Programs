 // Write a Java program to find first non repeating character in a string.


class NonRepeatingCharacter {
 public static void main(String[] args) {
    java.util.Scanner scan = new java.util.Scanner(System.in);
    System.out.println("Please enter a String: ");
    String s = scan.nextLine();
    for (int i = 0; i < s.length(); i++) {
        int flag = 0;
        for (int j = 0; j < s.length(); j++) {
            if (i != j && s.charAt(i) == s.charAt(j)) {
               flag++;
               break;
            }
        }
        if (flag == 0) {
          System.out.println("The first non repeated character in String is: " + s.charAt(i));
          break;
        }
    }
 }
}
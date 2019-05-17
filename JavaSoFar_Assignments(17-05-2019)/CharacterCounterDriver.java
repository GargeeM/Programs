//Exercise 2: Create a method that accepts a character array and count the number of times each
//character is present in the array. Add how many times each character is present to a hash map with the
//character as key and the repetitions count as value

import java.util.*;

class CharacterCounter{
	void countCharacter(Character[] ar){
		HashMap<Character, Integer> map = new HashMap<>();
		//checking for character repetition
		for (Character c : ar ) {
			if(map.containsKey(c))
				map.put(c, map.get(c) + 1);
			else
				map.put(c, 1);
		}
		  //displaying the map key and value pairs
          Set set = map.entrySet();
          Iterator it = set.iterator();         
          while(it.hasNext()){
       	  Map.Entry me = (Map.Entry)it.next();
       	  System.out.print("Character Key: " + me.getKey());
       	  System.out.println(" Repeating times: " + me.getValue());
       }
	}
}

class CharacterCounterDriver{
	public static void main(String[] args) {
		java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.println("Please enter the no. of characters you wish to enter: ");
        Integer n = sc.nextInt();
        Character userInput[] = new Character[n];
        
        //taking characters from user as input
        System.out.println("Please enter some characters: ");
        for (int i = 0; i < n ; i++) {
        	Character c = sc.next().charAt(0);
        	userInput[i] = c;
        }
		CharacterCounter ob = new CharacterCounter();
		ob.countCharacter(userInput);
	}
}
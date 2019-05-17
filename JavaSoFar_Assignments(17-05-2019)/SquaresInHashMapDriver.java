// Create a method which accepts an array of numbers and returns the numbers and their squares in HashMap

import java.util.*;

class SquaresInHashMap{
	void getSquares(Integer[] userInput){
       Integer square = 0;
       HashMap<Integer, Integer> map = new HashMap<>();
       for (Integer i : userInput) {
       	   square = i * i;
       	   map.put(i, square);    	
       }

       //displaying the key value pairs stored in map
       Set set = map.entrySet();
       Iterator it = set.iterator();         
       while(it.hasNext()){
       	  Map.Entry me = (Map.Entry)it.next();
       	  System.out.print("Key: " + me.getKey());
       	  System.out.println(" Squared Value: " + me.getValue());
       }
	}
}

class SquaresInHashMapDriver{
	public static void main(String[] args) {
		java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.println("Please enter limit: ");
        Integer n = sc.nextInt();
        Integer userInput[] = new Integer[n];
        System.out.println("Please enter some numbers: ");
        for (int i = 0; i < n ; i++) {
        	userInput[i] = sc.nextInt();
        }   
		SquaresInHashMap ob = new SquaresInHashMap();
		ob.getSquares(userInput);
	}
}
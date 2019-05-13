
class TrafficLight{
   void displayTrafficLight(int choice){
       switch(choice){
       	case 1: System.out.println("STOP!");
       	        break;
       	case 2: System.out.println("READY!");
       	        break;
       	case 3: System.out.println("GO!");
       	        break;
       	default: System.out.println("Wrong choice! Try Again :)");
       }
   }
}

class TrafficLightDriver{
    public static void main(String[] args) {
    	java.util.Scanner scan = new java.util.Scanner(System.in);
    	System.out.println("Welcome to Traffic Lights! \n Enter 1 for RED \n Enter 2 for YELLOW \n Enter 3 for GREEN");
    	int choice = scan.nextInt();
    	TrafficLight tl = new TrafficLight();
    	tl.displayTrafficLight(choice);
    }
}
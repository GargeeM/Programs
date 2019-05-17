// Create a method to accept date and print the duration in days, months and years with
// regards to current system date.

class DateComparison{
	void compareDate(String date){
		java.time.LocalDate currTime = java.time.LocalDate.now();
        java.time.LocalDate userTime = java.time.LocalDate.parse(date);
        java.time.Period period = java.time.Period.between(userTime, currTime);
        System.out.println("Difference in given date and current date is: " + period.getYears() + " years " +  period.getMonths() + " months and " + period.getDays() + " days.");
	}
}

class DateComparisonDriver{
	public static void main(String[] args) {
		java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.println("Please enter Date only in YYYY-MM-DD Format:");
        String date = sc.nextLine();
        DateComparison ob = new DateComparison();
        ob.compareDate(date);
	}
}
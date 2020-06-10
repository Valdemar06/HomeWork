import java.util.Scanner;

public class BankInterest {
    public static void main(String[] args) {
        Scanner money = new Scanner(System.in);
        Scanner days = new Scanner(System.in);
        Scanner percent = new Scanner(System.in);

        System.out.println("Enter you money: ");
        int customerMoney = money.nextInt();
        System.out.println("Enter the number of days: ");
        int customerDays = days.nextInt();
        System.out.println("Enter you percent: ");
        int customerPercent = percent.nextInt();
        int percentOfYear = (customerMoney*customerPercent* customerDays/365)/100;

        System.out.println("Your money with interest: "+ percentOfYear);
        System.out.println("You money this year: " + (percentOfYear + customerMoney));
        System.out.println("Your interest days: " + customerDays);
        System.out.println("Want to calculate money at interest for several years?\n Yes or No");

        Scanner theChoice = new Scanner(System.in);
        String customerChoice = theChoice.nextLine();
        if(customerChoice.equals("Yes")){
            System.out.println("Enter the number of years: ");
            Scanner years = new Scanner(System.in);
            int customerYears = years.nextInt();
            int moneyOfYear = (customerMoney*customerPercent*1) /100;
            int moneyOfYears = (customerMoney*customerPercent*customerYears) /100 ;
            System.out.println("You money for 1 year: " + moneyOfYear);
            System.out.println("You money for  " + customerYears + " years: "+moneyOfYears);
        }
            System.out.println("Good luck day");
    }
}

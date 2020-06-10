import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class EvenOrNot {
    public static void main(String[] args) {
        System.out.println(" ");
        System.out.println("The program will show an even number or not");
        Scanner number = new Scanner(System.in);
        System.out.println("Enter you number: ");
        int customerNumber = number.nextInt();
        if(customerNumber%2==0){
            System.out.println("Yes, your number even");
        }else{
            System.out.println("No");
        }
        System.out.println(" ");
        System.out.println("Prime number ");
        if(customerNumber/customerNumber == 1 & customerNumber/1==customerNumber & customerNumber%2 !=0){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
        System.out.println(" ");
        System.out.println("Multiple numbers");
        for (int i = 1; i < 10; i++){
            if(customerNumber % i == 0){
                System.out.println("Multiple numbers:" + i);
            }
        }
    }
}

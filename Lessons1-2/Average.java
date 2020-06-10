import java.util.Scanner;

public class Average {
    public static void main(String[] args) {
        int numberArray[];
        float amount = 0f;
        int firstNumber = 20;
        int secondNumber = 30;
        System.out.println("You average number: "+(firstNumber+secondNumber)/2);
       /* Scanner number = new Scanner(System.in);
        System.out.println("Enter first number: ");
        int first = number.nextInt();
        System.out.println("Enter second  number: ");
        int second = number.nextInt();
        System.out.println("Enter third number:  ");
        int third = number.nextInt();
        System.out.println("You average number: "+(first+second+third)/3);*/
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of digits: ");
        int size = input.nextInt();
        numberArray = new int[size];
        System.out.println("Enter you numbers: ");
        for (int i = 0; i < numberArray.length; i++) {
            numberArray[i] = input.nextInt();
        }
       /* Вывод информации о массиве в более приятном виде/Outputting information about the array in a more pleasant way
       String intArrayString = Arrays.toString(numberArray);
        System.out.println(intArrayString);*/
        for (int i = 0; i < numberArray.length; i++){
            amount = amount + numberArray[i];
        }
        System.out.println("Average:" + amount/ size);
    }
}

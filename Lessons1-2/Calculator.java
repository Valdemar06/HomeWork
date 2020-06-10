import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        float result = 0f;

        Scanner first = new Scanner(System.in);

        System.out.println("Enter first number: ");
        float firstNumber = first.nextFloat();
        System.out.println("Enter operation: ");
        char operationChar = first.next().charAt(0);
        System.out.println("Enter second number: ");
        float secondNumber = first.nextFloat();


        if(operationChar == '+'){
            result = firstNumber + secondNumber;
        }if(operationChar == '-'){
            result = firstNumber - secondNumber;
        }if (operationChar == '*'){
            result = firstNumber * secondNumber;
        }else if(operationChar == '/'){
            if( firstNumber == 0 || secondNumber ==0) {
            System.out.println("You cannot divide by zero");
                System.exit(0);
            }
         result = firstNumber / secondNumber;
        }else if(operationChar != '+'&& operationChar != '-'&& operationChar != '*' && operationChar!= '/'){
            System.out.println("Please enter a math sign ");
            System.exit(0);
        }
        if(result % 1 == 0){
            System.out.println("Result = " + (int) result);
        }else {
            System.out.println("Result = " +  result);
        }
    }
}
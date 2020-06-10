import java.util.Scanner;

public class Stars {
    public static void main(String[] args) {
        Scanner figure = new Scanner(System.in);
        System.out.println("Enter weight: ");
        double weight = figure.nextDouble();
        System.out.println("Enter height: ");
        double height = figure.nextDouble();
//Прямоугольник
     /*   for(int i=0; i < height; i++) {
            for(int k=0; k < weight; k++) {
                if(k==0 || k==weight-1 || i==0 || i==height-1) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        System.out.println();*/
// Конверт
       for (int i = 0; i <height ; i++) {
            for (int j = 0; j < weight; j++) {
                if (i == 0 || i == height - 1 || j == 0 || j == weight - 1) {
                    System.out.print("* ");
                } else if (i-height==j-weight|i == weight-j-1) {
                    System.out.print("* ");
                }else{
                    System.out.print("  ");
                }
            }
            System.out.println(" ");
        }
        System.out.println( );

//Шахматы
   /*for (int i = 0; i < height; i++) {
            if (i % 2 != 0) {
                System.out.print(" ");
            }
            for (int j = 0; j < weight; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }*/
    }
}

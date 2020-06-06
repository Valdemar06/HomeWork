
public class Homework {
    public static void main(String[] args) {
        int k = 123; int x =k;
        int s = 0;
        while (x != 0 ){
            s = s + x%10;
            System.out.println(s);
            x = x/10;
        }
        System.out.println("Сумма цифр в числе " + k + " = " + s);
    }
}

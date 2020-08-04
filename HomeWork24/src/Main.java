import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {

        DecimalFormat decimalFormat = new DecimalFormat();
        decimalFormat.setDecimalSeparatorAlwaysShown(false);

        float answer = raisePower(2, -2);
        System.out.println(decimalFormat.format(answer));
    }
    private static float raisePower(float number, int power) {
        float temp;
        if( power == 0){ return 1;}
        temp = raisePower(number, power/2);

        if (power % 2 == 0) {return temp*temp;}
        else {
            if(power > 0) {return number * temp * temp;}
            else {return (temp * temp) / number;}
        }
    }
}

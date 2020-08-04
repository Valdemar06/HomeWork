import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(raisePower(BigInteger.valueOf(2),15));
    }
    private static BigInteger raisePower(BigInteger number, int power) {
        List<BigInteger> powerX = new ArrayList<>();
        powerX.add(number);

        BigInteger xPowerN = number.multiply(number);
        powerX.add(xPowerN);

        int result = 2;

        while (result < power - 2){
            xPowerN = xPowerN.multiply(xPowerN);
            powerX.add(xPowerN);
            result *= 2;
        }
        BigInteger answer = BigInteger.valueOf(1);
        for (int i = 0; i <powerX.size() ; i++) {
            if((power &( 1 << i))!=0){
                answer = answer.multiply(powerX.get(i));
            }
        }
        return answer;
    }
}

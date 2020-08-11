import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Mean mean = new Mean();
        List<Double> numbers = Arrays.asList(1.0,2.0,3.0,6.0,7.0,8.0,9.0,10.0);
        System.out.println("Mean " + mean.meanMethod(numbers));
        System.out.println("Quadratic " + mean.quadraticMethod(numbers));
    }
}

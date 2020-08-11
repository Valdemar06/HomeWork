import java.util.List;
import java.util.stream.Stream;


public class Mean {


    public double meanMethod(List<Double> numbers) {
     /*   double result = 0;
        for (double number: numbers) {
            result += number;
        }
        return result / numbers.size();*/
        Stream<Double> stream = numbers.stream();
        double  result = stream.mapToDouble(x -> x).sum();
        return result/numbers.size();
    }
    public double quadraticMethod(List<Double> numbers){
      /* double result = 0;
       double power =0;
        for (double number: numbers) {
            if(number > 0){
                power = number * number;
            }
            if (power%2==0){
                result +=power;
            }
        }
        return result;*/
        Stream<Double> stream = numbers.stream();
        return stream.filter(doubles -> doubles>0)
                .map(doubles -> doubles * doubles)
                .filter(doubles -> doubles%2 ==0).mapToDouble(x->x).sum();
    }
}

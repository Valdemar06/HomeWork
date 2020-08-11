import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;


public class Mean {


    public Optional<Double> meanMethod(List<Double> numbers) {
     /*   double result = 0;
        for (double number: numbers) {
            result += number;
        }
        return result / numbers.size();*/
        Stream<Double> stream = numbers.stream();
        double  result = stream.mapToDouble(x -> x).sum();
        return Optional.of(result/numbers.size());
    }
    public Optional<Double> quadraticMethod(List<Double> numbers){
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
        return Optional.of(stream.filter(doubles -> doubles>0)
                .map(doubles -> doubles * doubles)
                .filter(doubles -> doubles%2 ==0).mapToDouble(x->x).sum());
    }
}

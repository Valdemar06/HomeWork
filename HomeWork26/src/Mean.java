import java.util.ArrayList;
import java.util.List;

public class Mean {

    public double meanMethod(List<Double> numbers){
        /**
         * mean = n(n+1)/2
         */
        double result = numbers.size() * (numbers.size() + 1) >> 1;
        return result/numbers.size();
    }
    public double quadraticMethod(List<Double> numbers){
        /**
         * (n(n+1)*(2n+1))/6(Why division by 6. I don't know)
         */
        List<Double>list = new ArrayList<>();
        double firstResult = (numbers.size()*(numbers.size() +1 )*(2*numbers.size()+1)) /6;

        for (double number: numbers) {
            if (number%2 == 0){
                list.add(number);
            }
        }
        double secondResult = (list.size() *(list.size()+1) * (2* list.size()+1))/6;

        return secondResult;
    }

}

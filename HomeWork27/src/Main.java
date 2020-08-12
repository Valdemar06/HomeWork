import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        /**
         * I FIND METHOD MATCHES THIS IS MAGIC MAN
         * MY TIME WHEN I FINISHED 00:51
         */
        List<String> surname = Arrays.asList("Ivanov", "Grechkin", "Pushkin", "Petrov", "Frackov","aoesdad","aui","oia");
        List<String> collect = surname.stream().
                filter(s -> s.toUpperCase().matches("(.*[AEYIUO].*){3,}")).collect(Collectors.toList());
        System.out.println(collect);
    }
}

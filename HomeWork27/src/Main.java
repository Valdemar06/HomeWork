import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        /**
         * A,O,E,I,U
         */
        List<String> surname = Arrays.asList("Ivanov", "Grechkin", "Pushkin", "Petrov", "Frackov","aoesdad","aui","oia");

        List<String> collect = surname.stream().map(String::toUpperCase)
                .filter(name -> name.contains("A") && name.contains("O") && name.contains("E")||
                        name.contains("A") && name.contains("O") && name.contains("I")||
                        name.contains("A") && name.contains("O") && name.contains("U")||
                        name.contains("A") && name.contains("E") && name.contains("I")||
                        name.contains("A") && name.contains("E") && name.contains("U")||
                        name.contains("A") && name.contains("I") && name.contains("U")||
                        name.contains("O") && name.contains("E") && name.contains("I")||
                        name.contains("O") && name.contains("E") && name.contains("U")||
                        name.contains("O") && name.contains("I") && name.contains("U")||
                        name.contains("E") && name.contains("I") && name.contains("U")).
                collect(Collectors.toList());
        System.out.println(collect);
    }
}

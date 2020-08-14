import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        /**
         * I FIND METHOD MATCHES THIS IS MAGIC MAN
         * MY TIME WHEN I FINISHED 00:51
         */
        Student student1 = new Student("Ivanov", "Ivan");
        Student student2 = new Student("Petrov", "Petr");
        Student student3 = new Student("Pushkin", "Aleksandr");
        Student student4 = new Student("Marian", "Nikolay");
        Student student5 = new Student("Kuplinov", "Dmitry");
        List<Student> surname = new ArrayList<>();
        surname.add(student1);
        surname.add(student2);
        surname.add(student3);
        surname.add(student4);
        surname.add(student5);
        List<String> collect = surname.stream().
                filter(s -> s.getFirstName().toUpperCase().matches("(.*[AEYIUO].*){3}"))
                .map(name -> name.getLastName().toUpperCase()).sorted().collect(Collectors.toList());
        System.out.println(collect);
    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int sum = 13;
        List<Integer> list = new ArrayList<>(Arrays.asList(3, 7, 10, 15));
        boolean result = false;
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j <list.size(); j++) {
                if (j != i && (list.get(i)+ list.get(j)) == sum) {
                    System.out.println(list.indexOf(list.get(i)));
                    result = true;
                }
            }
        }
        if (result){
        }else{
            System.out.println("There are no matching elements in this array.");
        }
    }
}

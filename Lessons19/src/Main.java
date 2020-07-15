import java.util.*;

public class Main {

    public static void main(String[] args) {
        int sum = 13;
        List<Integer> list = new ArrayList<>(Arrays.asList(3, 7, 10, 15));
        List<Integer> delete = new ArrayList<>();
        for (int i : list) {
            if (list.indexOf(sum - i) == -1){
                delete.add(list.indexOf(sum - i));
            }else{
                System.out.println( "["+ list.indexOf(sum - i) + ", "
                        + list.indexOf(i) + "]");
            }
        }
    }
}

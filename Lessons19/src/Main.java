import java.util.*;

public class Main {

    public static void main(String[] args) {
        int sum = 13;
        List<Integer> list = new ArrayList<>(Arrays.asList(3, 7, 10, 15));
        Map<Integer, Integer> pairs = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            int complement = sum - list.get(i);
            if (pairs.containsKey(complement)) {
                System.out.println(pairs.get(complement) + " " + i);
            }
            pairs.put(list.get(i), i);
        }
    }
}


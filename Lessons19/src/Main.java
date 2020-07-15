import java.util.*;

public class Main {

    public static void main(String[] args) {
        int sum = 13;
        List<Integer> list = new ArrayList<>(Arrays.asList(3, 7, 10, 15));
        Map<Integer, Integer> pairs = new HashMap<>();
        for (int i : list) {
            if (pairs.containsKey(i)) {
                if (pairs.get(i) != null) { }
                pairs.put(sum - i, null);
            } else if (!pairs.containsValue(i)) {
                pairs.put(sum-i, i);
            }
        }
        System.out.println(pairs);
    }
}

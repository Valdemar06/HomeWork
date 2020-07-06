import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Student ivanov = new Student(2, "ivanov");
        Student stack = new Student(5, "stack");
        Student demo = new Student(4, "demo");
        Map map = new HashMap();
        map.put(ivanov,"Ivanov");
        map.put(stack,"Stack");
        map.put(demo,"Demo");
        map.entrySet();
        System.out.println(map);
        map.remove(stack);
        System.out.println(map);
    }
}

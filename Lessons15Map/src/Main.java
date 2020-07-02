import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        MyMap mymap = new MyMap();
        Map map = new HashMap();
        mymap.put("32", "one");
        System.out.println(mymap);
    }
}

import java.util.Iterator;
import java.util.LinkedList;

public class Test {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        String line2 = "C";
        String line3 = "D";
        list.add(line2);
        list.add(line3);
        LinkedList list1 = new LinkedList();
        list1.add("A");
        list1.add("B");
        MyList myList = new MyList();
        String line = "A";
        String lime = "B";
        myList.add(line);
        myList.add(lime);
        System.out.println(list);
        System.out.println(myList);
        myList.addAll(list);
        System.out.println(myList);
         myList.retainAll(list1);
        System.out.println(myList);

        Iterator iterator = myList.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}

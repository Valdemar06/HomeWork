import java.util.Iterator;
import java.util.LinkedList;

public class Test {
    public static void main(String[] args) {
        MyCollection myCollection = new MyCollection();
        LinkedList<String> collection = new LinkedList<>();
        collection.add("Two");
        String string ="One";
        myCollection.add(string);
        myCollection.add("two");
        myCollection.add("Three");
        System.out.println(myCollection.contains(string));
        System.out.println(myCollection.isEmpty());
        System.out.println(myCollection.containsAll(collection));
        System.out.println(myCollection.size());

        Iterator iterator = myCollection.iterator();
          while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Test {
    public static void main(String[] args) {
        int i1 = 2;
        List list = new ArrayList();
        list.add(1);
        list.add(i1);
        list.add(3);
        MyList myList = new MyList();
        int i = 1;
        myList.add(5);
        myList.add(1, i1);
        myList.set(1, 4);
        myList.add(3);
        System.out.println(myList.toString());
        myList.addAll(0, list);
        System.out.println(myList.toString());
       /* myList.removeAll(list);
        System.out.println(myList.toString());
        System.out.println(myList.lastIndexOf(2));*/

       /*Iterator iterator = myList.iterator();
         while(iterator.hasNext()){
            System.out.println(iterator.next());
        }*/
        ListIterator listIterator = myList.listIterator(9);
        while (listIterator.hasNext()) {
          System.out.println(listIterator.next());
      }
        System.out.println(myList.subList(0,9));
    }
}

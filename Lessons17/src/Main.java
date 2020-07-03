import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ListGeneric<>();
        List<String> list1 = new ArrayList<>();
        list1.add("Five");
        list1.add("Eight");
        list1.add("Nine");
        list1.add("Ten");
        list.add("One");
        list.add("Two");
        list.add("Tree");
        /*List<Integer> list = new ListGeneric<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(5);
        list1.add(8);
        list1.add(9);
        list1.add(10);
        list.add(1);
        list.add(2);
        list.add(3);*/
        Integer six = 6;
        list.addAll(list1);
        System.out.println(list);
        list.retainAll(list1);
        System.out.println(list);
        System.out.println("Method last index");
        System.out.println("String");
        System.out.println(list.lastIndexOf("Eight"));
        System.out.println("Integer");
        System.out.println(list.lastIndexOf(8));
        System.out.println("Iterator" );
        Iterator iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("");
        System.out.println("Block try, catch");
        /***
         * Write a part of code that uses indexes in a block
         */
        try{
            list.add(20, "Twenty");
        }catch (RuntimeException exception){
            System.out.println("Out bound of array");
        }
    }
}

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        List list = new ArrayList();
        binaryTree.add(1);
        binaryTree.add(-2);
        binaryTree.add(3);
        list.add(4);
        list.add(-5);
        list.add(6);
        binaryTree.addAll(list);

        Iterator iterator = binaryTree.iterator();
       /* while(iterator.hasNext()){
           System.out.println(iterator.next());
        }*/
         binaryTree.traverseInOrder(binaryTree.getRoot());
    }
}

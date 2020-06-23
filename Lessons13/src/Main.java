import java.util.*;

public class Main {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        List list = new ArrayList();
        binaryTree.add(6);
        binaryTree.add(5);
        binaryTree.add(4);
        Iterator iterator = binaryTree.iterator();
        while(iterator.hasNext()){
           System.out.println(iterator.next());
        }
    }
}

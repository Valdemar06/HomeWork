import java.util.*;

public class Main {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.add(1);
        binaryTree.add(2);
        binaryTree.add(0);
        binaryTree.add(10);
        binaryTree.add(1);
        binaryTree.add(1);
        binaryTree.add(1);
        binaryTree.add(1);
        binaryTree.add(1);

        System.out.println(binaryTree);
        System.out.println(binaryTree.size());
        Iterator iterator = binaryTree.iterator();
        while(iterator.hasNext()){
           System.out.println(iterator.next());
        }
    }
}

import java.util.*;

public class BinaryTree implements Set {
    private Node root;
    private int size = 0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        if(root == null){ return false; }
        return containsIn((Integer) o,root);
    }
    private boolean containsIn(int value, Node node){
        if(node == null){ return false; }
        if(node.data == value){ return true; }
        return value < node.data
                ? containsIn(value, node.left)
                : containsIn(value, node.right);
    }

    @Override
    public Iterator iterator() {
        return new Iterator(root);
    }

    public  void traverseInOrder(Node node){
        if(node != null){
            traverseInOrder(node.left);
            System.out.println(node.data);
            traverseInOrder(node.right);
        }
    }
    @Override
    public Object[] toArray() {
        return toArray(root);
    }
    private Object [] toArray(Node node){
        List result = new ArrayList();
        if (node.left!= null){
            Object [] temp = toArray(node.left);
            for (int i = 0; i <temp.length ; i++) {
                Comparable object = (Comparable) temp[i];
                result.add(object);
            }
        }
        result.add(node.data);
        if(node.right != null){
            Object [] temp = toArray(node.right);
            for (int i = 0; i <temp.length ; i++) {
                Comparable object = (Comparable) temp[i];
                result.add(object);
            }
        }
        return  result.toArray();
    }

    @Override
    public boolean add(Object o) {
        Integer add = (Integer)o;
        Node newNode = new Node(add);
        if(contains(add) == true) return false;
        if(root == null){
            root = newNode;
        }else{
            appendToNode(add, root);
        }
        size++;
        return true;
    }

    /**
     * A check occurs that checks the incoming element is larger or smaller than the root element,
     * if it is larger then it is in the right node,
     * if it is smaller then in the left node and these nodes are creating additional nodes.
     */
    private void appendToNode(Integer toAdd, Node node){
        if(node.data == toAdd){
            return;
        }else if (node.data > toAdd){
            if(node.left == null) {
                node.left = new Node(toAdd);
            }else{
                appendToNode(toAdd, node.left);
        }
        }else{
           if(node.right == null){
               node.right = new Node(toAdd);
           } else{
               appendToNode(toAdd, node.right);
           }
        }
    }

    @Override
    public boolean remove(Object o) {
        root = delete(root, o);
        size--;
        return true;
    }

    /**
     * Method delete
     * It checks all nodes and if there is an element that we want to delete in this node,
     * it checks if this node has child nodes,
     * so that then it will place a child node in place of the remote node
     */
    private Node delete(Node node, Object object){
        int value = (Integer)object;
        if(node== null){
            return null;
        }if(value == node.data){
            if(node.left == null && node.right == null){
                return null;
            }
            if(node.right == null){
                return node.left;
            }
            if(node.left == null){
                return node.right;
            }
            int smallestValue = findSmallestValue(node.right);
            node.data = smallestValue;
            node.right = delete(node.right, smallestValue);
            return node;
        }if (value < node.data){
            node.left = delete(node.left, value);
            return node;
        }
        node.right = delete(node.right, value);
        return node;
    }

    private int findSmallestValue(Node node){
        return node.left == null ? node.data : findSmallestValue(node.left);
    }

    @Override
    public boolean addAll(Collection c) {
        for (Object object: c) {
            add(object);
        }
        return true;
    }

    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    @Override
    public boolean removeAll(Collection c) {
        for (Object object: c) {
            remove(object);
        }
        return true;
    }

    /**
     * This method works on this principle.
     * First, a new tree is created, then the current tree is sorted
     * and a check is made for identical elements in the tree and in the collection that was transferred,
     * then it is added to the new tree.
     * The current tree is completely deleted using method clear
     * and elements from the new tree are added to the current tree.
     */
    @Override
    public boolean retainAll(Collection c) {
        BinaryTree binaryTree = new BinaryTree();
        for (Node x = root.right; x!= null; x = x.right){
            for (Object object: c){
                if(object.equals(x.data)){
                    binaryTree.add(object);
                }
            }
        }
        for (Node x = root.left; x!=null; x=x.left){
            for (Object object: c) {
                if(object.equals(x.data)){
                    binaryTree.add(object);
                    System.out.println(object);
                }
            }
        }
        clear();
        for (Object o: binaryTree) {
            add(o);
        }
        return true;
    }

    @Override
    public boolean containsAll(Collection c) {
        for (Object object : c) {
            for (Node x = root.right; x!= null; x = x.right)
            if(object.equals(x.data)){
                return true;
            }
            for (Node x = root.left; x!= null; x = x.left){
                if(object.equals(x.data)){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        Object [] newArray = new Object[a.length];
        for (int i = 0; i < a.length; i++) {
            newArray[i]= a[i];
        }
        return newArray;
    }

    @Override
    public String toString() {
        return print(root);
    }

    /**
     * This method uses vertical traversal of a binary tree.
     * This is done for greater beauty inference.
     */
    private String print (Node node){
        if(node==null){
            return "";
        }
        String result = "";
       String left = print(node.left);
       String root = String.valueOf(node.data);
       String right=  print(node.right);
       result = left + " " + root + " " + right;
       return  result;
    }

   /**
    * This class iterator uses a stack to add and remove nodes, and go through each node separately
      In this case, first left then right, so that sorting is right away.
    */
    public class Iterator implements java.util.Iterator {
        private Stack<Node> stack = new Stack();
        private Node current;

        public Iterator(Node current) {
            this.current = current;
        }

        public Object next (){
            while (current!=null){
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            Node node = current;
            current = current.right;
            return node.data;
        }

        @Override
        public void remove() {
        }

        public boolean hasNext(){
            return (!stack.isEmpty() || current!=null);
        }
        public   Iterator iterator(Node root){
            return new Iterator(root);
        }
    }

    private class Node{
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }

        public int getData() { return data; }
        public void setData(int data) { this.data = data; }
        public Node getLeft() { return left; }
        public Node getRight() { return right; }
    }
}

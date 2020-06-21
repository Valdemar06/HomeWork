import java.util.*;

public class BinaryTree implements Set {
    private Node root;
    private int size = 0;

    public Node getRoot(){return root;}
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
        if(node.data == 1){
            return true;
        }else if(node.data > value){ return containsIn(value, node.left);
        }else{ return containsIn(value, node.right); }
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            Node node = root;
            @Override
            public boolean hasNext() {
                return node!=null;
            }
            @Override
            public Object next() {
                Node temp = node;
                node = node.right;
                return temp.data;
            }
        };
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
        int index = 0;
        Object [] newArray = new Object[size];
        for (Node x = root.left; x!= null; x= x.left){
            newArray[index++] = x;
        }
        for (Node x = root.right; x!= null; x= x.right){
            newArray[index++] = x;
        }
        return newArray;
    }

    @Override
    public boolean add(Object o) {
        Integer add = (Integer)o;
        Node newNode = new Node(add);
        if(root == null){
            root = newNode;
        }else{
            appendToNode(add, root);
        }
        size++;
        return true;
    }
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

    private Node delete(Node node, Object object){
        int value = (Integer)object;
        if(node== null){
            return null;
        }if(value == node.data){
            node.data = 0;
        }if (value < node.data){
            node.left = delete(node.left, value);
            return node;
        }
        node.right = delete(node.right, value);
        return node;
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
                }
            }
        }
        clear();
        for (Object object : c) {
            add(object);
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

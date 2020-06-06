import java.util.Collection;
import java.util.Iterator;

public class MyList implements Collection {
    private int size = 0;
    private Node first;
    private Node last;
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
        for (Node x = first; x != null; x = x.next) {
            if (o.equals(x.data)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            Node node = first;
            @Override
            public boolean hasNext() {
                return  node != null;
            }
            @Override
            public Object next() {
                Node  temp = node;
                node = node.getNext();
                return temp.data;
            }
        };
    }

    @Override
    public Object[] toArray() {
        int index = 0;
        Object[] newArray = new Object[size];
        for (Node x = first; x != null; x = x.next) {
            newArray[index++] = x;
        }
        return newArray;
    }

    @Override
    public boolean add(Object object) {
        Node lastNode = last;
        Node newNode = new Node(lastNode, object, null);
        last = newNode;
        if (lastNode == null) {
            first = newNode;
        } else {
            lastNode.next = newNode;
        }
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) {
            for (Node x = first; x != null; x = x.next) {
                if (x.data == null) {
                    unlink(x);
                    return true;
                }
            }
        } else {
            for (Node x = first; x != null; x = x.next) {
                if (o.equals(x.data)) {
                    unlink(x);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        Object[] newArray = c.toArray();
        int newNumber = newArray.length;

        Node prev;
        Node temp;

        if (c.size() == size) {
            temp = null;
            prev = last;
        } else {
            temp = node(c.size());
            prev = temp.prev;
        }
        for (Object object : c){
            Node newNode = new Node(prev, object,null);
            if(prev == null){
                first=newNode;
            }else{
                prev.next = newNode;
                prev = newNode;
            }
            if(temp == null){
                last = prev;
            }else{
                prev.next = temp;
                temp.next = prev;
            }
            size += newNumber;
        }

        return true;
    }

    @Override
    public void clear() {
        for (Node x = first; x != null; x = x.next) {
            Node next = x.next;
            x.data = null;
            x.next = null;
            x.prev = null;
            x = next;
        }
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public boolean retainAll(Collection c) {
        MyList  list = new MyList();
        for (Node x = first; x != null; x = x.next){
            for (Object object : c) {
                if (x.data.equals(object)) {
                    list.add(object);
                }
            }
        }
        clear();
        for (Object object :c ){
            add(object);
        }
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        for (Node x = first; x != null; x = x.next)
            for (Object o : c) {
                if (o.equals(x.data)) {
                    remove(o);
                }
            }
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        for (Node x = first; x != null; x = x.next)
            for (Object o : c) {
                if (o.equals(x.data)) {
                    return true;
                }
            }
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        Object[] newArray = new Object[a.length];
        for (int i = 0; i < a.length; i++) {
            newArray[i] = a[i];
        }
        return newArray;
    }

    public String toString() {
        String result = "";
        Node current = first;
        while (current != null) {
            result += current.getData() + ", ";
            current = current.getNext();
        }
        if (!result.isEmpty()) {
            result = result.substring(0, result.length() - 2);
        }
        return "[" + result + "]";
    }

    private Object unlink(Node node) {
        Object element = node.data;
        Node next = node.next;
        Node prev = node.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            node.prev = null;
        }
        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            node.next = null;
        }
        node.data = null;
        size--;
        return element;
    }

    private Node node(int index) {
        Node result = first;
        if (index < (size >> 1)) {
            Node x = first;
            for (int i = 0; i < index; i++) {
                x = x.next;
                result = x;
            }
        } else {
            Node x = last;
            for (int i = 0; i > index; i--) {
                x = x.prev;
                result = x;
            }
        }
        return result;
    }


    private static class Node {
        protected Node prev;
        protected Object data;
        protected Node next;

        public Node(Node prev, Object data, Node next) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
        public Object getData() {
            return data;
        }
        public void setData(Object data) {
            this.data = data;
        }
        public Node getNext() {
            return next;
        }
        public void setNext(Node next) {
            this.next = next;
        }
        public Node getPrev() {
            return prev;
        }
        public void setPrev(Node prev) {
            this.prev = prev;
        }


    }
}

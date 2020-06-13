import java.util.*;

public class MyList implements List {
    private Object [] myList = new Object[0];
    @Override
    public int size() { return myList.length; }

    @Override
    public boolean isEmpty() { return myList.length == 0; }

    @Override
    public boolean contains(Object o) {
        boolean result = false;
        for (int i = 0; i  < myList.length ; i++) {
            if(myList[i].equals(o)){
                result = true;
            }
        }
        return result ;
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            private int index = 0;
            @Override
            public boolean hasNext() { return index < myList.length && myList[index] != null; }
            @Override
            public Object next() { return myList[index++]; }
        };
    }

    @Override
    public Object[] toArray() {
        return myList;
    }

    @Override
    public boolean add(Object o) {
        Object [] newArray = new Object[myList.length+1];
        for (int i = 0; i <myList.length ; i++) {
            newArray[i] = myList[i];
        }
        newArray[myList.length] = o;
        myList=newArray;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        MyList list = new MyList();
        for (int i = 0; i <myList.length ; i++) {
           if(myList[i].equals(o)){
               myList[i] = null;
           }else if(!(myList[i] == null)){
               list.add(myList[i]);
           }
        }
        myList = list.toArray();
        return true;
    }

    @Override
    public boolean addAll(Collection c) {
        Object [] collection = c.toArray();
        Object [] newArray = new Object[myList.length + c.size()];
        for (int i = 0; i <myList.length ; i++) {
            newArray[i] = myList[i];
        }
        for (int i = myList.length; i <newArray.length ; i++) {
            newArray[i] = collection[i - myList.length];
        }
        myList = newArray;
        return true;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        Object [] collection = c.toArray();
        MyList list = new MyList();
        for (int i = 0; i <myList.length ; i++) {
           list.add(myList[i]);
        }
        for (int i = myList.length+index; i <myList.length + c.size() ; i++) {
            list.add(collection[i - myList.length]);
        }
        myList = list.toArray();
        return false;
    }

    @Override
    public void clear() {
        Object[] newArray = {};
        myList = newArray;
    }

    @Override
    public Object get(int index) { return myList[index]; }

    @Override
    public Object set(int index, Object element) { return  myList[index] = element; }

    @Override
    public void add(int index, Object element) {
        Object[] newArray = new Object[myList.length+1];
        for (int i = 0; i <myList.length ; i++) {
            newArray[i] = myList[i];
        }
        newArray[index] = element;
        myList = newArray;
    }

    @Override
    public Object remove(int index) {
        MyList list = new MyList();
        for (int i = 0; i <myList.length ; i++) {
            if(i == index){
                myList[i] = null;
            }else if(!(myList[i] == null)){
                list.add(myList[i]);
            }
        }
        myList = list.toArray();
        return null;
    }

    @Override
    public int indexOf(Object o) {
        int index = 0;
        for (int i = 0; i <myList.length ; i++) {
            if(myList[i].equals(o)){
                index = i;
            }
        }
        return index;
    }

    @Override
    public int lastIndexOf(Object o) {
        int result = -1;
        for (int i = 0; i <myList.length; i++) {
            if(myList[i].equals(o)){
                result = i;
            }
        }
        return result;
    }

    @Override
    public ListIterator listIterator() {
        return new ListIter(0);
    }

    @Override
    public ListIterator listIterator(int index) {
        if(index >= size()){
            System.out.println("Out of bounds of array");
            System.exit(0);
        }
        return new ListIter(index);
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean retainAll(Collection c) {
        Object[] newArray = c.toArray();
        MyList list = new MyList();
        for (int i = 0; i <newArray.length; i++) {
            for (int j = 0; j <myList.length ; j++) {
                if(myList[j].equals(newArray[i])){
                    list.add(myList[j]);
                }
            }
        }
        clear();
        Object [] listArray = list.toArray();
        for (Object o : listArray) {
            add(o);
        }
        myList = listArray;
        return true;
    }

    @Override
    public boolean removeAll(Collection c) {
        Object[] newArray = c.toArray();
        for (int i = 0; i <newArray.length; i++) {
            for (int j = 0; j <myList.length ; j++) {
                if(myList[j].equals(newArray[i])){
                    remove(myList[j]);
                }
            }
        }
        return true;
    }

    @Override
    public boolean containsAll(Collection c) {
        boolean result = false;
        Object[] newArray = c.toArray();
        for (int i = 0; i <newArray.length; i++) {
            for (int j = 0 ; j <myList.length ; j++) {
                if(myList[j].equals(newArray[i])){
                    result = true;
                }
            }
        }
        return result;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return a;
    }

    @Override
    public String toString() {
        return "MyList{" +
                "myList=" + Arrays.toString(myList) +
                " size= "+ myList.length+
                '}';
    }
    private class ListIter implements ListIterator{
        int index;
        int previous = myList.length-1;
        public ListIter(int index) {
            this.index = index;
        }

        @Override
        public boolean hasNext() { return index < myList.length && myList[index] != null; }

        @Override
        public Object next() { return myList[index++]; }

        @Override
        public boolean hasPrevious() { return previous < myList.length & myList[previous] != myList[index] ; }

        @Override
        public Object previous() { return myList[previous--];}

        @Override
        public int nextIndex() { return index++; }

        @Override
        public int previousIndex() { return previous--; }

        @Override
        public void remove() {
            MyList.this.remove(index);
        }

        @Override
        public void set(Object o) {
            MyList.this.set(index, o);
        }

        @Override
        public void add(Object o) {
            MyList.this.add(o);
        }
    }
}


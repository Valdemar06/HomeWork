
import java.util.*;

public class ListGeneric<E> implements List<E> {

    private Object [] myList = new Object[0];

    @Override
    public int size() { return myList.length; }

    @Override
    public boolean isEmpty() { return myList.length == 0; }

    @Override
    public boolean contains(Object o) {
        if(o == null){return false;}
        for (Object object: myList) {
            if(object.equals(o)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < myList.length && myList[index] !=null;
            }

            @Override
            public E next() { return (E)myList[index++]; }
        };
    }

    @Override
    public Object[] toArray() {
        Object [] newList = new Object[myList.length];
        for (int i = 0; i <myList.length ; i++) {
            newList[i] = myList[i];
        }
        return newList;}

    @Override
    public <T> T[] toArray(T[] a) {
        if (a == null){ throw new RuntimeException("You cannot add here null");}
        for (int i = 0; i <size() ; i++) {
            Arrays.fill(a, (T) myList[i]);
        }
        return a;
    }

    @Override
    public boolean add(E e) {
        if(e == null){ throw new RuntimeException("You cannot add here null"); }
        Object[] newList =  new Object[myList.length+1];
        for (int i = 0; i <myList.length; i++) {
            newList[i] = myList[i];
        }
        newList[myList.length] = e;
        myList = newList;
        return true;
    }


    @Override
    public boolean remove(Object o) {
        if(o == null){ throw new RuntimeException("You cannot add here null"); }
       List list = new ListGeneric();
        for (int i = 0; i <myList.length ; i++) {
            if (myList[i].equals(o)){
                myList[i] =null;
            }else {
                list.add(myList[i]);
            }
        }
        myList = list.toArray();
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        if(c == null){ throw new RuntimeException("You cannot add here null"); }
        for (Object object: c) {
            for (Object list : myList)
            if (object.equals(list)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        if (c == null){ throw new RuntimeException("You cannot add here null"); }
        Object [] newList = c.toArray();
        Object [] newArray = new Object[c.size() + size()];
        for (int i = 0; i <myList.length ; i++) {
            newArray[i] = myList[i];
        }
        for (int i = myList.length; i <newArray.length ; i++) {
            newArray[i]= newList[i - myList.length];
        }
        myList = newArray;
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        if (c == null){ throw new RuntimeException("You cannot add here null");}
        if(index > size()){ throw new RuntimeException("Out bound of array"); }
        Object [] collection = c.toArray();
        ListGeneric list = new ListGeneric<>();
        for (int i = 0; i <myList.length ; i++) {
            list.add(myList[i]);
        }
        for (int i = myList.length + index; i <myList.length + c.size() ; i++) {
            list.add(collection[i-myList.length]);
        }
        myList = list.toArray();
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        if (c == null){ throw new RuntimeException("You cannot add here null"); }
        for (Object collection : c) {
            for (Object list : myList) {
                if (list.equals(collection)){
                    remove(list);
                }
            }

        }
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        if(c == null){ throw new RuntimeException("You cannot add here null"); }
        ListGeneric list = new ListGeneric();
        for (Object collection: c) {
            for (Object myList : myList) {
                if(myList.equals(collection)){ list.add(myList); }
            }
        }
        clear();
        for (Object element: list) {
            add((E) element);
        }
        return true;
    }

    @Override
    public void clear() {
        Object[] clearArray = new Object[0];
        myList = clearArray;
    }

    @Override
    public E get(int index) {
        if(index > size()){ throw new RuntimeException("Out bound of array"); }
        return (E)myList[index]; }

    @Override
    public E set(int index, E element) {
        if(element == null){ throw new RuntimeException("You cannot add here null"); }
        if(index > size()){ throw new RuntimeException("Out bound of array"); }
        return (E) (myList[index] = element); }

    @Override
    public void add(int index, E element) {
        if (element == null){ throw new RuntimeException("You cannot add here null"); }
        if(index > size()){ throw new RuntimeException("Out bound of array"); }
        Object [] newArray = new Object[size()+1];
        for (int i = 0; i <size() ; i++) {
            newArray[i] = myList[i];
        }
       while(newArray[index]==null){
           newArray[index] = element;
       }
        myList = newArray;
    }

    @Override
    public E remove(int index) {
        if(index > size()){ throw new RuntimeException("Out bound of array"); }
        List list = new ListGeneric();
        for (int i = 0; i <size() ; i++) {
            if(myList[i] == myList[index]){
                myList[i] = null;
            }else if(!(myList[i]==null)){
                list.add(myList[i]);
            }
        }
        myList = list.toArray();
        return null;
    }

    @Override
    public int indexOf(Object o) {
        if (o == null){ throw new RuntimeException("You cannot add here null");}
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
        if(o == null){ throw new RuntimeException("You cannot add here null");}
        int index = indexOf(o)-1;
        return index;
    }

    @Override
    public String toString() {
        return "{" +"Size = " + myList.length +
                ", myList =" + Arrays.toString(myList) + '}';
    }

    @Override
    public ListIterator<E> listIterator() { return new ListIter(0); }

    @Override
    public ListIterator<E> listIterator(int index) {
        if (index >= size()){
            throw  new RuntimeException("Out bound of array ");
        }
        return new ListIter(index);
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        ListGeneric newList = new ListGeneric();
        if(toIndex> size() | fromIndex > size()){
            throw  new RuntimeException("Out bound of array");
        }
        for (int i = fromIndex; i < toIndex; i++) {
            newList.add(myList[i]);
        }
        return newList;
    }

    public class ListIter implements ListIterator<E>{
        private int index = 0;
        int previous = myList.length-1;

        public ListIter(int index){
            this.index = index;
        }

        @Override
        public boolean hasNext() { return index< myList.length && myList[index] != null; }

        @Override
        public E next() { return (E) myList[index++]; }

        @Override
        public boolean hasPrevious() { return previous < myList.length && myList[previous] != myList[index]; }

        @Override
        public E previous() { return (E) myList[previous--]; }

        @Override
        public int nextIndex() { return index++; }

        @Override
        public int previousIndex() { return previous--; }

        @Override
        public void remove() { ListGeneric.this.remove(index); }

        @Override
        public void set(E e) { ListGeneric.this.set(index, e); }

        @Override
        public void add(E e) { ListGeneric.this.add(e); }
    }
}

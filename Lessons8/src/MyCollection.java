import java.util.Collection;
import java.util.Iterator;

public class MyCollection implements Collection {
    Object[] collection = new Object[0];

    @Override
    public int size() {
        return collection.length;
    }

    @Override
    public boolean isEmpty() {
        return collection.length == 0;
    }

    @Override
    public boolean contains(Object object) {
        boolean check = false;
        for (Object originObject : collection) {
            if (originObject.equals(object)) {
                check = true;
            }
        }
        return check;
    }


    @Override
    public Iterator iterator() {
        return new Iterator() {
            int index = 0;
            @Override
            public boolean hasNext() {
                return index < collection.length && collection[index] != null;
            }
            @Override
            public Object next() {
                return collection[index++];
            }
        };
    }

    @Override
    public Object[] toArray() {
        Object [] result = new Object[collection.length];
        for (int i = 0; i <collection.length ; i++) {
            result[i] = collection[i];
        }
        return result;
    }

    @Override
    public boolean add(Object object) {
        Object [] newArray = new Object[collection.length+1];
        for (int i = 0; i <collection.length ; i++) {
            newArray[i] = collection[i];
        }
        newArray[collection.length] = object;
        collection = newArray;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < collection.length ; i++) {
            if(collection[i].equals(o)){
                collection[i]= null;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection c) {
        Object[] newArray = new Object[collection.length + c.size()];
        for (int i = 0; i < collection.length; i++) {
            newArray[i] = collection[i];
        }
        for (int i = collection.length; i < newArray.length; i++) {
            newArray[i] = c;
        }
        collection = newArray;
        return false;
    }

    @Override
    public void clear() {
        Object [] newArray = new Object[0];
         collection=newArray;
    }

    @Override
    public boolean retainAll(Collection c) {
        Object[] newArray = new Object[c.size()];
        for (int i = 0; i < collection.length; i++) {
            for (int j = 0; j < c.size(); j++) {
                if(collection[i] == null){
                    collection[i] = " ";
                }
                if (collection[i].equals(c)) {
                    newArray[j] = collection[i];
                }
            }
        }
        collection = newArray;
        return true;
    }

    @Override
    public boolean removeAll(Collection c) {
        for (int i = c.size(); i < collection.length; i++) {
            if (collection[i].equals(c)) {
                collection[i] = "";
            }
        }
        return true;
    }

    @Override
    public boolean containsAll(Collection c) {
        boolean result = false;
        for (int i = c.size(); i < collection.length; i++) {
            if (collection[i].equals(c)) {
                result = true;
            }
        }
        return result;
    }

    @Override
    public Object[] toArray(Object[] a) {
        Object [] result = new Object[a.length];
        for (int i = 0; i <a.length ; i++) {
            result[i] = a[i];
        }
        return result;
    }
    public String print() {
        if (collection == null) { return "null"; }
        int iMax = collection.length - 1;
        if (iMax == -1) { return "[]"; }
        StringBuilder builder = new StringBuilder();
        builder.append('[');
        for (int i = 0; ; i++) {
            builder.append(collection[i]);
            if (i == iMax) {
                return builder.append(']').toString();
            }
            builder.append(", ");
        }
    }

}

public class MyCollection {
    private Object[] collection;

    public MyCollection(Object[] collection, int length) {
        this.collection = copy(collection);
        fill(length);
    }

    public int size() { return collection.length; }

    public boolean isEmpty() {
        boolean result = true;
        for (int i = 0; i < collection.length; i++) {
            if (collection[i] != null) {
                result = false;
            }
        }
        return result;
    }

    public Object[] addObject(Object object, int index) {
        collection[index] = object;
        return collection;
    }

    private Object [] fill(int size){
        Object[] newArray = new Object[size];
        for (int i = 0; i <collection.length ; i++) {
            for (int j = 0; j <newArray.length ; j++) {
                if (collection[i] == null) {
                    collection[i] = "";
                    newArray[j] = collection[i];
                }
            }
            collection=newArray;
        }
        return collection;
    }

    public void contains(Object object) {
        boolean check = false;
        for (Object originObject : collection) {
            if (originObject.equals(object)) {
                check = true;
            }
        }
        if (check) {
            System.out.println("Find object: " + object);
        } else {
            System.out.println("There is no such object");
        }
    }

    public Object[] clear() {
       Object [] newArray = new Object[0];
        return collection=newArray;
    }

    public void remove(Object object) {
        for (int i = 0; i < collection.length; i++) {
            if (collection[i].equals(object)) {
                collection[i] = null;
            }
        }
    }

    public Object[] addAllArray(Object[] arrayOutside) {
        Object[] newArray = new Object[collection.length + arrayOutside.length];
        for (int i = 0; i < collection.length; i++) {
            newArray[i] = collection[i];
        }
        for (int i = collection.length; i < newArray.length; i++) {
            newArray[i] = arrayOutside[i - collection.length];
        }
        collection = newArray;
        return collection;
    }

    public void removeAll(Object[] objects) {
        for (int i = objects.length; i < collection.length; i++) {
            if (collection[i].equals(objects[i - objects.length])) {
                collection[i] = "";
            }
        }
    }

    public boolean containsAll(Object[] objects) {
        boolean result = false;
        for (int i = objects.length; i < collection.length; i++) {
            if (collection[i].equals(objects[i - objects.length])) {
                result = true;
            }
        }
        return result;
    }

    public Object[] retailAll(Object[] outsideArray) {
        Object[] newArray = new Object[outsideArray.length];
        for (int i = 0; i < collection.length; i++) {
            for (int j = 0; j < outsideArray.length; j++) {
                if(collection[i] == null){
                    collection[i] = " ";
                }
                if (collection[i].equals(outsideArray[j])) {
                    newArray[j] = collection[i];
                }
            }
        }
        collection = newArray;
        return collection;
    }

    public Object[] copy(Object[] origin) {
        Object[] result = new Object[origin.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = origin[i];
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

    public Object[] getArray() { return copy(collection); }
}

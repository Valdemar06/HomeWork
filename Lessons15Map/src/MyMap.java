import java.util.*;

public class MyMap implements Map {
    private  int capacity = 16;
    private int size;
    private Entry[] data;

    public MyMap() {
        data = new Entry[capacity];
    }

    public MyMap(int capacity) {
        this.capacity = capacity;
        data = new Entry[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        int index = index(key);
        Entry entry = data[index];
            for (Entry first = entry; first!=null; first = first.next)
            if(first.getKey().equals(key)) {
                return true;
            }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        for (int i = 0; i <data.length ; i++) {
            for (Entry first =data[i]; first!=null; first = first.next){
                if (first.getValue().equals(value)){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Object get(Object key) {
        Object value = null;
        int index = index(key);
        Entry entry = data[index];
        while(entry!=null){
            if(entry.getKey().equals(key)){
                value = entry.getValue();
                break;
            }
            entry = entry.getNext();
        }
        return value;
    }

    @Override
    public Object put(Object key, Object value) {
        int index  = index(key);
        Entry newEntry = new Entry(key , value, null);
        if(data[index] == null){
            data[index] = newEntry;
        }else{
            Entry previousNode = null;
            Entry currentNode = data[index];
            while (currentNode!=null){
                if(currentNode.getKey().equals(key)){
                    currentNode.setValue(value);
                    break;
                }
                previousNode = currentNode;
                currentNode = currentNode.getNext();
            }
            if(previousNode!=null){
                previousNode.setNext(newEntry);
            }
        }
        size++;
        return data[index];
    }

    @Override
    public Object remove(Object key) {
        int index = index(key);
        Entry previous = null;
        Entry entry = data[index];
        while(entry!= null){
            if(entry.getKey().equals(key)){
                if (previous == null){
                    entry = entry.getNext();
                    data[index] = entry;
                }else{
                    previous.setNext(entry.getNext());
                }
                size--;
                return data[index];
            }
            previous = entry;
            entry = entry.getNext();
        }
        return data[index];
    }

    @Override
    public void putAll(Map m) {
        Set key = m.keySet();
        Collection value = m.values();
        for (Object objectKey: key) {
            for (Object objectValue: value) {
                put(objectKey, objectValue);
            }
        }
        size = size -2;
    }


    @Override
    public void clear() {
        size = 0;
        capacity = 0;
        data = null;
    }

    @Override
    public Set keySet() {
        Set set = new HashSet();
        for (Entry datum : data) {
            for (Entry entry = datum; entry != null; entry = entry.next) {
                set.add(entry.getKey());
            }
        }
        return set;
    }

    @Override
    public Collection values() {
        Collection collection = new ArrayList();
        for (Entry datum : data) {
            for (Entry entry = datum; entry != null; entry = entry.next) {
                collection.add(entry.getValue());
            }
        }
        return collection;
    }

    @Override
    public Set<Entry> entrySet() {
        Set<Entry> set = new HashSet();
        for (int i = 0; i <data.length ; i++) {
            set.add(data[i]);
        }
        return set;
    }
    private int index (Object key){
        if(key == null){
            return 0;
        }
        return Math.abs(key.hashCode()&capacity);
    }

    @Override
    public String toString() {
        String result = " ";
        for (int i = 0; i <data.length ; i++) {
            for (Entry entry = data[i]; entry!=null; entry = entry.next){
                System.out.println(entry.getKey() + " = " + entry.getValue());
            }
        }
        return result;
    }

    private static class Entry {
        private Entry next;
        private Object key;
        private Object value;

        public Entry( Object key, Object value,Entry next) {
            this.next = next;
            this.key = key;
            this.value = value;
        }

        public Entry getNext() { return next; }

        public void setNext(Entry next) { this.next = next; }

        public Object getKey() { return key; }

        public void setKey(Object key) { this.key = key; }

        public Object getValue() { return value; }

        public void setValue(Object value) { this.value = value; }

    }
}

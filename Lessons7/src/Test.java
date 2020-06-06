public class Test {
    public static void main(String[] args) {
        Object [] newArray = new Object[10];
        Object [] newArray2 = new Object[10];
        String object = "One";
        String  object2 = "TWo";
        MyCollection myCollection = new MyCollection(newArray,1);
        MyCollection collection = new MyCollection(newArray2,1);
        myCollection.addObject(object, 0);
        collection.addObject(object2, 0);
        collection.addAllArray(myCollection.getArray());
        System.out.println(collection.print());
        System.out.println(myCollection.print());
        collection.removeAll(myCollection.getArray());
        System.out.println(collection.print());
    }
}

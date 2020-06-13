public class Test {
    public static void main(String[] args) {
        Object [] newArray = new Object[0];
        Object [] newArray2 = new Object[1];
        String object = "One";
        String  object2 = "TWo";
        MyCollection myCollection = new MyCollection();
        MyCollection collection = new MyCollection();
        myCollection.addObject(object);
        collection.addObject(object2);
        /*collection.addAllArray(myCollection.getArray());
        System.out.println(collection.print());
        System.out.println(myCollection.print());
        collection.removeAll(myCollection.getArray());
        System.out.println(collection.print());*/
        System.out.println(myCollection.print());
        System.out.println(myCollection.size());
        myCollection.remove(object);
        System.out.println(myCollection.print());
        System.out.println(myCollection.size());
    }
}

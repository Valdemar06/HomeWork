public class Test {
    public static void main(String[] args) {
        int [] arrayFirst = new int [10];
        int [] arraySecond = new int [10];
        MyArray array = new MyArray(arrayFirst);
        MyArray array1 = new MyArray(arraySecond);
        array.addArray(5,0);
        array.addArray(4, 1);
        array.addArray(6,2);
        array1.addArray(5,0);
        array1.addArray(8,2);
        array1.addArray(9,4);
        array1.addArray(10, 3);
        array1.addArray(12, 5);
        array1.getNumber(0);
        System.out.println(array1.print());
        array.addAllArray(array1.getArray());
        System.out.println(array.print());
    }
}
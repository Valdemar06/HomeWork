import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int [] array = new int [1000];
        for (int i = 0; i <array.length ; i++) {
            array[i]=i;
        }
        HomeWork work = new HomeWork();
        System.out.println(Arrays.toString(array));
        System.out.println(work.binarySearch(array, 279));
        System.out.println(work.fibonacci(44));
    }
}

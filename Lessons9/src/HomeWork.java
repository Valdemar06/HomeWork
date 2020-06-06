public class HomeWork {

    public int binarySearch(int[] sortedArray, int key) {
        sort(sortedArray);
        int index = -1;
        int low = sortedArray[0];
        int high = sortedArray.length-1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (sortedArray[mid] < key) {
                low = mid + 1;
            } else if (sortedArray[mid] > key) {
                high = mid - 1;
            } else if (sortedArray[mid] == key) {
                index = mid;
                break;
            }
        }
        return index;
    }

    public int fibonacci(int n){
        if (n <= 1) return n;
        int previous = 0;
        int next = 1;
        int sum;

        for (int i = 2; i <= n; i++) {
            sum = previous;
            previous = next;
            next = sum + previous;
        }
        return next;
    }
    public int[] sort(int [] array) {
        for (int value = 1; value < array.length; value++) {
            if (array[value] < array[value - 1]) {
                swap(array, value, value - 1);
            }
            for (int valueSecond = value - 1; (valueSecond - 1) >= 0; valueSecond--) {
                if (array[valueSecond] < array[valueSecond - 1]) {
                    swap(array, valueSecond, valueSecond - 1);
                } else { break; }
            }
        }
        return array;
    }

    private int[] swap(int[] origin, int firstNumber, int secondNumber) {
        origin[firstNumber] = origin[firstNumber] + origin[secondNumber];
        origin[secondNumber] = origin[firstNumber] - origin[secondNumber];
        origin[firstNumber] = origin[firstNumber] - origin[secondNumber];
        return origin;
    }
}

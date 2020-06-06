public class MyArray {
    private int[] array;

    public MyArray(int[] array) {
        this.array = copy(array);
    }

    public void addArray (int number,int index) {
        array[index] = number;
    }

    public void getNumber(int index) {
        int number = array[index];
        System.out.println("Your index (" + index + ") number: " + number);
    }

    public void contains(int number) {
        boolean check = false;
        for (int value : array) {
            if (value == number) {
                check = true;
            }
        }
        if (check) {
            System.out.println("Find number: " + number);
        } else {
            System.out.println("There is no such number");
        }
    }

    public int[] copy(int[] origin) {
        int[] result = new int[origin.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = origin[i];
        }
        return result;
    }
    public void addAllArray(int[] arrayOutside) {
       int [] newArray = new int [array.length + arrayOutside.length];
        for (int i = 0; i <array.length ; i++) {
            newArray[i] = array[i];
        }
        for (int i = array.length; i <newArray.length ; i++) {
            newArray[i] = arrayOutside[i-array.length];
        }
        array= newArray;

    }

    public int[] clear() {
        for (int value = 0; value< array.length; value++) {
            array[value] = 0;
        }
        return array;
    }

    public boolean equals(int[] arraySecond) {
        if (array == arraySecond) { return true; }
        if (array == null || arraySecond == null) {
            return false;
        }
        return array.length == arraySecond.length;
    }

    public void getSize() {
        System.out.println("Size your array: " + copy(array).length);
    }

    public int find(int[] origin, int number) {
        boolean check = false;
        int index = 0;
        for (int value : origin) {
            if (origin[value] == number) {
                index = origin[value];
                check = true;
            }
        }
        if (check) { System.out.println("The number you searched for is by index: " + index);
        } else { System.out.println("There is no such number"); }
        return index;
    }

    public int[] sort() {
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

    public int [] getArray(){ return copy(array); }

    private int[] swap(int[] origin, int firstNumber, int secondNumber) {
        origin[firstNumber] = origin[firstNumber] + origin[secondNumber];
        origin[secondNumber] = origin[firstNumber] - origin[secondNumber];
        origin[firstNumber] = origin[firstNumber] - origin[secondNumber];
        return origin;
    }
    public String print() {
        if (array == null) {return "null";}
        int iMax = array.length - 1;
        if (iMax == -1) {return "[]";}

        StringBuilder builder = new StringBuilder();
        builder.append('[');
        for (int i = 0; ; i++) {
                builder.append(array[i]);
            if (i == iMax) {
                return builder.append(']').toString();
            }
            builder.append(", ");
        }
    }
}

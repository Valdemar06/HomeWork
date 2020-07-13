import java.io.Serializable;

public class Student implements Serializable {
    private int firstNumber;
    private int secondNumber;

    public Student(int firstNumber, int secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    public int getFirstNumber() { return firstNumber; }

    public void setFirstNumber(int firstNumber) { this.firstNumber = firstNumber; }

    public int getSecondNumber() { return secondNumber; }

    public void setSecondNumber(int secondNumber) { this.secondNumber = secondNumber; }

    @Override
    public String toString() {
        return "Student{" +
                "firstNumber='" + firstNumber + '\'' +
                ", secondNumber='" + secondNumber + '\'' +
                '}';
    }
}
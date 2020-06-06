import java.util.Arrays;

public class Student {
   private String surname;
   private  String name;
   private  int [] marks = new int [20];


    public Student(String surname, String name){
        if(surname == null | name == null){
            System.out.println("Name or surname can not be null");
            System.exit(0);
        }else {
            this.surname = surname;
            this.name = name;
        }
    }


    public Student[] addStudent (Student[] array, Student object, int number){
        array[number] = object;
        return array;
    }
    public Student[] deleteStudent(Student[] array, int number){
        array[number] = null;
        return array;
    }
    public void showInfo(Student [] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                continue;
            }else{
                System.out.println(array[i].surname + " " + array[i].name + "\t" + Arrays.toString(marks));
            }
        }
    }
    public int [] addMarks(int visit, int mark){
        marks[visit] = mark;
        return marks;
    }
    public int [] deleteMarks(int visit){
        marks[visit] = 0;
        return marks;
    }
    public Student [] deleteGroup(Student []array){
        Arrays.fill(array,null);
        return array;
    }
    public void searchStudent(Student [] array, Student object){
        boolean find = false;
        for(int i = 0; i < array.length; i ++) {
            if (array[i] == object) {
                find =true;
            }
        }
        if(find){
            System.out.println(object.toString());
        }else {
            System.out.println("Could not found ");
        }
    }
    public void sort(Student[] array){
        Arrays.toString(array);
        showInfo(array);
    }
}


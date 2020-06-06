import java.util.Arrays;

public class MagazineofMariaIvanovna {
    public static void main(String[] args) {
        String[] students = new String[5];
        int [] [] AK161 = new int [20][10];
        Arrays.fill(students, "Students");
        addStudent(students,0,"Vladimir","Kanyus");
        showInfo(students,AK161);

    }
    public static  void showInfo(String[] students, int[] [] arrays){
        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i] + ": " + (i+1));
            for (int  j = 0; j < arrays[i].length; j++){
                    System.out.print("Exercise "+j+ ": "+arrays[i][j]+"\t");
            }
            System.out.println();
        }
    }
    public static  String[] addStudent(String [] students, int number, String lastName, String firstName){
        students[number] = lastName+" "+firstName;
        return students;
    }
    public static int [] [] addStudentScore(int [] [] arrays, int visit, int number, int score){
        if(score<0){
            System.out.println("The journal cannot have negative numbers");
        }else {
            arrays[visit][number] = score;
        }
        return arrays;
    }
    public static  String[] deleteStudent(String [] students,String lastName, String firstName,int [][] arrays, int visit){
        String search = lastName + " " + firstName;
        for(int i = 0; i < students.length; i++) {
           if(search.equals(students[i])){
               students[i] = "Name";
           }
        }
        deleteAllScore(arrays,visit,students);
        return students;
    }
    public static int [][] deleteStudentScore(int [][] arrays,int visit, int number){
        arrays[visit][number] = 0;
        return arrays;
    }
    public static int [] [] deleteAllScore(int [] [] arrays, int visit,String [] students){
        for (int i = 0; i < students.length; i++) {
            arrays[visit][i] = 0;
        }
        return arrays;
    }
    public static void searchForName(String[] students,String lastName, String firstName){
        boolean find= false;
        String search = lastName + " " + firstName;
        for (String student : students) {
            if (search.equals(student)) {
                find = true;
            }
        }
     if(find){
         System.out.println("Find a student: " +"(" + search + ")");
    }else{
         System.out.println("Have not find: " + search );
     }
    }
    public static void sortMagazine(String [] students){
        Arrays.sort(students);
        System.out.println(Arrays.toString(students));
    }
}

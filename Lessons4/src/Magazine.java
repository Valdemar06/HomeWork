public class Magazine {
    public static void main(String[] args) {
        Student [] students = new Student[5];
        Student student1 = new Student("Ava", "Vlid");
        Student student2 = new Student("bp", "Kepa");
        Student student3 = new Student("cB", "Bk");
        Student student4 = new Student("FFFF", "FFF");
        student1.addStudent(students,student1, 3);
        student2.addStudent(students, student2, 0);
        student3.addStudent(students,student3,1);
        student1.showInfo(students);
    }
}

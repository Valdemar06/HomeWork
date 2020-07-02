import java.util.Objects;

public class Student {
    private int id;
    private String lastName;

    public Student(int id, String lastName) {
        this.id = id;
        this.lastName = lastName;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id &&
                Objects.equals(lastName, student.lastName);
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                '}';
    }


}

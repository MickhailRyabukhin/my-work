import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="students")
public class Student {
    //    Table: students
    //    Columns:
    //    id int UN AI PK
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;
    //    name varchar(45)
    private String name;
    //    age int UN
    private int age;
    //    registration_date datetime
    LocalDate registrationDate;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }
}

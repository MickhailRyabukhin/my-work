import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name="students")
public class Student {
    //    Table: students
    //    Columns:
    //    id int UN AI PK
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer studentId;
    //    name varchar(45)
//    @ManyToOne(cascade = CascadeType.ALL)
    private String name;
    //    age int UN
    private int age;
    //    registration_date datetime
    @Column(name = "registration_date")
    Date registrationDate;


    public Integer getStudentId() {
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

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }
}

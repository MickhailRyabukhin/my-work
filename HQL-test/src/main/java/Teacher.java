import javax.persistence.*;

@Entity
@Table(name = "Teachers")
public class Teacher {

//    Table: teachers
//    Columns:
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
//    id int UN AI PK
    private String name;
//    name varchar(45)
    private int salary;
//    salary int UN
    private int age;
//    age int UN

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

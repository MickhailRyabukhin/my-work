import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "courses")
public class Course {
    //    Table: courses Непосредственно из SQL skillbox
    //    Columns:
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //    id int UN AI PK
    private String name;
    //    name varchar(500)
    private Integer duration;
    //    duration int UN
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "enum")
    private CourseType type;
    //    type enum('DESIGN','PROGRAMMING','MARKETING','MANAGEMENT','BUSINESS')
    private String description;
    //    description varchar(500)

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Teacher teacher;
    //     int UN
    @Column(name = "students_count")
    private Integer studentsCount;
    //    students_count int UN
    private Integer price;

    public Integer getId() {
        return id;
    }

    //    price int UN
    @Column(name = "price_per_hour")
    private float pricePerHour;

    //    price_per_hour float
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Subscriptions",
            joinColumns = {@JoinColumn(name = "student_id")},
            inverseJoinColumns = {@JoinColumn(name = "course_id")}
            )



    private List<Student> students;

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public CourseType getType() {
        return type;
    }

    public void setType(CourseType type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    public void setTeacherId(Teacher teacher) {
        this.teacher = teacher;
    }

    public Integer getStudentsCount() {
        return studentsCount;
    }

    public void setStudentsCount(Integer studentsCount) {
        this.studentsCount = studentsCount;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public float getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(float pricePerHour) {
        this.pricePerHour = pricePerHour;
    }
}

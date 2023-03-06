import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;


@Embeddable
public class PurKey implements Serializable {
    public PurKey() {
    }

    public PurKey(String studentName, String courseName) {
        this.studentName = studentName;
        this.courseName = courseName;
    }

    @Column(name = "student_name",insertable = false, updatable = false)
    private String studentName;

    @Column(name = "course_name",insertable = false, updatable = false)

    private String courseName;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    @ColumnDefault("+++++++")
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    //setters, getters, equals(), hashcode()


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PurKey purKey = (PurKey) o;
        return studentName.equals(purKey.studentName) && courseName.equals(purKey.courseName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentName, courseName);
    }
}


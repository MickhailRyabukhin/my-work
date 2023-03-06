import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "subscriptions")
public class Subscription {
//    Table: subscriptions
@EmbeddedId
private SubKey id;
//    Columns:
    private int studentId;
//    student_id int UN PK
    private int courseId;
//    course_id int UN PK
    private LocalDate subscriptionDate;
//    subscription_date datetime

    public SubKey getId() {
        return id;
    }

    public void setId(SubKey id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public LocalDate getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(LocalDate subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }

}

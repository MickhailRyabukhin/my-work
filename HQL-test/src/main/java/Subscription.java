import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "subscriptions")
public class Subscription {
    //    Table: subscriptions
    @EmbeddedId
    private SubKey id;
    //    Columns:
    @Column(name = "student_id", insertable = false, updatable = false)
    private int studentId;
    //    student_id int UN PK
    @Column(name = "course_id", insertable = false, updatable = false)
    private int courseId;
    //    course_id int UN PK
    @Column(name = "subscription_date", insertable = false, updatable = false)
    private Date subscriptionDate;
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

    public Date getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(Date subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }

}

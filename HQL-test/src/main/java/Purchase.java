import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "purchaselist")
public class Purchase {
    //    Table: purchaselist
//    Columns:
    @EmbeddedId
    private PurKey id;

    @Column(name = "student_name",insertable = false, updatable = false)
    private String studentName;
    //    student_name varchar(500)
    @Column(name = "course_name",insertable = false, updatable = false)
    private String courseName;
    //    course_name varchar(500)
    private int price;
    //    price int
    @Column(name = "subscription_date")
    private Date subscriptionDate;

    public Purchase() {
    }

    public PurKey getId() {
        return id;
    }

    public void setId(PurKey id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(Date subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }
    //    subscription_date datetime
}

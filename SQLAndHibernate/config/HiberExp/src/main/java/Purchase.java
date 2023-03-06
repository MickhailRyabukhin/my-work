import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "purchaselist")
public class Purchase {
    //    Table: purchaselist
//    Columns:
    @EmbeddedId
    private PurKey id;

    @Column(name = "student_name")
    private String studentName;
    //    student_name varchar(500)
    @Column(name = "course_name")
    private String courseName;
    //    course_name varchar(500)
    private int price;
    //    price int
    @Column(name = "subscription_date")
    private LocalDate subscriptionDate;

    public Purchase() {
    }
//    subscription_date datetime
}

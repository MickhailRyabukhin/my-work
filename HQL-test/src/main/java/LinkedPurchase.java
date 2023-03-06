import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "LinkedPurchaseList")
public class LinkedPurchase {
    public LinkedPurchase(SubKey id) {
        this.id = id;
    }

    public LinkedPurchase() {
    }

    public LinkedPurchase(int studentId, int courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
    }

    //    Table: LinkedPurchaseList
    @EmbeddedId
    private SubKey id;
    //    Columns:
    @Column(name = "student_id", insertable = false, updatable = false)
    private int studentId;
    //    student_id int UN PK
    @Column(name = "course_id", insertable = false, updatable = false)
    private int courseId;
    //    course_id int UN PK




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


}
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {
//    private static final Logger logger = LogManager.getRootLogger();


    public static void main(String[] args) {

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();
        Course course = new Course();
        course.setName(" ");
        System.out.println("Название курса\t\t\tКоличество студентов");
        System.out.println("=================================================");
        Integer id = 1;
        while (true) {
            course = session.get(Course.class, id);

            if (course != null) {
                if (course.getStudentsCount() == null) {
                    System.out.println(id + "\t" + course.getName() + "\t Количество студентов неизвестно");
                } else {
                    System.out.println(id + "\t" + course.getName() + "\t" + course.getStudentsCount());
                }
            } else {
                break;
            }
            id++;
        }
        sessionFactory.close();
    }
}

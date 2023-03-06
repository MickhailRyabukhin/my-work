import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class Main {


    public static void main(String[] args) {
        // Подключение к базе данных, открытие сессии
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();

        // Использование Hibernate QueryBuilder
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Course> query = criteriaBuilder.createQuery(Course.class);
        Root<Course> root = query.from(Course.class);
        query.select(root);
        // Создаем запрос целиком таблицы Courses
        List<Course> courseList = session.createQuery(query).getResultList();

        System.out.println("===================== H Q L ======================");
        // Таблицу студентов получаем с помощью HQL запроса
        String hql = "From " + Student.class.getSimpleName();
        List<Student> studentList = session.createQuery(hql, Student.class).getResultList();

        // Открываем транзакцию
        Transaction transaction = session.beginTransaction();
        // Имеем два списка - студентов и курсов
        for (Student student : studentList) {
            //Получаем имя студента
            String studentName = student.getName();
            for (Course course : courseList) {
                // Получаем название курса
                String courseName = course.getName();
                // Создаем составной ключ PurKey (по имени студента и названию курса)
                PurKey purKey = new PurKey(studentName, courseName);
                // и с его помощью получаем строку из PurchaseList
                Purchase purchase = session.get(Purchase.class, purKey);
                // Если строка существует, выводим соответствующие поля
                if (purchase != null) {
                    // Проверяем, что запишется в таблицу
                    System.out.println(studentName + "\t" + student.getStudentId() + "\t" +
                            course.getId() + "\t" + courseName);
                    // Формируем составной ключ SubKey (номер студента - номер курса)
                    SubKey subKey = new SubKey(student.getStudentId(), course.getId());
                    // и передаем в конструктор строки таблицы LinkedPurchaseList
                    LinkedPurchase lp = new LinkedPurchase(subKey);
                    // Записываем полученную строку в таблицу (сохраняем в сессии)
                    session.save("LinkedPurchase", lp);
                }
            }
        }
        // После построения таблицы завершаем транзакцию
        transaction.commit();
        // и закрываем сессию
        sessionFactory.close();
    }
}

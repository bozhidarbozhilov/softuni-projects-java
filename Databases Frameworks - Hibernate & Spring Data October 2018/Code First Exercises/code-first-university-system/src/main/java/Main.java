import entities.BaseEntity;
import entities.Course;
import entities.Student;
import entities.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Set;

public class Main {
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("university_system");
        EntityManager em = emf.createEntityManager();

        Teacher teacher = new Teacher("Grigor", "Grigorov", "12345");
        Student student = new Student("Student", "Studentov", "345678");
        Student student1 = new Student("Student1", "Studentov1", "1345678");


        Course course = new Course();
        course.setName("Databases");
        course.setStudents(Set.of(student, student1));
        course.setTeacher(teacher);
        em.getTransaction().begin();
        em.persist(course);
        em.getTransaction().commit();
        em.close();
    }
}

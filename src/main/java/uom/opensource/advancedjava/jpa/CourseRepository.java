package uom.opensource.advancedjava.jpa;

import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Optional;
import java.util.Set;

@Component
public class CourseRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void createCourse(int id, String name, String code) {
        Course course = new Course().setId(id).setName(name).setCode(code);

        //        em.getTransaction().begin();
        em.persist(course);

        /*
            if(name.length()<5) em.getTransaction().rollback();
            else em.getTransaction().commit();
        * */
    }

    @Transactional
    public Optional<Course> findCourseByCode(int id) {
//        em.getTransaction().begin();
        Course course = em.find(Course.class, id);
//        em.getTransaction().commit();
        return Optional.ofNullable(course);
    }

    @Transactional
    public Set<Student> findRegisteredSudents(int id) {
        //        em.getTransaction().begin();
        Course course = em.find(Course.class, id);
//        em.getTransaction().commit();
        return course.getRegisteredUsers();
    }
}

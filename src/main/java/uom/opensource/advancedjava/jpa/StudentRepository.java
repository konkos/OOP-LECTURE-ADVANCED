package uom.opensource.advancedjava.jpa;

import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Optional;

@Component
public class StudentRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void createStudent(int id, String name) {
        Student student = new Student().setId(id).setName(name);

//        em.getTransaction().begin();
        em.persist(student);


        /*
            if(name.length()<5) em.getTransaction().rollback();
            else em.getTransaction().commit();
        */
    }

    @Transactional
    public Optional<Student> findStudentById(int id) {
//        em.getTransaction().begin();
        Student student = em.find(Student.class, id);
//        em.getTransaction().commit();
        return Optional.ofNullable(student);
    }

    @Transactional
    public void updateStudent(Student s, Course c) {
        Student student = em.find(Student.class, s.getId());
        student.registerToCourse(c);
    }

}

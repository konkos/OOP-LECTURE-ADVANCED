package uom.opensource.advancedjava.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements CommandLineRunner {

    Logger logger = LoggerFactory.getLogger(MyRunner.class);

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public void run(String... args) throws Exception {
        saveStudents();
        saveCourses();

        printStudents();
        printCourses();

        registerStudentToCourses();

        printStudents();
        printCourses();

    }

    private void registerStudentToCourses() {
        Student student1 = studentRepository.findStudentById(1).get();
        Student student2 = studentRepository.findStudentById(2).get();
        Student student3 = studentRepository.findStudentById(3).get();

        Course course1 = courseRepository.findCourseByCode(1).get();
        Course course2 = courseRepository.findCourseByCode(2).get();
        Course course3 = courseRepository.findCourseByCode(3).get();

        studentRepository.updateStudent(student1, course1);
        studentRepository.updateStudent(student2, course2);
        studentRepository.updateStudent(student3, course3);

    }

    private void printCourses() {
        Course course1 = courseRepository.findCourseByCode(1).get();
        Course course2 = courseRepository.findCourseByCode(2).get();
        Course course3 = courseRepository.findCourseByCode(3).get();

        logger.info(String.valueOf(course1));
        logger.info(String.valueOf(course2));
        logger.info(String.valueOf(course3));
    }

    private void printStudents() {
        Student student1 = studentRepository.findStudentById(1).get();
        Student student2 = studentRepository.findStudentById(2).get();
        Student student3 = studentRepository.findStudentById(3).get();

        logger.info(String.valueOf(student1));
        logger.info(String.valueOf(student2));
        logger.info(String.valueOf(student3));
    }

    private void saveStudents() {
        studentRepository.createStudent(1, "John 1");
        studentRepository.createStudent(2, "John 2");
        studentRepository.createStudent(3, "John 3");
    }

    private void saveCourses() {
        courseRepository.createCourse(1, "Object Oriented Programming", "DAI301");
        courseRepository.createCourse(2, "Algorithms", "DAI205");
        courseRepository.createCourse(3, "Linear Algebra", "DAI102");
    }
}

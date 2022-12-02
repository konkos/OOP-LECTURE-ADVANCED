package uom.opensource.advancedjava.streams.student;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> studentList = List.of(
                new Student("John", 5.0),
                new Student("Jane", 3.1),
                new Student("Jack", 9.3),
                new Student("Bob", 6.7),
                new Student("Mary", 2.5),
                new Student("Anna", 10.0),
                new Student("George", 4.7));

        //find a student that have a passing grade (gpa>=5)
        Student firstStudentThatPassed = studentList.stream().filter(student -> student.getGpa() >= 5).findFirst().get();
        System.out.println(firstStudentThatPassed);

        // find all students that have a passing grade
        List<Student> students = studentList.stream().filter(student -> student.getGpa() >= 5).toList();
        System.out.println(students);

        // find the average grade of the "class" [studentList]
        double classAvg = studentList.stream().mapToDouble(student -> student.getGpa()).average().getAsDouble();
        System.out.println("Class Average: " + classAvg);

        // find the average grade of the students that have a passing grade
        double passingGradeAvg = studentList.stream().filter(student -> student.getGpa() >= 5.0).mapToDouble(st -> st.getGpa()).average().getAsDouble();
        System.out.println("Average grade of the students that have a passing grade: " + passingGradeAvg);

        //find all students that have a passing grade and their name starts with "J"
        List<Student> jThatPassed = studentList.stream().filter(student -> student.getGpa() >= 5.0).filter(student -> student.getName().startsWith("J")).toList();
        System.out.println(jThatPassed);
    }
}

package uom.opensource.advancedjava.jpa;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Student {
    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @Column
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "course_like",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id"))
    private Set<Course> registerdCourses;

    public String getName() {
        return name;
    }

    public Student setName(String name) {
        this.name = name;
        return this;
    }

    public int getId() {
        return id;
    }

    public Student setId(int id) {
        this.id = id;
        return this;
    }

    public Set<Course> getRegisterdCourses() {
        return registerdCourses;
    }

    public void registerToCourse(Course c) {
        registerdCourses.add(c);
        c.addRegisteredStudent(this);
    }
}

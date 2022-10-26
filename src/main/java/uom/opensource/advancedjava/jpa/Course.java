package uom.opensource.advancedjava.jpa;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Course {
    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @Column
    private String name;

    @Column
    private String code;

    // https://www.baeldung.com/jpa-many-to-many

    @ManyToMany(mappedBy = "registerdCourses", fetch = FetchType.EAGER)
    private Set<Student> registeredUsers;


    public String getName() {
        return name;
    }

    public Course setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public Course setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getCode() {
        return code;
    }

    public Course setCode(String code) {
        this.code = code;
        return this;
    }

    public Set<Student> getRegisteredUsers() {
        return registeredUsers;
    }

    public void addRegisteredStudent(Student s) {
        registeredUsers.add(s);
    }
}

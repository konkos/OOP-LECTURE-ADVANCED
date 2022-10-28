package uom.opensource.advancedjava.records;

public class StudentDTO {

    private String name;
    private Double gpa;

    public StudentDTO(String name, Double gpa) {
        this.name = name;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public StudentDTO setName(String name) {
        this.name = name;
        return this;
    }

    public Double getGpa() {
        return gpa;
    }

    public StudentDTO setGpa(Double gpa) {
        this.gpa = gpa;
        return this;
    }
}

package uom.opensource.advancedjava.records;

public class Main {

    public static void main(String[] args) {
        StudentDTOrec studentDTOrec = new StudentDTOrec("record", 1.0);
        Double gpa = studentDTOrec.gpa();
        System.out.println(studentDTOrec);

        StudentDTO studentDTO = new StudentDTO("POJO", 1.0);
        System.out.println(studentDTO.toString());

    }
}

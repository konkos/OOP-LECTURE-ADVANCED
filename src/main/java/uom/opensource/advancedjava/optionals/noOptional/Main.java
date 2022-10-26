package uom.opensource.advancedjava.optionals.noOptional;

public class Main {

    public static void main(String[] args) {
        int i = 1;
        User user = DB.findById(i);
        if (user == null)
            System.out.println("USER NOT FOUND");
        else
            System.out.println(user);
    }
}
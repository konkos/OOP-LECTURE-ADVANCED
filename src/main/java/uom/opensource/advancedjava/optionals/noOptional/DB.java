package uom.opensource.advancedjava.optionals.noOptional;

public class DB {
    public static User findById(int i) {
        if (i < 5 && i > 0) return new User("FOUND");
        return null;
    }
}
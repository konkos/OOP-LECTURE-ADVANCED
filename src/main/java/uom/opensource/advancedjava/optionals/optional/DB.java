package uom.opensource.advancedjava.optionals.optional;

import java.util.Optional;

public class DB {
    public static Optional<User> findById(int i) {
        if (i < 5 && i > 0) return Optional.of(new User("FOUND"));
        return Optional.empty();
    }
}
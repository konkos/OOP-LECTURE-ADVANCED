package uom.opensource.advancedjava.optionals.optional2;

import uom.opensource.advancedjava.optionals.optional.DB;
import uom.opensource.advancedjava.optionals.optional.User;

import java.util.Optional;

public class Main {
    public static void main(String[] args) throws Exception {
        int i = -3;
        Optional<User> dbUser = DB.findById(i);
//        User user = byId.orElse(new User("UNDEFINED"));
//        User user = dbUser.orElseThrow(() -> new RuntimeException("NOT FOUND THE USER WITH ID " + i));
        System.out.println("user");
    }

}
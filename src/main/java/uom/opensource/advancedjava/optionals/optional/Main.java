package uom.opensource.advancedjava.optionals.optional;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        int i = 5;
        Optional<User> byId = DB.findById(i);
        if(byId.isPresent()) System.out.println(byId.get());
        else System.out.println("NOT FOUND");

    }
}
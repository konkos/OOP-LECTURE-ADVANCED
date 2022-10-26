package uom.opensource.advancedjava.generics;

import java.util.ArrayList;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        ArrayList genericList = new ArrayList();
        genericList.add(1);
        genericList.add("name");
        genericList.add(new Date());

        Object o = genericList.get(0);
        Integer integer = (Integer) genericList.get(1);

        ArrayList<Integer> numbersList = new ArrayList<>();
        numbersList.add(0);
        numbersList.add(1);

        FileWriter<Integer> integerFileWriter = new FileWriter<>(1, "integer");
        integerFileWriter.saveObj();
    }
}

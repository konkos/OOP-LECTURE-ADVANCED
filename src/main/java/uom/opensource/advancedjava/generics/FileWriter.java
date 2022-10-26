package uom.opensource.advancedjava.generics;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class FileWriter<T> {

    private final T objToSave;
    private final String fileName;

    public FileWriter(T objToSave, String fileName) {
        this.objToSave = objToSave;
        this.fileName = fileName;
    }

    public void saveObj() {
        File file = new File(fileName);

        try {
            FileOutputStream fouts = new FileOutputStream(file);
            ObjectOutputStream douts = new ObjectOutputStream(fouts);
            douts.writeObject(objToSave);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
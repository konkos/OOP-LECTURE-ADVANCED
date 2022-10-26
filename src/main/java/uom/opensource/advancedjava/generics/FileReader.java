package uom.opensource.advancedjava.generics;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class FileReader<T> {

    private final String fileName;
    private T objToRead;

    public FileReader(String fileName) {
        this.fileName = fileName;
    }

    public T readObj() throws IOException, ClassNotFoundException {
        File file = new File(fileName);
        FileInputStream fins = new FileInputStream(file);
        ObjectInputStream dins = new ObjectInputStream(fins);
        objToRead = (T) dins.readObject();
        return objToRead;
    }
}
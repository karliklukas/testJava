package persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Storage {

    private final String FILEPATH = "./storage";

    public void store(Object object) {
        File storage = new File(FILEPATH);
        storage.mkdir();

        File classFolder = new File(storage.getAbsolutePath() + "/" + object.getClass().getName());
        classFolder.mkdir();

        File objectFile = new File(classFolder + "/" + object.hashCode());
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(objectFile));
            objectOutputStream.writeObject(object);

        } catch (IOException ex) {
            System.err.println("File output err.");
        }

        try {
            objectOutputStream.close();
        } catch (IOException ex) {
            System.err.println("File not closed.");
        }

    }

    public void unstore(Object object) {
        File storage = new File(FILEPATH);

        File classFolder = new File(storage.getAbsolutePath() + "/" + object.getClass().getName());

        File objectFile = new File(classFolder + "/" + object.hashCode());
        objectFile.delete();
    }

    public <T> List<T> load(Class<T> clazz) {
        File storage = new File(FILEPATH);
        File classFolder = new File(storage.getAbsolutePath() + "/" + clazz.getName());

        List<T> list = new ArrayList<>();
        File[] files = classFolder.listFiles();

        for (File file : files) {
            ObjectInputStream objectInputStream = null;
            try {
                objectInputStream = new ObjectInputStream(new FileInputStream(file));
                list.add((T) objectInputStream.readObject());
            } catch (IOException ex) {
                System.err.println("File err.");
            } catch (ClassNotFoundException ex) {
                System.err.println("Class not found err.");
            }

            try {
                objectInputStream.close();
            } catch (IOException ex) {
                System.err.println("File not closed.");
            }
        }

        return list;
    }

}

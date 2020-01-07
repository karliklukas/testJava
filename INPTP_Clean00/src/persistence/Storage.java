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

    public void store(Object object) {
        File storage = new File("./storage");
        storage.mkdir();

        File classFolder = new File(storage.getAbsolutePath() + "/" + object.getClass().getName());
        classFolder.mkdir();

        File objectFile = new File(classFolder + "/" + object.hashCode());
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(objectFile));
            objectOutputStream.writeObject(object);
            objectOutputStream.close();
        } catch (IOException ex) {
            System.err.println("File output err.");
        }

    }

    public void unstore(Object object) {
        File storage = new File("./storage");

        File classFolder = new File(storage.getAbsolutePath() + "/" + object.getClass().getName());

        File objectFile = new File(classFolder + "/" + object.hashCode());
        objectFile.delete();
    }

    public <T> List<T> load(Class<T> clazz) {
        File storage = new File("./storage");
        File classFolder = new File(storage.getAbsolutePath() + "/" + clazz.getName());

        List<T> list = new ArrayList<>();
        File[] files = classFolder.listFiles();

        for (File file : files) {
            ObjectInputStream ois = null;
            try {
                ois = new ObjectInputStream(new FileInputStream(file));
            } catch (IOException ex) {
            }
            try {
                list.add((T) ois.readObject());
            } catch (IOException ex) {
            } catch (ClassNotFoundException ex) {
            }
            try {
                ois.close();
            } catch (IOException ex) {
            }
        }

        return list;
    }

}

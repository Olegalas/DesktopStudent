package controller.serialisation;

import model.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dexter on 24.12.16.
 */
public class StudentSerializer {

    private final static String FILE_NAME = "student.data";

    public static void save(List<Student> students){
        try (FileOutputStream outputStream = new FileOutputStream(FILE_NAME);
            ObjectOutputStream oos = new ObjectOutputStream(outputStream)) {

            oos.writeObject(students);

        } catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public static List<Student> init(){
        try (FileInputStream inputStream = new FileInputStream(FILE_NAME);
             ObjectInputStream ois = new ObjectInputStream(inputStream)) {

            List<Student> students = (List<Student>) ois.readObject();
            return students;
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return new ArrayList<>();
    }


}

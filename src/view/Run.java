package view;

import model.Degree;
import model.Student;
import model.Teacher;

/**
 * Created by dexter on 16.12.16.
 */
public class Run {

    public static void main(String[] args) {

//        new MainFrame();

        Student s1 = new Student("1", 1, 1, new Teacher("1", 1, Degree.DEFAULT, 1));
        Student s2 = new Student("1", 1, 1, new Teacher("1", 1, Degree.DEFAULT, 1));

        Student s3 = Student.getInstance();
        Student s4 = Student.getInstance();


        System.out.println(s1.equals(s2));
    }

}

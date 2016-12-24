package controller;

import model.Degree;
import model.Student;
import model.Teacher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dexter on 17.12.16.
 */
public class StudentManager implements Manager<Student> { // is a

    private static final StudentManager MANAGER = new StudentManager();

    private Map<String, Integer> rows = new HashMap<>();
    private List<Student> students = new ArrayList<>();

    private StudentManager(){
        // FOR TESTS
        students.add(new Student("1", 1, 1, new Teacher("1", 1, Degree.DEFAULT, 1)));
        students.add(new Student("2", 2, 2, new Teacher("2", 2, Degree.DEFAULT, 2)));
        students.add(new Student("3", 3, 3, new Teacher("3", 3, Degree.DEFAULT, 3)));
        students.add(new Student("4", 4, 4, new Teacher("4", 4, Degree.DEFAULT, 4)));
    }

    public static StudentManager getInstance(){
        return MANAGER;
    }

    public void save(Student student) {
        students.add(student);
    }

    public void remove(int i) {
        students.remove(i);
    }

    public Student search(int i) {
        return students.get(i);
    }

    public Student edit(int i,Student student) {
        Student toReturn = students.get(i);
        students.set(i, student);
        return toReturn;
    }

    public List<Student> getAll() {
        return students;
    }

    public Map<String, Integer> getRows() {
        return rows;
    }
}

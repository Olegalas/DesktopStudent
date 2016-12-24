package controller.manager;

import controller.serialisation.StudentSerializer;
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
    private List<Student> students = StudentSerializer.init();

    private StudentManager(){
    }

    public static StudentManager getInstance(){
        return MANAGER;
    }

    public void save(Student student) {
        students.add(student);
        StudentSerializer.save(students);
    }

    public void remove(int i) {
        students.remove(i);
        StudentSerializer.save(students);
    }

    public Student search(int i) {
        return students.get(i);
    }

    public Student edit(int i,Student student) {
        Student toReturn = students.get(i);
        students.set(i, student);
        StudentSerializer.save(students);
        return toReturn;
    }

    public List<Student> getAll() {
        return students;
    }

    public Map<String, Integer> getRows() {
        return rows;
    }
}

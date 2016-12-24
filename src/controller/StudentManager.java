package controller;

import model.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dexter on 17.12.16.
 */
public class StudentManager implements Manager<Student> { // is a

    private static final StudentManager MANAGER = new StudentManager();

    private Map<String, Student> students = new HashMap<>();



    private StudentManager(){}

    public static StudentManager getInstance(){
        return MANAGER;
    }

    public void save(Student student) {
        students.put(student.name, student);
    }

    public void remove(String name) {
        students.remove(name);
    }

    public Student search(String name) {
        return students.get(name);
    }

    public Student edit(String name,Student student) {
        Student toReturn = student;
        if(students.containsKey(name)){
            toReturn = students.get(name);
            students.put(student.name, student);
        }
        return toReturn;
    }

    public List<Student> getAll() {
        List<Student> studentList = new ArrayList<>();
        for(Student student : students.values()){
            studentList.add(student);
        }
        return studentList;
    }
}

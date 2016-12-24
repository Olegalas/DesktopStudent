package controller.manager;

import model.Student;
import model.Teacher;

import java.util.List;
import java.util.Map;

/**
 * Created by dexter on 17.12.16.
 */
public class TeacherManager implements Manager<Teacher>{

    @Override
    public void save(Teacher person) {

    }

    @Override
    public void remove(int i) {

    }

    @Override
    public Student search(int i) {
        return null;
    }

    @Override
    public Student edit(int i, Teacher person) {
        return null;
    }

    @Override
    public List<Teacher> getAll() {
        return null;
    }

    @Override
    public Map<String, Integer> getRows() {
        return null;
    }
}

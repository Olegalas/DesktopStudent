package controller;

import model.Student;

import java.util.List;
import java.util.Map;

/**
 * Created by dexter on 17.12.16.
 */

public interface Manager<T> {

    void save(T person);
    void remove(int i);
    Student search(int i);
    Student edit(int i, T person);
    List<T> getAll();
    Map<String, Integer> getRows();

}

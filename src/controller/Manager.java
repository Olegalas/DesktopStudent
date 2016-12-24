package controller;

import model.Student;

import java.util.List;

/**
 * Created by dexter on 17.12.16.
 */

public interface Manager<T> {

    void save(T person);
    void remove(String name);
    Student search(String name);
    Student edit(String name, T person);
    List<T> getAll();

}

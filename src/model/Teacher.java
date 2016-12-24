package model;

import java.io.Serializable;

import static model.Degree.DEFAULT;

/**
 * Created by dexter on 16.12.16.
 */
public class Teacher implements Serializable{

    private static final Teacher DEFAULT_INSTANCE = new Teacher("set name", -1, DEFAULT, -1);

    public final String name;
    public final int age;
    public Degree degree;
    public int salary;

    public Teacher(String name, int age, Degree degree, int salary){
        this.name = name;
        this.age = age;
        this.degree = degree;
        this.salary = salary;
    }

    public static Teacher getInstance(){
        return DEFAULT_INSTANCE;
    }

    public String toString() {
        return String.format("Teacher. Name - %s; Age - %s; Degree - %s; Salary %s.", name, age, degree, salary);
    }
}

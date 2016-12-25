package model;

import java.io.Serializable;

/**
 * Created by dexter on 16.12.16.
 */
public class Student implements Serializable, Cloneable{

    private static final Student DEFAULT_STUDENT = new Student("enter name", -1, -1, Teacher.getInstance());

    public final String name;
    public final int age;
    public final double averageGrade;
    public final Teacher teacher; // student has a teacher

    public Student(String name, int age, double averageGrade, Teacher teacher){
        this.name = name;
        this.age = age;
        this.averageGrade = averageGrade;
        this.teacher = teacher;
    }

    public Student(Student s){
        this.name = s.name;
        this.age = s.age;
        this.averageGrade = s.averageGrade;
        this.teacher = new Teacher(s.teacher.name, s.teacher.age, s.teacher.degree, s.teacher.salary);
    }

    public static Student getInstance(){
        return DEFAULT_STUDENT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (age != student.age) return false;
        if (Double.compare(student.averageGrade, averageGrade) != 0) return false;
        if (name != null ? !name.equals(student.name) : student.name != null) return false;
        return teacher != null ? teacher.equals(student.teacher) : student.teacher == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        temp = Double.doubleToLongBits(averageGrade);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (teacher != null ? teacher.hashCode() : 0);
        return result;
    }

    public String toString(){
        return String.format("Student. Name - %s; Age %d; AverageGrade - %.1f; %s", name, age, averageGrade, teacher);
    }

    public final static class StudentBuilder {
        private String name;
        private int age;
        private double averageGrade;
        private Teacher teacher;

        public StudentBuilder() {
        }

        public StudentBuilder setName(String name){
            this.name = name;
            return this;
        }

        public StudentBuilder setAge(int age){
            this.age = age;
            return this;
        }

        public StudentBuilder setAverageGrade(double averageGrade){
            this.averageGrade = averageGrade;
            return this;
        }

        public StudentBuilder setTeacher(Teacher teacher){
            this.teacher = teacher;
            return this;
        }

        public Student build(){
            return new Student(name, age, averageGrade, teacher);
        }

    }

}

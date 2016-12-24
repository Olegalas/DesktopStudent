package model;

/**
 * Created by dexter on 16.12.16.
 */
public class Student {

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

    public static Student getInstance(){
        return DEFAULT_STUDENT;
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

package view;

import controller.Manager;
import controller.StudentManager;
import model.Student;

import javax.swing.table.AbstractTableModel;
import java.util.HashMap;
import java.util.Map;
import java.util.jar.Attributes;

/**
 * Created by dexter on 18.12.16.
 */
class TableModel extends AbstractTableModel {

    private Manager<Student> manager = StudentManager.getInstance();


    public int getRowCount() {
        return manager.getAll().size();
    }

    public int getColumnCount() {
        return 7;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Student student = manager.getAll().get(rowIndex);
        ColumnName name = ColumnName.getColumnName(columnIndex);
        switch (name){
            case NAME : {
                manager.getRows().put(student.name, rowIndex);
                return student.name;
            }
            case AGE : return student.age;
            case AVERAGE_GRADE: return student.averageGrade;
            case TEACHER : return student.teacher.name;
            case TEACHER_AGE : return student.teacher.age;
            case DEGREE : return student.teacher.degree;
            case SALARY : return student.teacher.salary;
            default: return "";
        }
    }

    public String getColumnName(int columnIndex){
        ColumnName name = ColumnName.getColumnName(columnIndex);
        switch (name){
            case NAME: return ColumnName.NAME.name();
            case AGE: return ColumnName.AGE.name();
            case AVERAGE_GRADE: return ColumnName.AVERAGE_GRADE.name();
            case TEACHER: return ColumnName.TEACHER.name();
            case TEACHER_AGE: return ColumnName.TEACHER_AGE.name();
            case DEGREE: return ColumnName.DEGREE.name();
            case SALARY: return ColumnName.SALARY.name();
        }
        return "*";
    }

    enum ColumnName{
        NAME,
        AGE,
        AVERAGE_GRADE,
        TEACHER,
        TEACHER_AGE,
        DEGREE,
        SALARY,
        DEFAULT;

        private static Map<Integer, ColumnName> map = new HashMap<>();

        static {
            map.put(NAME.ordinal(), NAME);
            map.put(AGE.ordinal(), AGE);
            map.put(AVERAGE_GRADE.ordinal(), AVERAGE_GRADE);
            map.put(TEACHER.ordinal(), TEACHER);
            map.put(TEACHER_AGE.ordinal(), TEACHER_AGE);
            map.put(DEGREE.ordinal(), DEGREE);
            map.put(SALARY.ordinal(), SALARY);
        }

        private static ColumnName getColumnName(int i){
            if(map.containsKey(i)){
                return map.get(i);
            }
            return DEFAULT;
        }

    }

}

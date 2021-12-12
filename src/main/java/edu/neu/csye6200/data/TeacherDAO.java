package edu.neu.csye6200.data;

import edu.neu.csye6200.models.Student;
import edu.neu.csye6200.models.Teacher;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class TeacherDAO extends DatabaseConnector{

    private static final String TABLE_NAME = "teacher";

    public void insertTeacher(Teacher teacher){
        String sql = "INSERT INTO "+TABLE_NAME+" (age, first_name, last_name, date, credits, salary, track_student_record, parents_first_name, parents_last_name, address) VALUES(?,?,?,?,?,?,?,?,?,?)";
        try {
            this.openConnection();
            PreparedStatement preparedStatement = this.openConnection().prepareStatement(sql);
            preparedStatement.setInt(2, teacher.getAge());
            preparedStatement.setString(3, teacher.getFirst_Name());
            preparedStatement.setString(4, teacher.getLast_name());
            preparedStatement.setString(5, teacher.getDate());
            preparedStatement.setInt(6, teacher.getCredits());
            preparedStatement.setInt(7, teacher.getSalary());
            preparedStatement.setString(8, teacher.getTrack_Student_Record());
            preparedStatement.setString(9, teacher.getParents_First_Name());
            preparedStatement.setString(10, teacher.getParents_Last_Name());
            preparedStatement.setString(11, teacher.getParents_First_Name());
            preparedStatement.setString(12, teacher.getAddress());
            preparedStatement.execute();
            this.closeConnection();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Teacher> get(){
        String sql = "Select * from "+ TABLE_NAME;
        List<Teacher> list = new ArrayList<>();
        try {

            PreparedStatement preparedStatement = this.openConnection().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Teacher teacher =  new Teacher();

                teacher.setId(resultSet.getInt(1));
                teacher.setAge(resultSet.getInt(2));
                teacher.setFirst_Name(resultSet.getString(3));
                teacher.setLast_name(resultSet.getString(4));
                teacher.setDate(resultSet.getString(5));
                teacher.setCredits(resultSet.getInt(6));
                teacher.setSalary(resultSet.getInt(7));
                teacher.setTrack_Student_Record(resultSet.getString(8));
                teacher.setParents_First_Name(resultSet.getString(9));
                teacher.setParents_Last_Name(resultSet.getString(10));
                teacher.setAddress(resultSet.getString(10));

            }
            resultSet.close();
            this.closeConnection();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}

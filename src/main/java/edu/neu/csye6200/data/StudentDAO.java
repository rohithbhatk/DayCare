package edu.neu.csye6200.data;

import edu.neu.csye6200.models.Student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO extends DatabaseConnector {

    private static final String TABLE_NAME = "student";

    public void insertStudent(Student student) {
        String sql = "INSERT INTO " + TABLE_NAME + " ( first_name, last_name, age, gender, grade, group_id, parent_last_name, parent_first_name, address, dob ) VALUES(?,?,?,?,?,?,?,?,?,?)";
        try {
            this.openConnection();
            PreparedStatement preparedStatement = this.openConnection().prepareStatement(sql);
            preparedStatement.setString(1, student.getFirst_Name());
            preparedStatement.setString(2, student.getLast_name());
            preparedStatement.setInt(3, student.getAge());
            preparedStatement.setString(4, student.getGender());
            preparedStatement.setInt(5, student.getGrade());
            preparedStatement.setInt(6, student.getGroupId());
//            preparedStatement.setInt(7, student.get());
            preparedStatement.setInt(6, student.getGroupId());
            preparedStatement.setInt(2, student.getAge());
            preparedStatement.setString(3, student.getGender());
            preparedStatement.setInt(4, student.getGrade());
            preparedStatement.setInt(5, student.getGroupId());

            preparedStatement.execute();
            this.closeConnection();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }


    }

    public List<Student> get(){
        String sql = "Select * from "+ TABLE_NAME;
        List<Student> list = new ArrayList<>();
        try {
            this.openConnection();
            PreparedStatement preparedStatement = this.openConnection().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Student student =  new Student();

                student.setName(resultSet.getString(2));
                student.setAge(resultSet.getInt(3));
                student.setGender(resultSet.getString(4));
                student.setGrade(resultSet.getInt(5));
                student.setGroupId(resultSet.getInt(6));
            }
            resultSet.close();
            this.closeConnection();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}

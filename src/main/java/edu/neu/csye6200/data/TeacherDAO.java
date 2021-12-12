package edu.neu.csye6200.data;

import edu.neu.csye6200.models.Teacher;

import java.sql.PreparedStatement;
import java.sql.SQLException;



public class TeacherDAO extends DatabaseConnector{

    private static final String TABLE_NAME = "teacher";

    public void insertTeacher(Teacher teacher){
        String sql = "INSERT INTO "+TABLE_NAME+" (name, age, gender) VALUES(?,?,?)";
        try {
            this.openConnection();
            PreparedStatement preparedStatement = this.openConnection().prepareStatement(sql);
            preparedStatement.setInt(2, teacher.getAge());
            preparedStatement.execute();
            this.closeConnection();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

}

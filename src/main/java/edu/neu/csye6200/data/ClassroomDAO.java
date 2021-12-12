package edu.neu.csye6200.data;

import edu.neu.csye6200.models.ClassRoom;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClassroomDAO extends DatabaseConnector{

    private static final String TABLE_NAME = "classroom";

    public void createClassroom(){
        String sql = "INSERT INTO "+TABLE_NAME + " (`description`) VALUES(?)";
        try {
            this.openConnection();
            PreparedStatement preparedStatement = this.openConnection().prepareStatement(sql);
            preparedStatement.setString(1,"here");
            preparedStatement.execute();
            this.closeConnection();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            this.closeConnection();
        }
    }

    public List<ClassRoom> get(){
        String sql = "Select * from "+ TABLE_NAME;
        List<ClassRoom> list = new ArrayList<>();
        try {
            this.openConnection();
            PreparedStatement preparedStatement = this.openConnection().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                ClassRoom classRoom =  new ClassRoom();
//                classRoom.setId(resultSet.getInt(1));
//                classRoom.setDescription(resultSet.getString("classroom_id"));
                list.add(classRoom);
            }
            resultSet.close();
            this.closeConnection();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
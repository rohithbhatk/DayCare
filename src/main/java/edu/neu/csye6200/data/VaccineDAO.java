package edu.neu.csye6200.data;
import edu.neu.csye6200.models.ClassRoom;
import edu.neu.csye6200.models.Vaccine;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VaccineDAO extends DatabaseConnector{

    private static final String TABLE_NAME = "vaccine";

    public void insertVaccine(Vaccine vaccine){
        String sql = "INSERT INTO "+TABLE_NAME + " (vaccine_name, dose2, dose3, dose4) VALUES(?, ?, ?, ?)";
        try {
            this.openConnection();
            PreparedStatement preparedStatement = this.openConnection().prepareStatement(sql);
            preparedStatement.setString(1,vaccine.getVaccine_name());
            preparedStatement.setInt(2,vaccine.getDose1());
            preparedStatement.setInt(3,vaccine.getDose2());
            preparedStatement.setInt(4,vaccine.getDose3());
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
//                classRoom.setId(resultSet.getString(1));
//                classRoom.getString(resultSet.getString(1));
//                classRoom.getString(resultSet.getString(1));
//                classRoom.getString(resultSet.getString(1));
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


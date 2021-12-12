package edu.neu.csye6200.data;

import edu.neu.csye6200.models.Vaccine;
import edu.neu.csye6200.models.VaccineStatus;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VaccineStatusDAO extends DatabaseConnector{

    private static final String TABLE_NAME = "vaccine_status";

    public void insertVaccine(VaccineStatus vaccineStatus){
        String sql = "INSERT INTO "+TABLE_NAME + " (vaccine_id, student_id, date) VALUES(?, ?, ?, ?)";
        try {
            this.openConnection();
            PreparedStatement preparedStatement = this.openConnection().prepareStatement(sql);
            preparedStatement.setInt(1,vaccineStatus.getVaccineId());
            preparedStatement.setInt(2,vaccineStatus.getStudentId());
            preparedStatement.setString(3,vaccineStatus.getDate());
            this.closeConnection();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            this.closeConnection();
        }
    }

    public List<VaccineStatus> get(){
        String sql = "Select * from "+ TABLE_NAME;
        List<VaccineStatus> list = new ArrayList<>();
        try {
            this.openConnection();
            PreparedStatement preparedStatement = this.openConnection().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                VaccineStatus vaccineStatus =  new VaccineStatus();

                preparedStatement.setInt(1,vaccineStatus.getVaccineId());
                preparedStatement.setInt(2,vaccineStatus.getStudentId());
                preparedStatement.setString(3,vaccineStatus.getDate());


                vaccineStatus.setVaccineId(resultSet.getInt(1));
                vaccineStatus.setStudentId(resultSet.getInt(2));
                vaccineStatus.setDate(resultSet.getString(3));

                list.add(vaccineStatus);
            }
            resultSet.close();
            this.closeConnection();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}


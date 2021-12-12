package edu.neu.csye6200.data;

import edu.neu.csye6200.models.Vaccine;
import edu.neu.csye6200.models.VaccineStatus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VaccineStatusDAO extends DatabaseConnector{

    private static final String TABLE_NAME = "vaccine_status";

    public void insertStudentVaccine(VaccineStatus vaccineStatus){
        String sql = "INSERT INTO "+TABLE_NAME + " (vaccine_id, student_id, date) VALUES(?, ?, ?)";
        try {
            this.openConnection();
            PreparedStatement preparedStatement = this.openConnection().prepareStatement(sql);
            preparedStatement.setInt(1,vaccineStatus.getVaccineId());
            preparedStatement.setInt(2,vaccineStatus.getStudentId());
            preparedStatement.setString(3,vaccineStatus.getDate());
            preparedStatement.execute();
            preparedStatement.close();
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

    public String  getVaccineStatusStudent(int id, Connection connection){

        String sql = "Select v.id, v.vaccine_name, vs.date as vaccine_date from vaccine v left join vaccine_status vs on vs.vaccine_id = v.id  and vs.student_id=? order by v.id";
//        List<VaccineStatus> list = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            StringBuilder sb = new StringBuilder();
            while (resultSet.next()){
                sb.append(resultSet.getString("vaccine_date")).append(",");
            }
            resultSet.close();
            return sb.toString();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";
    }

    public String getStudentVaccinationCount(int vaccineId, int studentId){
        String sql = "Select date from "+TABLE_NAME+" where id = ? and student_id = ? limit 1";
        try {
            PreparedStatement preparedStatement = this.openConnection().prepareStatement(sql);
            preparedStatement.setInt(1,vaccineId);
            preparedStatement.setInt(2, studentId);
            ResultSet resultSet = preparedStatement.executeQuery();
            String result = null;
            while (resultSet.next()){
                result = resultSet.getString(1);
            }
            preparedStatement.close();
            this.closeConnection();
            return result;
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    public void insertStudentVaccine(int studentId, int vaccineId, String date){
        String previousVaccinationDates = this.getStudentVaccinationCount(vaccineId,studentId);
        if (previousVaccinationDates!=null){
            this.updateStudentVaccinationStatus(studentId,vaccineId,previousVaccinationDates+";"+date);
            return;
        }
        this.insertStudentVaccine(new VaccineStatus(vaccineId,studentId,date));
    }

    public void updateStudentVaccinationStatus(int studentId, int vaccineId, String date){
        String sql = "Update "+TABLE_NAME+" set date = ? where id = ? and student_id = ?";
        try {
            PreparedStatement preparedStatement = this.openConnection().prepareStatement(sql);
            preparedStatement.setInt(2,vaccineId);
            preparedStatement.setInt(3,studentId);
            preparedStatement.setString(1,date);
            preparedStatement.execute();
            preparedStatement.close();
            this.closeConnection();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }
}


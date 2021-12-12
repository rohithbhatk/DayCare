package edu.neu.csye6200.data;

import com.mysql.cj.log.NullLogger;
import edu.neu.csye6200.controller.Vaccination;
import edu.neu.csye6200.models.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO extends DatabaseConnector {

    private static final String TABLE_NAME = "student";

    public void insertStudent(Student student) {
        String sql = "INSERT INTO " + TABLE_NAME + " ( first_name, last_name, age, gender, grade, parent_first_name, parent_last_name, address, dob, date_of_joining ) VALUES(?,?,?,?,?,?,?,?,?,?)";
        try {
            this.openConnection();
            PreparedStatement preparedStatement = this.openConnection().prepareStatement(sql);

            preparedStatement.setString(1, student.getFirst_Name());
            preparedStatement.setString(2, student.getLast_name());
            preparedStatement.setInt(3, student.getAge());
            preparedStatement.setString(4, student.getGender());
            preparedStatement.setString(5, student.getGrade());
//            preparedStatement.setInt(6, student.getGroupId());

            preparedStatement.setString(6, student.getParents_First_Name());
            preparedStatement.setString(7, student.getParents_Last_Name());
            preparedStatement.setString(8, student.getAddress());
            preparedStatement.setString(9, student.getDate());
            preparedStatement.setString(10, student.getDate_of_joining());


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

                student.setId(resultSet.getInt(1));
                student.setFirst_Name(resultSet.getString(2));
                student.setAge(resultSet.getInt(3));
                student.setGender(resultSet.getString(4));
                student.setGrade(resultSet.getString(5));
                student.setGroupId(resultSet.getInt(6));
                student.setLast_name(resultSet.getString(7));
                student.setParents_First_Name(resultSet.getString(8));
                student.setParents_Last_Name(resultSet.getString(9));
                student.setAddress(resultSet.getString(10));
                student.setDate(resultSet.getString(11));
                student.setDate_of_joining(resultSet.getString(12));

                list.add(student);
            }
            resultSet.close();
            this.closeConnection();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<String> getStudentString(){
        String sql = "Select * from "+ TABLE_NAME;
        VaccineStatusDAO vaccineStatusDAO = new VaccineStatusDAO();
        List<String> list = new ArrayList<>();
        try {
            Connection connection = this.openConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){

                StringBuilder sb = new StringBuilder();

                sb.append(resultSet.getInt("id")).append(",");
                sb.append(resultSet.getString("first_name"))
                        .append(" ")
                        .append(resultSet.getString("last_name"))
                        .append(',');
                sb.append(resultSet.getString("gender")+',');
                sb.append(resultSet.getInt("age")).append(',');
                sb.append(resultSet.getString("grade")+',');
                sb.append(resultSet.getString("date_of_joining")+',');
                sb.append(resultSet.getString(8)).append(',');
                sb.append(resultSet.getString(9)+',');
                sb.append(resultSet.getString(10)+',');
                sb.append(resultSet.getString(11)+',');
                sb.append(resultSet.getString(12)+',');
                sb.append(vaccineStatusDAO.getVaccineStatusStudent(resultSet.getInt("id"), connection));
                list.add(sb.toString().replaceAll("null","NA"));
            }
            resultSet.close();
            this.closeConnection();
            return list;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return list;
    }



//    public static void main(String[] args) {
//
////        VaccineStatusDAO vaccineStatusDAO = new VaccineStatusDAO();
////        vaccineStatusDAO.insertStudentVaccine(1,1,"12/01/2021");
////        vaccineStatusDAO.insertStudentVaccine(1,2,"12/01/2021");
////        vaccineStatusDAO.insertStudentVaccine(1,1,"12/08/2021");
//
//        StudentDAO studentDAO = new StudentDAO();
//        List<String> strings = studentDAO.getStudentString();
//        System.out.println(strings);
//
//        Vaccination vaccination = new Vaccination();
//        Student student = new Student(0, 25, "Akhil","Sirra","12/12/20","M", vaccination, "A", 1, "Parentname", "Sirra", "99 Washington st", "08/08/2021");
//        studentDAO.insertStudent(student);
//        List<Student>  student_list = studentDAO.get();
//        for(int i=0;i<student_list.size();i++){
//            System.out.println(student_list.get(i));
//        }
//    }


}

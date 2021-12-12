package edu.neu.csye6200.data;

import edu.neu.csye6200.controller.Vaccination;
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
            preparedStatement.setInt(1, teacher.getAge());
            preparedStatement.setString(2, teacher.getFirst_Name());
            preparedStatement.setString(3, teacher.getLast_name());
            preparedStatement.setString(4, teacher.getDate());
            preparedStatement.setInt(5, teacher.getCredits());
            preparedStatement.setInt(6, teacher.getSalary());
            preparedStatement.setString(7, teacher.getTrack_Student_Record());
            preparedStatement.setString(8, teacher.getParents_First_Name());
            preparedStatement.setString(9, teacher.getParents_Last_Name());
            preparedStatement.setString(10, teacher.getAddress());
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

    public static void main(String[] args) {

        TeacherDAO teacherDAO = new TeacherDAO();

        Vaccination vaccination = new Vaccination();
//     public Teacher(int id, int age, String first_Name, String last_name,  String date, String gender, int credits, int salary, String track_Student_Record, String parents_first_name, String parents_last_name, String address) {

            Teacher teacher = new Teacher(0, 26, "Akhil","Sirra","12/12/20","M", 4, 100, "A", "Sirra", "Akira", "100 Heath St");
        teacherDAO.insertTeacher(teacher);
//        List<Student>  student_list = studentDAO.get();
//        for(int i=0;i<student_list.size();i++){
//            System.out.println(student_list.get(i));
//        }
    }

}

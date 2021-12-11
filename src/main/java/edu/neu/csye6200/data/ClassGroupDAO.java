package edu.neu.csye6200.data;

import edu.neu.csye6200.models.ClassGroup;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClassGroupDAO extends DatabaseConnector{

    private static final String TABLE_NAME = "class_group";

    public void insertClassGroup(int classroomId, int teacherId){
        String sql = "INSERT INTO "+TABLE_NAME+" (classroom_id, teacher_id) VALUES(?,?)";
        try {
            this.openConnection();
            PreparedStatement preparedStatement = this.openConnection().prepareStatement(sql);
            preparedStatement.setInt(1, classroomId);
            preparedStatement.setInt(2, teacherId);

            preparedStatement.execute();
            this.closeConnection();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public List<ClassGroup> get(){
        String sql = "Select * from "+ TABLE_NAME;
        List<ClassGroup> list = new ArrayList<>();
        try {
            this.openConnection();
            PreparedStatement preparedStatement = this.openConnection().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                ClassGroup classGroup =  new ClassGroup();
                classGroup.setGroupId(resultSet.getInt(1));
                classGroup.setClassroomId(resultSet.getInt("classroom_id"));
                classGroup.setTeacherId(resultSet.getInt("teacher_id"));
                list.add(classGroup);
            }
            resultSet.close();
            this.closeConnection();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args) {
        ClassGroupDAO classGroupDAO = new ClassGroupDAO();
        classGroupDAO.insertClassGroup(1,1);
        classGroupDAO.insertClassGroup(1,2);
        classGroupDAO.get().forEach(group->{
            System.out.println(group.getGroupId());
        });
    }

}


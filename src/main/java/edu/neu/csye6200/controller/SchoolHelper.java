package edu.neu.csye6200.controller;


import edu.neu.csye6200.models.Student;
import edu.neu.csye6200.models.Teacher;
import edu.neu.csye6200.utils.FileUtil;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class SchoolHelper {
    private static final ClassRoomController classroom = new ClassRoomController();
    private static Object[][] classrooms;

    public static void demo() throws Exception {
//        School school = SchoolFactory.getInstance().getObject();
        // Implementing Design Pattern
        String line = "";
        String splitBy = ",";
        String student_filename = "src/main/resources/students.txt";
        String teacher_filename = "src/main/resources/teachers.txt";
        try (BufferedReader bufferReader = FileUtil.openBufferedReader(FileUtil.openFileReader(student_filename))) {

            while ((line = FileUtil.readBufferedReader(bufferReader)) != null)   //returns a Boolean value
            {
                Student student = Student.createStudentFromCSV(line);

                School.addStudent(student);
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try (BufferedReader bufferReader = FileUtil.openBufferedReader(FileUtil.openFileReader(teacher_filename))) {

            while ((line = FileUtil.readBufferedReader(bufferReader)) != null)   //returns a Boolean value
            {
                Teacher teacher = Teacher.createTeacherFromCSV(line);
                School.addTeacher(teacher);
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void setClassrooms() {
        classrooms = new Object[6][10];


        //check if classroom[1][i] is full
//        if (i == 10) {
//            System.out.println("CLASS ROOM MAX SIZE REACHED");
//        }
        // age 6-12 4X3
        Queue<Teacher> teachers = new LinkedList<>(School.teacherRoster);
        Queue<Student> students = new LinkedList<>(School.studentRoster);

        int i = 1;
        while(!students.isEmpty()) {
            Map<Teacher, ArrayList<Student>> actualHashMap = classroom.createGroup(4, 3, teachers, students);
            classrooms[1][i] = actualHashMap;
            i++;
        }

//        actualHashMap.forEach((key, value) -> {
//            value.forEach(v -> {
//                System.out.println("Actual Hash Map: " + v.getFirst_Name() + " " + v.getLast_name());
//            });
//        });
//        if ((actualHashMap.keySet().size() * (actualHashMap.values().size())) > 12) {
//            classrooms[1][i] = actualHashMap;
//            i++;
//        } else {
//            classrooms[1][i] = actualHashMap;
//        }
    }

    public static Object[][] getClassrooms() {
        return classrooms;

    }
}




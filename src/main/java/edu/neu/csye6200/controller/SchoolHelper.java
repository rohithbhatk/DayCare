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
import java.util.stream.Collectors;

public class SchoolHelper {
    private static final ClassRoomController classroom = new ClassRoomController();
    private static Object[][] classrooms;

    public static void demo() throws Exception {
        String line = "";
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

    public static void setClassrooms() throws Exception {
        classrooms = new Object[6][10];

        Queue<Teacher> teachers = new LinkedList<>(School.teacherRoster);

        Queue<Student> students1 = new LinkedList<>(School.studentRoster.stream().filter(o -> o.getAge() >= 6 && o.getAge() <= 12).collect(Collectors.toList()));
        Queue<Student> students2 = new LinkedList<>(School.studentRoster.stream().filter(o -> o.getAge() >= 13 && o.getAge() <= 24).collect(Collectors.toList()));
        Queue<Student> students3 = new LinkedList<>(School.studentRoster.stream().filter(o -> o.getAge() >= 25 && o.getAge() <= 35).collect(Collectors.toList()));
        Queue<Student> students4 = new LinkedList<>(School.studentRoster.stream().filter(o -> o.getAge() >= 36 && o.getAge() <= 47).collect(Collectors.toList()));
        Queue<Student> students5 = new LinkedList<>(School.studentRoster.stream().filter(o -> o.getAge() >= 48 && o.getAge() <= 59).collect(Collectors.toList()));
        Queue<Student> students6 = new LinkedList<>(School.studentRoster.stream().filter(o -> o.getAge() >= 60).collect(Collectors.toList()));


        int i = 0;
        // age 6-12 4X3
        while (!students1.isEmpty() && i < 10) {
            Map<Teacher, ArrayList<Student>> actualHashMap = classroom.createGroup(4, 3, teachers, students1);
            classrooms[0][i] = actualHashMap;
            i++;
        }
        if(i == 10 && !students1.isEmpty()) throw new Exception("Too many students in age 6-12 (months) group.");
        // age 13-24 5X3
        i = 0;
        while (!students2.isEmpty() && i < 10) {
            Map<Teacher, ArrayList<Student>> actualHashMap = classroom.createGroup(5, 3, teachers, students2);
            classrooms[1][i] = actualHashMap;
            i++;
        }
        if(i == 10 && !students2.isEmpty()) throw new Exception("Too many students in age 13-24 (months) group.");
        // age 25-35 6X3
        i = 0;
        while (!students3.isEmpty() && i < 10) {
            Map<Teacher, ArrayList<Student>> actualHashMap = classroom.createGroup(6, 3, teachers, students3);
            classrooms[2][i] = actualHashMap;
            i++;
        }
        if(i == 10 && !students3.isEmpty()) throw new Exception("Too many students in age 25-35 (months) group.");
        // age 36-47 8X3
        i = 0;
        while (!students4.isEmpty() && i < 10) {
            Map<Teacher, ArrayList<Student>> actualHashMap = classroom.createGroup(8, 3, teachers, students4);
            classrooms[3][i] = actualHashMap;
            i++;
        }
        if(i == 10 && !students1.isEmpty()) throw new Exception("Too many students in age 36-47 (months) group.");
        // age 48-59 12X2
        i = 0;
        while (!students5.isEmpty() && i < 10) {
            Map<Teacher, ArrayList<Student>> actualHashMap = classroom.createGroup(12, 2, teachers, students5);
            classrooms[4][i] = actualHashMap;
            i++;
        }
        if(i == 10 && !students1.isEmpty()) throw new Exception("Too many students in age 48-59 (months) group.");
        // age 60 up 15X2
        i = 0;
        while (!students6.isEmpty() && i < 10) {
            Map<Teacher, ArrayList<Student>> actualHashMap = classroom.createGroup(15, 2, teachers, students6);
            classrooms[5][i] = actualHashMap;
            i++;
        }
        if(i == 10 && !students1.isEmpty()) throw new Exception("Too many students in age 60 (months) group.");


    }

    public static Object[][] getClassrooms() {
        return classrooms;

    }
}




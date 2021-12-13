package edu.neu.csye6200.controller;

// Using LAMBDA Functions for LOGIN
import edu.neu.csye6200.models.Person;
import edu.neu.csye6200.models.Student;
import edu.neu.csye6200.models.Teacher;

import java.util.Optional;
import java.util.Queue;

public class LoginCredentials {
    boolean isLogged = false;
    String logged_in_Person;
    boolean isStudent = false;
    String password;
    public LoginCredentials(String logged_in_Person, boolean isStudent) {

    }

    public static boolean isValidTeacherLogin(Queue<Teacher> persons, String userName, String lastName){
        return persons.stream().anyMatch(person -> {
            if (person.getFirst_Name().equals(userName)){
                return person.getLast_name().equals(lastName);
            }
            return false;
        });
    }

    public static boolean isValidStudentLogin(Queue<Student> persons, String userName, String lastName){
        return persons.stream().anyMatch(person -> {
            if (person.getFirst_Name().equals(userName)){
                return person.getLast_name().equals(lastName);
            }
            return false;
        });
    }


    public static void login(String username, String lastName){
        boolean isValidLogin = isValidTeacherLogin(School.teacherRoster,username,lastName);
        boolean isTeacher = isValidLogin;

        if(!isValidLogin) isValidLogin = isValidStudentLogin(School.studentRoster,username,lastName);


    }

    public static int getidTeacher( Queue<Teacher> teacherRoster, String firstName, String lastName) {
        Optional<Teacher> teacherOptional = teacherRoster.stream().filter(teacher ->
                (firstName.equals(teacher.getFirst_Name()) && lastName.equals(teacher.getLast_name()))).findAny();

        return teacherOptional.map(Person::getId).orElse(-1);
    }

    public static int getidStudent( Queue<Student> studentRoster, String firstName, String lastName) {
        Optional<Student> studentOptional = studentRoster.stream().filter(student ->
                (firstName.equals(student.getFirst_Name()) && lastName.equals(student.getLast_name()))).findAny();

        return studentOptional.map(Person::getId).orElse(-1);
    }

//    public static Teacher getidStudent( Queue<Teacher> teacherRoster, String firstName, String lastName;) {
//        Optional<Teacher> teacherRes =  teacherRoster.stream().filter(teacher ->
//                (firstName.equals(teacher.getFirst_Name()) && lastName.equals(teacher.getLast_name()))).findFirst();
//
//        return teacherRes.orElse(null);
//    }

    public void logout(){
        // We are not creating Session. If the person is on Login page, it means its logged out.
    }
}

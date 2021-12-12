package edu.neu.csye6200.controller;

// Using LAMBDA Functions for LOGIN
import edu.neu.csye6200.models.Person;
import edu.neu.csye6200.models.Student;
import edu.neu.csye6200.models.Teacher;

import java.util.Queue;

public class LoginCredentials {
    boolean isLogged = false;
    String logged_in_Person;
    boolean isStudent = false;
    String password;
    public LoginCredentials(String logged_in_Person, boolean isStudent) {

    }

    private boolean isValidTeacherLogin(Queue<Teacher> persons, String userName, String lastName){
        return persons.stream().anyMatch(person -> {
            if (person.getFirst_Name().equals(userName)){
                return person.getLast_name().equals(lastName);
            }
            return false;
        });
    }

    private boolean isValidStudentLogin(Queue<Student> persons, String userName, String lastName){
        return persons.stream().anyMatch(person -> {
            if (person.getFirst_Name().equals(userName)){
                return person.getLast_name().equals(lastName);
            }
            return false;
        });
    }


    public void login(String username, String lastName){
        boolean isValidLogin = this.isValidTeacherLogin(School.teacherRoster,username,lastName);
        boolean isTeacher = isValidLogin;

        if(!isValidLogin) isValidLogin = this.isValidStudentLogin(School.studentRoster,username,lastName);


    }

    public void logout(){
        // We are not creating Session. If the person is on Login page, it means its logged out.
    }
}

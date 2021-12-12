package edu.neu.csye6200.controller;

import edu.neu.csye6200.models.Student;
import edu.neu.csye6200.models.Teacher;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class School {

	public static Queue<Teacher> teacherRoster = new LinkedList<>();
	public static Queue<Student> studentRoster = new LinkedList<>();

	public Queue<Teacher> getTeacher() {
		return teacherRoster;
	}
	public void setTeacher(Queue<Teacher> teacher) {
		this.teacherRoster = teacher;
	}
	public Queue<Student> getStudent() {
		return studentRoster;
	}
	public void setStudent(Queue<Student> student) {
		this.studentRoster = student;
	}

	public School(Vector<Teacher> teacher, Vector<Student> student) {
		super();
		this.studentRoster= new LinkedList<>();
		this.teacherRoster=new LinkedList<>();
	}

	public void addStudent(Student std) {

		studentRoster.add(std);
	}

	public void addTeacher(Teacher tea) {

		teacherRoster.add(tea);
	}

	@Override
	public String toString() {
		return "School lo teacher=" + teacherRoster + ", student=" + studentRoster + "]";
	}
	public School() {
		// default constructor
		this.studentRoster= new LinkedList<>();
		this.teacherRoster=new LinkedList<>();
	}


//comprises of Teachers and Students satisfying the conditions
/*
Age (months) Group_Size Ratio_(Student:Teacher) Max_Groups/Room
6-12 			 4 		        4:1 					3
13-24			 5 				5:1 					3
25-35 			 6 				6:1 					3
36-47 			 8 				8:1 					3
48-59 			12 				12:1 					2
60 on up 		15 				15:1 					2
*/


}

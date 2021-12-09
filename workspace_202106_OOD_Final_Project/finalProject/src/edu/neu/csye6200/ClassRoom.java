package edu.neu.csye6200;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class ClassRoom {
private int capacity;
Queue<Teacher> teacherRoster = new LinkedList<>();
Queue<Student> studentRoster = new LinkedList<>();

public int getCapacity() {
	return capacity;
}

public void setCapacity(int capacity) {
	this.capacity = capacity;
}
public Queue<Teacher> getTeacher() {
	return teacherRoster;
}
public void setTeacher(Queue<Teacher> teacher) {
	this.teacherRoster = teacher;
}
public Queue<Teacher> getStudent() {
	return teacherRoster;
}
public void setStudent(Queue<Student> student) {
	this.studentRoster = student;
}

public ClassRoom(int capacity, Vector<Teacher> teacher, Vector<Student> student) {
	super();
	this.capacity = capacity;
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
	return "ClassRoom [capacity=" + capacity + ", teacher=" + teacherRoster + ", student=" + studentRoster + "]";
}
public ClassRoom() {
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


public void room() {
	//ClassRoom classroom = new ClassRoom();
	System.out.println(this.getTeacher());
	System.out.println(this.getStudent());
	
}


}

package edu.neu.csye6200.models;

import edu.neu.csye6200.controller.Vaccination;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Teacher extends Person {
	private int credits;
	private int salary;
	private String track_Student_Record;

	public Teacher(int id, String name){
		super(id, name);

	}
	public Teacher(int id, int age, String first_Name, String last_name,
				   String date, String gender,
				   int credits, int salary, String track_Student_Record, String parents_first_name, String parents_last_name, String address) {
		super(id, age, first_Name, last_name, date, gender, parents_first_name, parents_last_name, address);
		this.credits = credits;
		this.salary = salary;
		this.track_Student_Record = track_Student_Record;
	}

	public Teacher() {

	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}


	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getTrack_Student_Record() {
		return track_Student_Record;
	}

	public void setTrack_Student_Record(String track_Student_Record) {
		this.track_Student_Record = track_Student_Record;
	}



	public static Teacher createTeacherFromCSV(String std) {
		String[] data = std.split(",");

		Teacher tea = null;
		try {
			tea = new Teacher(Integer.parseInt(data[0]), Integer.parseInt(data[1]), data[2], data[3], "", data[4], 0, 0, "", "", "", "");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tea;
	}

	@Override
	public String toString() {
		return "Teacher [credits=" + credits + ", id=" + getId() + ", salary=" + salary + ", track_Student_Record="
				+ track_Student_Record + ", Age = " + getAge() + ", First_Name = "
				+ getFirst_Name() + ", Last_name = " + getLast_name() + ", Date = " + getDate() + ", Gender = "
				+ getGender() + ", EventRegistration = " + getEventRegistration() + "]\n";
	}

}

package edu.neu.csye6200.models;

import java.util.Scanner;

public class Teacher extends Person {
	private int credits;
	private Double salary;
	private String track_Student_Record;

	public Teacher(int id, String name){
		super(id, name);

	}
	public Teacher(int id, int age, String name, String first_Name, String last_name,
				   String date, String gender, Vaccination immunization_Records,
				   int credits, Double salary, String track_Student_Record, String parents_first_name, String parents_last_name, String address) {
		super(id, age, name, first_Name, last_name, date, gender, immunization_Records, parents_first_name, parents_last_name, address);
		this.credits = credits;
		this.salary = salary;
		this.track_Student_Record = track_Student_Record;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}


	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String getTrack_Student_Record() {
		return track_Student_Record;
	}

	public void setTrack_Student_Record(String track_Student_Record) {
		this.track_Student_Record = track_Student_Record;
	}



	public static Teacher createTeacherFromCSV(String std) {
		Scanner sn = new Scanner(std);
		sn.useDelimiter(",");
		Teacher tea = null;
		tea = new Teacher(sn.nextInt(), sn.next());
		//to-do
		sn.close();
		return tea;

	}

	@Override
	public String toString() {
		return "Teacher [credits=" + credits + ", id=" + getId() + ", salary=" + salary + ", track_Student_Record="
				+ track_Student_Record + ", Age = " + getAge() + ", Name = " + getName() + ", First_Name = "
				+ getFirst_Name() + ", Last_name = " + getLast_name() + ", Date = " + getDate() + ", Gender = "
				+ getGender() + ", EventRegistration = " + getEventRegistration() + "]\n";
	}

}

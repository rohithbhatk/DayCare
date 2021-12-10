package edu.neu.csye6200;

import java.util.Scanner;

public class Teacher extends Person {
	private int credits;
	private String id;
	private Double salary;
	private String track_Student_Record;

	public Teacher(int age, String name, String first_Name, String last_name, String date, String gender,
			Vaccination immunization_Records, int credits, String id, Double salary, String track_Student_Record) {
		super(age, name, first_Name, last_name, date, gender, immunization_Records);
		this.credits = credits;
		this.id = id;
		this.salary = salary;
		this.track_Student_Record = track_Student_Record;
	}

	public Teacher(int age, String name, String first_Name, String last_name, String date, String gender, int credits,
			String id, Double salary) {
		super(age, name, first_Name, last_name, date, gender);
		this.credits = credits;
		this.id = id;
		this.salary = salary;
		this.track_Student_Record = track_Student_Record;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public Teacher(int age, String name, String first_Name, String last_name, String date, String gender, int credits,
			String id, Double salary, String track_Student_Record) {
		super(age, name, first_Name, last_name, date, gender);
		this.credits = credits;
		this.id = id;
		this.salary = salary;
		this.track_Student_Record = track_Student_Record;
	}

	public static Teacher createTeacherFromCSV(String std) {
		Scanner sn = new Scanner(std);
		sn.useDelimiter(",");
		Teacher tea = null;
		tea = new Teacher(sn.nextInt(), sn.next(), sn.next(), sn.next(), sn.next(), sn.next(), sn.nextInt(), sn.next(),
				sn.nextDouble(), sn.next());
		sn.close();
		return tea;

	}

	@Override
	public String toString() {
		return "Teacher [credits=" + credits + ", id=" + id + ", salary=" + salary + ", track_Student_Record="
				+ track_Student_Record + ", Age = " + getAge() + ", Name = " + getName() + ", First_Name = "
				+ getFirst_Name() + ", Last_name = " + getLast_name() + ", Date = " + getDate() + ", Gender = "
				+ getGender() + ", EventRegistration = " + getEventRegistration() + "]\n";
	}

}

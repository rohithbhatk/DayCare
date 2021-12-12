package edu.neu.csye6200.models;

import edu.neu.csye6200.controller.Vaccination;

import java.util.*;

public class Student extends Person{

	private String grade;
	private int groupId;
	private String date_of_joining;
	private Vaccination immunization_Records;

	public Student() {
		super();
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public  Student(int id, String name){
		super(id, name);
	}

	public Student(int id, int age, String first_Name, String last_name, String date, String gender, Vaccination immunization_Records,
				   String grade, int groupId, String parents_first_name, String parents_last_name, String address,String date_of_joining) {
		super(id, age, first_Name, last_name, date, gender, parents_first_name, parents_last_name, address);
		this.grade = grade;
		this.groupId = groupId;
		this.date_of_joining = date_of_joining;
		this.immunization_Records = immunization_Records;
	}

	public Student(int id, int age, String first_Name, String last_name, String date, String gender, Vaccination immunization_Records,
				   String grade, String parents_first_name, String parents_last_name, String address,String date_of_joining) {
		super(id, age, first_Name, last_name, date, gender, parents_first_name, parents_last_name, address);
		this.grade = grade;
		this.date_of_joining = date_of_joining;
		this.immunization_Records = immunization_Records;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getDate_of_joining() {
		return date_of_joining;
	}

	public void setDate_of_joining(String date_of_joining) {
		this.date_of_joining = date_of_joining;
	}

	public Vaccination getImmunization_Records() {
		return immunization_Records;
	}

	public void setImmunization_Records(Vaccination immunization_Records, Student s1) {
		this.immunization_Records = immunization_Records;
	}


	public static Student createStudentFromCSV(String std) throws Exception {
		String[] data = std.split(",");

		Vaccination v = new Vaccination();
		List<Date> dates = new ArrayList<Date>();
		dates.add(new Date( 2019, 02, 03));
		dates.add(new Date( 2020, 03, 03));
		v.setVaricella(dates);
		v.setmMR(dates);
		v.setHepatitis_B(dates);
		v.setdTaP(dates);
		v.setPolio(dates);
		v.setHib(dates);

		Student st = null;
		try {
			st = new Student(Integer.parseInt(data[0]), Integer.parseInt(data[1]), data[2], data[3], data[4], data[5], v, "0", data[6], data[7], data[8], data[9]);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return st;
	}

	@Override
	public String toString() {
		return "Student [grade=" + grade + ", Age = " + getAge()  + ", First_Name = "
				+ getFirst_Name() + ", Last_name=" + getLast_name() + ", Date = " + getDate() + ", Gender = "
				+ getGender() + ", EventRegistration =" + getEventRegistration() + "]\n";
	}



}

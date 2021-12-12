package edu.neu.csye6200.models;

import java.util.Scanner;

public class Student extends Person{

	private int grade;
	private int groupId;
	private String date_of_joining;

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

	public Student(int id, int age, String name, String first_Name, String last_name, String date, String gender, Vaccination immunization_Records,
				   int grade, int groupId, String parents_first_name, String parents_last_name, String address) {
		super(id, age, name, first_Name, last_name, date, gender,
				immunization_Records, parents_first_name, parents_last_name, address);
		this.grade = grade;
		this.groupId = groupId;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getDate_of_joining() {
		return date_of_joining;
	}

	public void setDate_of_joining(String date_of_joining) {
		this.date_of_joining = date_of_joining;
	}

	public static Student createStudentFromCSV(String std) throws Exception {
		Scanner sn = new Scanner(std);
		sn.useDelimiter(",");
		
		Student st = null;
		try {
			st = new Student(sn.nextInt(), sn.next());
			// TO-Do
			//12,Rohith,asdf,asf,11121234,sdfas,1
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sn.close();
		return st;
	}



	@Override
	public String toString() {
		return "Student [grade=" + grade + ", Age = " + getAge() + ", Name() = " + getName() + ", First_Name = "
				+ getFirst_Name() + ", Last_name=" + getLast_name() + ", Date = " + getDate() + ", Gender = "
				+ getGender() + ", EventRegistration =" + getEventRegistration() + "]\n";
	}
	


}

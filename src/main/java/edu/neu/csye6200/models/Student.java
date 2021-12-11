package edu.neu.csye6200.models;

import java.util.Scanner;

public class Student extends Person{

	private int grade;
	private int groupId;

	public Student() {
		super();
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public Student(int age, String name, String first_Name, String last_name, String std, String gender, int grade) {
		super(age, name, first_Name, last_name, std, gender);
		this.grade = grade;
	}

	

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}


	public static Student createStudentFromCSV(String std) throws Exception {
		Scanner sn = new Scanner(std);
		sn.useDelimiter(",");
		
		Student st = null;
		try {
			st = new Student(sn.nextInt(), sn.next(),sn.next(), sn.next(), sn.next(),sn.next(), sn.nextInt());
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

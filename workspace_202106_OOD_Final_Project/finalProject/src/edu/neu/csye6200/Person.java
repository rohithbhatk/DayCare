package edu.neu.csye6200;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Person {

	private int age;
	private String name;
	private String first_Name;
	private String last_name;
	private String date;
	private String gender;
	protected static EventRegistration eventRegistration;
	private Vaccination immunization_Records;

	public Person(int age, String name, String first_Name, String last_name, String date, String gender) {
		super();
		this.age = age;
		this.name = name;
		this.first_Name = first_Name;
		this.last_name = last_name;
		this.date = date;
		this.gender = gender;

	}

	public Person(int age, String name, String first_Name, String last_name, String date2, String gender,
			Vaccination immunization_Records) {
		super();
		this.age = age;
		this.name = name;
		this.first_Name = first_Name;
		this.last_name = last_name;
		this.date = date2;
		this.gender = gender;
		this.immunization_Records = immunization_Records;
	}

	public Person(int age, String name, String first_Name, String last_name, String date, String gender,
			Vaccination immunization_Records, EventRegistration eventRegistration) {
		super();
		this.age = age;
		this.name = name;
		this.first_Name = first_Name;
		this.last_name = last_name;
		this.setDate(date);
		this.gender = gender;
		this.immunization_Records = immunization_Records;
		this.eventRegistration = eventRegistration;
	}

	public Vaccination getImmunization_Records(Student s1) {
		return immunization_Records;
	}

	public void setImmunization_Records(Vaccination immunization_Records, Student s1) {
		this.immunization_Records = immunization_Records;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirst_Name() {
		return first_Name;
	}

	public void setFirst_Name(String first_Name) {
		this.first_Name = first_Name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {

		this.date = date;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public EventRegistration getEventRegistration() {
		return eventRegistration;
	}

	public void setEventRegistration(EventRegistration eventRegistration) {
		this.eventRegistration = eventRegistration;
	}

	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + ", first_Name=" + first_Name + ", last_name=" + last_name
				+ ", date=" + date + ", gender=" + gender + ", eventRegistration=" + eventRegistration + "]";
	}

}

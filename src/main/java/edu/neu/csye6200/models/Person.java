package edu.neu.csye6200.models;

import edu.neu.csye6200.controller.Vaccination;

public class Person {
	private  int id;
	private int age;
	private String first_Name;
	private String last_name;
	private String date;  // date_of_Birth
	private String gender;
	private String parents_First_Name;
	private String parents_Last_Name;
	private String address;

	protected static EventRegistration eventRegistration;

	public Person(int id, int age, String first_Name, String last_name, String date,
				  String gender, String parents_First_Name,
				  String parents_last_name, String address) {
		this.id = id;
		this.age = age;
		this.first_Name = first_Name;
		this.last_name = last_name;
		this.date = date;
		this.gender = gender;
		this.address = address;
		this.parents_First_Name = parents_First_Name;
		this.parents_Last_Name = parents_last_name;
	}

	public String getParents_First_Name() {
		return parents_First_Name;
	}

	public String getParents_Last_Name() {
		return parents_Last_Name;
	}

	public void setParents_First_Name(String parents_First_Name) {
		this.parents_First_Name = parents_First_Name;
	}

	public void setParents_Last_Name(String parents_Last_Name) {
		this.parents_Last_Name = parents_Last_Name;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	public String getAddress() {
		return address;
	}

	public Person() {

	}

	public Person(int id, String name) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
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
		return "Person [age=" + age  + ", first_Name=" + first_Name + ", last_name=" + last_name
				+ ", date=" + date + ", gender=" + gender + ", eventRegistration=" + eventRegistration + "]";
	}

}

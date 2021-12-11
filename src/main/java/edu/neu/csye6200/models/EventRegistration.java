package edu.neu.csye6200.models;

public class EventRegistration {
	private String type_Of_Event;
	private String date;
	private String description;
	public String getType_Of_Event() {
		return type_Of_Event;
	}
	public void setType_Of_Event(String type_Of_Event) {
		this.type_Of_Event = type_Of_Event;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public EventRegistration(String type_Of_Event, String date, String description) {
		super();
		this.type_Of_Event = type_Of_Event;
		this.date = date;
		this.description = description;
	}
	@Override
	public String toString() {
		return "EventRegistration [type_Of_Event=" + type_Of_Event + ", date=" + date + ", description=" + description
				+ "]/n";
	}
	
}

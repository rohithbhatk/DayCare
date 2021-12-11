package edu.neu.csye6200.models;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class ClassRoom {

	private int id;
	private String description;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	protected int groupSize; //max students per classroom
	protected int maxGroups; //max teachers per room 

	public Map<Object, Object> createGroup(int groupSize, int maxGroups, Queue teacher, Queue student)
	{
		Map<Object, Object> classroom = new HashMap<Object, Object>(); 

		for(int i =0; i < maxGroups; i++) //repeat process for all groups in the age category 
		{
			this.groupSize = groupSize; 
			Teacher groupTeacher = (Teacher) teacher.remove(); //Get the next teacher that will be that teacher for that classroom 
			for(int iter = 0;  iter < groupSize; iter++)
			{
				classroom.put(groupTeacher, student.remove()); // pop students off the queue until the group is filled, will be for that teacher 
			}
		}
		return classroom; //this will return a hashmap per classroom per age group 
	}
}
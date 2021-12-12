package edu.neu.csye6200.models;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class ClassRoom {

	protected int groupSize; //max students per classroom
	protected int maxGroups; //max teachers per room

	public Map<Teacher, ArrayList<Student>> createGroup(int groupSize, int maxGroups)
	{
		Map<Teacher, ArrayList<Student>> classroom = new HashMap<Teacher, ArrayList<Student>>();

		//Map<Object, Object> classroom = new HashMap<Object, Object>();
		//if (ageinMonths <= 12 || ageinMonths >= 6) {
		for(int i =0; i < maxGroups; i++) //repeat process for all groups in the age category
		{
			List<Student> list = new ArrayList<Student>();
			this.groupSize = groupSize;
			Teacher groupTeacher = (Teacher) School.teacherRoster.remove();
			//Get the next teacher that will be that teacher for that classroom
			for(int iter = 0;  iter < groupSize; iter++)
				if (groupTeacher == null) {
					list.add(School.studentRoster.remove());
				}
				else{
					list.add(School.studentRoster.remove());
					// pop students off the queue until the group is filled, will be for that teacher
					// Teacher should be matched to a list of students
					// This approach throws key already exists error
					// Map of {groupTeacher, List[Students]}  --> {"Teacher1":["a", "b", "c"]}
				}
			classroom.put(groupTeacher, (ArrayList<Student>) list);
		}
		System.out.println("The classroom size is full. Please create a new classroom From GUI");
		return classroom; //this will return a hashmap per classroom per age group
	}
}
//returns classroom that contai

// Classroom_id  -> {[parsing each groupSize  -> Contains 1 teacher and 4 students}, {maxGroups}
// Classroom_id, {[TEACHERS], [STUDENTS]}

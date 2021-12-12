package edu.neu.csye6200.controller;


import edu.neu.csye6200.models.Student;
import edu.neu.csye6200.models.Teacher;


import java.util.*;

public class ClassRoomController {

    protected int groupSize; //max students per classroom
    protected int maxGroups; //max teachers per room

    public Map<Teacher, ArrayList<Student>> createGroup(int groupSize, int maxGroups) {

        Map<Teacher, ArrayList<Student>> classroom = new HashMap<Teacher, ArrayList<Student>>();
        Queue<Teacher> teachers = new LinkedList<>(School.teacherRoster);
        Queue<Student> students = new LinkedList<>(School.studentRoster);

        //Map<Object, Object> classroom = new HashMap<Object, Object>();
        //if (ageinMonths <= 12 || ageinMonths >= 6) {
        for (int i = 0; i < maxGroups; i++) //repeat process for all groups in the age category
        {
            List<Student> list = new ArrayList<Student>();
            this.groupSize = groupSize;

            Teacher groupTeacher = teachers.poll();

            //Get the next teacher that will be that teacher for that classroom
            for (int iter = 0; iter < groupSize; iter++) {
				if (groupTeacher == null) {
					// Todo: handle when teacher is null
//					list.add(School.studentRoster.remove());
				} else {
					Student stu = students.poll();
					if (stu != null) list.add(stu);
					else {
						// Todo: handle when student is null
					}
					// pop students off the queue until the group is filled, will be for that teacher
					// Teacher should be matched to a list of students
					// This approach throws key already exists error
					// Map of {groupTeacher, List[Students]}  --> {"Teacher1":["a", "b", "c"]}
				}
			}
			System.out.println(groupTeacher);
			System.out.println(list.size());
            classroom.put(groupTeacher, (ArrayList<Student>) list);
        }
        System.out.println("The classroom size is full. Please create a new classroom From GUI");
        return classroom; //this will return a hashmap per classroom per age group
    }
}
//returns classroom that contai

// Classroom_id  -> {[parsing each groupSize  -> Contains 1 teacher and 4 students}, {maxGroups}
// Classroom_id, {[TEACHERS], [STUDENTS]}

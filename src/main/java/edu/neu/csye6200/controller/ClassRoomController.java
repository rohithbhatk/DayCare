package edu.neu.csye6200.controller;


import edu.neu.csye6200.models.Student;
import edu.neu.csye6200.models.Teacher;


import java.util.*;

public class ClassRoomController {

    protected int groupSize; //max students per classroom
    protected int maxGroups; //max teachers per room

    public Map<Teacher, ArrayList<Student>> createGroup(int groupSize, int maxGroups, Queue<Teacher> teachers, Queue<Student> students) {

        Map<Teacher, ArrayList<Student>> classroom = new HashMap<Teacher, ArrayList<Student>>();

        for (int i = 0; i < maxGroups; i++)
        {
            List<Student> list = new ArrayList<Student>();

            if(!students.isEmpty()) {
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
                    }
                }
                classroom.put(groupTeacher, (ArrayList<Student>) list);
            }

        }
        System.out.println("The classroom size is full. Please create a new classroom From GUI");
        return classroom; //this will return a hashmap per classroom per age group
    }
}

// Classroom_id  -> {[parsing each groupSize  -> Contains 1 teacher and 4 students}, {maxGroups}
// Classroom_id, {[TEACHERS], [STUDENTS]}

package edu.neu.csye6200.controller;




import edu.neu.csye6200.models.Student;
import edu.neu.csye6200.models.Teacher;
import edu.neu.csye6200.utils.FileUtil;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SchoolHelper {
	private static School school = new School();
	private static ClassRoomController classroom = new ClassRoomController();
	private static Object[][] classrooms;

	public static void demo() throws Exception {
		String line = "";
		String splitBy = ",";
		String student_filename = "src/main/resources/students.txt";
		String teacher_filename = "src/main/resources/teachers.txt";
		try (BufferedReader bufferReader = FileUtil.openBufferedReader(FileUtil.openFileReader(student_filename))){

			while ((line = FileUtil.readBufferedReader(bufferReader)) != null)   //returns a Boolean value
			{
				System.out.println(line);
				Student student = Student.createStudentFromCSV(line);

				System.out.println(student);
				school.addStudent(student);

				System.out.println("Here "+school);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try (BufferedReader bufferReader = FileUtil.openBufferedReader(FileUtil.openFileReader(teacher_filename))){

			while ((line = FileUtil.readBufferedReader(bufferReader)) != null)   //returns a Boolean value
			{

				//System.out.println(person[8]);
				Teacher teacher = Teacher.createTeacherFromCSV(line);   // To Create Student object From CSV file
				// Add student object to a list, so that we can store and sort or perform any operations on that data

				school.addTeacher(teacher);

				System.out.println("Here 2 "+ school);

			}
			System.out.println(school);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void  setClassrooms()
	{
		classrooms = new Object[6][];
		//if age in between 6 to 12
		//classrooms [Freshman][section1]
		classrooms[1][1] = classroom.createGroup(4, 3); //this will put all the classrooms of different age groups in an array

		//else if age in between 12 to 25 months
		//classrooms [sophomore][section1]
		//classrooms[2][1] = classroom.createGroup(4, 2);

		// 1st dimensions - > SCalability of each classroom
		// 2nd dimensions - > will for classroom based on size


		//Object[] classrooms = new Object[6];
		//classrooms[1] = classroom.createGroup(4, 3); // Room is filled ? then what ?


	}
	public static Object[][] getClassrooms()
	{
		return classrooms;

	}





}




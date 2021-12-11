package edu.neu.csye6200.models;




import edu.neu.csye6200.utils.FileUtil;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Queue;

public class SchoolHelper {
	static School school = new School();
	ClassRoom classroom = new ClassRoom();
	public static void demo() throws Exception {


		String line = "";  
		String splitBy = ",";  
		String student_filename = "./src/edu/neu/csye6200/students.txt";
		String teacher_filename = "./src/edu/neu/csye6200/teachers.txt";
		try (BufferedReader bufferReader = FileUtil.openBufferedReader(FileUtil.openFileReader(student_filename))){

			while ((line = FileUtil.readBufferedReader(bufferReader)) != null)   //returns a Boolean value  
			{  
				Student student = Student.createStudentFromCSV(line);  

				school.addStudent(student);
				System.out.println("Here"+school);
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

	public void setClassrooms(Queue teacher, Queue student)
	{
		Object[] classrooms = new Object[6]; 
		classrooms[1] = classroom.createGroup(4, 3, teacher, student); //this will put all the classrooms of different age groups in an array 
	}





}




package edu.neu.csye6200;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ClassRoomHelper {
	static ClassRoom classRoom = new ClassRoom();

	public static void demo() throws Exception {

		String line = "";
		String splitBy = ",";
		String student_filename = "./src/edu/neu/csye6200/students.txt";
		String teacher_filename = "./src/edu/neu/csye6200/teachers.txt";
		try (BufferedReader bufferReader = FileUtil.openBufferedReader(FileUtil.openFileReader(student_filename))) {

			while ((line = FileUtil.readBufferedReader(bufferReader)) != null) // returns a Boolean value
			{
				Student student = Student.createStudentFromCSV(line);
				classRoom.addStudent(student);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try (BufferedReader bufferReader = FileUtil.openBufferedReader(FileUtil.openFileReader(teacher_filename))) {

			while ((line = FileUtil.readBufferedReader(bufferReader)) != null) // returns a Boolean value
			{

				// System.out.println(person[8]);
				Teacher teacher = Teacher.createTeacherFromCSV(line); // To Create Student object From CSV file
				// Add student object to a list, so that we can store and sort or perform any
				// operations on that data

				classRoom.addTeacher(teacher);

			}
			System.out.println(classRoom);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		classRoom.room();

	}

}

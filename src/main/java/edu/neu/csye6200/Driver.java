package edu.neu.csye6200;

import edu.neu.csye6200.models.SchoolHelper;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Driver {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("Final Project");
		
		SchoolHelper.demo();
		
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy");

		String dateInString = "07082013";
		Date date = formatter.parse(dateInString);
		System.out.println(date);
//		ClassRoom classroom = new ClassRoom();
//		classroom.classroom();
	}

}
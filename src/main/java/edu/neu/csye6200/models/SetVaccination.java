package edu.neu.csye6200.models;

import edu.neu.csye6200.utils.Utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// NEED TO UPDATE THE IF CONDITION w.r.t 
//https://www.northeastern.edu/uhcs/wp-content/uploads/2019/07/guidelines-ma-school-requirements.pdf

// Student.vaccication --> Boolean 

// Studenet object --> All the vaccines checks during Registration

public class SetVaccination {
	static List<Date> vaccinationList = new ArrayList<>();
public static void Vaccine(String vaccine_Name, Date date) {
	Vaccination vaccination = new Vaccination();
	
	switch (vaccine_Name) {
	case  "Hib":{
		
		vaccinationList = vaccination.getHib();	
		if (vaccinationList.size() == 0) {
			vaccination.setHib(date);
		}
		else if ((vaccinationList.size() < 4) && (Utils.differenceDate(vaccinationList.get(vaccinationList.size()-1)) > 180)) // Some condition
			
		vaccination.setHib(date);
		break;
	}
	case "DtaP":{
		vaccinationList = vaccination.getdTaP();	
		if (vaccinationList.size() == 0) {
			vaccination.setdTaP(date);
		}
		else if ((vaccinationList.size() < 4) && (Utils.differenceDate(vaccinationList.get(vaccinationList.size()-1)) > 180)) // Some condition
			
		vaccination.setdTaP(date);
		break;
	}
	case  "Polio":{
		vaccinationList = vaccination.getPolio();	
		if (vaccinationList.size() == 0) {
			vaccination.setPolio(date);
		}
		else if ((vaccinationList.size() < 4) && (Utils.differenceDate(vaccinationList.get(vaccinationList.size()-1)) > 180)) // Some condition
			
		vaccination.setPolio(date);
		break;
	}
	case  "Hepatitis_B":{
		
		vaccinationList = vaccination.getHepatitis_B();	
		if (vaccinationList.size() == 0) {
			vaccination.setHepatitis_B(date);
		}
		else if ((vaccinationList.size() < 4) && (Utils.differenceDate(vaccinationList.get(vaccinationList.size()-1)) > 180)) // Some condition
			
		vaccination.setHepatitis_B(date);
		break;
		
	}
	case  "MMR":{
		
		
		vaccinationList = vaccination.getmMR();	
		if (vaccinationList.size() == 0) {
			vaccination.setmMR(date);
		}
		else if ((vaccinationList.size() < 4) && (Utils.differenceDate(vaccinationList.get(vaccinationList.size()-1)) > 180)) // Some condition
			
		vaccination.setmMR(date);
		break;
	}
	case  "Varicella":{
		vaccinationList = vaccination.getVaricella();	
		if (vaccinationList.size() == 0) {
			vaccination.setVaricella(date);
		}
		else if ((vaccinationList.size() < 4) && (Utils.differenceDate(vaccinationList.get(vaccinationList.size()-1)) > 180)) // Some condition
			
		vaccination.setVaricella(date);
		break;
	}
	}
}
public void add() {
	
}
}

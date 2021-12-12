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
	public static void Vaccine(String vaccine_Name, Date date) {
		Vaccination vaccination = new Vaccination();
		switch (vaccine_Name) {
			case "Hib": {
				List gethib = vaccination.getHib();
				if (gethib.size() < 4) // Some condition
					vaccination.setHib(date);
			}
			case "DtaP": {
				List getdtap = vaccination.getdTaP();
				if (getdtap.size() < 2)
					vaccination.setdTaP(date);
			}
			case "Polio": {
				List getpolio = vaccination.getPolio();
				if (getpolio.size() < 4)
					vaccination.setPolio(date);
			}
			case "Hepatitis_B": {
				List gethepatitis_B = vaccination.getHepatitis_B();
				if (gethepatitis_B.size() < 4)
					vaccination.setHepatitis_B(date);
			}
			case "MMR": {
				List getmmr = vaccination.getmMR();
				if (getmmr.size() < 4)
					vaccination.setmMR(date);
			}
			case "Varicella": {
				List getvaricella = vaccination.getVaricella();
				if (getvaricella.size() < 4)
					vaccination.setVaricella(date);
			}
		}
	}

	public void add() {

	}
}

package edu.neu.csye6200;

// NEED TO UPDATE THE IF CONDITION w.r.t 
//https://www.northeastern.edu/uhcs/wp-content/uploads/2019/07/guidelines-ma-school-requirements.pdf

public class SetVaccination {
	public static void Vaccine(String vaccine_Name) {
		Vaccination vaccination = new Vaccination();
		switch (vaccine_Name) {
		case "Hib": {
			int gethib = vaccination.getHib();
			if (gethib < 4) // Some condition
				vaccination.setHib();
		}
		case "DtaP": {
			int getdtap = vaccination.getdTaP();
			if (getdtap < 2)
				vaccination.setdTaP();
		}
		case "Polio": {
			int getpolio = vaccination.getPolio();
			if (getpolio < 4)
				vaccination.setPolio();
		}
		case "Hepatitis_B": {
			int gethepatitis_B = vaccination.getHepatitis_B();
			if (gethepatitis_B < 4)
				vaccination.setHepatitis_B();
		}
		case "MMR": {
			int getmmr = vaccination.getmMR();
			if (getmmr < 4)
				vaccination.setmMR();
		}
		case "Varicella": {
			int getvaricella = vaccination.getVaricella();
			if (getvaricella < 4)
				vaccination.setVaricella();
		}
		}
	}

	public void add() {

	}
}

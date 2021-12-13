package edu.neu.csye6200.controller;

import java.util.*;

public class ImmunizationController {
    // Anyone who adds to our registration, we are assuming that they are vaccinated
    // So, if they are not vaccinated, they will not be registered
    public List<Map<String, List<Date>>> checkImmunizationStatus(){
        Vaccination vaccination = new Vaccination();
        Map<String, List<Date>> immunizationstatusmap = new HashMap<String,  List<Date>>();
        List<Map<String,  List<Date>>> immunizationList = new ArrayList<Map<String,  List<Date>>>();
        immunizationstatusmap.put("Hepatitis_B",vaccination.getHepatitis_B());
        immunizationList.add(immunizationstatusmap);
        immunizationstatusmap.put("Hib",vaccination.getHib());
        immunizationList.add(immunizationstatusmap);
        immunizationstatusmap.put("dTaP",vaccination.getdTaP());
        immunizationList.add(immunizationstatusmap);
        immunizationstatusmap.put("Polio",vaccination.getPolio());
        immunizationList.add(immunizationstatusmap);
        immunizationstatusmap.put("mMR",vaccination.getmMR());
        immunizationList.add(immunizationstatusmap);
        immunizationstatusmap.put("Varicella",vaccination.getVaricella());
        immunizationList.add(immunizationstatusmap);

        return immunizationList;  // [{"HIB":[01/01/2021, 01/01/2022, 01/01/2023]},{"mmr":[01/01/2021, 01/01/2022, 01/01/2023]} ]
    }
    public boolean checkifvaccinated(int age) {
        List<Map<String,  List<Date>>> checkifvaccinatedList = new ArrayList<>();
        checkifvaccinatedList = checkImmunizationStatus();
        Set<String> vaccine_name;
        Date list_dates = new Date();
        if (age > 6 || age > 12 ) {
            for (int i=0; i<checkifvaccinatedList.size();i++){
                vaccine_name = checkifvaccinatedList.get(i).keySet(); // Returns set of vaccines (HiB, mmr, varicella)
                list_dates = (Date) checkifvaccinatedList.get(i).values(); // [dates1, date2]
                for (int j = 0;j<vaccine_name.size(); j++) {
                    if(list_dates !=null) {
                        return true;
                    }
                }

            }
        }
        return false;
    }
}

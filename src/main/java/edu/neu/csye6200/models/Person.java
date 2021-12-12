package edu.neu.csye6200.models;

import edu.neu.csye6200.utils.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Person {
	private  int id;
	private int age;
	private String name;
	private String first_Name;
	private String last_name;
	private String date;  // date_of_Birth
	private String gender;
	private String parents_First_Name;
	private String parents_Last_Name;
	private String address;

	protected static EventRegistration eventRegistration;
	private Vaccination immunization_Records;

	public Person(int id, int age, String name, String first_Name, String last_name, String date,
				  String gender, Vaccination immunization_Records, String parents_First_Name,
				  String parents_last_name, String address) {
		this.id = id;
		this.age = age;
		this.name = name;
		this.first_Name = first_Name;
		this.last_name = last_name;
		this.date = date;
		this.gender = gender;
		this.immunization_Records = immunization_Records;
		this.address = address;
		this.parents_First_Name = parents_First_Name;
		this.parents_Last_Name = parents_last_name;
	}

	public String getParents_First_Name() {
		return parents_First_Name;
	}

	public String getParents_Last_Name() {
		return parents_Last_Name;
	}

	public String getAddress() {
		return address;
	}

	public Vaccination getImmunization_Records() {
		return immunization_Records;
	}

	public Person() {

	}

	public Person(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Vaccination getImmunization_Records(Student s1) {
		return immunization_Records;
	}

	public void setImmunization_Records(Vaccination immunization_Records, Student s1) {
		this.immunization_Records = immunization_Records;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirst_Name() {
		return first_Name;
	}

	public void setFirst_Name(String first_Name) {
		this.first_Name = first_Name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {

		this.date = date;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public EventRegistration getEventRegistration() {
		return eventRegistration;
	}

	public void setEventRegistration(EventRegistration eventRegistration) {
		this.eventRegistration = eventRegistration;
	}

	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + ", first_Name=" + first_Name + ", last_name=" + last_name
				+ ", date=" + date + ", gender=" + gender + ", eventRegistration=" + eventRegistration + "]";
	}
	// Anyone who adds to our registration, we are assuming that they are vaccinated
	// So, if they are not vaccinated, they will not be registered
	public List<Map<String,  List<Date>>> checkImmunizationStatus(){
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

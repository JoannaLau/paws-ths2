package Models;

import java.util.ArrayList;

public class Accreditor {
	
	private int accreditorID;
	private String honorifics;
	private String firstName;
	private String lastName;
	private String middleName;
	private String email;
	private String contact;
	private String institution;
	private String discipline;
	private int primaryAreaID;
	private int secondaryAreaID;
	private int tertiaryAreaID;
	private String primaryArea;
	private String secondaryArea;
	private String tertiaryArea;

	private int totalSurveys;
	private String city;
	private String country;
	private String venueTrained;
	private String dateTrained;
	private String address;
	private ArrayList<Degree> degrees;
	private ArrayList<Work> works;
	
	
	
	
	
	public Accreditor(int accreditorID, String honorifics, String firstName, String lastName, String middleName,
			String email, String contact, String institution, String discipline, int primaryAreaID, int secondaryAreaID,
			int tertiaryAreaID, String primaryArea, String secondaryArea, String tertiaryArea, int totalSurveys,
			String city, String country, String venueTrained, String dateTrained, String address) {
		super();
		this.accreditorID = accreditorID;
		this.honorifics = honorifics;
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
		this.email = email;
		this.contact = contact;
		this.institution = institution;
		this.discipline = discipline;
		this.primaryAreaID = primaryAreaID;
		this.secondaryAreaID = secondaryAreaID;
		this.tertiaryAreaID = tertiaryAreaID;
		this.primaryArea = primaryArea;
		this.secondaryArea = secondaryArea;
		this.tertiaryArea = tertiaryArea;
		this.totalSurveys = totalSurveys;
		this.city = city;
		this.country = country;
		this.venueTrained = venueTrained;
		this.dateTrained = dateTrained;
		this.address = address;
	}


	public int getPrimaryAreaID() {
		return primaryAreaID;
	}


	public void setPrimaryAreaID(int primaryAreaID) {
		this.primaryAreaID = primaryAreaID;
	}


	public int getSecondaryAreaID() {
		return secondaryAreaID;
	}


	public void setSecondaryAreaID(int secondaryAreaID) {
		this.secondaryAreaID = secondaryAreaID;
	}


	public int getTertiaryAreaID() {
		return tertiaryAreaID;
	}


	public void setTertiaryAreaID(int tertiaryAreaID) {
		this.tertiaryAreaID = tertiaryAreaID;
	}


	public String getPrimaryArea() {
		return primaryArea;
	}


	public void setPrimaryArea(String primaryArea) {
		this.primaryArea = primaryArea;
	}


	public String getSecondaryArea() {
		return secondaryArea;
	}


	public void setSecondaryArea(String secondaryArea) {
		this.secondaryArea = secondaryArea;
	}


	public String getTertiaryArea() {
		return tertiaryArea;
	}


	public void setTertiaryArea(String tertiaryArea) {
		this.tertiaryArea = tertiaryArea;
	}


	public Accreditor(int accreditorID, String honorifics, String firstName, String lastName, String middleName) {
		super();
		this.accreditorID = accreditorID;
		this.honorifics = honorifics;
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
		
		
	}
	
	
	public Accreditor(){
		
	}
	

	public void addDegrees(ArrayList<Degree> degrees){
		this.degrees = degrees;
	}
	
	public void addWorks(ArrayList<Work> works){
		this.works = works;
	}
	
	public ArrayList<Work> getWorks(){
		return works;
	}
	public ArrayList<Degree> getDegrees(){
		return degrees;
	}
	
	public String getContact(){
		return contact;
	}
	public void setContact(String contact){
		this.contact = contact;
	}
	public int getAccreditorID() {
		return accreditorID;
	}
	public void setAccreditorID(int accreditorID) {
		this.accreditorID = accreditorID;
	}
	public String getHonorifics() {
		return honorifics;
	}
	public void setHonorifics(String honorifics) {
		this.honorifics = honorifics;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getInstitution() {
		return institution;
	}
	public void setInstitution(String institution) {
		this.institution = institution;
	}
	public String getDiscipline() {
		return discipline;
	}
	public void setDiscipline(String discipline) {
		this.discipline = discipline;
	}

	public int getTotalSurveys() {
		return totalSurveys;
	}
	public void setTotalSurveys(int totalSurveys) {
		this.totalSurveys = totalSurveys;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getVenueTrained() {
		return venueTrained;
	}
	public void setVenueTrained(String venue_trained) {
		this.venueTrained = venue_trained;
	}
	public String getDateTrained() {
		return dateTrained;
	}
	public void setDateTrained(String date_trained) {
		this.dateTrained = date_trained;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getFullName(){
		return lastName + ", " + firstName + " " + middleName + " (" + honorifics + ")";
	}
	
}
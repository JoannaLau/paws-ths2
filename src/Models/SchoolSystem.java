package Models;

public class SchoolSystem {


	private int schoolSystemID;
	private String name;
	private String dateJoined = "";
	private int numberOfInstitutions;
	
	public SchoolSystem(){}
	
	public int getNumberOfInstitutions() {
		return numberOfInstitutions;
	}

	public void setNumberOfInstitutions(int numberOfInstitutions) {
		this.numberOfInstitutions = numberOfInstitutions;
	}

	public SchoolSystem(int schoolsystemID, String name, String date_joined) {
		super();
		this.schoolSystemID = schoolsystemID;
		this.name = name;
		this.dateJoined = date_joined;
	}

	public int getSchoolSystemID() {
		return schoolSystemID;
	}

	public void setSchoolSystemID(int schoolsystemID) {
		this.schoolSystemID = schoolsystemID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDateJoined() {
		return dateJoined;
	}

	public void setDateJoined(String date_joined) {
		this.dateJoined = date_joined;
	}
	
	
	
	
}

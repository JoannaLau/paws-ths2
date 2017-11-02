package Models;

public class CommissionMembers 
{
	private int cmID;
	private String firstName;
	private String lastName;
	private String middleName;
	private String honorifics;
	private String position;
	private String institution;
	private String city;
	private int year;
	private int commissionPositionID;
	private int educLevelID;
	
	public CommissionMembers()
	{
		
	}
	
	public CommissionMembers(int cmID, String firstName, String lastName, String middleName, String honorifics,
			String position, String institution, String city, int year, int commissionPositionID, int educLevelID) {
		this.cmID = cmID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
		this.honorifics = honorifics;
		this.position = position;
		this.institution = institution;
		this.city = city;
		this.year = year;
		this.commissionPositionID = commissionPositionID;
		this.educLevelID = educLevelID;
	}

	public int getCmID() {
		return cmID;
	}

	public void setCmID(int cmID) {
		this.cmID = cmID;
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

	public String getHonorifics() {
		return honorifics;
	}

	public void setHonorifics(String honorifics) {
		this.honorifics = honorifics;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getCommissionPositionID() {
		return commissionPositionID;
	}

	public void setCommissionPositionID(int commissionPositionID) {
		this.commissionPositionID = commissionPositionID;
	}

	public int getEducLevelID() {
		return educLevelID;
	}

	public void setEducLevelID(int educLevelID) {
		this.educLevelID = educLevelID;
	}
	
	
	
}

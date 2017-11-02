package Models;

public class CommissionMember 
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
	private String commissionPosition;
	private int educLevelID;
	private String educLevel;
	
	public CommissionMember()
	{
		
	}
	
	public CommissionMember(int cmID, String firstName, String lastName, int commissionPositionID, 
			int year, String commissionPosition, int educLevelID, String educLevel) {
		this.cmID = cmID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.year = year;
		this.commissionPositionID = commissionPositionID;
		this.setCommissionPosition(commissionPosition);
		this.educLevelID = educLevelID;
		this.setEducLevel(educLevel);
	}
	
	
	
	public CommissionMember(int cmID, String firstName, String lastName, String middleName, String honorifics,
			String position, String institution, String city, int year, int commissionPositionID,
			String commissionPosition, int educLevelID, String educLevel) {
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
		this.commissionPosition = commissionPosition;
		this.educLevelID = educLevelID;
		this.educLevel = educLevel;
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
	
	public String getFullName()
	{
		return this.lastName + ", " + this.firstName + " "; 
	}

	public String getCommissionPosition() {
		return commissionPosition;
	}

	public void setCommissionPosition(String commissionPosition) {
		this.commissionPosition = commissionPosition;
	}

	public String getEducLevel() {
		return educLevel;
	}

	public void setEducLevel(String educLevel) {
		this.educLevel = educLevel;
	}
	
	
	
}

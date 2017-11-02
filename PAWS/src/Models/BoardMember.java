package Models;

public class BoardMember 
{
	private int bmID;
	private String firstName;
	private String lastName;
	private String middleName;
	private String honorifics;
	private String position;
	private String institution;
	private String city;
	private int year;
	private int boardPositionID;
	private String boardPosition;
	
	public BoardMember()
	{
		
	}
	
	public BoardMember(int bmID, String firstName, String lastName, int boardPositionID, String boardPosition, int year)
	{
		this.bmID = bmID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.boardPosition = boardPosition;
		this.boardPositionID = boardPositionID;
		this.year = year;
		
	}
	
	public BoardMember(int bmID, String firstName, String lastName, String middleName, String honorifics,
			String position, String institution, String city, int year, int boardPositionID, String boardPosition) {
		this.bmID = bmID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
		this.honorifics = honorifics;
		this.position = position;
		this.institution = institution;
		this.city = city;
		this.year = year;
		this.boardPositionID = boardPositionID;
		this.boardPosition = boardPosition;
	}



	public int getBmID() {
		return bmID;
	}

	public void setBmID(int bmID) {
		this.bmID = bmID;
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

	public int getBoardPositionID() {
		return boardPositionID;
	}

	public void setBoardPositionID(int boardPositionID) {
		this.boardPositionID = boardPositionID;
	}

	public String getBoardPosition() {
		return boardPosition;
	}

	public void setBoardPosition(String boardPosition) {
		this.boardPosition = boardPosition;
	}

	public String getFullName()
	{
		return this.lastName + ", " + this.firstName + " "; 
	}
	
	
}

package Models;

public class Institution {

	private int institutionID;
	private String institutionAcronym;
	private String name;
	private String head="";
	private String hPosition="";
	private String hEmail="";
	private String address="";
	private String region="";
	private String status="";
	private String dateAdded="";
	private String city="";
	private String fax="";
	private String contactPerson="";
	private String contactNumber="";
	private String contactPosition="";
	private String schoolSystemName;
	private int schoolSystemID;
	private String website;
	private String country;
	private String contactEmail;
	private String dateAddedWord;

	private String educLevel;
	
	
	
	

	public String getEducLevel() {
		return educLevel;
	}

	public void setEducLevel(String educLevel) {
		this.educLevel = educLevel;
	}

	public int getInstitutionID() {
		return institutionID;
	}

	public void setInstitutionID(int institutionID) {
		this.institutionID = institutionID;
	}

	public String getInstitutionAcronym() {
		return institutionAcronym;
	}

	public void setInstitutionAcronym(String institutionAcronym) {
		this.institutionAcronym = institutionAcronym;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public String gethPosition() {
		return hPosition;
	}

	public void sethPosition(String hPosition) {
		this.hPosition = hPosition;
	}

	public String gethEmail() {
		return hEmail;
	}

	public void sethEmail(String hEmail) {
		this.hEmail = hEmail;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(String dateAdded) {
		this.dateAdded = dateAdded;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getContactPosition() {
		return contactPosition;
	}

	public void setContactPosition(String contactPosition) {
		this.contactPosition = contactPosition;
	}

	public String getSchoolSystemName() {
		return schoolSystemName;
	}

	public void setSchoolSystemName(String schoolsystemName) {
		this.schoolSystemName = schoolsystemName;
	}

	public int getSchoolSystemID() {
		return schoolSystemID;
	}

	public void setSchoolSystemID(int schoolsystemID) {
		this.schoolSystemID = schoolsystemID;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public String getDateAddedWord() {
		return dateAddedWord;
	}

	public void setDateAddedWord(String dateAddedWord) {
		this.dateAddedWord = dateAddedWord;
	}

	public Institution(){}
	
	public Institution(int institutionID, int schoolsystemID, String name, String head, String position, String email,
			String address, String status, String date_added, String city, String fax,
			String contact_person, String contact_position, String contact_number, String website, String country, String contact_email, String institutionAcronym, String educLevel) {
		super();
		this.institutionID = institutionID;
		this.schoolSystemID = schoolsystemID;
		this.institutionAcronym = institutionAcronym;
		this.name = name;
		this.head = head;
		this.hPosition = position;
		this.hEmail = email;
		this.address = address;
		this.country = country;
		this.status = status;
		this.dateAdded = formatDate_yearFirst(date_added);
		this.dateAddedWord = formatDate(date_added);
		this.city = city;
		this.fax = fax;
		this.contactPerson = contact_person;
		this.contactNumber = contact_number;
		this.contactEmail = contact_email;
		this.website = website;
		this.contactPosition =contact_position;
		this.educLevel = educLevel;
		System.out.println(date_added+"CITY!!!!!!!!!!"+ institutionAcronym);
	}

	private static String formatDate(String date){
		String format = new String();
		String month = "";
		String day;
		String year;
		String[] parts = date.split("-");
		if(parts[1].equals("01")){
			month = "January";
		}else if(parts[1].equals("02")){
			month = "February";
		}else if(parts[1].equals("03")){
			month = "March";
		}else if(parts[1].equals("04")){
			month = "April";
		}else if(parts[1].equals("05")){
			month = "May";
		}else if(parts[1].equals("06")){
			month = "June";
		}else if(parts[1].equals("07")){
			month = "July";
		}else if(parts[1].equals("08")){
			month = "August";
		}else if(parts[1].equals("09")){
			month = "September";
		}else if(parts[1].equals("10")){
			month = "October";
		}else if(parts[1].equals("11")){
			month = "November";
		}else if(parts[1].equals("12")){
			month = "December";
		}
		year = parts[0];

//		parts = parts[1].split(",");
		day = parts[2];
		
		format = month + " " + day + ", "+ year;
		return format;
	}
	
	private static String formatDate_yearFirst(String date){
		String format = new String();
		String month = "";
		String day;
		String year;
		String[] parts = date.split("-");
		if(parts[1].equals("01")){
			month = "January";
		}else if(parts[1].equals("02")){
			month = "February";
		}else if(parts[1].equals("03")){
			month = "March";
		}else if(parts[1].equals("04")){
			month = "April";
		}else if(parts[1].equals("05")){
			month = "May";
		}else if(parts[1].equals("06")){
			month = "June";
		}else if(parts[1].equals("07")){
			month = "July";
		}else if(parts[1].equals("08")){
			month = "August";
		}else if(parts[1].equals("09")){
			month = "September";
		}else if(parts[1].equals("10")){
			month = "October";
		}else if(parts[1].equals("11")){
			month = "November";
		}else if(parts[1].equals("12")){
			month = "December";
		}
		year = parts[0];

//		parts = parts[1].split(",");
		day = parts[2];
		
		format = year + " " + month + " "+ day;
		return format;
	}
	
	
	
}

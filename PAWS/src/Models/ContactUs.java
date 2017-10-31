package Models;

public class ContactUs {

	private int contactID;
	private String name;
	private String email;
	private String message;
	private String dateTime;
	private String ipAddress;
	
	
	public ContactUs(int contactID, String name, String email, String message, String dateTime, String ipAddress) {
		this.contactID = contactID;
		this.name = name;
		this.email = email;
		this.message = message;
		this.dateTime = dateTime;
		this.ipAddress = ipAddress;
	}

	public ContactUs()
	{
		
	}

	public int getContactID() {
		return contactID;
	}


	public void setContactID(int contactID) {
		this.contactID = contactID;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public String getDateTime() {
		return dateTime;
	}


	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}


	public String getIpAddress() {
		return ipAddress;
	}


	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	
	
	
}

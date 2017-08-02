package Models;

public class Work {
	
	private String institution;
	private int accreditorID;
	private String dateEntered;
	private String dateFinished;
	private String position;
	private String placeOfPosition;
	private int institutionID;
	
	
	public Work(String institution, int accreditorID, String date_entered, String date_finished, String position, int institutionID, String placeOfPosition) {
		super();
		this.institution = institution;
		this.accreditorID = accreditorID;
		this.dateEntered = date_entered;
		this.dateFinished = date_finished;
		this.position = position;
		this.placeOfPosition = placeOfPosition;
		this.institutionID = institutionID;
	}
	
	public Work(){
		
	}
	
	public int getInstitutionID() {
		return institutionID;
	}

	public void setInstitutionID(int institutionID) {
		this.institutionID = institutionID;
	}

	public int getAccreditorID() {
		return accreditorID;
	}
	public void setAccreditorID(int accreditorID) {
		this.accreditorID = accreditorID;
	}
	public String getDateEntered() {
		return dateEntered;
	}
	public void setDateEntered(String date_entered) {
		this.dateEntered = date_entered;
	}
	public String getDateFinished() {
		return dateFinished;
	}
	public void setDateFinished(String date_finished) {
		this.dateFinished = date_finished;
	}

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
	
	public String getPlaceOfPosition() {
		return placeOfPosition;
	}

	public void setPlaceOfPosition(String position) {
		this.placeOfPosition = position;
	}
	
		
	
}

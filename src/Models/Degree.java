package Models;

public class Degree {
	
	private String degreeName;
	private int accreditorID;
	private String institution;
	private int institutionID;
	
	
	public Degree(String degree_name, int accreditorID, String institution, int institutionID) {
		super();
		this.degreeName = degree_name;
		this.accreditorID = accreditorID;
		this.institution = institution;
		this.institutionID = institutionID;
	}
	


	public Degree(){
		
	}



	public String getDegreeName() {
		return degreeName;
	}



	public void setDegreeName(String degreeName) {
		this.degreeName = degreeName;
	}



	public int getAccreditorID() {
		return accreditorID;
	}



	public void setAccreditorID(int accreditorID) {
		this.accreditorID = accreditorID;
	}



	public String getInstitution() {
		return institution;
	}



	public void setInstitution(String institution) {
		this.institution = institution;
	}



	public int getInstitutionID() {
		return institutionID;
	}



	public void setInstitutionID(int institutionID) {
		this.institutionID = institutionID;
	}
	
	
}

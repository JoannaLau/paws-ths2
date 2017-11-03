package Models;

public class Survey {
	private int surveyID;
	
	private String startDate;
	private String endDate;	
	private String dateApproved;
	private String dateRequested;
	private int institutionID;
	private String institutionName;
	public int getSurveyID() {
		return surveyID;
	}
	public void setSurveyID(int surveyID) {
		this.surveyID = surveyID;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getDateApproved() {
		return dateApproved;
	}
	public void setDateApproved(String dateApproved) {
		this.dateApproved = dateApproved;
	}
	public String getDateRequested() {
		return dateRequested;
	}
	public void setDateRequested(String dateRequested) {
		this.dateRequested = dateRequested;
	}
	public int getInstitutionID() {
		return institutionID;
	}
	public void setInstitutionID(int institutionID) {
		this.institutionID = institutionID;
	}
	public String getInstitutionName() {
		return institutionName;
	}
	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
	}
	
	
	
}

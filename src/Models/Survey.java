package Models;

public class Survey {
	private int surveyID;
	private String startDate;
	private String endDate;	
	private String dateApproved;
	private String dateRequested;
	private int institution;
	
	public Survey()
	{
		
	}
	
	
	public Survey(int surveyID, String startDate, String endDate, String dateApproved, String dateRequested,
			int institution) {
		super();
		this.surveyID = surveyID;
		this.startDate = startDate;
		this.endDate = endDate;
		this.dateApproved = dateApproved;
		this.dateRequested = dateRequested;
		this.institution = institution;
	}


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
	public int getInstitution() {
		return institution;
	}
	public void setInstitution(int institution) {
		this.institution = institution;
	}
	
	
	
}

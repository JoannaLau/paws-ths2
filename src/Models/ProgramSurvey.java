package Models;

public class ProgramSurvey {

	private int PSID;
	private int surveyID;
	private int SPID;
	private String surveyType;
	private String boardDecision;
	private String validThru;
	private String reportPath;
	private String remarks;
	private String decisionDate;
	private String decisionBy;
	private String surveyDate;

	public ProgramSurvey(){
		
	}

	
	
	public ProgramSurvey(int pSID, int surveyID, int sPID, String survey_type, String board_decision, String valid_thru,
			String report_path, String remarks, String decision_date, String decision_by) {
		
		this.PSID = pSID;
		this.surveyID = surveyID;
		this.SPID = sPID;
		this.surveyType = survey_type;
		this.boardDecision = board_decision;
		this.validThru = valid_thru;
		this.reportPath = report_path;
		this.remarks = remarks;
		this.decisionDate = decision_date;
		this.decisionBy = decision_by;
	}



	public int getPSID() {
		return PSID;
	}



	public void setPSID(int pSID) {
		PSID = pSID;
	}



	public int getSurveyID() {
		return surveyID;
	}



	public void setSurveyID(int surveyID) {
		this.surveyID = surveyID;
	}



	public int getSPID() {
		return SPID;
	}



	public void setSPID(int sPID) {
		SPID = sPID;
	}



	public String getSurveyType() {
		return surveyType;
	}



	public void setSurveyType(String surveyType) {
		this.surveyType = surveyType;
	}



	public String getBoardDecision() {
		return boardDecision;
	}



	public void setBoardDecision(String boardDecision) {
		this.boardDecision = boardDecision;
	}



	public String getValidThru() {
		return validThru;
	}



	public void setValidThru(String validThru) {
		this.validThru = validThru;
	}



	public String getReportPath() {
		return reportPath;
	}



	public void setReportPath(String reportPath) {
		this.reportPath = reportPath;
	}



	public String getRemarks() {
		return remarks;
	}



	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}



	public String getDecisionDate() {
		return decisionDate;
	}



	public void setDecisionDate(String decisionDate) {
		this.decisionDate = decisionDate;
	}



	public String getDecisionBy() {
		return decisionBy;
	}



	public void setDecisionBy(String decisionBy) {
		this.decisionBy = decisionBy;
	}



	public String getSurveyDate() {
		return surveyDate;
	}



	public void setSurveyDate(String surveyDate) {
		this.surveyDate = surveyDate;
	}


	
}

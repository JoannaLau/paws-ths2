package Models;

public class SchoolProgram {
	
	private int SPID;
	private String institution;
	private String level;
	private String dateAdded;
	private String nextSurveySched;
	private String pendingReports;
	private String nextSurveyType;
	private String degreeName;
	private String dateAddedWord;
	private String surveyDate;
	private String lapseDate;
	private String currentDecision;
	private String decisionBy;
	private String lastSurveyDate;
	
	
	public SchoolProgram(int sPID, String institution, String level, String date_added, String next_survey_sched,
			String pending_reports, String next_survey_type, String degree_name) {
		super();
		this.SPID = sPID;
		this.institution = institution;
		this.level = level;
		this.dateAdded = date_added;
		this.nextSurveySched = formatDate(next_survey_sched);
		this.pendingReports = pending_reports;
		this.nextSurveyType = next_survey_type;
		this.dateAddedWord = formatDate(date_added);
		this.degreeName = degree_name;
		
	}
	
	public SchoolProgram(){
		
	}
	
	public String getLastSurveyDate() {
		return lastSurveyDate;
	}

	public void setLastSurveyDate(String lastSurveyDate) {
		this.lastSurveyDate = formatDate(lastSurveyDate);
	}
	
	private static String formatDate(String date){
		String format = "NA";
		String month = "";
		String day;
		String year;
		System.out.println(date+"date of next sruv sched");

		if(date==null||date.equals("NA")||date.equals(" ")||date.equals("")){}
		else{
		String[] parts = date.split("-");
		System.out.println("pogiako"+ date);
		if(parts[1].equals("01")){
			month = "Jan";
		}else if(parts[1].equals("02")){
			month = "Feb";
		}else if(parts[1].equals("03")){
			month = "Mar";
		}else if(parts[1].equals("04")){
			month = "Apr";
		}else if(parts[1].equals("05")){
			month = "May";
		}else if(parts[1].equals("06")){
			month = "Jun";
		}else if(parts[1].equals("07")){
			month = "Jul";
		}else if(parts[1].equals("08")){
			month = "Aug";
		}else if(parts[1].equals("09")){
			month = "Sep";
		}else if(parts[1].equals("10")){
			month = "Oct";
		}else if(parts[1].equals("11")){
			month = "Nov";
		}else if(parts[1].equals("12")){
			month = "Dec";
		}
		year = parts[0];

//		parts = parts[1].split(",");
		day = parts[2];
		
		format = year + " " + month + " "+ day;
		}
		return format;
	}

	public int getSPID() {
		return SPID;
	}

	public void setSPID(int sPID) {
		SPID = sPID;
	}

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(String dateAdded) {
		this.dateAdded = dateAdded;
	}

	public String getNextSurveySched() {
		return nextSurveySched;
	}

	public void setNextSurveySched(String nextSurveySched) {
		this.nextSurveySched = nextSurveySched;
	}

	public String getPendingReports() {
		return pendingReports;
	}

	public void setPendingReports(String pendingReports) {
		this.pendingReports = pendingReports;
	}

	public String getNextSurveyType() {
		return nextSurveyType;
	}

	public void setNextSurveyType(String nextSurveyType) {
		this.nextSurveyType = nextSurveyType;
	}

	public String getDegreeName() {
		return degreeName;
	}

	public void setDegreeName(String degreeName) {
		this.degreeName = degreeName;
	}

	public String getDateAddedWord() {
		return dateAddedWord;
	}

	public void setDateAddedWord(String dateAddedWord) {
		this.dateAddedWord = dateAddedWord;
	}

	public String getSurveyDate() {
		return surveyDate;
	}

	public void setSurveyDate(String surveyDate) {
		this.surveyDate = surveyDate;
	}

	public String getLapseDate() {
		return lapseDate;
	}

	public void setLapseDate(String lapseDate) {
		this.lapseDate = lapseDate;
	}

	public String getCurrentDecision() {
		return currentDecision;
	}

	public void setCurrentDecision(String currentDecision) {
		this.currentDecision = currentDecision;
	}

	public String getDecisionBy() {
		return decisionBy;
	}

	public void setDecisionBy(String decisionBy) {
		this.decisionBy = decisionBy;
	}
	
	
}

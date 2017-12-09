package Models;


public class Accreditation {

	private int surveyID;
	private int SPID;
	private String institution;
	private String from;
	private String to;
	private String program;
	private String areas;
	
	public Accreditation(){
		
	}
	

	public Accreditation(int surveyID, int SPID, String institution, String type, String from, String to, String position, String programs,
			String areas) {
		super();
		this.surveyID = surveyID;
		this.SPID = SPID;
		this.institution = institution;
		this.from = from;
		this.to = to;
		this.program = programs;
		this.areas = areas;
	}
	
	public Accreditation(String institution, String type, String from, String to, String position, String programs,
			String areas) {
		super();
		this.institution = institution;
		this.from = from;
		this.to = to;
		this.program = programs;
		this.areas = areas;
	}
	
	

	public String getProgram() {
		return program;
	}


	public void setProgram(String program) {
		this.program = program;
	}


	public String getAreas() {
		return areas;
	}


	public void setAreas(String areas) {
		this.areas = areas;
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


	public void setSPID(int SPID) {
		this.SPID = SPID;
	}

	public String getInstitution() {
		return institution;
	}
	public void setInstitution(String institution) {
		this.institution = institution;
	}
	
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	
}

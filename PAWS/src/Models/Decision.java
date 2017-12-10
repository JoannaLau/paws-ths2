package Models;

public class Decision 
{
	private int decisionID;
	private String decisionBy;
	private String decision;
	private String validThru;
	private String remarks;
	private int PSID;
	private String institution;
	private String degreeName;
	
	
	public Decision() {
	}
	
	
	
	public Decision(int decisionID, String decisionBy, String decision, String validThru, String remarks, int pSID,
			String institution, String degreeName) {
		super();
		this.decisionID = decisionID;
		this.decisionBy = decisionBy;
		this.decision = decision;
		this.validThru = validThru;
		this.remarks = remarks;
		PSID = pSID;
		this.institution = institution;
		this.degreeName = degreeName;
	}



	public String getInstitution() {
		return institution;
	}



	public void setInstitution(String institution) {
		this.institution = institution;
	}



	public String getDegreeName() {
		return degreeName;
	}



	public void setDegreeName(String degreeName) {
		this.degreeName = degreeName;
	}



	public int getDecisionID() {
		return decisionID;
	}
	public void setDecisionID(int decisionID) {
		this.decisionID = decisionID;
	}
	public String getDecisionBy() {
		return decisionBy;
	}
	public void setDecisionBy(String decisionBy) {
		this.decisionBy = decisionBy;
	}
	public String getDecision() {
		return decision;
	}
	public void setDecision(String decision) {
		this.decision = decision;
	}
	public String getValidThru() {
		return validThru;
	}
	public void setValidThru(String validThru) {
		this.validThru = validThru;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public int getPSID() {
		return PSID;
	}
	public void setPSID(int pSID) {
		this.PSID = pSID;
	}
	
	
	
}

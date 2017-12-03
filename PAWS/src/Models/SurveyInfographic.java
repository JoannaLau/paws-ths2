package Models;

public class SurveyInfographic {
	
	
	
	private int year;
	private int preliminary;
	private int formal;
	private int resurvey;
	private int interim;
	private int total; 
	
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getPreliminary() {
		return preliminary;
	}
	public void setPreliminary(int preliminary) {
		this.preliminary = preliminary;
	}
	public int getFormal() {
		return formal;
	}
	public void setFormal(int formal) {
		this.formal = formal;
	}
	public int getResurvey() {
		return resurvey;
	}
	public void setResurvey(int resurvey) {
		this.resurvey = resurvey;
	}
	public int getInterim() {
		return interim;
	}
	public void setInterim(int interim) {
		this.interim = interim;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
	
	public SurveyInfographic(int a, int b, int c, int d, int e) {
		year = a;
		preliminary = b;
		formal = c;
		resurvey = d;
		interim = e;
		total = (b+c+d+e);
	
	
	
	}


}
	



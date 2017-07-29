package Models;

public class Infographic {
	

	private int year;
	private int gradeSchool; 
	private int highSchool;
	private int basicEd;
	private int tertiary;
	private int graduate;
	private int medical;
	private int cecste;
	private int total;
	
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getGradeSchool() {
		return gradeSchool;
	}
	public void setGradeSchool(int gradeSchool) {
		this.gradeSchool = gradeSchool;
	}
	public int getHighSchool() {
		return highSchool;
	}
	public void setHighSchool(int highSchool) {
		this.highSchool = highSchool;
	}
	public int getMedical() {
		return medical;
	}
	public void setMedical(int medical) {
		this.medical = medical;
	}
	public int getGraduate() {
		return graduate;
	}
	public void setGraduate(int graduate) {
		this.graduate = graduate;
	}
	public int getTertiary() {
		return tertiary;
	}
	public void setTertiary(int tertiary) {
		this.tertiary = tertiary;
	}
	public int getBasicEd() {
		return basicEd;
	}
	public void setBasicEd(int basicEd) {
		this.basicEd = basicEd;
	}
	

	public int getCecste() {
		return cecste;
	}
	public void setCecste(int secste) {
		this.cecste = secste;
	}
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}

	
	public Infographic(int a, int b, int c, int d, int e, int f, int g, int h){
		
	    year=a;
		gradeSchool=b; 
		highSchool=c;
		basicEd=d;
		tertiary=e;
		graduate=f;
		medical=g;
		cecste = h;
		
		total = (b+c+d+e+f+g+h);
		
	}
	
}

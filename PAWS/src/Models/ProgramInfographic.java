package Models;

public class ProgramInfographic {

	private int year;
	private int tertiary;
	private int graduate;
	
	
	public int getTertiary() {
		return tertiary;
	}
	public void setTertiary(int tertiary) {
		this.tertiary = tertiary;
	}
	public int getGraduate() {
		return graduate;
	}
	public void setGraduate(int graduate) {
		this.graduate = graduate;
	}
	
	
	
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}

	public ProgramInfographic(){
		
	}
	

	public ProgramInfographic(int a, int b, int c){
		year =a;
		tertiary =b;
		graduate = c;
		
		
	}
}

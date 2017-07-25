package Models;

public class Area {

	private int areaID;
	private String area;
	
	
	public Area(int areaID, String area) {
		super();
		this.areaID = areaID;
		this.area = area;
	}
	
	public int getAreaID() {
		return areaID;
	}
	public void setAreaID(int areaID) {
		this.areaID = areaID;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}

	
}

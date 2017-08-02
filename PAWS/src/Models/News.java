package Models;

import java.io.File;

public class News {

	private int newsID;
	private String title;
	private String content;
	private String date;
	private String image;
	
	public News(){}
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

	

	public int getNewsID() {
		return newsID;
	}


	public void setNewsID(int newsID) {
		this.newsID = newsID;
	}
	


public String getImage() {
	return image;
}

public void setImage(String image) {
	this.image = image;
}

	
	
	
public News(int newsID, String title, String content, String date){
		
		super();
		this.newsID = newsID;
		this.title = title;
		this.content = content;
		this.date = date;
		
		
	}

	
}

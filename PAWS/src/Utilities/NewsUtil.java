package Utilities;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mysql.jdbc.Connection;

import Models.News;
import Models.Program;



public class NewsUtil {

	
	private DBUtil db;

	
	public NewsUtil(){
		db = new DBUtil();
	}
	
	
	
	
	
	private String formatDate(String date){
		String format = new String();
		String month = "";
		String day;
		String year;
		String[] parts = date.split(" ");
		if(parts[1].equals("Jan")){
			month = "01";
		}else if(parts[1].equals("Feb")){
			month = "02";
		}else if(parts[1].equals("Mar")){
			month = "03";
		}else if(parts[1].equals("Apr")){
			month = "04";
		}else if(parts[1].equals("May")){
			month = "05";
		}else if(parts[1].equals("Jun")){
			month = "06";
		}else if(parts[1].equals("Jul")){
			month = "07";
		}else if(parts[1].equals("Aug")){
			month = "08";
		}else if(parts[1].equals("Sep")){
			month = "09";
		}else if(parts[1].equals("Oct")){
			month = "10";
		}else if(parts[1].equals("Nov")){
			month = "11";
		}else if(parts[1].equals("Dec")){
			month = "12";
		}
		year = parts[4];

		parts = parts[1].split(",");
		day = parts[2];
		
		format = year + "-" + month + "-"+ day;
		return format;
	}
	
	
	
	public void addNews(String title, String content, String date){
		try{
			Connection conn = db.getConnection();

			PreparedStatement ps = conn.prepareStatement("INSERT INTO `pads`.`news`(title, content, date) VALUES (?, ?, ?)");
			ps.setString(1, title);
			ps.setString(2, content);
			ps.setString(3, date);
			ps.executeUpdate();			
		} catch (Exception e){
			System.out.println("Error in NewsUtil:addNews()");
			e.printStackTrace();	
		}
	}
	
	
	
	
	
	
	
	public News getNews(int newsID){
		News temp = new News();
		try{
			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM programs WHERE programID=?");
			ps.setInt(1, newsID);
			ResultSet rs = ps.executeQuery();
			rs.next();
			temp = new News(rs.getString(2), rs.getString(3), rs.getString(4));
		} catch (Exception e){
			System.out.println("Error in NewsUtil:getNews()");
			e.printStackTrace();
		}
		
	    return temp;
	}
	
	
	
	
	

	public JSONArray getAllNewsJSON(){
		JSONArray jArray = new JSONArray();
		JSONObject job = new JSONObject();
		
		try{
			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM `news` ORDER BY `newsID`");
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				job = new JSONObject();
				job.put("title", rs.getString(2));
				job.put("content", rs.getString(3));
				job.put("date", rs.getString(4));
				
				

				jArray.put(job);
				
			}
		} catch (Exception e){
			System.out.println("Error in InstitutionsUtil:getAllInstitutionsJSON()");
			e.printStackTrace();
		}
		
		return jArray;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
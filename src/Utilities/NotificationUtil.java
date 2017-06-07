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

import Models.Accreditor;
import Models.Notification;

public class NotificationUtil {
	private DBUtil db;
	
	public NotificationUtil(){		
			db = new DBUtil();
	}
	
	
	public ArrayList<Notification> getAllNotifications (){
		ArrayList<Notification> notifs = new ArrayList<Notification>();
		Notification temp = new Notification();
		try{
			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM notifications");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
								
				int notificationID = rs.getInt(1);
				String content = rs.getString(2);
				String date_created = rs.getString(3);
				String status = rs.getString(4);
				String type = rs.getString(5);
				
				temp = new Notification(notificationID, content, date_created, status, type);
				notifs.add(temp);
			}
		} catch (Exception e){
			System.out.println("Error in AccreditorUtil:getAccreditors()");
			e.printStackTrace();
		}
		
	    return notifs;
	}
	
	public ArrayList<Notification> getAwardNotifications (){
		ArrayList<Notification> notifs = new ArrayList<Notification>();
		Notification temp = new Notification();
		try{
			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM notifications where type = ?");
			ps.setString(1,"Awards");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
								
				int notificationID = rs.getInt(1);
				String content = rs.getString(2);
				String date_created = rs.getString(3);
				String status = rs.getString(4);
				String type = rs.getString(5);
				
				temp = new Notification(notificationID, content, date_created, status, type);
				notifs.add(temp);
			}
		} catch (Exception e){
			System.out.println("Error in AccreditorUtil:getAccreditors()");
			e.printStackTrace();
		}
		
	    return notifs;
	}

	
	public ArrayList<Notification> getExpirationNotifications (){
		ArrayList<Notification> notifs = new ArrayList<Notification>();
		Notification temp = new Notification();
		try{
			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM notifications where type = ?");
			ps.setString(1,"Expirations");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
								
				int notificationID = rs.getInt(1);
				String content = rs.getString(2);
				String date_created = rs.getString(3);
				String status = rs.getString(4);
				String type = rs.getString(5);
				
				temp = new Notification(notificationID, content, date_created, status, type);
				notifs.add(temp);
			}
		} catch (Exception e){
			System.out.println("Error in AccreditorUtil:getAccreditors()");
			e.printStackTrace();
		}
		
	    return notifs;
	}

	
	public ArrayList<Notification> getUnconfirmedNotifications (){
		ArrayList<Notification> notifs = new ArrayList<Notification>();
		Notification temp = new Notification();
		try{
			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM notifications where type = ?");
			ps.setString(1,"UnconfirmedSurveys");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
								
				int notificationID = rs.getInt(1);
				String content = rs.getString(2);
				String date_created = rs.getString(3);
				String status = rs.getString(4);
				String type = rs.getString(5);
				
				temp = new Notification(notificationID, content, date_created, status, type);
				notifs.add(temp);
			}
		} catch (Exception e){
			System.out.println("Error in AccreditorUtil:getAccreditors()");
			e.printStackTrace();
		}
		
	    return notifs;
	}

	
	
	
}

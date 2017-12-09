package Utilities;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mysql.jdbc.Connection;

import Models.SchoolSystem;

public class SchoolSystemUtil {
	
private DBUtil db;
public SchoolSystemUtil(){
	db = new DBUtil();
}

public SchoolSystem getSchoolSystem(int ssID){
	SchoolSystem temp = new SchoolSystem();
	try{
		Connection conn = db.getConnection();
		PreparedStatement ps = conn.prepareStatement("SELECT systemID, name, dateJoined FROM `school-systems` WHERE systemID = "+ ssID +"");
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()){
			temp = new SchoolSystem(rs.getInt(1),rs.getString(2), rs.getString(3));

		}
	} catch (Exception e){
		System.out.println("Error in ProgramUtil:getSchoolSystems()");
		e.printStackTrace();
	}
	
    return temp;
}


public ArrayList<SchoolSystem> getSchoolSystemsChanges() {
	ArrayList<SchoolSystem> schoolsystems = new ArrayList<SchoolSystem>();
	SchoolSystem temp = new SchoolSystem();
	try{
		Connection conn = db.getConnection();
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM `school-systems-changes` ORDER BY `name`");
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()){
			//constructor is (int accreditorID, String name, String institution, String discipline, String primaryArea, 
			// String secondaryArea, int totalSurveys, String city)
			//db returns accreditorID, lastname, firstname, midlename, honorifics, 
			//email, num_surveys, date_trained, contact, address, city, country, venue_trained
			temp = new SchoolSystem(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getDate(4));
			temp.setNumberOfInstitutions(getInstitutionCount(temp.getSchoolSystemID()));
			schoolsystems.add(temp);
		}
	} catch (Exception e){
		System.out.println("Error in ProgramUtil:getSchoolSystems()");
		e.printStackTrace();
	}
	return schoolsystems;
}


public ArrayList<SchoolSystem> getSchoolSystems(){
	ArrayList<SchoolSystem> schoolsystems = new ArrayList<SchoolSystem>();
	SchoolSystem temp = new SchoolSystem();
	try{
		Connection conn = db.getConnection();
		PreparedStatement ps = conn.prepareStatement("SELECT systemID, name, dateJoined FROM `school-systems`  ORDER BY `name`");
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()){
			//constructor is (int accreditorID, String name, String institution, String discipline, String primaryArea, 
			// String secondaryArea, int totalSurveys, String city)
			//db returns accreditorID, lastname, firstname, midlename, honorifics, 
			//email, num_surveys, date_trained, contact, address, city, country, venue_trained
			temp = new SchoolSystem(rs.getInt(1),rs.getString(2), rs.getString(3));
			temp.setNumberOfInstitutions(getInstitutionCount(temp.getSchoolSystemID()));
			schoolsystems.add(temp);
		}
	} catch (Exception e){
		System.out.println("Error in ProgramUtil:getSchoolSystems()");
		e.printStackTrace();
	}
	
    return schoolsystems;
}

public int getInstitutionCount(int ID){
	int count=0;
	try{
		Connection conn = db.getConnection();
		PreparedStatement ps = conn.prepareStatement("SELECT count(*) FROM institutions WHERE systemID = ?");
		ps.setInt(1,ID);
		ResultSet rs = ps.executeQuery();
		rs.next();
		return rs.getInt(1);
		
	} catch (Exception e){
		System.out.println("Error in ProgramUtil:getSchoolSystems()");
		e.printStackTrace();
	}
	
    return count;
}


public JSONArray getSystems(){
	JSONArray jArray = new JSONArray();
	JSONObject job = new JSONObject();
	
	try{
		Connection conn = db.getConnection();
		PreparedStatement ps = conn.prepareStatement("SELECT systemID, name FROM `school-systems`  ORDER BY `name`");
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			job = new JSONObject();
			job.put("systemID", rs.getInt(1));
			job.put("systemName", rs.getString(2));
			jArray.put(job);
			System.out.println(rs.getInt(1) + rs.getString(2) + "jugjug");
			
		}
	} catch (Exception e){
		System.out.println("Error in SchoolSystemUtil:getSystems()");
		e.printStackTrace();
	}
	
	return jArray;
}

public void addSchoolSystem(String name, String date_joined){
	try{
		Connection conn = db.getConnection();
		PreparedStatement ps = conn.prepareStatement("INSERT INTO `school-systems` (name, dateJoined) VALUES (?,?)");
		ps.setString(1, name);
		ps.setString(2, date_joined);
		if(ps.executeUpdate() > 0)
		{
			try{
				ps  = conn.prepareStatement("SELECT MAX(systemID) FROM `school-systems`");
				ResultSet rs = ps.executeQuery();
				if(rs.first())
				{
					
					PreparedStatement ps2  = conn.prepareStatement("INSERT INTO `school-systems-changes` (systemID, name, dateJoined, dateChanged) VALUES (?,?,?,?)");
					ps2.setInt(1, rs.getInt(1));
					ps2.setString(2, name);
					ps2.setString(3, date_joined);
					Date date = new Date();
					String modifiedDate= new SimpleDateFormat("yyyy-MM-dd").format(date);
					ps2.setString(4, modifiedDate);
					ps2.executeUpdate();
				}
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
	} catch (Exception e){
		System.out.println("Error in ProgramUtil:addSystem()");
		e.printStackTrace();	
	}
}

public void editSchoolSystem(int systemID, String name, String date_joined){
	try{
		Connection conn = db.getConnection();
		PreparedStatement ps = conn.prepareStatement("UPDATE `school-systems` SET name=?, dateJoined=? WHERE systemID=?");
		ps.setString(1, name);
		ps.setString(2, date_joined);
		ps.setInt(3,systemID);
//		System.out.println(name + " " + date_joined +"!!!!!!!!!!!!!!");	
		if(ps.executeUpdate() > 0)
		{
			ps = conn.prepareStatement("SELECT * FROM `school-systems-changes` WHERE systemID = ?");
			ps.setInt(1, systemID);
			ResultSet rs = ps.executeQuery();
			//ss is in change
			if(rs.first())
			{
				try{
					PreparedStatement ps2 = conn.prepareStatement("UPDATE `school-systems-changes` SET name=?, dateJoined=? WHERE systemID=?");
					ps2.setString(1, name);
					ps2.setString(2, date_joined);
					ps2.setInt(3,systemID);
					
					ps2.executeUpdate();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			else
			{
				try{
					PreparedStatement ps2 = conn.prepareStatement("INSERT INTO `school-systems-changes` (systemID, name, dateJoined) VALUES (?,?,?)");

					ps2.setInt(1,systemID);
					ps2.setString(2, name);
					ps2.setString(3, date_joined);
					
					ps2.executeUpdate();	

				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			
		}
	} catch (Exception e){
		System.out.println("Error in ProgramUtil:addSystem()");
		e.printStackTrace();	
	}
}

public void deleteSchoolSystem(int schoolSystemID){
	try{
		Connection conn = db.getConnection();
		PreparedStatement ps = conn.prepareStatement("DELETE from `school-systems` WHERE systemID = ?");
		ps.setInt(1, schoolSystemID);
		ps.executeUpdate();
	} catch (Exception e){
		System.out.println("Error in SchoolSystemUtil:deleteSchoolSystem()");
		e.printStackTrace();
	}
}

public int deleteSchoolSystemsChanges(ArrayList<SchoolSystem> ssList) {
	int rows = 0;
	
	for(int i = 0; i<ssList.size(); i++)
		{
		try{
			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement("DELETE from `school-systems-changes` WHERE systemID = ?");
			ps.setInt(1, ssList.get(i).getSchoolSystemID());
			if(ps.executeUpdate() > 0)
				rows++;
		} catch (Exception e){
			System.out.println("Error in SchoolSystemUtil:deleteSchoolSystem()");
			e.printStackTrace();
		}
	}
	return rows;
}


//public void editProgram(int programID, String name){
//	try{
//		Connection conn = db.getConnection();
//		PreparedStatement ps = conn.prepareStatement("UPDATE programs SET name = ? WHERE programID = ?");
//		ps.setString(1, name);
//		ps.setInt(2, programID);
//		ps.executeUpdate();
//	} catch (Exception e){
//		System.out.println("Error in ProgramUtil:editProgram()");
//		e.printStackTrace();
//	}
//}

}

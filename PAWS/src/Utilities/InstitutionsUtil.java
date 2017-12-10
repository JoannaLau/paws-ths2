package Utilities;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mysql.jdbc.Connection;

import Models.BoardMember;
import Models.Decision;
import Models.Infographic;
import Models.Institution;
import Models.SchoolProgram;

public class InstitutionsUtil {
	private DBUtil db;
	public InstitutionsUtil(){
		db = new DBUtil();
	}
	

	public JSONArray getInstitutionsJSON(int systemID){
		JSONArray jArray = new JSONArray();
		JSONObject job = new JSONObject();
		  
		try{
			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT institutionID, name, city FROM `institutions` WHERE systemID = ?  ORDER BY `name`");
			ps.setInt(1, systemID);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				job = new JSONObject();
				job.put("institutionID", rs.getInt(1));
				job.put("institutionName", rs.getString(2) + " - " + rs.getString(3));
				jArray.put(job);
			}
		} catch (Exception e){
			System.out.println("Error in InstitutionsUtil:getInstitutionsJSON()");
			e.printStackTrace();
		}
		
		return jArray;
	}
	
	//NEW
	public JSONArray getInvitationInstitutionsJSON(){
		JSONArray jArray = new JSONArray();
		JSONObject job = new JSONObject();
		
		try{
			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT institutionID, name, city FROM institutions");
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				job = new JSONObject();
				job.put("institutionID", rs.getInt(1));
				job.put("institutionName", rs.getString(2));
				job.put("city", rs.getString(3));
				
				
				jArray.put(job);
				
			}
		} catch (Exception e){
			System.out.println("Error in InstitutionsUtil:getInvitationInstitutionsJSON()");
			e.printStackTrace();
		}
		
		return jArray;
	}
	
	//NEW
	public JSONArray getInstitutionForInvitationJSON(int instID){
		JSONArray jArray = new JSONArray();
		JSONObject job = new JSONObject();
		
		try{
			Connection conn = db.getConnection();
			//PreparedStatement ps = conn.prepareStatement("SELECT name, head, hPosition, city FROM `institutions` WHERE institutionID = (SELECT institutionID FROM `work` WHERE accreditorID = ? AND dateFinished IS NULL)");
			PreparedStatement ps = conn.prepareStatement("SELECT head, hPosition, name, city FROM `institutions` WHERE institutionID = ?");
			ps.setInt(1, instID);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				job = new JSONObject();
				job.put("head", rs.getString(1));
				job.put("hPosition", rs.getString(2));
				job.put("name", rs.getString(3));
				job.put("city", rs.getString(4));
				
				

				jArray.put(job);
				
			}
		} catch (Exception e){
			System.out.println("Error in InstitutionsUtil:getInstitutionForInvitationJSON()");
			e.printStackTrace();
		}
		
		return jArray;
	}
	
	//NEW
	public JSONArray getInstitutionInSurveysJSON(int date){
		JSONArray jArray = new JSONArray();
		JSONObject job = new JSONObject();
		
		try{
			Connection conn = db.getConnection();
			//PreparedStatement ps = conn.prepareStatement("SELECT name, head, hPosition, city FROM `institutions` WHERE institutionID = (SELECT institutionID FROM `work` WHERE accreditorID = ? AND dateFinished IS NULL)");
			PreparedStatement ps = conn.prepareStatement("SELECT institutionID, name, city FROM `institutions` WHERE institutionID IN (SELECT DISTINCT institutionID from surveys WHERE startDate > ?)");
			ps.setInt(1, date);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				job = new JSONObject();
				job.put("institutionID", rs.getInt(1));
				job.put("institutionName", rs.getString(2));
				job.put("city", rs.getString(3));
				
				
				
				jArray.put(job);
				
			}
		} catch (Exception e){
			System.out.println("Error in InstitutionsUtil:getInstitutionInSurveysJSON()");
			e.printStackTrace();
		}
		
		return jArray;
	}
	


	//NEW
	public JSONArray getSurveysOfInstitutionJSON(int ID, int date){
		JSONArray jArray = new JSONArray();
		JSONObject job = new JSONObject();
		
		try{
			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT ps.PSID, s.surveyID, sp.degreeName, s.startDate, s.endDate, ps.surveyType FROM `program-survey` ps, surveys s, `school-program` sp WHERE ps.surveyID = s.surveyID AND ps.SPID = sp.SPID AND s.surveyID IN (SELECT surveyID from surveys WHERE institutionID = ? AND startDate > ?)");
			ps.setInt(1, ID);
			ps.setInt(2, date);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				job = new JSONObject();
				
				job.put("PSID", rs.getInt(1));
				job.put("surveyID", rs.getInt(2));
				job.put("degreeName", rs.getString(3));
				job.put("startDate", formatDateDash(rs.getString(4)));
				job.put("endDate", formatDateDash(rs.getString(5)));
				job.put("type", rs.getString(6));
				

				jArray.put(job);
				
			}
		} catch (Exception e){
			System.out.println("Error in InstitutionsUtil:getSurveysOfInstitutionJSON()");
			e.printStackTrace();
		}
		
		return jArray;
	}
	
	//NEW
	public JSONArray getNextSurveyInstitutions() {
		JSONArray jArray = new JSONArray();
		JSONObject job = new JSONObject();
		
		try{
			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT DISTINCT i.institutionID, i.name, i.city FROM `school-program` sp, institutions i WHERE sp.institutionID = i.institutionID AND sp.nextSurveySched LIKE ?");
			ps.setString(1, "%" +  String.valueOf((Calendar.getInstance().get(Calendar.YEAR) + 1)) + "%");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				job = new JSONObject();
				
				job.put("institutionID", rs.getInt(1));
				job.put("institutionName", rs.getString(2));
				job.put("city", rs.getString(3));
				
				jArray.put(job);
				
			}
		} catch (Exception e){
			System.out.println("Error in InstitutionsUtil:getInstitutionInSurveysJSON()");
			e.printStackTrace();
		}
		
		return jArray;
	}
	
	//NEW
	public JSONArray getNextSurveyInstitutionPrograms(int instID) {
		JSONArray jArray = new JSONArray();
		JSONObject job = new JSONObject();
		
		try{
			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT sp.degreeName, sp.nextSurveySched FROM `school-program` sp WHERE sp.institutionID = ? AND sp.nextSurveySched LIKE ?");
			ps.setInt(1, instID);
			ps.setString(2, "%" +  String.valueOf((Calendar.getInstance().get(Calendar.YEAR) + 1)) + "%");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				job = new JSONObject();
				job.put("degreeName", rs.getString(1));
				job.put("nextSched", rs.getString(2));
				
				jArray.put(job);
				
			}
		} catch (Exception e){
			System.out.println("Error in InstitutionsUtil:getInstitutionInSurveysJSON()");
			e.printStackTrace();
		}
		
		return jArray;
	}

	
	//OLD
	public JSONArray getDuplicateCheckerJSON(){
		JSONArray jArray = new JSONArray();
		JSONObject job = new JSONObject();
		
		try{
			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT systemID, name, city FROM `institutions`");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				job = new JSONObject();
				job.put("ssID", rs.getInt(1));
				job.put("institutionName", rs.getString(2)); 
				job.put("city", rs.getString(3));
				jArray.put(job);				
			}
		} catch (Exception e){
			System.out.println("Error in InstitutionUtil:getDuplicateCheckerJSON()");
			e.printStackTrace();
		}
		
		return jArray;
	}
	
	
	//NEW
	public JSONArray getAllInstitutionsJSON(){
		JSONArray jArray = new JSONArray();
		JSONObject job = new JSONObject();
		
		try{
			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT name, systemID, acronym, dateAdded, city, institutionID FROM `institutions` ORDER BY `name`");
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				job = new JSONObject();
				job.put("institutionName", rs.getString(1));
				job.put("system", getSchoolSystemName(rs.getInt(2)));
				job.put("acronym", rs.getString(3));
				job.put("dateAdded", formatDate_yearFirst(rs.getString(4)));
				job.put("city", rs.getString(5));
				job.put("institutionID", rs.getInt(6));
				

				jArray.put(job);
				
			}
		} catch (Exception e){
			System.out.println("Error in InstitutionsUtil:getAllInstitutionsJSON()");
			e.printStackTrace();
		}
		
		return jArray;
	}
	
	//NEW
	public JSONArray getAllInstitutionsNoSystemJSON(){
		JSONArray jArray = new JSONArray();
		JSONObject job = new JSONObject();
		
		try{
			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT name, acronym, dateAdded, city, institutionID FROM `institutions` WHERE systemID = 0 ORDER BY `name`");
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				job = new JSONObject();
				job.put("institutionName", rs.getString(1));
				job.put("acronym", rs.getString(2));
				job.put("dateAdded", formatDate_yearFirst(rs.getString(3)));
				job.put("city", rs.getString(4));
				job.put("institutionID", rs.getInt(5));
				

				jArray.put(job);
				
			}
		} catch (Exception e){
			System.out.println("Error in InstitutionsUtil:getAllInstitutionsJSON()");
			e.printStackTrace();
		}
		
		return jArray;
	}
	
	
	//NEW
	private String getEducLevelName(int educLevelID)
	{
		String name="";
		
		try{
			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT `levelName` FROM `educationlevel` where `levelID`=?");
			ps.setInt(1, educLevelID);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){				
			
				name = rs.getString(1);
			}
		} catch (Exception e){
			System.out.println("Error in InstitutionsUtil:getEducLevelName()");
			e.printStackTrace();
		}
		
		return name;
	}
	
	private String getSchoolSystemName(int ID){
		String name="";
		
		try{
			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT `name` FROM `school-systems` where `systemID`=?");
			ps.setInt(1, ID);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){				
			
				name = rs.getString(1);
				System.out.println("Checking schoolsystemName: "+ name);
			}
		} catch (Exception e){
			System.out.println("Error in InstitutionsUtil:getSchoolSystemName()");
			e.printStackTrace();
		}
		
		return name;
	}
	
	
	
	public ArrayList<Institution> getInstitutions(){
		ArrayList<Institution> institutions = new ArrayList<Institution>();
		Institution temp = new Institution();
		/*FTPDemo demo = new FTPDemo();
		*/
		try{
			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM institutions ORDER BY `name`");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				//constructor is (int accreditorID, String name, String institution, String discipline, String primaryArea, 
				// String secondaryArea, int totalSurveys, String city)
				//db returns accreditorID, lastname, firstname, midlename, honorifics, email, num_surveys, 
				//date_trained, contact, address, city, country, venue_trained, primaryAreaID, 
				//secondaryAreaID, discipline
				
				
			
				System.out.println(rs.getString(3));
				temp = new Institution(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17), rs.getString(18));
				temp.setSchoolSystemName(getSchoolSystemName(rs.getInt(2)));
				
				institutions.add(temp);
			}
		} catch (Exception e){
			System.out.println("Error in InstitutionsUtil:getInstitutions()");
			e.printStackTrace();
		}
		
	    return institutions;
	}
	
		
	//NEW

	public ArrayList<Institution> getInstitutionsChanges(){
		ArrayList<Institution> institutions = new ArrayList<Institution>();
		Institution temp = new Institution();
		try{
			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM `institutions-changes` ORDER BY `name`");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				
			
				System.out.println(rs.getString(3));
				temp = new Institution(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17), rs.getString(18), rs.getDouble(19), rs.getDouble(20), rs.getDate(21));
				temp.setSchoolSystemName(getSchoolSystemName(rs.getInt(2)));
				
				institutions.add(temp);
			}
			
		} catch (Exception e){
			System.out.println("Error in InstitutionsUtil:getInstitutionsChanges()");
			e.printStackTrace();
		}
		
	    return institutions;
	}
	
	//NEW
	public JSONArray getExistingDecisionJSON(int PSID){
		
		JSONArray jArray = new JSONArray();
		JSONObject job = new JSONObject();
		
		try{
			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT d.decisionID, d.decisionBy, d.decision, d.validThru, d.remarks, d.PSID, i.name, sp.degreeName FROM `decisions` d, institutions i, `school-program` sp, `program-survey` ps WHERE d.PSID = ps.PSID AND ps.SPID = sp.SPID AND sp.institutionID = i.institutionID AND d.PSID = ?");
			ps.setInt(1, PSID);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				job = new JSONObject();
				job.put("decisionID", rs.getString(1));
				job.put("decisionBy", rs.getString(2));
				job.put("decision", rs.getString(3));
				job.put("validThru", rs.getString(4));
				job.put("remarks", rs.getString(5));
				job.put("PSID", rs.getInt(6));
				job.put("name", rs.getString(7));
				job.put("degreeName", rs.getString(8));
		
				jArray.put(job);
				
			}
		} catch (Exception e){
			System.out.println("Error in InstitutionsUtil:getAllInstitutionsJSON()");
			e.printStackTrace();
		}
		
		return jArray;
		
		
	}
	
	/*
	//NEW
	public ArrayList<Institution> getInstitutionsNameIDLevel(){
		ArrayList<Institution> institutions = new ArrayList<Institution>();
		Institution temp = new Institution();
		FTPDemo demo = new FTPDemo();
		
		try{
			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT institutionID, name, city, educLevelID FROM institutions ORDER BY `name`");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				//constructor is (int accreditorID, String name, String institution, String discipline, String primaryArea, 
				// String secondaryArea, int totalSurveys, String city)
				//db returns accreditorID, lastname, firstname, midlename, honorifics, email, num_surveys, 
				//date_trained, contact, address, city, country, venue_trained, primaryAreaID, 
				//secondaryAreaID, discipline
				
			
				temp = new Institution(rs.getInt(1), rs.getString(2), rs.getString(3));
				
				institutions.add(temp);
			}
		} catch (Exception e){
			System.out.println("Error in InstitutionsUtil:getInstitutionsNameID()");
			e.printStackTrace();
		}
		
	    return institutions;
	}*/
	
	//NEW
	/*public JSONArray getInstitutionsForLevelJSON(int educLevelID){
		JSONArray jArray = new JSONArray();
		JSONObject job = new JSONObject();
		
		try{
			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT name, systemID, acronym, dateAdded, city, institutionID, educLevelID FROM `institutions` WHERE educLevelID = ? ORDER BY `name`");
			ps.setInt(1, educLevelID);
		
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				job = new JSONObject();
				job.put("institutionName", rs.getString(1));
				job.put("system", getSchoolSystemName(rs.getInt(2)));
				job.put("acronym", rs.getString(3));
				job.put("dateAdded", formatDate_yearFirst(rs.getString(4)));
				job.put("city", rs.getString(5));
				job.put("institutionID", rs.getInt(6));
				job.put("educLevel", getEducLevelName(rs.getInt(7)));
				

				jArray.put(job);
				
			}
		} catch (Exception e){
			System.out.println("Error in InstitutionsUtil:getInstitutionsForLevelJSON()");
			e.printStackTrace();
		}
		
		return jArray;
	}*/

	//NEW
	public String getInstitutionName(int institutionID){
		String name = "";
		Institution temp = new Institution();
		try{
			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT name FROM institutions WHERE `institutionID` = ?");
			
			ps.setInt(1, institutionID);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				//constructor is (int accreditorID, String name, String institution, String discipline, String primaryArea, 
				// String secondaryArea, int totalSurveys, String city)
				//db returns accreditorID, lastname, firstname, midlename, honorifics, email, num_surveys, 
				//date_trained, contact, address, city, country, venue_trained, primaryAreaID, 
				//secondaryAreaID, discipline
				
				
			
				name = rs.getString(1);
				
			}
		} catch (Exception e){
			System.out.println("Error in InstitutionsUtil:getInstitutions()");
			e.printStackTrace();
		}
		return name;
	}
	
	public ArrayList<Institution> getSchoolSystemInstitutions(int systemID){
		ArrayList<Institution> institutions = new ArrayList<Institution>();
		Institution temp = new Institution();
		try{
			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM institutions WHERE `systemID` = ?  ORDER BY `name`");
			ps.setInt(1, systemID);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				//constructor is (int accreditorID, String name, String institution, String discipline, String primaryArea, 
				// String secondaryArea, int totalSurveys, String city)
				//db returns accreditorID, lastname, firstname, midlename, honorifics, email, num_surveys, 
				//date_trained, contact, address, city, country, venue_trained, primaryAreaID, 
				//secondaryAreaID, discipline
			
				System.out.println(rs.getString(3));
				temp =  new Institution(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17), rs.getString(18));
				institutions.add(temp);
			}
		} catch (Exception e){
			System.out.println("Error in InstitutionsUtil:getSchoolSystemInstitutions()");
			e.printStackTrace();
		}
		
	    return institutions;
	}
	
	public Institution getInstitution(int instID){
		Institution temp = new Institution();
		try{
			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM institutions where institutionID = ?");
			ps.setInt(1,  instID);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				temp =  new Institution(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17), rs.getString(18), rs.getDouble(19), rs.getDouble(20));
			}
		} catch (Exception e){
			System.out.println("Error in InstitutionsUtil:getInstitution()");
			e.printStackTrace();
		}
		
	    return temp;
	}
	
	
	
	public void addInstitution(String ssName, String institutionName, String institutionAcronym, String address , String city , String country ,
			String website , String contactNumber , String fax , String institutionHead , String position , String headEmail ,
			String contactPerson , String contactPosition , String contactEmail , String membershipDate){
		try{
		
			String dateBuild = formatDate(membershipDate);
			
			
			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement("INSERT INTO institutions (systemID, name, head, hPosition, hEmail, address, status, dateAdded, city, fax, contactPerson, contactPosition, contactNumber, website, country, contactEmail, acronym) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			int ssID_int = Integer.parseInt(ssName);
			ps.setInt(1, ssID_int);
			ps.setString(2, institutionName);
			ps.setString(3, institutionHead);
			ps.setString(4, position);
			ps.setString(5, headEmail);
			ps.setString(6, address);
			ps.setString(7, "Preliminary Visit");
			ps.setString(8, dateBuild);
			ps.setString(9, city);
			ps.setString(10, fax);
			ps.setString(11, contactPerson);
			ps.setString(12, contactPosition);
			ps.setString(13, contactNumber);
			ps.setString(14, website);
			ps.setString(15, country);
			ps.setString(16, contactEmail);
			ps.setString(17, institutionAcronym);
			
			if(ps.executeUpdate() > 0)
			{
				try{
					PreparedStatement ps1 = conn.prepareStatement("SELECT MAX(institutionID) FROM `institutions`");
					ResultSet rs = ps1.executeQuery();
					while(rs.next())
					{
						int ID = rs.getInt(1);	
						PreparedStatement ps2 = conn.prepareStatement("INSERT INTO `institutions-changes` (institutionID, systemID, name, head, hPosition, hEmail, address, status, dateAdded, city, fax, contactPerson, contactPosition, contactNumber, website, country, contactEmail, acronym, dateChanged) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
						
						ps2.setInt(1, ID);
						ps2.setInt(2, ssID_int);
						ps2.setString(3, institutionName);
						ps2.setString(4, institutionHead);
						ps2.setString(5, position);
						ps2.setString(6, headEmail);
						ps2.setString(7, address);
						ps2.setString(8, "Preliminary Visit");
						ps2.setString(9, dateBuild);
						ps2.setString(10, city);
						ps2.setString(11, fax);
						ps2.setString(12, contactPerson);
						ps2.setString(13, contactPosition);
						ps2.setString(14, contactNumber);
						ps2.setString(15, website);
						ps2.setString(16, country);
						ps2.setString(17, contactEmail);
						ps2.setString(18, institutionAcronym);
						Date date = new Date();
						String modifiedDate= new SimpleDateFormat("yyyy-MM-dd").format(date);
						ps2.setString(19, modifiedDate);
						
						ps2.executeUpdate();
					}
				
				} catch (Exception e){
					System.out.println("Error in InstitutionsUtil:addInstitution()");
					e.printStackTrace();	
				}
				
			}
		} catch (Exception e){
			System.out.println("Error in InstitutionsUtil:addInstitution()");
			e.printStackTrace();	
		}
	}
	
	public void addInstitutionLngLat(String ssName, String institutionName, String institutionAcronym, String address , String city , String country ,
			String website , String contactNumber , String fax , String institutionHead , String position , String headEmail ,
			String contactPerson , String contactPosition , String contactEmail , String membershipDate, Double lng, Double lat){
		try{
			
			String dateBuild = formatDate(membershipDate);
			
			
			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement("INSERT INTO institutions (systemID, name, head, hPosition, hEmail, address, status, dateAdded, city, fax, contactPerson, contactPosition, contactNumber, website, country, contactEmail, acronym, longitude, latitude) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			int ssID_int = Integer.parseInt(ssName);
			ps.setInt(1, ssID_int);
			ps.setString(2, institutionName);
			ps.setString(3, institutionHead);
			ps.setString(4, position);
			ps.setString(5, headEmail);
			ps.setString(6, address);
			ps.setString(7, "Preliminary Visit");
			ps.setString(8, dateBuild);
			ps.setString(9, city);
			ps.setString(10, fax);
			ps.setString(11, contactPerson);
			ps.setString(12, contactPosition);
			ps.setString(13, contactNumber);
			ps.setString(14, website);
			ps.setString(15, country);
			ps.setString(16, contactEmail);
			ps.setString(17, institutionAcronym);
			ps.setDouble(18, lng);
			ps.setDouble(19, lat);
			
			
			if(ps.executeUpdate() > 0)
			{
				try{
					PreparedStatement ps1 = conn.prepareStatement("SELECT MAX(institutionID) FROM `institutions`");
					ResultSet rs = ps1.executeQuery();
					if(rs.first())
					{
						int ID = rs.getInt(1);	
						
						PreparedStatement ps2 = conn.prepareStatement("INSERT INTO `institutions-changes` (institutionID, systemID, name, head, hPosition, hEmail, address, status, dateAdded, city, fax, contactPerson, contactPosition, contactNumber, website, country, contactEmail, acronym, longitude, latitude) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
	
						ps2.setInt(1, ID);
						ps2.setInt(2, ssID_int);
						ps2.setString(3, institutionName);
						ps2.setString(4, institutionHead);
						ps2.setString(5, position);
						ps2.setString(6, headEmail);
						ps2.setString(7, address);
						ps2.setString(8, "Preliminary Visit");
						ps2.setString(9, dateBuild);
						ps2.setString(10, city);
						ps2.setString(11, fax);
						ps2.setString(12, contactPerson);
						ps2.setString(13, contactPosition);
						ps2.setString(14, contactNumber);
						ps2.setString(15, website);
						ps2.setString(16, country);
						ps2.setString(17, contactEmail);
						ps2.setString(18, institutionAcronym);
						ps2.setDouble(19, lng);
						ps2.setDouble(20, lat);
						
						ps2.executeUpdate();
				
					}
				
				} catch (Exception e){
					System.out.println("Error in InstitutionsUtil:addInstitution()");
					e.printStackTrace();	
				}
				
			}
		} catch (Exception e){
			System.out.println("Error in InstitutionsUtil:addInstitution()");
			e.printStackTrace();	
		}
	}
	
	public void editInstitution(int institutionID, String ssName, String institutionName, String institutionAcronym, String address , String city , String country ,
			String website , String contactNumber , String fax , String institutionHead , String position , String headEmail ,
			String contactPerson , String contactPosition , String contactEmail , String membershipDate, Double lng, Double lat){
		try{
			String dateBuild = formatDate(membershipDate);
			
			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement("UPDATE institutions SET systemID=?, name=?, head=?, hPosition=?, hEmail=?, address=?, status=?, dateAdded=?, city=?, fax=?, contactPerson=?, contactPosition=?, contactNumber=?, website=?, country=?, contactEmail=?, acronym=?, longitude=?, latitude=? WHERE institutionID=?");
			int ssID_int = Integer.parseInt(ssName);
			
			ps.setInt(1, ssID_int);
			ps.setString(2, institutionName);
			ps.setString(3, institutionHead);
			ps.setString(4, position);
			ps.setString(5, headEmail);
			ps.setString(6, address);
			ps.setString(7, "Preliminary Visit");
			ps.setString(8, dateBuild);
			ps.setString(9, city);
			ps.setString(10, fax);
			ps.setString(11, contactPerson);
			ps.setString(12, contactPosition);
			ps.setString(13, contactNumber);
			ps.setString(14, website);
			ps.setString(15, country);
			ps.setString(16, contactEmail);
			ps.setString(17, institutionAcronym);
			ps.setDouble(18, lng);
			ps.setDouble(19, lat);
			ps.setInt(20, institutionID);
			
			
			if(ps.executeUpdate() > 0)
			{
				try{
					PreparedStatement ps2 = conn.prepareStatement("SELECT * FROM `institutions-changes` WHERE institutionID=?");
					ps2.setInt(1, institutionID);
					ResultSet rs = ps2.executeQuery();
					
					if(!rs.first())
					{
						try
						{
							System.out.print("INSIDE EXECUTE UPDATE -------------------------------------------------");
							PreparedStatement ps1 = conn.prepareStatement("INSERT INTO `institutions-changes` (institutionID, systemID, name, head, hPosition, hEmail, address, status, dateAdded, city, fax, contactPerson, contactPosition, contactNumber, website, country, contactEmail, acronym, longitude, latitude, dateChanged) VALUES (?, ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
							int ssID_int1 = Integer.parseInt(ssName);
							
							ps1.setInt(1, institutionID);
							ps1.setInt(2, ssID_int1);
							ps1.setString(3, institutionName);
							ps1.setString(4, institutionHead);
							ps1.setString(5, position);
							ps1.setString(6, headEmail);
							ps1.setString(7, address);
							ps1.setString(8, "Preliminary Visit");
							ps1.setString(9, dateBuild);
							ps1.setString(10, city);
							ps1.setString(11, fax);
							ps1.setString(12, contactPerson);
							ps1.setString(13, contactPosition);
							ps1.setString(14, contactNumber);
							ps1.setString(15, website);
							ps1.setString(16, country);
							ps1.setString(17, contactEmail);
							ps1.setString(18, institutionAcronym);
							ps1.setDouble(19, lng);
							ps1.setDouble(20, lat);
							Date date = new Date();
							String modifiedDate= new SimpleDateFormat("yyyy-MM-dd").format(date);
							ps1.setString(21, modifiedDate);
							ps1.executeUpdate();
							
						} catch (Exception e){
							System.out.println("Error in InstitutionsUtil:editInstitution()");
							e.printStackTrace();	
						}
					}
					else
					{
						try
						{
							int ssID_int1 = Integer.parseInt(ssName);
							
							System.out.print("INSIDE EXECUTE UPDATE -------------------------------------------------");
							PreparedStatement ps1 = conn.prepareStatement("UPDATE `institutions-changes` SET systemID=?, name=?, head=?, hPosition=?, hEmail=?, address=?, status=?, dateAdded=?, city=?, fax=?, contactPerson=?, contactPosition=?, contactNumber=?, website=?, country=?, contactEmail=?, acronym=?, longitude=?, latitude=?, dateChanged=? WHERE institutionID=?");
							
							ps1.setInt(1, ssID_int1);
							ps1.setString(2, institutionName);
							ps1.setString(3, institutionHead);
							ps1.setString(4, position);
							ps1.setString(5, headEmail);
							ps1.setString(6, address);
							ps1.setString(7, "Preliminary Visit");
							ps1.setString(8, dateBuild);
							ps1.setString(9, city);
							ps1.setString(10, fax);
							ps1.setString(11, contactPerson);
							ps1.setString(12, contactPosition);
							ps1.setString(13, contactNumber);
							ps1.setString(14, website);
							ps1.setString(15, country);
							ps1.setString(16, contactEmail);
							ps1.setString(17, institutionAcronym);
							ps1.setDouble(18, lng);
							ps1.setDouble(19, lat);
							Date date = new Date();
							String modifiedDate= new SimpleDateFormat("yyyy-MM-dd").format(date);
							ps1.setString(20, modifiedDate);
							
							ps1.setInt(21, institutionID);
							ps1.executeUpdate();
							
						} catch (Exception e){
							System.out.println("Error in InstitutionsUtil:editInstitution()");
							e.printStackTrace();	
						}
					}
				} catch (Exception e){
					System.out.println("Error in InstitutionsUtil:editInstitution()");
					e.printStackTrace();	
				}
			}
		} catch (Exception e){
			System.out.println("Error in InstitutionsUtil:editInstitution()");
			e.printStackTrace();	
		}
	}
	
	//NEW
	public int deleteInstitutionsChanges(ArrayList<Institution> instList) 
	{
		int rows = 0;
		try{
			Connection conn = db.getConnection();
			for(int i = 0; i<instList.size(); i++)
			{
				PreparedStatement ps = conn.prepareStatement("DELETE from `institutions-changes` WHERE institutionID = ?");
				ps.setInt(1, instList.get(i).getInstitutionID());
				if(ps.executeUpdate() > 0)
					rows++;
			}
		} catch (Exception e){
			System.out.println("Error in AccreditorUtil:addAccreditor()");
			e.printStackTrace();
		}
		return rows;
	}
	
	//NEW
	public int deleteSchoolProgramsChanges(ArrayList<SchoolProgram> spList) 
	{
		int rows = 0;
		try{
			Connection conn = db.getConnection();
			for(int i = 0; i<spList.size(); i++)
			{
				PreparedStatement ps = conn.prepareStatement("DELETE from `school-program-changes` WHERE SPID = ?");
				ps.setInt(1, spList.get(i).getSPID());
				if(ps.executeUpdate() > 0)
					rows++;
			}
		} catch (Exception e){
			System.out.println("Error in AccreditorUtil:addAccreditor()");
			e.printStackTrace();
		}
		return rows;
	}
	
	//NEW
	public ArrayList<SchoolProgram> getSchoolProgramChanges()
	{
		ArrayList<SchoolProgram> schoolPrograms = new ArrayList<SchoolProgram>();
		SchoolProgram temp = new SchoolProgram();
		try{
			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM `school-program-changes`");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				temp = new SchoolProgram(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10), rs.getString(11));
				schoolPrograms.add(temp);
			}
			
		} catch (Exception e){
			System.out.println("Error in InstitutionsUtil:getInstitutionsChanges()");
			e.printStackTrace();
		}
		
	    return schoolPrograms;
	}
	
	//MODIFIED
	public void addProgramToInst(String specific, int generalID, int instID, String level, int educLevelID){
		try{
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();
			String strDate = dateFormat.format(date);
			
			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement("INSERT INTO `school-program` (programID, institutionID, accLevel, dateAdded, degreeName, levelID) VALUES (?,?,?,?,?,?)");
		
			ps.setInt(1, generalID);
			ps.setInt(2, instID);
			ps.setString(3, level);
			
			ps.setString(5, specific);
			ps.setString(4, strDate);
			ps.setInt(6, educLevelID);
			
			
			if(ps.executeUpdate() > 0)
			{
				try{
					Institution inst = getInstitution(instID);
					try{
						PreparedStatement ps2 = conn.prepareStatement("SELECT * FROM `institutions-changes` WHERE institutionID=?");
						ps2.setInt(1, inst.getInstitutionID());
						ResultSet rs = ps2.executeQuery();
						
						if(!rs.first())
						{
							try
							{
								System.out.print("INSIDE EXECUTE UPDATE -------------------------------------------------");
								PreparedStatement ps1 = conn.prepareStatement("INSERT INTO `institutions-changes` (institutionID, systemID, name, head, hPosition, hEmail, address, status, dateAdded, city, fax, contactPerson, contactPosition, contactNumber, website, country, contactEmail, acronym, longitude, latitude, dateChanged) VALUES (?, ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
								
								ps1.setInt(1, inst.getInstitutionID());
								ps1.setInt(2, inst.getSchoolSystemID());
								ps1.setString(3, inst.getName());
								ps1.setString(4, inst.getHead());
								ps1.setString(5, inst.gethPosition());
								ps1.setString(6, inst.gethEmail());
								ps1.setString(7, inst.getAddress());
								ps1.setString(8, "Preliminary Visit");
								ps1.setString(9, inst.getDateAddedRaw());
								ps1.setString(10, inst.getCity());
								ps1.setString(11, inst.getFax());
								ps1.setString(12, inst.getContactPerson());
								ps1.setString(13, inst.getContactPosition());
								ps1.setString(14, inst.getContactNumber());
								ps1.setString(15, inst.getWebsite());
								ps1.setString(16, inst.getCountry());
								ps1.setString(17, inst.getContactEmail());
								ps1.setString(18, inst.getInstitutionAcronym());
								ps1.setDouble(19, inst.getLongitude());
								ps1.setDouble(20, inst.getLatitude());
								Date date1 = new Date();
								String modifiedDate= new SimpleDateFormat("yyyy-MM-dd").format(date1);
								ps1.setString(21, modifiedDate);
								
								ps1.executeUpdate();
								
							} catch (Exception e){
								System.out.println("Error in InstitutionsUtil:editInstitution()");
								e.printStackTrace();	
							}
						}
						else
						{
							try
							{
								
								System.out.print("INSIDE EXECUTE UPDATE -------------------------------------------------");
								PreparedStatement ps1 = conn.prepareStatement("UPDATE `institutions-changes` SET systemID=?, name=?, head=?, hPosition=?, hEmail=?, address=?, status=?, dateAdded=?, city=?, fax=?, contactPerson=?, contactPosition=?, contactNumber=?, website=?, country=?, contactEmail=?, acronym=?, longitude=?, latitude=?, dateChanged=? WHERE institutionID=?");
								
								
								ps1.setInt(1, inst.getSchoolSystemID());
								ps1.setString(2, inst.getName());
								ps1.setString(3, inst.getHead());
								ps1.setString(4, inst.gethPosition());
								ps1.setString(5, inst.gethEmail());
								ps1.setString(6, inst.getAddress());
								ps1.setString(7, "Preliminary Visit");
								ps1.setString(8, inst.getDateAddedRaw());
								ps1.setString(9, inst.getCity());
								ps1.setString(10, inst.getFax());
								ps1.setString(11, inst.getContactPerson());
								ps1.setString(12, inst.getContactPosition());
								ps1.setString(13, inst.getContactNumber());
								ps1.setString(14, inst.getWebsite());
								ps1.setString(15, inst.getCountry());
								ps1.setString(16, inst.getContactEmail());
								ps1.setString(17, inst.getInstitutionAcronym());
								ps1.setDouble(18, inst.getLongitude());
								ps1.setDouble(19, inst.getLatitude());
								
								Date date1 = new Date();
								String modifiedDate= new SimpleDateFormat("yyyy-MM-dd").format(date1);
								ps1.setString(20, modifiedDate);
								
								ps1.setInt(21, inst.getInstitutionID());
								
								ps1.executeUpdate();
								
								
							} catch (Exception e){
								System.out.println("Error in InstitutionsUtil:editInstitution()");
								e.printStackTrace();	
							}
						}
					} catch (Exception e){
						System.out.println("Error in InstitutionsUtil:editInstitution()");
						e.printStackTrace();	
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();	
					
				}
				
				try{
					PreparedStatement ps2 = conn.prepareStatement("SELECT MAX(SPID) FROM `school-program`");
					ResultSet rs = ps2.executeQuery();
					if(rs.first())
					{
						
						PreparedStatement ps3 = conn.prepareStatement("INSERT INTO `school-program-changes` (SPID, programID, institutionID, accLevel, dateAdded, degreeName, levelID) VALUES (?,?,?,?,?,?,?)");
	
						ps3.setInt(1, rs.getInt(1));
						ps3.setInt(2, generalID);
						ps3.setInt(3, instID);
						ps3.setString(4, level);
						
						ps3.setString(6, specific);
						ps3.setString(5, strDate);
						ps3.setInt(7, educLevelID);
						
						
						ps3.executeUpdate();
				
					}
				
				} catch (Exception e){
					System.out.println("Error in InstitutionsUtil:addInstitution()");
					e.printStackTrace();	
				}
				
			}
		} catch (Exception e){
			System.out.println("Error in InstitutionUtil:addProgramToInstitution()");
			e.printStackTrace();	
		}
		
	}
	
	//OLD
	public void updateProgramToInst(String SPID, String level){
		try{
			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement("UPDATE `school-program` SET accLevel=? WHERE `SPID`=?");
						
			ps.setString(1, level);
			ps.setString(2, SPID);
					
			if(ps.executeUpdate() > 0)
			{
				try{
					Institution inst = getInstitutionFromSPID(Integer.parseInt(SPID.replaceAll("\\s","")));
					try{
						PreparedStatement ps2 = conn.prepareStatement("SELECT * FROM `institutions-changes` WHERE institutionID=?");
						ps2.setInt(1, inst.getInstitutionID());
						ResultSet rs = ps2.executeQuery();
						
						//institution not yet in changes
						if(!rs.first())
						{
							try
							{
								System.out.print("INSIDE EXECUTE UPDATE -------------------------------------------------");
								PreparedStatement ps1 = conn.prepareStatement("INSERT INTO `institutions-changes` (institutionID, systemID, name, head, hPosition, hEmail, address, status, dateAdded, city, fax, contactPerson, contactPosition, contactNumber, website, country, contactEmail, acronym, longitude, latitude, dateChanged) VALUES (?, ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
								
								ps1.setInt(1, inst.getInstitutionID());
								ps1.setInt(2, inst.getSchoolSystemID());
								ps1.setString(3, inst.getName());
								ps1.setString(4, inst.getHead());
								ps1.setString(5, inst.gethPosition());
								ps1.setString(6, inst.gethEmail());
								ps1.setString(7, inst.getAddress());
								ps1.setString(8, "Preliminary Visit");
								ps1.setString(9, inst.getDateAddedRaw());
								ps1.setString(10, inst.getCity());
								ps1.setString(11, inst.getFax());
								ps1.setString(12, inst.getContactPerson());
								ps1.setString(13, inst.getContactPosition());
								ps1.setString(14, inst.getContactNumber());
								ps1.setString(15, inst.getWebsite());
								ps1.setString(16, inst.getCountry());
								ps1.setString(17, inst.getContactEmail());
								ps1.setString(18, inst.getInstitutionAcronym());
								ps1.setDouble(19, inst.getLongitude());
								ps1.setDouble(20, inst.getLatitude());
								Date date1 = new Date();
								String modifiedDate= new SimpleDateFormat("yyyy-MM-dd").format(date1);
								ps1.setString(21, modifiedDate);
								
								ps1.executeUpdate();
								
							} catch (Exception e){
								System.out.println("Error in InstitutionsUtil:editInstitution()");
								e.printStackTrace();	
							}
						}
						else
						{
							try
							{
								
								System.out.print("INSIDE EXECUTE UPDATE -------------------------------------------------");
								PreparedStatement ps1 = conn.prepareStatement("UPDATE `institutions-changes` SET systemID=?, name=?, head=?, hPosition=?, hEmail=?, address=?, status=?, dateAdded=?, city=?, fax=?, contactPerson=?, contactPosition=?, contactNumber=?, website=?, country=?, contactEmail=?, acronym=?, longitude=?, latitude=?, dateChanged=? WHERE institutionID=?");
								
								
								ps1.setInt(1, inst.getSchoolSystemID());
								ps1.setString(2, inst.getName());
								ps1.setString(3, inst.getHead());
								ps1.setString(4, inst.gethPosition());
								ps1.setString(5, inst.gethEmail());
								ps1.setString(6, inst.getAddress());
								ps1.setString(7, "Preliminary Visit");
								ps1.setString(8, inst.getDateAddedRaw());
								ps1.setString(9, inst.getCity());
								ps1.setString(10, inst.getFax());
								ps1.setString(11, inst.getContactPerson());
								ps1.setString(12, inst.getContactPosition());
								ps1.setString(13, inst.getContactNumber());
								ps1.setString(14, inst.getWebsite());
								ps1.setString(15, inst.getCountry());
								ps1.setString(16, inst.getContactEmail());
								ps1.setString(17, inst.getInstitutionAcronym());
								ps1.setDouble(18, inst.getLongitude());
								ps1.setDouble(19, inst.getLatitude());
								
								Date date1 = new Date();
								String modifiedDate= new SimpleDateFormat("yyyy-MM-dd").format(date1);
								ps1.setString(20, modifiedDate);
								
								ps1.setInt(21, inst.getInstitutionID());
								
								ps1.executeUpdate();
								
								
							} catch (Exception e){
								System.out.println("Error in InstitutionsUtil:editInstitution()");
								e.printStackTrace();	
							}
						}
					} catch (Exception e){
						System.out.println("Error in InstitutionsUtil:editInstitution()");
						e.printStackTrace();	
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();	
					
				}
				
				try{
					PreparedStatement ps2 = conn.prepareStatement("SELECT * FROM `school-program-changes` WHERE SPID = ?");
					ps2.setInt(1, Integer.parseInt(SPID.replaceAll("\\s","")));
					ResultSet rs = ps2.executeQuery();
					System.out.println("OUTSIDE IF SPID ------------------------------------------------");
			
					if(rs.first())
					{
						System.out.println("INSIDE TRY SPID ------------------------------------------------");
						PreparedStatement ps3 = conn.prepareStatement("UPDATE `school-program-changes` SET accLevel=? WHERE `SPID`=?");
						
						ps3.setString(1, level);
						ps3.setString(2, SPID);
						
						ps3.executeUpdate();
				
					}
					else
					{
						
						try{
							PreparedStatement ps4 = conn.prepareStatement("SELECT * FROM `school-program` WHERE SPID = ?");
							ps4.setInt(1, Integer.parseInt(SPID.replaceAll("\\s","")));
							ResultSet rs1 = ps4.executeQuery();
							if(rs1.first())
							{
								SchoolProgram sp = new SchoolProgram(rs1.getInt(1), rs1.getInt(2), rs1.getInt(3), rs1.getString(4), 
										rs1.getString(5), rs1.getString(6), rs1.getString(7), rs1.getString(8), rs1.getString(9),
										rs1.getInt(10), rs1.getString(11));
								
								PreparedStatement ps3 = conn.prepareStatement("INSERT INTO `school-program-changes` (SPID, programID, institutionID, accLevel, dateAdded, degreeName, validUntil, levelID) VALUES (?,?,?,?,?,?,?,?)");
								ps3.setInt(1, sp.getSPID());
								ps3.setInt(2, sp.getProgramID());
								ps3.setInt(3, sp.getInstitutionID());
								ps3.setString(4, sp.getLevel());
								ps3.setString(5, sp.getDateAdded());
								ps3.setString(6, sp.getDegreeName());
								ps3.setString(7, sp.getValidUntil());
								ps3.setInt(8, sp.getLevelID());
								
								
								
								ps3.executeUpdate();
							}
							
						
						} catch (Exception e){
							System.out.println("Error in InstitutionsUtil:addInstitution()");
							e.printStackTrace();	
						}
						
						
						
						
					}
				
				} catch (Exception e){
					System.out.println("Error in InstitutionsUtil:addInstitution()");
					e.printStackTrace();	
				}
				
			}
			
			
		} catch (Exception e){
			System.out.println("Error in InstitutionUtil:addProgramToInstitution()");
			e.printStackTrace();	
		}
		
	}
	
	private Institution getInstitutionFromSPID(int SPID) {
		Institution temp = new Institution();
		try{
			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT i.* FROM institutions i, `school-program` sp WHERE i.institutionID = sp.institutionID AND sp.SPID = ?");
			ps.setInt(1,  SPID);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				temp =  new Institution(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17), rs.getString(18), rs.getDouble(19), rs.getDouble(20));
			}
		} catch (Exception e){
			System.out.println("Error in InstitutionsUtil:getInstitution()");
			e.printStackTrace();
		}
		
	    return temp;
		
	}
	
	//NEW
	public ArrayList<SchoolProgram> getMembershipFromYear(int year, int educLevelID) {
		ArrayList<SchoolProgram> sp = new ArrayList<SchoolProgram>();
		SchoolProgram temp = new SchoolProgram();
		try{
			Connection conn = db.getConnection();
			
			if(educLevelID != 0)
			{
				PreparedStatement ps = conn.prepareStatement("SELECT i.institutionID, i.name, p.name, sp.degreeName, sp.dateAdded, e.levelName FROM educationlevel e, institutions i, programs p, `school-program` sp WHERE e.levelID = sp.levelID AND i.institutionID = sp.institutionID AND p.programID = sp.programID AND sp.dateAdded LIKE ? AND sp.levelID = ? ORDER BY i.name ASC");
				ps.setString(1,  "%" + year + "%");
				ps.setInt(2,  educLevelID);
				
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					temp =  new SchoolProgram(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
					sp.add(temp);
				}
			}
			else
			{
				PreparedStatement ps = conn.prepareStatement("SELECT i.institutionID, i.name, p.name, sp.degreeName, sp.dateAdded, e.levelName FROM educationlevel e, institutions i, programs p, `school-program` sp WHERE e.levelID = sp.levelID AND i.institutionID = sp.institutionID AND p.programID = sp.programID AND sp.dateAdded LIKE ? ORDER BY i.name ASC");
				ps.setString(1,  "%" + year + "%");
				
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					temp =  new SchoolProgram(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
					sp.add(temp);
				}
			}
		} catch (Exception e){
			System.out.println("Error in InstitutionsUtil:getInstitution()");
			e.printStackTrace();
		}
		
	    return sp;
	}
	
	//NEW
	public ArrayList<SchoolProgram> getMemberProgramsFromYear(int year, int educLevelID) {
		ArrayList<SchoolProgram> sp = new ArrayList<SchoolProgram>();
		SchoolProgram temp = new SchoolProgram();
		try{
			Connection conn = db.getConnection();
			
			if(educLevelID!=0)
			{
				PreparedStatement ps = conn.prepareStatement("SELECT i.name, p.programID, p.name, sp.degreeName, sp.dateAdded, e.levelName FROM educationlevel e, institutions i, programs p, `school-program` sp WHERE e.levelID = sp.levelID AND i.institutionID = sp.institutionID AND p.programID = sp.programID AND sp.dateAdded LIKE ? AND sp.levelID = ? ORDER BY i.name ASC");
				ps.setString(1,  "%" + year + "%");
				ps.setInt(2, educLevelID);
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					temp =  new SchoolProgram(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
					sp.add(temp);
				}
				
			}
			else
			{
				PreparedStatement ps = conn.prepareStatement("SELECT i.name, p.programID, p.name, sp.degreeName, sp.dateAdded, e.levelName FROM educationlevel e, institutions i, programs p, `school-program` sp WHERE e.levelID = sp.levelID AND i.institutionID = sp.institutionID AND p.programID = sp.programID AND sp.dateAdded LIKE ? AND (sp.levelID = 4 OR sp.levelID = 5) ORDER BY i.name ASC");
				ps.setString(1,  "%" + year + "%");
				ps.setInt(2, educLevelID);
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					temp =  new SchoolProgram(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
					sp.add(temp);
				}

			}
		} catch (Exception e){
			System.out.println("Error in InstitutionsUtil:getInstitution()");
			e.printStackTrace();
		}
		
	    return sp;
	}
	
	//NEW
	public ArrayList<SchoolProgram> getSurveyVisits(int year, int educLevelID) {
		ArrayList<SchoolProgram> sp = new ArrayList<SchoolProgram>();
		SchoolProgram temp = new SchoolProgram();
		try{
			Connection conn = db.getConnection();
			
			if(educLevelID!=0)
			{
				PreparedStatement ps = conn.prepareStatement("SELECT s.surveyID, i.name, sp.degreeName, e.levelName, ps.boardApprovalDate FROM educationlevel e, institutions i, `program-survey` ps, surveys s, `school-program` sp WHERE e.levelID = sp.levelID AND sp.institutionID = i.institutionID AND ps.SPID = sp.SPID AND ps.surveyID = s.surveyID AND sp.levelID = ? AND ps.boardApprovalDate LIKE ?");
				ps.setInt(1, educLevelID);
				ps.setString(2,  "%" + year + "%");
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					temp =  new SchoolProgram(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
					sp.add(temp);
				}
			}
			else
			{
				PreparedStatement ps = conn.prepareStatement("SELECT s.surveyID, i.name, sp.degreeName, e.levelName, ps.boardApprovalDate FROM educationlevel e, institutions i, `program-survey` ps, surveys s, `school-program` sp WHERE e.levelID = sp.levelID AND sp.institutionID = i.institutionID AND ps.SPID = sp.SPID AND ps.surveyID = s.surveyID AND ps.boardApprovalDate LIKE ?");
				ps.setString(1,  "%" + year + "%");
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					temp =  new SchoolProgram(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
					sp.add(temp);
				}

			}
		} catch (Exception e){
			System.out.println("Error in InstitutionsUtil:getInstitution()");
			e.printStackTrace();
		}
		
	    return sp;
	}
	
	//NEW
	public ArrayList<SchoolProgram> getSurveyTypeForYear(int year, String surveyType) {
		ArrayList<SchoolProgram> sp = new ArrayList<SchoolProgram>();
		SchoolProgram temp = new SchoolProgram();
		try{
			Connection conn = db.getConnection();
			
			if(surveyType!="" && surveyType!="Consultancy")
			{
				PreparedStatement ps = conn.prepareStatement("SELECT s.surveyID, i.name, sp.degreeName, e.levelName, ps.boardApprovalDate FROM educationlevel e, institutions i, `program-survey` ps, surveys s, `school-program` sp WHERE e.levelID = sp.levelID AND sp.institutionID = i.institutionID AND ps.SPID = sp.SPID AND ps.surveyID = s.surveyID AND ps.surveyType = ? AND ps.boardApprovalDate LIKE ?");
				ps.setString(1, surveyType);
				ps.setString(2,  "%" + year + "%");
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					temp =  new SchoolProgram(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
					sp.add(temp);
				}
			}
			else if(surveyType!="" && surveyType=="Consultancy")
			{
				PreparedStatement ps = conn.prepareStatement("SELECT s.surveyID, i.name, sp.degreeName, e.levelName, ps.boardApprovalDate FROM educationlevel e, institutions i, `program-survey` ps, surveys s, `school-program` sp WHERE e.levelID = sp.levelID AND sp.institutionID = i.institutionID AND ps.SPID = sp.SPID AND ps.surveyID = s.surveyID AND (ps.surveyType = 'Interim' OR ps.surveyType = 'Consultancy' AND ps.boardApprovalDate LIKE ?");
				ps.setString(1,  "%" + year + "%");
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					temp =  new SchoolProgram(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
					sp.add(temp);
				}
			}
			else
			{
				PreparedStatement ps = conn.prepareStatement("SELECT s.surveyID, i.name, sp.degreeName, e.levelName, ps.boardApprovalDate FROM educationlevel e, institutions i, `program-survey` ps, surveys s, `school-program` sp WHERE e.levelID = sp.levelID AND sp.institutionID = i.institutionID AND ps.SPID = sp.SPID AND ps.surveyID = s.surveyID AND ps.boardApprovalDate LIKE ?");
				ps.setString(1,  "%" + year + "%");
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					temp =  new SchoolProgram(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
					sp.add(temp);
				}

			}
		} catch (Exception e){
			System.out.println("Error in InstitutionsUtil:getInstitution()");
			e.printStackTrace();
		}
		
	    return sp;
	}

	public void deleteInstitution(int institutionID){
		try{
			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement("DELETE from institutions WHERE institutionID = ?");
			ps.setInt(1, institutionID);
			ps.executeUpdate();
		} catch (Exception e){
			System.out.println("Error in InstitutionsUtil:deleteInstitution()");
			e.printStackTrace();
		}
	}
	

	
	
	private static String formatDate(String date){
		String format = new String();
		String month = "";
		String day;
		String year;
		if(date!=null&&date!=""){
		String[] parts = date.split(" ");
		if(parts[0].equals("January")){
			month = "01";
		}else if(parts[0].equals("February")){
			month = "02";
		}else if(parts[0].equals("March")){
			month = "03";
		}else if(parts[0].equals("April")){
			month = "04";
		}else if(parts[0].equals("May")){
			month = "05";
		}else if(parts[0].equals("June")){
			month = "06";
		}else if(parts[0].equals("July")){
			month = "07";
		}else if(parts[0].equals("August")){
			month = "08";
		}else if(parts[0].equals("September")){
			month = "09";
		}else if(parts[0].equals("October")){
			month = "10";
		}else if(parts[0].equals("November")){
			month = "11";
		}else if(parts[0].equals("December")){
			month = "12";
		}
		year = parts[2];

		parts = parts[1].split(",");
		day = parts[0];
		
		format = year + "-" + month + "-"+ day;
		}
		return format;
	}
	
	private static String formatDate_yearFirst(String date){
		String format = new String();
		String month = "";
		String day;
		String year;
		String[] parts = date.split("-");
		if(parts[1].equals("01")){
			month = "January";
		}else if(parts[1].equals("02")){
			month = "February";
		}else if(parts[1].equals("03")){
			month = "March";
		}else if(parts[1].equals("04")){
			month = "April";
		}else if(parts[1].equals("05")){
			month = "May";
		}else if(parts[1].equals("06")){
			month = "June";
		}else if(parts[1].equals("07")){
			month = "July";
		}else if(parts[1].equals("08")){
			month = "August";
		}else if(parts[1].equals("09")){
			month = "September";
		}else if(parts[1].equals("10")){
			month = "October";
		}else if(parts[1].equals("11")){
			month = "November";
		}else if(parts[1].equals("12")){
			month = "December";
		}
		year = parts[0];

//		parts = parts[1].split(",");
		day = parts[2];
		
		format = year + " " + month + " "+ day;
		return format;
	}
	
	private static String formatDateDash(String date){
		String format = new String();
		String month = "";
		String day;
		String year;
		String[] parts = date.split("-");
		if(parts[1].equals("01")){
			month = "January";
		}else if(parts[1].equals("02")){
			month = "February";
		}else if(parts[1].equals("03")){
			month = "March";
		}else if(parts[1].equals("04")){
			month = "April";
		}else if(parts[1].equals("05")){
			month = "May";
		}else if(parts[1].equals("06")){
			month = "June";
		}else if(parts[1].equals("07")){
			month = "July";
		}else if(parts[1].equals("08")){
			month = "August";
		}else if(parts[1].equals("09")){
			month = "September";
		}else if(parts[1].equals("10")){
			month = "October";
		}else if(parts[1].equals("11")){
			month = "November";
		}else if(parts[1].equals("12")){
			month = "December";
		}
		year = parts[0];

		day = parts[2];
		
		format = month + " "+ day + ", " + year;
		return format;
	}

	//NEW
	public JSONArray getEducLevelJSON(int instID) {
		JSONArray jArray = new JSONArray();
		JSONObject job = new JSONObject();
		
		try{
			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT educLevelID FROM `institutions` WHERE institutionID = ?");
			ps.setInt(1, instID);
		
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				job = new JSONObject();
				job.put("educLevel", getEducLevelName(rs.getInt(1)));
				

				jArray.put(job);
				
			}
		} catch (Exception e){
			System.out.println("Error in InstitutionsUtil:getEducLevelJSON()");
			e.printStackTrace();
		}
		
		return jArray;
	}

	//NEW
	public JSONArray getInstIDFromPSID(int PSID) {
		JSONArray jArray = new JSONArray();
		JSONObject job = new JSONObject();
		
		try{
			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT i.institutionID FROM `program-survey` ps, surveys s, `institutions` i WHERE ps.surveyID = s.surveyID AND ps.PSID = ? AND s.institutionID = i.institutionID");
			ps.setInt(1, PSID);
		
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				job = new JSONObject();
				job.put("instID", rs.getInt(1));
				

				jArray.put(job);
				
			}
		} catch (Exception e){
			System.out.println("Error in InstitutionsUtil:getEducLevelJSON()");
			e.printStackTrace();
		}
		
		return jArray;
	}

	//NEW
	public String getInstitutionAndDegreeProgram(int PSID) {
		String temp = "";
		try{
			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT i.name, sp.degreeName FROM institutions i, `school-program` sp, `program-survey` ps WHERE ps.SPID = sp.SPID AND i.institutionID = sp.institutionID AND ps.PSID = ?");
			ps.setInt(1,  PSID);
			ResultSet rs = ps.executeQuery();
			if(rs.first()){
				temp = rs.getString(1) + " - " + rs.getString(2);
			}
		} catch (Exception e){
			System.out.println("Error in InstitutionsUtil:getInstitution()");
			e.printStackTrace();
		}
		
	    return temp;
		
		
	}

	//NEW
	public String getSurveyType(int PSID) {
		String temp = "";
		try{
			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT surveyType FROM `program-survey` WHERE PSID = ?");
			ps.setInt(1,  PSID);
			ResultSet rs = ps.executeQuery();
			if(rs.first()){
				temp = rs.getString(1);
			}
		} catch (Exception e){
			System.out.println("Error in InstitutionsUtil:getInstitution()");
			e.printStackTrace();
		}
		
	    return temp;
	}


	public void updateDecision(int PSID, String boardChoice, String commChoice, String teamChoice, String text) {
		try{
			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement("DELETE from `decisions` WHERE PSID = ?");
			ps.setInt(1, PSID);
			ps.executeUpdate();
		} catch (Exception e){
			System.out.println("Error in AccreditorUtil:addAccreditor()");
			e.printStackTrace();
		}
		
		//BOARD
		try{
		
			
			Connection conn = db.getConnection();
			PreparedStatement ps4 = conn.prepareStatement("INSERT INTO `decisions` (decisionBy, decision, remarks, PSID) VALUES (?,?,?,?)");
			ps4.setString(1, "Board");
			ps4.setString(2, boardChoice);
			ps4.setString(3, text);
			ps4.setInt(4, PSID);
			
			
			ps4.executeUpdate();
			
		} catch (Exception e){
			System.out.println("Error in InstitutionsUtil:addInstitution()");
			e.printStackTrace();	
		}
		
		//TEAM
		try{
		
			
			Connection conn = db.getConnection();
			PreparedStatement ps4 = conn.prepareStatement("INSERT INTO `decisions` (decisionBy, decision, remarks, PSID) VALUES (?,?,?,?)");
			ps4.setString(1, "Team");
			ps4.setString(2, teamChoice);
			ps4.setString(3, text);
			ps4.setInt(4, PSID);
			
			
			ps4.executeUpdate();
			
		} catch (Exception e){
			System.out.println("Error in InstitutionsUtil:addInstitution()");
			e.printStackTrace();	
		}
		
		//Commision
		try{
		
			
			Connection conn = db.getConnection();
			PreparedStatement ps4 = conn.prepareStatement("INSERT INTO `decisions` (decisionBy, decision, remarks, PSID) VALUES (?,?,?,?)");
			ps4.setString(1, "Commission");
			ps4.setString(2, commChoice);
			ps4.setString(3, text);
			ps4.setInt(4, PSID);
			
			
			ps4.executeUpdate();
			
		} catch (Exception e){
			System.out.println("Error in InstitutionsUtil:addInstitution()");
				e.printStackTrace();	
			}
	}
	
}

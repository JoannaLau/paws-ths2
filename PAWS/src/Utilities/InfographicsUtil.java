package Utilities;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;


public class InfographicsUtil {
	private DBUtil db;
	
	public InfographicsUtil(){
			db = new DBUtil();
	}
	
	
	
	
	public int getInstitutionProgramCount(int educLevelID, int year, String status){

			int count =0;
		
		
		try{
			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT COUNT(`SPID`) FROM `school-program` s, `institutions` i WHERE s.institutionID=i.institutionID AND s.levelID = ? AND YEAR(STR_TO_DATE(i.dateAdded, '%Y-%m-%d')) = ? AND i.status = ?");
			ps.setInt(1, educLevelID);
			ps.setInt(2, year);
			ps.setString(3, status);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){				
				
				count = rs.getInt(1);
	
				
				
			}
		
		} catch (Exception e){
			System.out.println("Error in InfographicsUtil:getprogramCount()");
			e.printStackTrace();
		}
		
		return count;
	}
	
	
	
	public int getInstitutionCountByLevelAndYear(int educLevelID, int year, String status)
	{
		int count=0;
	
		
		
		try{
			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT COUNT(*) FROM `school-program` WHERE levelID = ? AND dateAdded LIKE ?");
			ps.setInt(1, educLevelID);
			ps.setString(2, "%" + year + "%");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){				
			
				count = rs.getInt(1);
	
				
				
			}
		} catch (Exception e){
			System.out.println("Error in InfographicsUtil:getInstitutionCount()");
			e.printStackTrace();
		}
		
		return count;
	}
	
	public int getFirstYearInstitutionAdded() {
		int year=0;

		
		try{
			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT MIN(YEAR(STR_TO_DATE(`dateAdded`, '%Y-%m-%d'))) FROM paws.institutions;");
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){					
			year = rs.getInt(1);	
			}
		} catch (Exception e){
			System.out.println("Error in InfographicsUtil:getyear");
			e.printStackTrace();
		}
		
	
	return year;
	
	}
	
	
	public int getLastYearInstitutionAdded() {
int year=0;

		
		try{
			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT MAX(YEAR(STR_TO_DATE(`dateAdded`, '%Y-%m-%d'))) FROM paws.institutions;");
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){					
			year = rs.getInt(1);	
			}
		} catch (Exception e){
			System.out.println("Error in InfographicsUtil:getyear");
			e.printStackTrace();
		}
		
	
	return year;
	
	}
	
	
	
	
	public int getSurveyVisitCount(int educLevelID, int year)
	{
		int count=0;
	
		try{
			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT COUNT(*) FROM `program-survey` ps, surveys s, `school-program` sp WHERE ps.SPID = sp.SPID AND ps.surveyID = s.surveyID AND ps.boardApprovalDate LIKE ? AND sp.levelID = ?");
			ps.setString(1, "%" + year + "%");
			ps.setInt(2, educLevelID); 
			ResultSet rs = ps.executeQuery();
			while(rs.next()){				
			
				count = rs.getInt(1);
	
				
				
			}
		} catch (Exception e){
			System.out.println("Error in InfographicsUtil:getSurveyVisitCount()");
			e.printStackTrace();
		}
		
		return count;
	}
	
	
	
	public int getTypeofSurveyCount(String type, int year) {
		
		int count = 0;
		
		
		try{
			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT COUNT(`surveyType`) FROM paws.`program-survey` WHERE surveyType=? AND YEAR(STR_TO_DATE(`boardApprovalDate`, '%Y-%m-%d')) =?");
			ps.setString(1, type);
			ps.setInt(2, year); 
			ResultSet rs = ps.executeQuery();
			while(rs.next()){				
			
				count = rs.getInt(1);
	
				
				
			}
		} catch (Exception e){
			System.out.println("Error in InfographicsUtil:getTypeofVisitCount()");
			e.printStackTrace();
		}
		
		
	
		return count;
	}
	
	public int getAccreditorVisitCount(int level, int year) {
		
	
	
	
int count = 0;
		
		
		try{
			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT Count(*) FROM areas ar, accreditors a, institutions i, `program-area` pa, `program-survey` ps, surveys s, `school-program` sp WHERE ar.areaID = pa.areaID AND pa.accreditorID = a.accreditorID AND sp.institutionID = i.institutionID AND pa.PSID = ps.PSID AND ps.surveyID = s.surveyID AND ps.SPID = sp.SPID AND ps.surveyID IN (SELECT surveyID FROM surveys WHERE YEAR(STR_TO_DATE(startDate, '%Y-%m-%d')) = ?) AND sp.levelID = ?");
			ps.setInt(1, year);
			ps.setInt(2, level); 
			ResultSet rs = ps.executeQuery();
			while(rs.next()){				
			
				count = rs.getInt(1);
	
				
				
			}
		} catch (Exception e){
			System.out.println("Error in InfographicsUtil:getAccreditorVisitCount()");
			e.printStackTrace();
		}
		
		
	
		return count;
	
	
	
	
	
	
	}
}

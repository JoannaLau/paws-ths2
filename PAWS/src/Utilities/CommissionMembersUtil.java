package Utilities;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mysql.jdbc.Connection;

import Models.BoardMember;
import Models.CommissionMember;

public class CommissionMembersUtil {

	private DBUtilWeb db;

	
	public CommissionMembersUtil(){
		db = new DBUtilWeb();
	}


	public ArrayList<CommissionMember> getCommissionMembers() {
		ArrayList<CommissionMember> commissionMembers = new ArrayList<CommissionMember>();
		CommissionMember temp = new CommissionMember();
		
		try{
			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT cm.commissionMemberID, cm.firstname, cm.lastname, cm.commissionPositionID, cm.year, cm.educLevelID, el.levelName FROM `paws-web`.`commission-members` cm, `paws-web`.`educationlevel` el WHERE cm.educLevelID = el.levelID ORDER BY year");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				temp = new CommissionMember(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), getCommissionPosition(rs.getInt(4)), rs.getInt(6),  String.valueOf(rs.getInt(6)) + " - " + rs.getString(7));
				commissionMembers.add(temp);
			}
			db.cutPort();
		} catch (Exception e){
			System.out.println("Error in InstitutionsUtil:getInstitutions()");
			e.printStackTrace();
		}
		
	    return commissionMembers;
	}


	private String getCommissionPosition(int ID) 
	{
		String position = "";
		
		try{
			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT positionName FROM `paws-web`.`commission-positions` WHERE positionID = ?");
			ps.setInt(1, ID);
			ResultSet rs = ps.executeQuery();
			if(rs.first()){
				position = rs.getString(1);
			}
			db.cutPort();
		} catch (Exception e){
			System.out.println("Error in InstitutionsUtil:getInstitutions()");
			e.printStackTrace();
		}
		
	    return position;
	}


	public JSONArray checkCommissionMembersInYear(int level, int year, int positionID) 
	{
		JSONArray jArray = new JSONArray();
		JSONObject job = new JSONObject();
		  
		try{
			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM `paws-web`.`commission-members` WHERE year = ? AND commissionPositionID = ? AND educLevelID = ?");
			ps.setInt(1, year);
			ps.setInt(2, positionID);
			ps.setInt(3, level);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				job = new JSONObject();
				job.put("name", rs.getString(2) + " " + rs.getString(3));
				job.put("year", year);
				
				jArray.put(job);
			}
			db.cutPort();
		} catch (Exception e){
			System.out.println("Error in InstitutionsUtil:getInstitutionsJSON()");
			e.printStackTrace();
		}
		
		return jArray;
		
	}

	public CommissionMember getCommissionMember(int cmID) {
		CommissionMember temp = new CommissionMember();
		
		try{
			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM `paws-web`.`commission-members` cm, `paws-web`.`educationlevel` el WHERE cm.educLevelID = el.levelID AND commissionMemberID = ? ORDER BY year");
			ps.setInt(1, cmID);
			System.out.print("AADA" + cmID);
			ResultSet rs = ps.executeQuery();
			if(rs.first())
			{
				temp = new CommissionMember(rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getString(4), rs.getString(5), 
						rs.getString(6), rs.getString(7), rs.getString(8), 
						rs.getInt(9), rs.getInt(10), getCommissionPosition(rs.getInt(10)), rs.getInt(11), rs.getString(13));
			}
			db.cutPort();
		} catch (Exception e){
			System.out.println("Error in InstitutionsUtil:getInstitutions()");
			e.printStackTrace();
		}
		
	    return temp;
	}


	public int addCommissionMember(int cmID, CommissionMember cm) {
		int ID = 0;
		
		try{
			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement("INSERT INTO `commission-members` (`firstname`, `lastname`, `middleinitial`, `honorifics`, `position`, `institution`, `city`, `year`, `commissionPositionID`, `educLevelID`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			ps.setString(1, cm.getFirstName());
			ps.setString(2, cm.getLastName());
			ps.setString(3, cm.getMiddleName());
			ps.setString(4, cm.getHonorifics());
			ps.setString(5, cm.getPosition());
			ps.setString(6, cm.getInstitution());
			ps.setString(7, cm.getCity());
			ps.setInt(8, cm.getYear());
			ps.setInt(9, cm.getCommissionPositionID());
			ps.setInt(10,  cm.getEducLevelID());
			
			ps.executeUpdate();
			
			ps = conn.prepareStatement("SELECT LAST_INSERT_ID()");
			ResultSet rs = ps.executeQuery();
			rs.next();
			ID = rs.getInt(1);
			
			db.cutPort();
		} catch (Exception e){
			System.out.println("Error in AccreditorUtil:addAccreditor()");
			e.printStackTrace();
		}
		return ID;
		
	}

	public void editCommissionMember(int cmID, CommissionMember cm) {
		try{
			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement("UPDATE `commission-members` SET `firstname` = ?, `lastname` = ?, `middleinitial` = ?, `honorifics` = ?, `position` = ?, `institution` = ?, `city` = ?, `year` = ?, `commissionPositionID` = ?, `educLevelID` = ? WHERE commissionMemberID = ?");
			ps.setString(1, cm.getFirstName());
			ps.setString(2, cm.getLastName());
			ps.setString(3, cm.getMiddleName());
			ps.setString(4, cm.getHonorifics());
			ps.setString(5, cm.getPosition());
			ps.setString(6, cm.getInstitution());
			ps.setString(7, cm.getCity());
			ps.setInt(8, cm.getYear());
			ps.setInt(9, cm.getCommissionPositionID());
			ps.setInt(10, cm.getEducLevelID());
			ps.setInt(11, cmID);
			ps.executeUpdate();
			db.cutPort();
		} catch (Exception e){
			System.out.println("Error in AccreditorUtil:addAccreditor()");
			e.printStackTrace();
		}
	}
	
	
}

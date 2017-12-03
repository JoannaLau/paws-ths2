package Utilities;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mysql.jdbc.Connection;

import Models.BoardMember;
import Models.Institution;

public class BoardMembersLocalUtil {
	
	private DBUtil db;

	public BoardMembersLocalUtil(){
		db = new DBUtil();
	}

	public ArrayList<BoardMember> getBoardMembers() 
	{
		ArrayList<BoardMember> boardMembers = new ArrayList<BoardMember>();
		BoardMember temp = new BoardMember();
		
		try{
			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT boardMemberID, firstname, lastname, boardPositionID, year FROM `board-members` ORDER BY `year`");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				temp = new BoardMember(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), getBoardPosition(rs.getInt(4)), rs.getInt(5));
				boardMembers.add(temp);
			}
		} catch (Exception e){
			System.out.println("Error in InstitutionsUtil:getInstitutions()");
			e.printStackTrace();
		}
		
	    return boardMembers;
		
		
	}
		
	public String getBoardPosition(int ID)
	{
		String position = "";
		
		try{
			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT name FROM `board-positions` WHERE positionID = ?");
			ps.setInt(1, ID);
			ResultSet rs = ps.executeQuery();
			if(rs.first()){
				position = rs.getString(1);
			}
		} catch (Exception e){
			System.out.println("Error in InstitutionsUtil:getInstitutions()");
			e.printStackTrace();
		}
		
	    return position;
	}
	
	
	public JSONArray checkBoardMembersInYear(int year, int positionID) 
	{
		JSONArray jArray = new JSONArray();
		JSONObject job = new JSONObject();
		  
		try{
			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM `board-members` WHERE year = ? AND boardPositionID = ?");
			ps.setInt(1, year);
			ps.setInt(2, positionID);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				job = new JSONObject();
				job.put("name", rs.getString(2) + " " + rs.getString(3));
				job.put("year", year);
				
				jArray.put(job);
			}
		} catch (Exception e){
			System.out.println("Error in InstitutionsUtil:getInstitutionsJSON()");
			e.printStackTrace();
		}
		
		return jArray;
		
	}

	public BoardMember getBoardMember(int bmID) 
	{
		BoardMember temp = new BoardMember();
		
		try{
			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM `board-members` WHERE boardMemberID =? ");
			ps.setInt(1, bmID);
			ResultSet rs = ps.executeQuery();
			if(rs.first())
			{
				temp = new BoardMember(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9), rs.getInt(10), getBoardPosition(rs.getInt(10)));
			}
		} catch (Exception e){
			System.out.println("Error in InstitutionsUtil:getInstitutions()");
			e.printStackTrace();
		}
		
	    return temp;
		
	}

	public JSONArray getPositionsAllMembersJSON() 
	{
		JSONArray jArray = new JSONArray();
		JSONObject job = new JSONObject();
		  
		try{
			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT DISTINCT position FROM `board-members` UNION SELECT DISTINCT position FROM `commission-members`");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				job = new JSONObject();
				job.put("position", rs.getString(1));
				jArray.put(job);
			}
		} catch (Exception e){
			System.out.println("Error in InstitutionsUtil:getInstitutionsJSON()");
			e.printStackTrace();
		}
		
		return jArray;
		
	}

	public JSONArray getBoardPositionsJSON() {
		JSONArray jArray = new JSONArray();
		JSONObject job = new JSONObject();
		  
		try{
			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM `board-positions`");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				job = new JSONObject();
				
				job.put("positionID", rs.getInt(1));
				job.put("name", rs.getString(2));
				
				jArray.put(job);
			}
		} catch (Exception e){
			System.out.println("Error in InstitutionsUtil:getInstitutionsJSON()");
			e.printStackTrace();
		}
		
		return jArray;
	}

	public int addBoardMember(BoardMember bm) {
		
		int ID = 0;
		
		try{
			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement("INSERT INTO `board-members` (`firstname`, `lastname`, `middleinitial`, `honorifics`, `position`, `institution`, `city`, `year`, `boardPositionID`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
			ps.setString(1, bm.getFirstName());
			ps.setString(2, bm.getLastName());
			ps.setString(3, bm.getMiddleName());
			ps.setString(4, bm.getHonorifics());
			ps.setString(5, bm.getPosition());
			ps.setString(6, bm.getInstitution());
			ps.setString(7, bm.getCity());
			ps.setInt(8, bm.getYear());
			ps.setInt(9, bm.getBoardPositionID());
			
			ps.executeUpdate();
			
			ps = conn.prepareStatement("SELECT LAST_INSERT_ID()");
			ResultSet rs = ps.executeQuery();
			rs.next();
			ID = rs.getInt(1);
			
		} catch (Exception e){
			System.out.println("Error in AccreditorUtil:addAccreditor()");
			e.printStackTrace();
		}
		return ID;
		
	}

	public void editBoardMember(int bmID, BoardMember bm) {
		try{
			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement("UPDATE `board-members` SET `firstname` = ?, `lastname` = ?, `middleinitial` = ?, `honorifics` = ?, `position` = ?, `institution` = ?, `city` = ?, `year` = ?, `boardPositionID` = ? WHERE boardMemberID = ?");
			ps.setString(1, bm.getFirstName());
			ps.setString(2, bm.getLastName());
			ps.setString(3, bm.getMiddleName());
			ps.setString(4, bm.getHonorifics());
			ps.setString(5, bm.getPosition());
			ps.setString(6, bm.getInstitution());
			ps.setString(7, bm.getCity());
			ps.setInt(8, bm.getYear());
			ps.setInt(9, bm.getBoardPositionID());
			ps.setInt(10, bmID);
			ps.executeUpdate();
		} catch (Exception e){
			System.out.println("Error in AccreditorUtil:addAccreditor()");
			e.printStackTrace();
		}
	}

	public int addBoardMemberChanges(BoardMember bm) {
		int ID = 0;
		
		try{
			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement("INSERT INTO `board-members-changes` (`boardMemberID`, `firstname`, `lastname`, `middleinitial`, `honorifics`, `position`, `institution`, `city`, `year`, `boardPositionID`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			ps.setInt(1, 0);
			ps.setString(2, bm.getFirstName());
			ps.setString(3, bm.getLastName());
			ps.setString(4, bm.getMiddleName());
			ps.setString(5, bm.getHonorifics());
			ps.setString(6, bm.getPosition());
			ps.setString(7, bm.getInstitution());
			ps.setString(8, bm.getCity());
			ps.setInt(9, bm.getYear());
			ps.setInt(10, bm.getBoardPositionID());
			
			ps.executeUpdate();
			
			ps = conn.prepareStatement("SELECT LAST_INSERT_ID()");
			ResultSet rs = ps.executeQuery();
			rs.next();
			ID = rs.getInt(1);
			
		} catch (Exception e){
			System.out.println("Error in AccreditorUtil:addAccreditor()");
			e.printStackTrace();
		}
		return ID;
		
	}
	

	public int getCountBoardMemberChanges() {
		int count = 0;
		
		try{
			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT COUNT(*) FROM `board-members-changes`");
			ResultSet rs = ps.executeQuery();
			
			if(rs.first()){
				count = rs.getInt(1);
			}
			
		} catch (Exception e){
			System.out.println("Error in AccreditorUtil:addAccreditor()");
			e.printStackTrace();
		}
		return count;
		
	}

	public ArrayList<BoardMember> getUnsyncedBoardMembers() {
		ArrayList<BoardMember> boardMembers = new ArrayList<BoardMember>();
		BoardMember temp = new BoardMember();
		
		try{
			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM `board-members-changes`");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				temp = new BoardMember(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9), rs.getInt(10), getBoardPosition(rs.getInt(10)));
				boardMembers.add(temp);
			}
		} catch (Exception e){
			System.out.println("Error in InstitutionsUtil:getInstitutions()");
			e.printStackTrace();
		}
		
	    return boardMembers;
	}

	public BoardMember getUnsyncedBoardMember(int bmID) {
		BoardMember temp = new BoardMember();
		
		try{
			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM `board-members-changes` WHERE boardMemberID =? ");
			ps.setInt(1, bmID);
			ResultSet rs = ps.executeQuery();
			if(rs.first())
			{
				temp = new BoardMember(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9), rs.getInt(10), getBoardPosition(rs.getInt(10)));
			}
		} catch (Exception e){
			System.out.println("Error in InstitutionsUtil:getInstitutions()");
			e.printStackTrace();
		}
		
	    return temp;
	}
	
	public void deleteBoardMembers(ArrayList<BoardMember> boardMembers) 
	{
		try{
			Connection conn = db.getConnection();
			for(int i = 0; i<boardMembers.size(); i++)
			{
				PreparedStatement ps = conn.prepareStatement("DELETE from `board-members-changes` WHERE boardMemberID = ?");
				ps.setInt(1, boardMembers.get(i).getBmID());
				ps.executeUpdate();
			}
		} catch (Exception e){
			System.out.println("Error in AccreditorUtil:addAccreditor()");
			e.printStackTrace();
		}
	}
	
}

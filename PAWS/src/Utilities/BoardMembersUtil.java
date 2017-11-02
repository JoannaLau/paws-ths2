package Utilities;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mysql.jdbc.Connection;

import Models.BoardMember;
import Models.Institution;

public class BoardMembersUtil {
	
	private DBUtilWeb db;

	public BoardMembersUtil(){
		db = new DBUtilWeb();
	}

	public ArrayList<BoardMember> getBoardMembers() 
	{
		ArrayList<BoardMember> boardMembers = new ArrayList<BoardMember>();
		BoardMember temp = new BoardMember();
		
		try{
			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT boardMemberID, firstname, lastname, boardPositionID, year FROM `paws-web`.`board-members` ORDER BY `year`");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				temp = new BoardMember(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), getBoardPosition(rs.getInt(4)), rs.getInt(5));
				boardMembers.add(temp);
			}
			db.cutPort();
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
			PreparedStatement ps = conn.prepareStatement("SELECT name FROM `paws-web`.`board-positions` WHERE positionID = ?");
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

	public BoardMember getBoardMember(int bmID) 
	{
		BoardMember temp = new BoardMember();
		
		try{
			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM `paws-web`.`board-members` WHERE boardMemberID =? ");
			ps.setInt(1, bmID);
			ResultSet rs = ps.executeQuery();
			if(rs.first())
			{
				temp = new BoardMember(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9), rs.getInt(10), getBoardPosition(rs.getInt(10)));
			}
			db.cutPort();
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
			db.cutPort();
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
			db.cutPort();
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
			
			db.cutPort();
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
			System.out.println("POTANGENA" + bmID);
			ps.executeUpdate();
			db.cutPort();
		} catch (Exception e){
			System.out.println("Error in AccreditorUtil:addAccreditor()");
			e.printStackTrace();
		}
	}
	
}

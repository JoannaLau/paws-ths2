package Utilities;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;

import Models.Institution;
import Models.SchoolProgram;
import Models.SchoolSystem;


public class InstitutionsWebUtil 
{	
	private DBUtilWeb db;

	
	public InstitutionsWebUtil(){
		db = new DBUtilWeb();
	}

	public Connection getDB()
	{
		return this.db.conn;
	}
	
	public int updateSchoolPrograms(ArrayList<SchoolProgram> spList) {
		int rows = 0;
		
		for(int i = 0; i<spList.size(); i++)
		{
			try{
				//check SP already exists
				Connection conn = db.getConnection();
				PreparedStatement ps = conn.prepareStatement("SELECT * FROM `school-program` WHERE SPID = ?");
				ps.setInt(1, spList.get(i).getSPID());
				ResultSet rs = ps.executeQuery();
				
				//SP exists, update only
				if(rs.first())
				{
					PreparedStatement ps2 = conn.prepareStatement("UPDATE `school-program` SET `programID` = ?, `institutionID` = ?, `accLevel` = ?, `dateAdded` = ?, `degreeName` = ?, `validUntil` = ?, `levelID` = ? WHERE SPID = ?");
					//ps1.setInt(1, instList.get(i).getInstitutionID());
					
					ps2.setInt(1, spList.get(i).getProgramID());
					ps2.setInt(2, spList.get(i).getInstitutionID());
					ps2.setString(3, spList.get(i).getLevel());
					ps2.setString(4, spList.get(i).getDateAdded());
					ps2.setString(5, spList.get(i).getDegreeName());
					ps2.setString(6, spList.get(i).getValidUntil());
					ps2.setInt(7, spList.get(i).getLevelID());
					ps2.setInt(8, spList.get(i).getSPID());
					
					
					if(ps2.executeUpdate() > 0)
						//successful update
						rows++;
					
					
					
				}
				//new SP
				else
				{
						PreparedStatement ps2 = conn.prepareStatement("INSERT INTO `school-program` (SPID, programID, institutionID, accLevel, dateAdded, degreeName, validUntil, levelID) VALUES (?,?,?,?,?,?,?,?)");
						//ps1.setInt(1, instList.get(i).getInstitutionID());
						
						ps2.setInt(1, spList.get(i).getSPID());
						ps2.setInt(2, spList.get(i).getProgramID());
						ps2.setInt(3, spList.get(i).getInstitutionID());
						ps2.setString(4, spList.get(i).getLevel());
						ps2.setString(5, spList.get(i).getDateAdded());
						ps2.setString(6, spList.get(i).getDegreeName());
						ps2.setString(7, spList.get(i).getValidUntil());
						ps2.setInt(8, spList.get(i).getLevelID());
						
						
						
						if(ps2.executeUpdate() > 0)
							//successful update
							rows++;
						
				}
			
	
			} catch (Exception e){
				System.out.println("Error in AccreditorUtil:addAccreditor()");
				e.printStackTrace();
			}
		}
		db.cutPort();
		return rows;
		
	}

	public int updateInstitutions(ArrayList<Institution> instList) {

		int rows = 0;
		
		for(int i = 0; i<instList.size(); i++)
		{
			try{
				//check if institution already exists
				Connection conn = db.getConnection();
				PreparedStatement ps = conn.prepareStatement("SELECT * FROM institutions WHERE institutionID = ?");
				ps.setInt(1, instList.get(i).getInstitutionID());
				ResultSet rs = ps.executeQuery();
				
				//institution exists, update only
				if(rs.first())
				{
					PreparedStatement ps2 = conn.prepareStatement("UPDATE institutions SET `systemID` = ?, `name` = ?, `head` = ?, `hPosition` = ?, `hEmail` = ?, `address` = ?, `status` = ?, `dateAdded` = ?, `city` = ?, `fax` = ?, `contactPerson` = ?, `contactPosition` = ?, `contactNumber` = ?, `website` = ?, `country` = ?, `contactEmail` = ?, `acronym` = ?, `longitude` = ?, `latitude` = ? WHERE institutionID = ?");
					//ps1.setInt(1, instList.get(i).getInstitutionID());
					
					ps2.setInt(1, instList.get(i).getSchoolSystemID());
					ps2.setString(2, instList.get(i).getName());
					ps2.setString(3, instList.get(i).getHead());
					ps2.setString(4, instList.get(i).gethPosition());
					ps2.setString(5, instList.get(i).gethEmail());
					ps2.setString(6, instList.get(i).getAddress());
					ps2.setString(7, "Preliminary Visit");
					ps2.setString(8, instList.get(i).getDateAdded());
					ps2.setString(9, instList.get(i).getCity());
					ps2.setString(10, instList.get(i).getFax());
					ps2.setString(11, instList.get(i).getContactPerson());
					ps2.setString(12, instList.get(i).getContactPosition());
					ps2.setString(13, instList.get(i).getContactNumber());
					ps2.setString(14, instList.get(i).getWebsite());
					ps2.setString(15, instList.get(i).getCountry());
					ps2.setString(16, instList.get(i).getContactEmail());
					ps2.setString(17, instList.get(i).getInstitutionAcronym());
					ps2.setDouble(18, instList.get(i).getLongitude());
					ps2.setDouble(19, instList.get(i).getLatitude());
					ps2.setInt(20, instList.get(i).getInstitutionID());
					
					if(ps2.executeUpdate() > 0)
						//successful update
						rows++;
					
					
					
				}
				//new institution
				else
				{
						PreparedStatement ps2 = conn.prepareStatement("INSERT INTO institutions (institutionID, systemID, name, head, hPosition, hEmail, address, status, dateAdded, city, fax, contactPerson, contactPosition, contactNumber, website, country, contactEmail, acronym, longitude, latitude) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
						//ps1.setInt(1, instList.get(i).getInstitutionID());
						
	
						ps2.setInt(1, instList.get(i).getInstitutionID());
						ps2.setInt(2, instList.get(i).getSchoolSystemID());
						ps2.setString(3, instList.get(i).getName());
						ps2.setString(4, instList.get(i).getHead());
						ps2.setString(5, instList.get(i).gethPosition());
						ps2.setString(6, instList.get(i).gethEmail());
						ps2.setString(7, instList.get(i).getAddress());
						ps2.setString(8, "Preliminary Visit");
						ps2.setString(9, instList.get(i).getDateAdded());
						ps2.setString(10, instList.get(i).getCity());
						ps2.setString(11, instList.get(i).getFax());
						ps2.setString(12, instList.get(i).getContactPerson());
						ps2.setString(13, instList.get(i).getContactPosition());
						ps2.setString(14, instList.get(i).getContactNumber());
						ps2.setString(15, instList.get(i).getWebsite());
						ps2.setString(16, instList.get(i).getCountry());
						ps2.setString(17, instList.get(i).getContactEmail());
						ps2.setString(18, instList.get(i).getInstitutionAcronym());
						ps2.setDouble(19, instList.get(i).getLongitude());
						ps2.setDouble(20, instList.get(i).getLatitude());
						
						if(ps2.executeUpdate() > 0)
							//successful update
							rows++;
						
				}
			
	
			} catch (Exception e){
				System.out.println("Error in AccreditorUtil:addAccreditor()");
				e.printStackTrace();
			}
		}
		db.cutPort();
		return rows;
		
	}
	
	public int updateSchoolSystems(ArrayList<SchoolSystem> ssList) {
		int rows = 0;
		for(int i = 0; i<ssList.size(); i++)
		{
			try{
				//check SP already exists
				Connection conn = db.getConnection();
				PreparedStatement ps = conn.prepareStatement("SELECT * FROM `school-systems` WHERE systemID = ?");
				ps.setInt(1, ssList.get(i).getSchoolSystemID());
				ResultSet rs = ps.executeQuery();
				
				//SS exists, update only
				if(rs.first())
				{
					PreparedStatement ps2 = conn.prepareStatement("UPDATE `school-systems` SET `name` = ? WHERE systemID = ?");
					//ps1.setInt(1, instList.get(i).getInstitutionID());
					
					ps2.setString(1, ssList.get(i).getName());
					ps2.setInt(2, ssList.get(i).getSchoolSystemID());
					
					
					if(ps2.executeUpdate() > 0)
						//successful update
						rows++;
					
					
					
				}
				//new SS
				else
				{
						PreparedStatement ps2 = conn.prepareStatement("INSERT INTO `school-systems` (systemID, name, dateJoined) VALUES (?,?,?)");
						//ps1.setInt(1, instList.get(i).getInstitutionID());
						
						ps2.setInt(1, ssList.get(i).getSchoolSystemID());
						ps2.setString(2, ssList.get(i).getName());
						ps2.setString(3, ssList.get(i).getDateJoined());
						
						if(ps2.executeUpdate() > 0)
							//successful update
							rows++;
						
				}
			
	
			} catch (Exception e){
				System.out.println("Error in AccreditorUtil:addAccreditor()");
				e.printStackTrace();
			}
		}
		db.cutPort();
		return rows;
	}

	
	
}

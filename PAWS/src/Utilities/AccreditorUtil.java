package Utilities;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mysql.jdbc.Connection;

import Models.Accreditation;
import Models.Accreditor;
import Models.AccreditorCard;
import Models.AccreditorDeck;
import Models.Degree;
import Models.Work;

public class AccreditorUtil {
	private DBUtil db;
	public AccreditorUtil(){
		db = new DBUtil();
	}
	private String getDegree(int SPID){
		String title = new String();
		
		try{
			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM `school-program` WHERE SPID = ?");
			ps.setInt(1, SPID);
			ResultSet rs = ps.executeQuery();
			rs.next();
			title = rs.getString(9);
		} catch (Exception e){
			System.out.println("Error in AccreditorUtil:getDegree()");
			e.printStackTrace();
		}
		
		return title;
	}
	private String getDiscipline(int disciplineID){
		String name = null;
		try{
			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM programs WHERE programID = ?");
			ps.setInt(1, disciplineID);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				name = rs.getString(2);
			}else{
				name = "No Data";
			}
		} catch (Exception e){
			System.out.println("Error in AccreditorUtil:getDiscipline()");
			e.printStackTrace();
		}
		
		return name;
	}
	
	public JSONArray getSurveyAccreditorsJSON(int institutionID, int PSID, int areaID){		
		int systemID = getSystemID(institutionID);
		int SPID = getSPID(PSID);
		String area = getArea(areaID);
		return getAccreditorsJSON1(SPID, systemID, area);
	}
	
	private boolean checkDiscipline(int accreditorID, int SPID){
		boolean result = false;
		int accDisciplineID, programID;
		
		try{
			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT discipline FROM accreditors WHERE accreditorID = ?");
			ps.setInt(1, accreditorID);
			ResultSet rs = ps.executeQuery();
			rs.next();
			accDisciplineID = rs.getInt(1);
			
			ps = conn.prepareStatement("SELECT programID FROM `school-program` WHERE SPID = ?");
			ps.setInt(1, SPID);
			rs = ps.executeQuery();
			rs.next();
			programID = rs.getInt(1);
			
			
	
			
			if(accDisciplineID==programID) result = true;
						
		} catch (Exception e){
			System.out.println("Error in AccreditorUtil:checkAffiliations()");
			e.printStackTrace();
		}
		
		
		return result;
	}
	
	public ArrayList<Accreditor> getInactiveAccreditors(){
		ArrayList<Accreditor> accreditors = new ArrayList<Accreditor>();
		Accreditor temp = new Accreditor();
		try{
			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM accreditors where status = 'Inactive'");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				
				int accreditorID = rs.getInt(1);
				String honorifics = rs.getString(5);
				String firstName = rs.getString(3);
				String lastName = rs.getString(2);
				String middleName = rs.getString(4);
				String email = rs.getString(6);
				String institution = getLatestAffiliation(accreditorID);
				String discipline = rs.getString(17);
				int primaryAreaID = rs.getInt(14);
				int secondaryAreaID = rs.getInt(15);
				int tertiaryAreaID = rs.getInt(16);
				String primaryArea = getArea(primaryAreaID);
				String secondaryArea = getArea(secondaryAreaID);
				String tertiaryArea = getArea(tertiaryAreaID);
				
				int totalSurveys = rs.getInt(7);
				String city = rs.getString(11);
				String country = rs.getString(12);
				String venue_trained = rs.getString(13);
				String date_trained = rs.getString(8);
				String address = rs.getString(10);
				String contact = rs.getString(9);
				
				temp = new Accreditor(accreditorID, honorifics, firstName, lastName, middleName, email, contact, institution, discipline, primaryAreaID, secondaryAreaID, tertiaryAreaID, primaryArea, secondaryArea, tertiaryArea, totalSurveys, city, country, venue_trained, date_trained, address);
				accreditors.add(temp);	


			}
		} catch (Exception e){
			System.out.println("Error in AccreditorUtil:getAccreditors()");
			e.printStackTrace();
		}
		
	    return accreditors;
	}
	
	public JSONArray getAccreditorsJSON1(int SPID, int systemID, String area){
		JSONArray jArray = new JSONArray();
		JSONObject job = new JSONObject();
		double v1total= 0, v2total = 0, v3total= 0, v4total = 0;
		AccreditorDeck deck = new AccreditorDeck();

		try{
			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT accreditorID, lastname, firstname, middlename, `numSurveys`, city, primaryAreaID, secondaryAreaID, tertiaryAreaID, discipline , dateTrained FROM `accreditors` where `status` = 'Active'");
			ResultSet rs = ps.executeQuery();
			AccreditorCard temp;
			while(rs.next()){
			temp = new AccreditorCard();
			int accID = rs.getInt(1);
			
			//V1 = Area | V2 = SurveyDate | V3 = Total Surveys | V4 = City
			
			//Date Implementation
//			System.out.println("RS GET STRING 10 ====="+rs.getString(11));
			temp.setLastSurveyDate(getAccreditorSurveyDate(accID, rs.getString(11)));	
			
			SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
			double v2=0;
			try {
				Date date = new Date();
				
			    
			    Date date2 = myFormat.parse(temp.getLastSurveyDate());
			    
			    
			    
			    
			    long diff = date.getTime() - date2.getTime();
			    v2 = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
			    
			} catch (ParseException e) {
			    e.printStackTrace();
			}
			
			temp.setV2(v2);
			
			//Accreditor Data
			temp.setAccreditorID(rs.getInt(1));
			temp.setAccreditorName(rs.getString(2) + ", " + rs.getString(3) + " " + rs.getString(4));
			temp.setCity(rs.getString(6));
			temp.setDiscipline(getDiscipline(rs.getInt(10)));
			temp.setPrimary(getArea(rs.getInt(7)));
			temp.setSecondary(getArea(rs.getInt(8)));
			temp.setTertiary(getArea(rs.getInt(9)));
			temp.setNumberSurveys(rs.getInt(5));
			temp.setPrimaryID(rs.getInt(7));
			temp.setSecondaryID(rs.getInt(8));
			temp.setTertiaryID(rs.getInt(9));
			temp.setDateTrained(rs.getString(11));

			
			int primaryAreaID = rs.getInt(7);
			int secondaryAreaID = rs.getInt(8);
			int tertiaryAreaID = rs.getInt(9);

			String primaryArea = getArea(primaryAreaID);
			String secondaryArea =  getArea(secondaryAreaID);
			String tertiaryArea =  getArea(tertiaryAreaID);
			
			//Affiliation Implementation
				boolean aff = checkAffiliations(accID, systemID);
				if(aff){deck.addCard_dump(temp); temp.setAffiliation("Affiliated");continue;}
				else{temp.setAffiliation("Non-affiliated");}
				
			//Discipline implementaion
				boolean disc = checkDiscipline(accID, SPID);
				if(!disc){deck.addCard_dump(temp); continue;}
				
				
				
				
			//Score
				if(primaryArea.equals(area)) temp.setV1(30); 
				if(secondaryArea.equals(area)) temp.setV1(20); 
				if(tertiaryArea.equals(area)) temp.setV1(10); 
								
			//Total Surveys
				temp.setV3(rs.getInt(5));

			//Store to Deck
				v1total+= temp.getV1();
				v2total+= temp.getV2();
				v3total+= temp.getV3();
				
				
			//City
				String city = getCity(SPID);
				if(city.equals(rs.getString(6))){deck.addPriorityCard(temp);}
				else{deck.addCard_filtered(temp);}
				
				System.out.println(temp.getAccreditorName() + " : " + temp.getV1()
				 + " : " + temp.getV2() + " : " + temp.getV3()
						);
				
			}
		} catch (Exception e){
			System.out.println("Error in AccreditorUtil:getAccreditorsJSON()");
			e.printStackTrace();
		}
		
		
		
		jArray = deck.getAccList(v1total, v2total, v3total);
		return jArray;
	}
	

	private String getCity(int SPID){
		String nice = "england is my city";
		try{
			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT institutionID FROM `school-program` WHERE SPID = ?");
			ps.setInt(1, SPID);
		
			ResultSet rs = ps.executeQuery();
			rs.next();
			int institutionID = rs.getInt(1);
				
			ps = conn.prepareStatement("SELECT city FROM `institutions` WHERE institutionID = ?");
			ps.setInt(1, institutionID);
		
			ResultSet rs1 = ps.executeQuery();
			rs1.next();
			nice = rs1.getString(1);
			
		} catch (Exception e){
			System.out.println("Error in AccreditorUtil:checkAffiliations()");
			e.printStackTrace();
		}
		return nice;
				
	}
	
	public void updateTotalSurveys(int accID, int add){
		int temp = 0;
			try{
				Connection conn = db.getConnection();
				PreparedStatement ps = conn.prepareStatement("SELECT `numSurveys` FROM `accreditors`  WHERE accreditorID = ? ");
				ps.setInt(1, accID);
			
				ResultSet rs = ps.executeQuery();
			
				if(rs.next()){
					temp = rs.getInt(1)+add;
				}
				
				ps = conn.prepareStatement("UPDATE `accreditors` SET `numSurveys`=? WHERE accreditorID=? ");
				ps.setInt(1, temp);
				ps.setInt(2, accID);
				ps.executeUpdate();
					
				
			} catch (Exception e){
				System.out.println("Error in AccreditorUtil:checkAffiliations()");
				e.printStackTrace();
			}
		}
	
	private String getAccreditorSurveyDate(int accID, String dateTrained){
		String latestDate = null;
		try{
//			System.out.println("initial date trained>>>>>>>>>>>>>"+ dateTrained);
			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT DISTINCT PSID FROM `program-area` WHERE accreditorID = ?");
			ps.setInt(1, accID);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				int PSID = rs.getInt(1);
				ps = conn.prepareStatement("SELECT surveyID FROM `program-survey` WHERE PSID = ?");
				ps.setInt(1, PSID);
				ResultSet rs2 = ps.executeQuery();
				
				int starter = 0;
				latestDate = "";		
				while(rs2.next()){
					int surveyID = rs2.getInt(1);
					ps = conn.prepareStatement("SELECT end_date FROM `surveys` WHERE surveyID = ?");
					ps.setInt(1, surveyID);
					ResultSet rs3 = ps.executeQuery();
					
					
					rs3.next();
						String date = rs3.getString(1);
//						System.out.println("TAAAAAAAAAAAAEEEEEEEEEEEEE123o"+date);
					
						if(starter == 0) {latestDate = date; starter++;}
						else{
							int currDate = Integer.parseInt(latestDate.replace("-",""));
							int newDate = Integer.parseInt(date.replace("-",""));
							if(currDate < newDate) {latestDate = date;}
						}
					
				}
				
				
	
			}
		
			if(latestDate==null||latestDate==""){
				latestDate = dateTrained;
			}
//			System.out.println("/"+dateTrained+"RETURNED DATE FROM GETACCREDITORSURVEYDATE:"+ latestDate);
			return latestDate;

		} catch (Exception e){
			System.out.println("Error in AccreditorUtil:getAccreditorSurveyDate()");
			e.printStackTrace();
		}
		
		return latestDate;
	}
	
	private int getSystemID(int institutionID){
		int id = 0;
		try{
			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT systemID FROM institutions WHERE institutionID = ?");
			ps.setInt(1, institutionID);
			ResultSet rs = ps.executeQuery();
			rs.next();
			id = rs.getInt(1);
			
		} catch (Exception e){
			System.out.println("Error in AccreditorUtil:getSystemID()");
			e.printStackTrace();
		}
		
		return id;
	}
	
	private int getSPID(int PSID){
		int id = 0;
		try{
			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT SPID FROM `program-survey` WHERE PSID = ?");
			ps.setInt(1, PSID);
			ResultSet rs = ps.executeQuery();
			rs.next();
			id = rs.getInt(1);
			
		} catch (Exception e){
			System.out.println("Error in AccreditorUtil:getSPID()");
			e.printStackTrace();
		}
		
		return id;
	}
	
	public ArrayList<Accreditation> getAccreditations(int accreditorID){
		ArrayList<Accreditation> past = new ArrayList<Accreditation>();
		Accreditation temp = new Accreditation();
		try{
			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT s.surveyID, s.startDate, s.endDate, s.institutionID, ps.surveyType, ps.SPID, pa.areaID, pa.accreditorID FROM `program-area` pa JOIN `program-survey` ps ON pa.PSID = ps.PSID JOIN surveys s ON ps.surveyID = s.surveyID WHERE accreditorID = ?");
			ps.setInt(1, accreditorID);
			ResultSet rs = ps.executeQuery();
			int surveyID = 0; int tempID = 0; int programID = 0; int tempID2 = 0;
			String programs = "";
			String areas = "";
			if(rs.next()){
				do{
					tempID = rs.getInt(1);
					tempID2 = rs.getInt(6);
					
					if(surveyID != tempID){
						temp.setPrograms(programs);
						
						past.add(temp);
						temp = new  Accreditation();
						temp.setInstitution(getInstitution(rs.getInt(4)));
						temp.setFrom(rs.getString(2));	
						temp.setTo(rs.getString(3));
						
						surveyID = tempID;
						programs = "";
						programID = tempID2;

						programs += getDegree(tempID2) + ": <br>";
						programs += getArea(rs.getInt(7)) + " ";
					}else{
						if (programID != tempID2){
							programs += "<br>";
							
							programs = getDegree(tempID2) + ": <br>";
							programs += getArea(rs.getInt(7)) + " ";

							programID = tempID2;
						}else{
							programs += getArea(rs.getInt(7)) + " ";
						}
					}
				}while(rs.next());
			}
			
			
		} catch (Exception e){
			System.out.println("Error in AccreditorUtil:getAccreditations()");
			e.printStackTrace();
		}
		return past;
	}
	public String updateConfirmation(int accreditorID, String confirmation, int PSID, int areaID){
		String temp = new String();
		try{
			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement("UPDATE `program-area` SET `attendanceConfirmation` = ? WHERE accreditorID=? AND PSID = ? AND areaID = ?");
			ps.setString(1, confirmation);
			ps.setInt(2, accreditorID);
			ps.setInt(3, PSID);
			ps.setInt(4, areaID);

			ps.executeUpdate();
			temp = "Successfully updated confirmation!";
		} catch (Exception e){
			System.out.println("Error in ProgramUtil:updateProgram()");
			temp = "Error in updating confirmation!";
			e.printStackTrace();
		}
		return temp;
	}
	public void updateAccreditor(int accreditorID, Accreditor acc, JSONObject affObject){
		try{
			removeAffiliations(accreditorID);

			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement("UPDATE `accreditors` SET `lastname` = ?, `firstname` = ?, `middlename` = ?, `honorifics` = ?, `email` = ?, `numSurveys` = ?, `dateTrained` = ?, `contact` = ?, `address` = ?, `city` = ?, `country` = ?, `venueTrained` = ?, `primaryAreaID` = ?, `secondaryAreaID` = ?, `tertiaryAreaID` = ?, `discipline` = ? WHERE accreditorID = ?");
			ps.setString(1, acc.getLastName());
			ps.setString(2, acc.getFirstName());
			ps.setString(3, acc.getMiddleName());
			ps.setString(4, acc.getHonorifics());
			ps.setString(5, acc.getEmail());
			ps.setInt(6, acc.getTotalSurveys());
			ps.setString(7, acc.getDateTrained());
			ps.setString(8, acc.getContact());
			ps.setString(9, acc.getAddress());
			ps.setString(10, acc.getCity());
			ps.setString(11, acc.getCountry());
			ps.setString(12, acc.getVenueTrained());
			ps.setInt(13, acc.getPrimaryAreaID());
			ps.setInt(14, acc.getSecondaryAreaID());
			ps.setInt(15, acc.getTertiaryAreaID());
			
			ps.setString(16, acc.getDiscipline());
			ps.setInt(17, accreditorID);
			ps.executeUpdate();

			addAffiliations(affObject, accreditorID);
		} catch (Exception e){
			System.out.println("Error in AccreditorUtil:updateAccreditor()");
			e.printStackTrace();
		}
	}
	
	private void removeAffiliations(int accreditorID){
		try{
			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement("DELETE from work WHERE accreditorID = ?");
			ps.setInt(1, accreditorID);
			ps.executeUpdate();
			
			ps = conn.prepareStatement("DELETE from `accreditor-degree` WHERE accreditorID = ?");
			ps.setInt(1, accreditorID);
			ps.executeUpdate();
		} catch (Exception e){
			System.out.println("Error in AccreditorUtil:removeAffiliations()");
			e.printStackTrace();
		}
	}
	

	public ArrayList<Accreditor> getAccreditorsNameID(){
		ArrayList<Accreditor> accreditors = new ArrayList<Accreditor>();
		Accreditor temp = new Accreditor();
		try{
			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT accreditorID, lastname, firstname, middlename, honorifics FROM accreditors");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				
				//int accreditorID, String honorifics, String firstName, String lastName, String middleName,
				//String email, String contact, String institution, String discipline, String primaryArea, String secondaryArea,
				//int totalSurveys, String city, String country, String venue_trained, String date_trained, String address
				
				//db returns accreditorID, lastname, firstname, midlename, honorifics, email, num_surveys, 
				//date_trained, contact, address, city, country, venue_trained, primaryAreaID, 
				//secondaryAreaID, discipline
				
				int accreditorID = rs.getInt(1);
				String honorifics = rs.getString(5);
				String firstName = rs.getString(3);
				String lastName = rs.getString(2);
				String middleName = rs.getString(4);
				temp = new Accreditor(accreditorID, honorifics, firstName, lastName, middleName);
				accreditors.add(temp);
			}
		} catch (Exception e){
			System.out.println("Error in AccreditorUtil:getAccreditorsNameID()");
			e.printStackTrace();
		}
		
	    return accreditors;
	}
	
	public JSONArray getAccreditorForInvitationJSON(int accID){
		JSONArray jArray = new JSONArray();
		JSONObject job = new JSONObject();
		
		try{
			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT head, hPosition, name, city FROM institutions WHERE institutionID = (SELECT institutionID FROM work WHERE accreditorID = ? AND dateFinished IS NULL LIMIT 1)");
			ps.setInt(1,  accID);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				
				
				String head = rs.getString(1);
				String partsHead[] = head.split(" ");
				head = "";
				for(int i = 0; i<partsHead.length; i++)
				{
					if(head == "")
					{
						head = partsHead[i].substring(0, 1).toUpperCase() + partsHead[i].substring(1).toLowerCase(); 
					}
					else	
						head = head + " " + partsHead[i].substring(0, 1).toUpperCase() + partsHead[i].substring(1).toLowerCase(); 
				}

				job = new JSONObject();
				job.put("head", head);
				job.put("hPosition", rs.getString(2));
				job.put("institutionName", rs.getString(3));
				job.put("city", rs.getString(4));
				jArray.put(job);
				
			}
		} catch (Exception e){
			System.out.println("Error in InstitutionsUtil:getAccreditorForInvitationJSON()");
			e.printStackTrace();
		}
		
		return jArray;
	}
	
	public JSONArray getDisciplinesJSON(){
		JSONArray jArray = new JSONArray();
		JSONObject job = new JSONObject();
		
		try{
			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT DISTINCT discipline FROM accreditors");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				job = new JSONObject();
				job.put("discipline", rs.getString(1));
				jArray.put(job);
				
			}
		} catch (Exception e){
			System.out.println("Error in AccreditorUtil:getDisciplinesJSON()");
			e.printStackTrace();
		}
		
		return jArray;
	}
	
	public JSONArray getHonorificsJSON(){
		JSONArray jArray = new JSONArray();
		JSONObject job = new JSONObject();
		
		try{
			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT DISTINCT honorifics FROM accreditors");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				job = new JSONObject();
				job.put("honorifics", rs.getString(1));
				jArray.put(job);
				
			}
		} catch (Exception e){
			System.out.println("Error in AccreditorUtil:getHonorificsJSON()");
			e.printStackTrace();
		}
		
		return jArray;
	}

	public JSONArray getInvitationAccreditorsJSON(){
		JSONArray jArray = new JSONArray();
		JSONObject job = new JSONObject();
		
		try{
			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT accreditorID, lastname, firstname, honorifics FROM accreditors");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				
				String cleanLastName = rs.getString(2);
				String cleanFirstName = rs.getString(3);
				String cleanHonorifics = rs.getString(4);
				String[] partsLastName = cleanLastName.split(" ");
				String[] partsFirstName = cleanFirstName.split(" ");
				String[] partsHonorifics = cleanHonorifics.split(" ");
				cleanLastName = "";
				cleanFirstName = "";
				cleanHonorifics = "";
				
				for(int i = 0; i<partsLastName.length; i++)
				{
					partsLastName[i] = 	partsLastName[i].substring(0, 1).toUpperCase() + partsLastName[i].substring(1).toLowerCase();
					if(cleanLastName == "")
						cleanLastName = partsLastName[i];
					else
						cleanLastName = cleanLastName + " " + partsLastName[i];
				}
				
				for(int i = 0; i<partsFirstName.length; i++)
				{
					partsFirstName[i] = partsFirstName[i].substring(0, 1).toUpperCase() + partsFirstName[i].substring(1).toLowerCase();
					
					if(cleanFirstName == "")
						cleanFirstName = partsFirstName[i];
					else
						cleanFirstName = cleanFirstName + " " + partsFirstName[i];
						
				}
				
				for(int i = 0; i<partsHonorifics.length; i++)
				{
					partsHonorifics[i] = partsHonorifics[i].substring(0, 1).toUpperCase() + partsHonorifics[i].substring(1).toLowerCase();
					cleanHonorifics = cleanHonorifics + partsHonorifics[i];
				}
				
				
				job = new JSONObject();
				job.put("accID", rs.getInt(1));
				job.put("accName", cleanHonorifics + " " + cleanFirstName + " " + cleanLastName);
				jArray.put(job);
				
			}
		} catch (Exception e){
			System.out.println("Error in InstitutionsUtil:getAccreditorsNameIDJSON()");
			e.printStackTrace();
		}
		
		return jArray;
	}
	
	public ArrayList<Accreditor> getAccreditors(){
		ArrayList<Accreditor> accreditors = new ArrayList<Accreditor>();
		Accreditor temp = new Accreditor();
		try{
			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM accreditors WHERE status = 'Active'");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				
				int accreditorID = rs.getInt(1);
				String honorifics = rs.getString(5);
				String firstName = rs.getString(3);
				String lastName = rs.getString(2);
				String middleName = rs.getString(4);
				String email = rs.getString(6);
				String institution = getLatestAffiliation(accreditorID);
				String discipline = rs.getString(17);
				int primaryAreaID = rs.getInt(14);
				int secondaryAreaID = rs.getInt(15);
				int tertiaryAreaID = rs.getInt(16);
				String primaryArea = getArea(primaryAreaID);
				String secondaryArea = getArea(secondaryAreaID);
				String tertiaryArea = getArea(tertiaryAreaID);
				
				int totalSurveys = rs.getInt(7);
				String city = rs.getString(11);
				String country = rs.getString(12);
				String venue_trained = rs.getString(13);
				String date_trained = rs.getString(8);
				String address = rs.getString(10);
				String contact = rs.getString(9);
				
				temp = new Accreditor(accreditorID, honorifics, firstName, lastName, middleName, email, contact, institution, discipline, primaryAreaID, secondaryAreaID, tertiaryAreaID, primaryArea, secondaryArea, tertiaryArea, totalSurveys, city, country, venue_trained, date_trained, address);
				accreditors.add(temp);
			}
		} catch (Exception e){
			System.out.println("Error in AccreditorUtil:getAccreditors()");
			e.printStackTrace();
		}
		
	    return accreditors;
	}
	private String getLatestAffiliation(int accreditorID){
		String name = null;
		try{
			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM work WHERE accreditorID = ? and dateFinished IS NULL");
			ps.setInt(1, accreditorID);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				name = getInstitution(rs.getInt(1));
			}
			else name = "No Data"; 
		} catch (Exception e){
			System.out.println("Error in AccreditorUtil:getLatestAffiliation()");
			e.printStackTrace();
		}
		return name;
	}
	
	public String getArea(int areaID){
		String name = null;
		try{
			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM areas WHERE areaID = ?");
			ps.setInt(1, areaID);
			ResultSet rs = ps.executeQuery();
			rs.next();
			name = rs.getString(1);
		} catch (Exception e){
			System.out.println("Error in AccreditorUtil:getArea()");
			e.printStackTrace();
		}
		
		return name;
	}
	
	public Accreditor getAccreditor(int accreditorID){
		Accreditor accreditor = new Accreditor();
		try{
			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM accreditors a WHERE a.accreditorID = ?");
			ps.setInt(1, accreditorID);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				//int accreditorID, String honorifics, String firstName, String lastName, String middleName,
				//String email, String contact, String institution, String discipline, String primaryArea, String secondaryArea,
				//int totalSurveys, String city, String country, String venue_trained, String date_trained, String address
				
				//db returns accreditorID, lastname, firstname, midlename, honorifics, email, num_surveys, 
				//date_trained, contact, address, city, country, venue_trained, primaryAreaID, 
				//secondaryAreaID, discipline
				String honorifics = rs.getString(5);
				String firstName = rs.getString(3);
				String lastName = rs.getString(2);
				String middleName = rs.getString(4);
				String email = rs.getString(6);
				String institution = getLatestAffiliation(accreditorID);
				String discipline = rs.getString(17);
				int primaryAreaID = rs.getInt(14);
				int secondaryAreaID = rs.getInt(15);
				int tertiaryAreaID = rs.getInt(16);
				String primaryArea = getArea(rs.getInt(14));
				String secondaryArea = getArea(rs.getInt(15));
				String tertiaryArea = getArea(rs.getInt(16));
				
				int totalSurveys = rs.getInt(7);
				String city = rs.getString(11);
				String country = rs.getString(12);
				String venue_trained = rs.getString(13);
				String date_trained = rs.getString(8);
				String address = rs.getString(10);
				String contact = rs.getString(9);
				accreditor = new Accreditor(accreditorID, honorifics, firstName, lastName, middleName, email, contact, institution, discipline, primaryAreaID, secondaryAreaID, tertiaryAreaID, primaryArea, secondaryArea, tertiaryArea, totalSurveys, city, country, venue_trained, date_trained, address);
				accreditor.addDegrees(getDegrees(accreditorID));
				accreditor.addWorks(getWorks(accreditorID));
			}
		} catch (Exception e){
			System.out.println("Error in AccreditorUtil:getAccreditors()");
			e.printStackTrace();
		}
		return accreditor;
	}
	
	private ArrayList<Degree> getDegrees(int accreditorID){
		ArrayList<Degree> degrees = new ArrayList<Degree>();
		Degree temp = new Degree();
		try{
			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM `accreditor-degree` WHERE accreditorID = ?");
			ps.setInt(1, accreditorID);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				temp = new Degree(rs.getString(2), accreditorID, getInstitution(rs.getInt(3)), rs.getInt(3));
				degrees.add(temp);
			}
			
		} catch (Exception e){
			System.out.println("Error in AccreditorUtil:getDegrees()");
			e.printStackTrace();
		}
		return degrees;
	}
	
	private String getInstitution(int institutionID){
		String name = null;
		try{
			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM institutions WHERE institutionID = ?");
			ps.setInt(1, institutionID);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				name = rs.getString(3);
			}else{
				name = "No Data";
			}
		} catch (Exception e){
			System.out.println("Error in AccreditorUtil:getInstitution()");
			e.printStackTrace();
		}
		
		return name;
	}
	private ArrayList<Work> getWorks(int accreditorID){
		ArrayList<Work> works = new ArrayList<Work>();
		Work temp = new Work();
		try{
			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM work WHERE accreditorID = ?");
			ps.setInt(1, accreditorID);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				temp = new Work(getInstitution(rs.getInt(2)), accreditorID, rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(2), rs.getString(7));
				works.add(temp);
			}
			
		} catch (Exception e){
			System.out.println("Error in AccreditorUtil:getDegrees()");
			e.printStackTrace();
		}
		return works;
	}
	
	
	private String formatDate(String date){
		String format = new String();
		String month = "";
		String day;
		String year;
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
		return format;
	}
	public void addAccreditor(Accreditor acc, JSONObject affObject){
		try{
			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement("INSERT INTO `accreditors` (`lastname`, `firstname`, `middlename`, `honorifics`, `email`, `numSurveys`, `dateTrained`, `contact`, `address`, `city`, `country`, `venueTrained`, `primaryAreaID`, `secondaryAreaID`, `tertiaryAreaID`,`discipline`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			ps.setString(1, acc.getLastName());
			ps.setString(2, acc.getFirstName());
			ps.setString(3, acc.getMiddleName());
			ps.setString(4, acc.getHonorifics());
			ps.setString(5, acc.getEmail());
			ps.setInt(6, acc.getTotalSurveys());
			ps.setString(7, formatDate(acc.getDateTrained()));
			ps.setString(8, acc.getContact());
			ps.setString(9, acc.getAddress());
			ps.setString(10, acc.getCity());
			ps.setString(11, acc.getCountry());
			ps.setString(12, acc.getVenueTrained());
			ps.setInt(13, acc.getPrimaryAreaID());
			ps.setInt(14, acc.getSecondaryAreaID());
			ps.setInt(15, acc.getTertiaryAreaID());
			ps.setString(16, acc.getDiscipline());
			ps.executeUpdate();
			ps = conn.prepareStatement("SELECT LAST_INSERT_ID()");
			ResultSet rs = ps.executeQuery();
			rs.next();
			int accreditorID = rs.getInt(1);
			addAffiliations(affObject, accreditorID);
			
		} catch (Exception e){
			System.out.println("Error in AccreditorUtil:addAccreditor()");
			e.printStackTrace();
		}
	}
	
	public void addLatestAffiliation(int accreditorID, int institutionID, String start, String position){
		try{
			Connection conn = db.getConnection();
			if(start == null || position == null){
				System.out.println("WALA");
			}
			PreparedStatement ps = conn.prepareStatement("INSERT INTO `work` (institutionID, accreditorID, `dateEntered`, `position`) VALUES (?, ?, ?, ?)");
			ps.setInt(1, institutionID);
			ps.setInt(2, accreditorID);
			ps.setString(3, start);
			ps.setString(4, position);
			
			ps.executeUpdate();			
		} catch (Exception e){
			System.out.println("Error in AccreditorUtil:addWork()");
			e.printStackTrace();	
		}
	}
	public void addAffiliations(JSONObject affObject, int accreditorID){
		JSONArray works = (JSONArray) affObject.getJSONArray("works");
		JSONArray edu = (JSONArray) affObject.getJSONArray("edu");
		JSONObject temp = new JSONObject();

		for(int i = 0; i < works.length(); i++){
			temp = works.getJSONObject(i);
			int institutionID = temp.getInt("institutionID");
			String position = temp.getString("pos");
			String positionPlace = temp.getString("placepos");
			String from = formatDate(temp.getString("from"));
			String to = formatDate(temp.getString("to"));
			addWork(accreditorID, institutionID, position, positionPlace, from, to);
		}
		
		for(int j = 0; j < edu.length(); j++){
			temp = edu.getJSONObject(j);
			int institutionID = temp.getInt("institutionID");
			String course = temp.getString("course");
			addEdu(accreditorID, institutionID, course);
		}
	}
	
	public void addWork(int accreditorID, int institutionID, String position, String placePos, String from, String to){
		try{
			Connection conn = db.getConnection();
			if(to.equals("")){
				PreparedStatement ps = conn.prepareStatement("INSERT INTO `work` (institutionID, accreditorID, `dateEntered`, `position`, `placeOfPosition`) VALUES (?, ?, ?, ?, ?)");
				
				ps.setInt(1, institutionID);
				ps.setInt(2, accreditorID);
				ps.setString(3, from);
				ps.setString(4, position);
				ps.setString(5, placePos);
				
				ps.executeUpdate();	
			}else{
				PreparedStatement ps = conn.prepareStatement("INSERT INTO `work` (institutionID, accreditorID, `dateEntered`, `dateFinished`, `position`, `placeOfPosition`) VALUES (?, ?, ?, ?, ?, ?)");
				
				ps.setInt(1, institutionID);
				ps.setInt(2, accreditorID);
				ps.setString(3, from);
				ps.setString(4, to);
				ps.setString(5, position);
				ps.setString(6, placePos);
				
				ps.executeUpdate();	
			}
					
		} catch (Exception e){
			System.out.println("Error in AccreditorUtil:addWork()");
			e.printStackTrace();	
		}
	}
	
	public void addEdu(int accreditorID, int institutionID, String course){
		try{
			Connection conn = db.getConnection();

			PreparedStatement ps = conn.prepareStatement("INSERT INTO `accreditor-degree` (accreditorID, `degreeName`, `institutionID`) VALUES (?, ?, ?)");
			ps.setInt(1, accreditorID);
			ps.setString(2, course);
			ps.setInt(3, institutionID);
			ps.executeUpdate();			
		} catch (Exception e){
			System.out.println("Error in AccreditorUtil:addWork()");
			e.printStackTrace();	
		}
	}
	public void deleteAccreditor(int accreditorID){
		try{
			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement("UPDATE accreditors Set `status` = 'Inactive' WHERE accreditorID = ?");
			ps.setInt(1, accreditorID);
			ps.executeUpdate();
		} catch (Exception e){
			System.out.println("Error in AccreditorUtil:deleteAccreditor()");
			e.printStackTrace();
		}
	}
	
	public JSONArray getAccreditorsJSON(int SPID, int systemID){
		JSONArray jArray = new JSONArray();
		JSONObject job = new JSONObject();
		
		try{
			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT accreditorID, lastname, firstname, middlename, `numSurveys`, city, primaryAreaID, secondaryAreaID, tertiaryAreaID, discipline FROM `accreditors`");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				job = new JSONObject();
				job.put("accreditorName", rs.getString(2) + ", " + rs.getString(3) + " " + rs.getString(4));
				int primaryAreaID = rs.getInt(7);
				if(rs.wasNull()){
					job.put("primaryArea", "None");
				}else{
					job.put("primaryArea", getArea(primaryAreaID));
				}
				
				int secondaryAreaID = rs.getInt(8);
				if(rs.wasNull()){
					job.put("secondaryArea", "None");
				}else{
					job.put("secondaryArea", getArea(secondaryAreaID));
				}
				
				int tertiaryAreaID = rs.getInt(9);
				if(rs.wasNull()){
					job.put("tertiaryArea", "None");
				}else{
					job.put("tertiaryArea", getArea(tertiaryAreaID));
				}
				job.put("primaryAreaID", rs.getInt(7));
				job.put("secondaryAreaID", rs.getInt(8));
				job.put("city", rs.getString(6));
				job.put("discipline", rs.getString(10));
				job.put("numberSurveys", rs.getInt(5));
				job.put("accreditorID", rs.getInt(1));
				job.put("hasAffiliation", checkAffiliations(rs.getInt(1), systemID));
				jArray.put(job);
				
			}
		} catch (Exception e){
			System.out.println("Error in AccreditorUtil:getAccreditorsJSON()");
			e.printStackTrace();
		}
		
		return jArray;
	}
	
	private boolean checkAffiliations(int accreditorID, int systemID){
		boolean nice = false;
		try{
			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM work INNER JOIN tertiary ON work.institutionID = institution.institutionID WHERE accreditorID = ? and systemID = ?");
			ps.setInt(1, accreditorID);
			ps.setInt(2, systemID);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				nice = true;
			}else{
				nice = false;
			}
				
			
		} catch (Exception e){
			System.out.println("Error in AccreditorUtil:checkAffiliations()");
			e.printStackTrace();
		}
		return nice;
	}
	public JSONArray getAccreditorForThankYouJSON(int accID) {
		JSONArray jArray = new JSONArray();
		JSONObject job = new JSONObject();
		
		try{
			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT i.name, i.city, w.position, w.placeOfPosition FROM institutions i, work w WHERE w.accreditorID = ? AND i.institutionID = (SELECT institutionID FROM work WHERE accreditorID = ? LIMIT 1) LIMIT 1");
			ps.setInt(1, accID);
			ps.setInt(2, accID);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				job = new JSONObject();
				job.put("name", rs.getString(1));
				job.put("city", rs.getString(2));
				job.put("position", rs.getString(3));
				job.put("placeOfPosition", rs.getString(4));
				
				jArray.put(job);
				
			}
		} catch (Exception e){
			System.out.println("Error in InstitutionsUtil:getAccreditorForThankYouJSON()");
			e.printStackTrace();
		}
		
		return jArray;
	}
	public JSONArray getCountriesJSON() {
		JSONArray jArray = new JSONArray();
		JSONObject job = new JSONObject();
		
		try{
			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT DISTINCT country FROM accreditors");
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				job = new JSONObject();
				job.put("country", rs.getString(1));
				
				jArray.put(job);
				
			}
		} catch (Exception e){
			System.out.println("Error in AccreditorUtil:getCountriesJSON()");
			e.printStackTrace();
		}
		
		return jArray;
	}
	public JSONArray getCitiesJSON() {
		JSONArray jArray = new JSONArray();
		JSONObject job = new JSONObject();
		
		try{
			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT DISTINCT city FROM accreditors");
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				job = new JSONObject();
				job.put("city", rs.getString(1));
				
				jArray.put(job);
				
			}
		} catch (Exception e){
			System.out.println("Error in AccreditorUtil:getCountriesJSON()");
			e.printStackTrace();
		}
		
		return jArray;
	}
}

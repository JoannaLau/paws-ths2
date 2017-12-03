package Listeners;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import Models.Accreditor;
import Models.BoardMember;
import Utilities.AccreditorUtil;
import Utilities.BoardMembersLocalUtil;
import Utilities.BoardMembersUtil;

/**
 * Servlet implementation class AddBoardMember
 */
@WebServlet("/AddBoardMember")
public class AddBoardMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBoardMember() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String honorifics = request.getParameter("honorifics");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String middleName = request.getParameter("middleName");
		String city = request.getParameter("city");
		int year = Integer.parseInt(request.getParameter("year"));
		String position = request.getParameter("position");
		int boardPositionID = Integer.parseInt(request.getParameter("boardPositionID"));
		String institution = request.getParameter("institution");
		
		BoardMember bm = new BoardMember();
		bm.setBoardPositionID(boardPositionID);
		bm.setHonorifics(honorifics);
		bm.setFirstName(firstName);
		bm.setMiddleName(middleName);
		bm.setLastName(lastName);
		bm.setCity(city);
		bm.setYear(year);
		bm.setPosition(position);
		bm.setInstitution(institution);
		
		BoardMembersUtil bmUtil = new BoardMembersUtil();
		BoardMembersLocalUtil bmlUtil = new BoardMembersLocalUtil();
		
		if(bmUtil.getDB()!=null)
			bmUtil.addBoardMember(bm);
		else
			bmlUtil.addBoardMemberChanges(bm);
			
		bmlUtil.addBoardMember(bm);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

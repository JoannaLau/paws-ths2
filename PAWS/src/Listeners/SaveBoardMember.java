package Listeners;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.BoardMember;
import Utilities.BoardMembersLocalUtil;
import Utilities.BoardMembersUtil;

/**
 * Servlet implementation class SaveBoardMember
 */
@WebServlet("/SaveBoardMember")
public class SaveBoardMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveBoardMember() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		BoardMembersUtil bmUtil = new BoardMembersUtil();
		BoardMembersLocalUtil bmlUtil = new BoardMembersLocalUtil();
		
		BoardMember bm = new BoardMember();
		
		String honorifics = request.getParameter("honorifics");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String middleName = request.getParameter("middleName");
		String city = request.getParameter("city");
		int year = Integer.parseInt(request.getParameter("year"));
		String position = request.getParameter("position");
		int boardPositionID = Integer.parseInt(request.getParameter("boardPositionID"));
		String institution = request.getParameter("institution");
		int bmID = Integer.parseInt(request.getParameter("bmID"));
		
		bm.setBmID(bmID);
		bm.setBoardPositionID(boardPositionID);
		bm.setHonorifics(honorifics);
		bm.setFirstName(firstName);
		bm.setMiddleName(middleName);
		bm.setLastName(lastName);
		bm.setCity(city);
		bm.setYear(year);
		bm.setPosition(position);
		bm.setInstitution(institution);
		
		if(bmUtil.getDB()!=null)
			bmUtil.editBoardMember(bm.getBmID(), bm);
		bmlUtil.editBoardMember(bm.getBmID(), bm);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package Listeners;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.CommissionMember;
import Utilities.CommissionMembersUtil;

/**
 * Servlet implementation class AddCommissionMember
 */
@WebServlet("/AddCommissionMember")
public class AddCommissionMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCommissionMember() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CommissionMembersUtil cmUtil = new CommissionMembersUtil();
		CommissionMember cm = new CommissionMember();
		
		String honorifics = request.getParameter("honorifics");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String middleName = request.getParameter("middleName");
		String city = request.getParameter("city");
		int year = Integer.parseInt(request.getParameter("year"));
		String position = request.getParameter("position");
		int educLevelID = Integer.parseInt(request.getParameter("educLevelID"));
		int boardPositionID = Integer.parseInt(request.getParameter("commissionPositionID"));
		String institution = request.getParameter("institution");
		
		cm.setCommissionPositionID(boardPositionID);
		cm.setHonorifics(honorifics);
		cm.setFirstName(firstName);
		cm.setMiddleName(middleName);
		cm.setLastName(lastName);
		cm.setCity(city);
		cm.setYear(year);
		cm.setPosition(position);
		cm.setInstitution(institution);
		cm.setEducLevelID(educLevelID);
		
		cmUtil.addCommissionMember(cm.getCmID(), cm);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

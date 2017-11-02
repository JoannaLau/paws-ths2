package Listeners;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.BoardMember;
import Models.CommissionMember;
import Utilities.BoardMembersUtil;
import Utilities.CommissionMembersUtil;

/**
 * Servlet implementation class EditCommissionMember
 */
@WebServlet("/EditCommissionMember")
public class EditCommissionMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCommissionMember() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int cmID = Integer.parseInt(request.getParameter("cmID"));
		CommissionMembersUtil cmUtil = new CommissionMembersUtil();
		CommissionMember cm = new CommissionMember();
		
		cm = cmUtil.getCommissionMember(cmID);
		request.setAttribute("cmID", cmID);
		request.setAttribute("cpID", cm.getCommissionPositionID());
		request.setAttribute("educLevelID", cm.getEducLevelID());
		
		request.setAttribute("commissionMember", cm);
		
		RequestDispatcher rd = request.getRequestDispatcher("editCommissionMember.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

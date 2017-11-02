package Listeners;

import java.io.IOException;
import java.util.ArrayList;

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
 * Servlet implementation class CommissionMembers
 */
@WebServlet("/CommissionMembers")
public class CommissionMembers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommissionMembers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CommissionMembersUtil cmUtil = new CommissionMembersUtil();
		ArrayList<CommissionMember> cm = new ArrayList<CommissionMember>();
		cm = cmUtil.getCommissionMembers();
		request.setAttribute("commissionMembers", cm);
		RequestDispatcher rd = request.getRequestDispatcher("commissionMembers.jsp");
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

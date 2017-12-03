package Listeners;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import Utilities.BoardMembersUtil;
import Utilities.CommissionMembersUtil;

/**
 * Servlet implementation class CommissionMemberYearLoader
 */
@WebServlet("/CommissionMemberYearLoader")
public class CommissionMemberYearLoader extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommissionMemberYearLoader() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setContentType("application/json");
		JSONArray jArray = new JSONArray();
		int year = Integer.parseInt((String) request.getParameter("year"));
		int positionID = Integer.parseInt((String) request.getParameter("positionID"));
		int level = Integer.parseInt((String) request.getParameter("educLevel"));
		
		CommissionMembersUtil cmUtil = new CommissionMembersUtil();
		jArray = cmUtil.checkCommissionMembersInYear(level, year, positionID);
		
		response.getWriter().write(jArray.toString());	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

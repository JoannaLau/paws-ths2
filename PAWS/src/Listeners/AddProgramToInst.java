package Listeners;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Utilities.InstitutionsUtil;
import Utilities.SchoolSystemUtil;

/**
 * Servlet implementation class AddProgramToInst
 */
@WebServlet("/AddProgramToInst")
public class AddProgramToInst extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProgramToInst() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String specific = request.getParameter("degreeName");
		int programID = Integer.parseInt((String)request.getParameter("programID"));
		int instID = Integer.parseInt((String)request.getParameter("instID"));
		int educLevelID = Integer.parseInt((String)request.getParameter("educLevelID"));
		
		InstitutionsUtil instUtil = new InstitutionsUtil();
		instUtil.addProgramToInst(specific, programID, instID, "NA", educLevelID);	
	
		
		RequestDispatcher rd = request.getRequestDispatcher("ViewInstitution?institutionID="+instID);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}

}

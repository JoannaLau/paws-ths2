package Listeners;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.Accreditor;
import Models.SchoolProgram;
import Utilities.AccreditorUtil;
import Utilities.InstitutionsUtil;

/**
 * Servlet implementation class ViewAccreditorForLevelSurvey
 */
@WebServlet("/ViewAccreditorForLevelSurvey")
public class ViewAccreditorForLevelSurvey extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAccreditorForLevelSurvey() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int year = Integer.parseInt(request.getParameter("year"));
		int educLevelID = Integer.parseInt(request.getParameter("educLevelID"));
		
		if(educLevelID == 0)
			request.setAttribute("level", "All");
		if(educLevelID == 1)
			request.setAttribute("level", "Grade School");
		if(educLevelID == 2)
			request.setAttribute("level", "High School");
		if(educLevelID == 3)
			request.setAttribute("level", "Basic Education");
		if(educLevelID == 4)
			request.setAttribute("level", "Tertiary Level");
		if(educLevelID == 5)
			request.setAttribute("level", "Graduate Level");
		if(educLevelID == 6)
			request.setAttribute("level", "Medical Level");
		if(educLevelID == 7)
			request.setAttribute("level", "CECSTE Level");
		
		
		
		AccreditorUtil accUtil = new AccreditorUtil();
		ArrayList<Accreditor> accList = accUtil.getAccreditorsInSurveyFromYear(year, educLevelID);
		request.setAttribute("accList", accList);
		request.setAttribute("year", year);
		RequestDispatcher rd = request.getRequestDispatcher("accreditorSurveysYear.jsp");
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

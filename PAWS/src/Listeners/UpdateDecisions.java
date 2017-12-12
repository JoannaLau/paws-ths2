package Listeners;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import Utilities.InstitutionsUtil;

/**
 * Servlet implementation class UpdateDecisions
 */
@WebServlet("/UpdateDecisions")
public class UpdateDecisions extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateDecisions() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int PSID = Integer.parseInt(request.getParameter("PSID"));
		int surveyID = Integer.parseInt(request.getParameter("surveyID"));
		
		InstitutionsUtil instUtil = new InstitutionsUtil();
		request.setAttribute("title", instUtil.getInstitutionAndDegreeProgram(PSID));
		String surveyType = instUtil.getSurveyType(PSID);
		
		System.out.print("---------------------------" + surveyType);
		request.setAttribute("surveyID", surveyID);
		request.setAttribute("PSID", PSID);
		
		
		if(surveyType.equals("Preliminary"))
		{
			request.setAttribute("surveyType", "Preliminary Survey");
			
			System.out.print("INSIDE PRELIMINARY");
			RequestDispatcher rd = request.getRequestDispatcher("updateDecisionsPreliminary.jsp");
			rd.forward(request, response);
			
		}
		
		else if(surveyType.equals("Formal"))
		{
			request.setAttribute("surveyType", "Formal Survey");
			
			System.out.print("INSIDE FORMAL");
			RequestDispatcher rd = request.getRequestDispatcher("updateDecisionsFormal.jsp");
			rd.forward(request, response);
			
		}

		else if(surveyType.equals("Interim"))
		{
			request.setAttribute("surveyType", "Interim Survey");
			
			System.out.print("INSIDE INTERIM");
			RequestDispatcher rd = request.getRequestDispatcher("updateDecisionsInterim.jsp");
			rd.forward(request, response);
		}

		else if(surveyType.equals("Consultancy"))
		{
			request.setAttribute("surveyType", "Consultancy Survey");
			
			System.out.print("INSIDE CONSULTANCY");
			RequestDispatcher rd = request.getRequestDispatcher("updateDecisionsConsultancy.jsp");
			rd.forward(request, response);
		}
		else if(surveyType.equals("Resurvey"))
		{
			request.setAttribute("surveyType", "Resurvey");
			
			System.out.print("INSIDE Resurvey");
			RequestDispatcher rd = request.getRequestDispatcher("updateDecisionsResurvey.jsp");
			rd.forward(request, response);
		}
		
		else if(surveyType.equals("Revisit"))
		{
			request.setAttribute("surveyType", "Revisit");
			
			System.out.print("INSIDE REVISIT");
			RequestDispatcher rd = request.getRequestDispatcher("updateDecisionsRevisit.jsp");
			rd.forward(request, response);
		}
		
		
		
		
		
/*		InstitutionsUtil instUtil = new InstitutionsUtil();
		JSONArray jArray = new JSONArray();

		jArray = instUtil.getExistingDecisionJSON(PSID);
		
		request.setAttribute("surveyID", surveyID);
		response.getWriter().write(jArray.toString());	
*/		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package Listeners;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Utilities.InstitutionsUtil;

/**
 * Servlet implementation class UpdateSurveyDecision
 */
@WebServlet("/UpdateSurveyDecision")
public class UpdateSurveyDecision extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateSurveyDecision() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String boardChoice = request.getParameter("boardChoice");
		String commChoice = request.getParameter("commChoice");
		String teamChoice = request.getParameter("teamChoice");
		String text = request.getParameter("text");
		
		int surveyID = Integer.parseInt(request.getParameter("surveyID"));
		
		int PSID = Integer.parseInt(request.getParameter("PSID"));
		
		System.out.println("--------------------------" + commChoice);
		
		InstitutionsUtil instUtil = new InstitutionsUtil();
		
		instUtil.updateDecision(PSID, boardChoice, commChoice, teamChoice, text);
		
		RequestDispatcher rd = request.getRequestDispatcher("ConfirmationPage?surveyID=" + surveyID);
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

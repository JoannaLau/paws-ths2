package Listeners;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.Infographic;
import Models.ProgramInfographic;
import Models.SurveyInfographic;
import Utilities.InfographicsUtil;

/**
 * Servlet implementation class AccreditorInfographics
 */
@WebServlet("/AccreditorInfographics")
public class AccreditorInfographics extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccreditorInfographics() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		
		InfographicsUtil ins = new InfographicsUtil();
		
		

		int endYear = 0;
		int startYear = 0;

		
		

		
		System.out.println(request.getParameter("yearStartSelect"));
		
		
		if(request.getParameter("yearStartSelect")!=null) {
		startYear = Integer.parseInt(request.getParameter("yearStartSelect"));
		endYear=  Integer.parseInt(request.getParameter("yearEndSelect"));
		}
		
		else {
			endYear = Calendar.getInstance().get(Calendar.YEAR);
			startYear = endYear-5;
		}
	
		ArrayList<SurveyInfographic> surList = new ArrayList<SurveyInfographic>();
	
		
		
		int n;
		
		for(n=startYear; n<=endYear; n++){
			
			SurveyInfographic sur = new SurveyInfographic(n, ins.getTypeofSurveyCount("Preliminary", n),ins.getTypeofSurveyCount("Formal", n), ins.getTypeofSurveyCount("Resurvey", n),ins.getTypeofSurveyCount("Interim/Consultancy", n));
			
			surList.add(sur);
			
		}
		
		
ArrayList<Infographic> infList = new ArrayList<Infographic>();
	
		
		
		 n=0;
		
		for(n=startYear; n<=endYear; n++){
			
			Infographic inf = new Infographic(n, ins.getAccreditorVisitCount(1, n),ins.getAccreditorVisitCount(2, n),ins.getAccreditorVisitCount(3, n),ins.getAccreditorVisitCount(4, n), ins.getAccreditorVisitCount(5, n),ins.getAccreditorVisitCount(5, n),ins.getAccreditorVisitCount(7, n));
			
			infList.add(inf);
			
		}
		
		
		request.setAttribute("SurveyCountList", infList);
		request.setAttribute("TypeCountList", surList);
		RequestDispatcher rd = request.getRequestDispatcher("accreditorInfographics.jsp");
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

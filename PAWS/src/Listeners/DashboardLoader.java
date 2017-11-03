package Listeners;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import Utilities.SurveyUtil;

/**
 * Servlet implementation class DashboardLoader
 */
@WebServlet("/DashboardLoader")
public class DashboardLoader extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DashboardLoader() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String day1 = request.getParameter("day1");
		String day2 = request.getParameter("day2");
		String day3 = request.getParameter("day3");
		String day4 = request.getParameter("day4");
		String day5 = request.getParameter("day5");
		String day6 = request.getParameter("day6");
		String today = request.getParameter("today");
		
		SurveyUtil sUtil = new SurveyUtil();
		response.setContentType("application/json");
		JSONArray jArray = new JSONArray();
		jArray = sUtil.getDashboardSurveyDetails(day1, day2, day3, day4, day5, day6, today);
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

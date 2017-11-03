package Listeners;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SurveyLoaderDate
 */
@WebServlet("/SurveyLoaderDate")
public class SurveyLoaderDate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SurveyLoaderDate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String month = request.getParameter("month");
		String year = request.getParameter("year");
		if(month.equalsIgnoreCase("January")){
			month = "01";
		}else if(month.equalsIgnoreCase("February")){
			month = "02";
		}else if(month.equalsIgnoreCase("March")){
			month = "03";
		}else if(month.equalsIgnoreCase("April")){
			month = "04";
		}else if(month.equalsIgnoreCase("May")){
			month = "05";
		}else if(month.equalsIgnoreCase("June")){
			month = "06";
		}else if(month.equalsIgnoreCase("July")){
			month = "07";
		}else if(month.equalsIgnoreCase("August")){
			month = "08";
		}else if(month.equalsIgnoreCase("September")){
			month = "09";
		}else if(month.equalsIgnoreCase("October")){
			month = "10";
		}else if(month.equalsIgnoreCase("November")){
			month = "11";
		}else if(month.equalsIgnoreCase("December")){
			month = "12";
		}
		request.setAttribute("month", month);
		request.setAttribute("year", year);
		RequestDispatcher rd = request.getRequestDispatcher("survey.jsp");
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

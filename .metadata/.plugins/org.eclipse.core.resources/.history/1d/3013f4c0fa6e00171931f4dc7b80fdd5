package Listeners;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.News;
import Models.SchoolProgram;
import Utilities.NewsUtil;
import Utilities.ProgramUtil;

/**
 * Servlet implementation class DisplayNews
 */
@WebServlet("/DisplayNews")
public class DisplayNews extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayNews() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		NewsUtil nUtil = new NewsUtil();
		int newsID = Integer.parseInt(request.getParameter("newsID"));
		News news = nUtil.getNews(newsID);
		request.setAttribute("news", news);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("news.jsp");
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

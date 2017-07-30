package Listeners;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.News;
import Models.SchoolSystem;
import Utilities.NewsUtil;
import Utilities.SchoolSystemUtil;

/**
 * Servlet implementation class EditNews
 */
@WebServlet("/EditNews")
public class EditNews extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditNews() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int newsID = Integer.parseInt((String)request.getParameter("newsID"));
		
		NewsUtil newsUtil = new NewsUtil();
		News news = newsUtil.getNews(newsID);
		
		request.setAttribute("News", news);
		RequestDispatcher rd = request.getRequestDispatcher("editNews.jsp");
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

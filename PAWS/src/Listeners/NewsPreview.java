package Listeners;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Utilities.NewsUtil;

/**
 * Servlet implementation class NewsPreview
 */
@WebServlet("/NewsPreview")
public class NewsPreview extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewsPreview() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String image = request.getParameter("filename");
		

	     Date dNow = new Date( );
		SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
		String date = ft.format(dNow);
		
		request.setAttribute("title", title);
		request.setAttribute("content", content);
		request.setAttribute("image", image);
		request.setAttribute("date", date);
		

		RequestDispatcher rd = request.getRequestDispatcher("newsPreview.jsp");
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

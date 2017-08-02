package Listeners;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.News;
import Utilities.NewsUtil;
import Utilities.SFTPDemo;

/**
 * Servlet implementation class UpdateNews
 */
@WebServlet("/UpdateNews")
public class UpdateNews extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateNews() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int newsID = Integer.parseInt((String)request.getParameter("newsID"));
		
		String content = request.getParameter("content");
		String title = request.getParameter("title");
		String image = request.getParameter("image");
		NewsUtil newsUtil = new NewsUtil();
		

		if(image=="") {
		SFTPDemo sftp = new SFTPDemo(image);
		
		File f= new File(image); 
		
		String file = f.getName();
		

		}
		
		newsUtil.updateNewsNoImage(newsID, title, content);
		
		ArrayList<News> news = newsUtil.getAllNews();
		request.setAttribute("news", news);
		RequestDispatcher rd = request.getRequestDispatcher("viewNews.jsp");
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

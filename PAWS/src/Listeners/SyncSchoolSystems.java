package Listeners;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.SchoolSystem;
import Utilities.InstitutionsWebUtil;
import Utilities.SchoolSystemUtil;

/**
 * Servlet implementation class SyncSchoolSystems
 */
@WebServlet("/SyncSchoolSystems")
public class SyncSchoolSystems extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SyncSchoolSystems() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SchoolSystemUtil ssUtil = new SchoolSystemUtil();
		InstitutionsWebUtil instWebUtil = new InstitutionsWebUtil();
		
		if(instWebUtil.getDB()!=null)
		{
			request.setAttribute("connection", true);
			ArrayList<SchoolSystem> ssList = ssUtil.getSchoolSystemsChanges();
			
			if(instWebUtil.getDB()!=null && ssList.size() > 0)
			{
				if(instWebUtil.getDB()!=null && instWebUtil.updateSchoolSystems(ssList)!=0)
				{
					if(ssUtil.deleteSchoolSystemsChanges(ssList) == ssList.size())
					{
						request.setAttribute("deleted", true);
					}
				}
				else
				{
					request.setAttribute("deleted", false);
					request.setAttribute("connection", false);
				}
			}
			else
			{
				request.setAttribute("deleted", false);
				request.setAttribute("connection", false);
			}
			
		}
		else
		{
			request.setAttribute("deleted", false);
			request.setAttribute("connection", false);
		}
		
		
		ArrayList<SchoolSystem> ssList = ssUtil.getSchoolSystemsChanges();
		request.setAttribute("schoolSystems", ssList);
		RequestDispatcher rd = request.getRequestDispatcher("webSchoolSystems.jsp");
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

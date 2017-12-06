package Listeners;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.BoardMember;
import Models.Institution;
import Models.SchoolProgram;
import Utilities.BoardMembersLocalUtil;
import Utilities.BoardMembersUtil;
import Utilities.InstitutionsUtil;
import Utilities.InstitutionsWebUtil;

/**
 * Servlet implementation class SyncInstitutions
 */
@WebServlet("/SyncInstitutions")
public class SyncInstitutions extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SyncInstitutions() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		InstitutionsUtil instUtil = new InstitutionsUtil();
		InstitutionsWebUtil instWebUtil = new InstitutionsWebUtil();
		ArrayList<Institution> inst = new ArrayList<Institution>();
		
		if(instWebUtil.getDB()!=null)
		{
			request.setAttribute("connection", true);
			ArrayList<Institution> instList = instUtil.getInstitutionsChanges();
			
			ArrayList<SchoolProgram> spList = instUtil.getSchoolProgramChanges();
			
			if(instWebUtil.getDB()!=null && spList.size() > 0)
			{
				instWebUtil.updateSchoolPrograms(spList);
			}
			
			int rows = instWebUtil.updateInstitutions(instList);
			
			if(instWebUtil.getDB()!=null && rows > 0)
			{
				if(instUtil.deleteInstitutionsChanges(instList) == instList.size())
					request.setAttribute("deleted", true);
			}
			else
				request.setAttribute("deleted", false);
		}
		else
		{
			request.setAttribute("deleted", false);
			request.setAttribute("connection", false);
		}
		inst = instUtil.getInstitutionsChanges();
		request.setAttribute("institutions", inst);
		RequestDispatcher rd = request.getRequestDispatcher("webInstitutions.jsp");
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

package Listeners;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.Accreditation;
import Models.Accreditor;
import Models.BoardMember;
import Utilities.AccreditorUtil;
import Utilities.BoardMembersLocalUtil;
import Utilities.BoardMembersUtil;

/**
 * Servlet implementation class ViewBoardMembers
 */
@WebServlet("/ViewBoardMembers")
public class ViewBoardMembers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewBoardMembers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		BoardMembersUtil bmUtil = new BoardMembersUtil();
		int bmID = Integer.parseInt(request.getParameter("bmID"));
		
		if(bmUtil.getDB()!=null)
		{
			BoardMember bm = bmUtil.getBoardMember(bmID);
			request.setAttribute("boardMember", bm);
			request.setAttribute("connection", true);
			
			RequestDispatcher rd = request.getRequestDispatcher("boardMembersProfile.jsp");
			rd.forward(request, response);
			
			
		}
		else
		{
			BoardMembersLocalUtil bmlUtil = new BoardMembersLocalUtil();
			BoardMember bm = bmlUtil.getBoardMember(bmID);
			request.setAttribute("boardMember", bm);
			request.setAttribute("connection", false);
			
			RequestDispatcher rd = request.getRequestDispatcher("boardMembersProfile.jsp");
			rd.forward(request, response);
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

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
import Utilities.BoardMembersLocalUtil;
import Utilities.BoardMembersUtil;

/**
 * Servlet implementation class UnsyncedBoardMembers
 */
@WebServlet("/UnsyncedBoardMembers")
public class UnsyncedBoardMembers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UnsyncedBoardMembers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BoardMembersLocalUtil bmlUtil = new BoardMembersLocalUtil();
		BoardMembersUtil bmUtil = new BoardMembersUtil();
		ArrayList<BoardMember> bm = new ArrayList<BoardMember>();
		
		if(bmUtil.getDB()!=null)
			request.setAttribute("connection", true);
		else
			request.setAttribute("connection", false);
		
		bm = bmlUtil.getUnsyncedBoardMembers();
		request.setAttribute("boardMembers", bm);
		RequestDispatcher rd = request.getRequestDispatcher("unsyncedBoardMembers.jsp");
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

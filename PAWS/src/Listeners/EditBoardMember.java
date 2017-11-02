package Listeners;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.Accreditor;
import Models.BoardMember;
import Utilities.AccreditorUtil;
import Utilities.BoardMembersUtil;

/**
 * Servlet implementation class EditBoardMember
 */
@WebServlet("/EditBoardMember")
public class EditBoardMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditBoardMember() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int bmID = Integer.parseInt(request.getParameter("bmID"));
		BoardMembersUtil bmUtil = new BoardMembersUtil();
		BoardMember bm = new BoardMember();
		
		bm = bmUtil.getBoardMember(bmID);
		request.setAttribute("bmID", bmID);
		request.setAttribute("bpID", bm.getBoardPositionID());
		request.setAttribute("boardMember", bm);
		
		RequestDispatcher rd = request.getRequestDispatcher("editBoardMember.jsp");
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

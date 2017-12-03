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
import Utilities.BoardMembersLocalUtil;
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
		
		if(bmUtil.getDB()!=null)
		{
			BoardMember bm = new BoardMember();
			
			bm = bmUtil.getBoardMember(bmID);
			request.setAttribute("bmID", bmID);
			request.setAttribute("bpID", bm.getBoardPositionID());
			request.setAttribute("boardMember", bm);

			request.setAttribute("connection", true);
			
			RequestDispatcher rd = request.getRequestDispatcher("editBoardMember.jsp");
			rd.forward(request, response);
		}
		else
		{
			BoardMembersLocalUtil bmlUtil = new BoardMembersLocalUtil();
			BoardMember bm = new BoardMember();
			
			bm = bmlUtil.getBoardMember(bmID);
			request.setAttribute("bmID", bmID);
			request.setAttribute("bpID", bm.getBoardPositionID());
			request.setAttribute("boardMember", bm);
			request.setAttribute("connection", false);
			
			RequestDispatcher rd = request.getRequestDispatcher("editBoardMember.jsp");
			rd.forward(request, response);
		}
			
		
//<h6 style="padding-top: 10px;"><i class="fa fa-exclamation-triangle" style="color:red; font-size: 20px;"> Warning: </i>&nbsp;Unable to retrieve data from the website. Any changes made here will update the local database. You can sync these changes when internet connection becomes available.</h6>
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

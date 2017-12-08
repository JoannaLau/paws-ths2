package Listeners;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import Models.Program;
import Utilities.InstitutionsUtil;
import Utilities.ProgramUtil;

/**
 * Servlet implementation class AddProgramToInstitution
 */
@WebServlet("/AddProgramToInstitution")
public class AddProgramToInstitution extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProgramToInstitution() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int ID = Integer.parseInt(request.getParameter("ID"));
		String name = request.getParameter("name");
		
		InstitutionsUtil instUtil = new InstitutionsUtil();
		request.setAttribute("ID", ID);
		request.setAttribute("name", name);
		
		RequestDispatcher rd = request.getRequestDispatcher("addProgramToInst.jsp");
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

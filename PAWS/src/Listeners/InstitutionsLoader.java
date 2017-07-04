package Listeners;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;

import Models.Institution;
import Utilities.InstitutionsUtil;
import Utilities.SchoolSystemUtil;

/**
 * Servlet implementation class InstitutionsLoader
 */
@WebServlet("/InstitutionsLoader")
public class InstitutionsLoader extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InstitutionsLoader() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/json");
		JSONArray jArray = new JSONArray();

		InstitutionsUtil insUtil = new InstitutionsUtil();
	
		
		int systemID = Integer.parseInt(request.getParameter("systemID"));
		
		jArray = insUtil.getInstitutionsJSON(systemID);
		
		response.getWriter().write(jArray.toString());	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}

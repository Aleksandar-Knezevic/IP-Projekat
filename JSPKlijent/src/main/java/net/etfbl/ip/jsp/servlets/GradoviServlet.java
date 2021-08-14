package net.etfbl.ip.jsp.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import net.etfbl.ip.jsp.dao.GradDAO;

/**
 * Servlet implementation class GradoviServlet
 */
@WebServlet("/GradoviServlet")
public class GradoviServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public GradoviServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
			Gson gson = new Gson();
			int drzavaId = Integer.parseInt(request.getParameter("drzava_id"));
			response.getWriter().print(gson.toJson(GradDAO.selectByState(drzavaId)));
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

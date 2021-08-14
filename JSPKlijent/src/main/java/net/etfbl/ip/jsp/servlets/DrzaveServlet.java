package net.etfbl.ip.jsp.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import net.etfbl.ip.jsp.dao.DrzavaDAO;


@WebServlet("/DrzaveServlet")
public class DrzaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public DrzaveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
			Gson gson = new Gson();
			response.getWriter().print(gson.toJson(DrzavaDAO.selectAll()));
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

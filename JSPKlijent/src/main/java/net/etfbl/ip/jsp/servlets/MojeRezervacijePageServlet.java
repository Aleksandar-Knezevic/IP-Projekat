package net.etfbl.ip.jsp.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/MojeRezervacijePageServlet")
public class MojeRezervacijePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MojeRezervacijePageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("user")!=null)
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/pages/moje-rezervacije.jsp");
			dispatcher.forward(request, response);
		}
		else
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/pages/login.jsp");
			dispatcher.forward(request, response);
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

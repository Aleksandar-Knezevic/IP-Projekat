package net.etfbl.ip.jsp.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.etfbl.ip.jsp.cron.PutnickiUpdaterThread;
import net.etfbl.ip.jsp.cron.TeretniUpdaterThread;
import net.etfbl.ip.jsp.dao.KorisnikDAO;

/**
 * Servlet implementation class WelcomeServlet
 */
@WebServlet("/WelcomeServlet")
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private boolean started = false;

    public WelcomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try
		{
			KorisnikDAO.evidentirajPristup();
			if(!started)
			{
				new PutnickiUpdaterThread().start();
				new TeretniUpdaterThread().start();
				started=true;
			}
		}
		catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pages/index.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

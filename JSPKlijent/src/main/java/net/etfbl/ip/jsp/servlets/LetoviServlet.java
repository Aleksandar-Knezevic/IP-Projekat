package net.etfbl.ip.jsp.servlets;

import java.io.IOException;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import net.etfbl.ip.jsp.dao.PutnickiLetDAO;

/**
 * Servlet implementation class DolasciServlet
 */
@WebServlet("/LetoviServlet")
public class LetoviServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LetoviServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
			Gson gson = new Gson();
			String type = request.getParameter("type");
			String dateString = request.getParameter("date");
			if(type.equals("odlasci"))
				response.getWriter().
						print(gson.toJson(PutnickiLetDAO.selectAll().
						stream().
						filter(e -> e.getPolazniGrad().getNazivGrada().equals("Banja Luka")).
						filter(e -> e.getDatumLeta().toString().equals(dateString)).
						sorted((a,b) -> {return a.getVrijemePolaska().compareTo(b.getVrijemePolaska());}).
						limit(5).
						collect(Collectors.toList())));
			else if(type.equals("dolasci"))
				response.getWriter().
				print(gson.toJson(PutnickiLetDAO.selectAll().
						stream().
						filter(e -> e.getOdredisniGrad().getNazivGrada().equals("Banja Luka")).
						filter(e -> e.getDatumLeta().toString().equals(dateString)).
						sorted((a,b) -> {return a.getVrijemeDolaska().compareTo(b.getVrijemeDolaska());}).
						limit(5).
						collect(Collectors.toList())));

		} catch (Exception e) {
			// TODO: handle exception
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

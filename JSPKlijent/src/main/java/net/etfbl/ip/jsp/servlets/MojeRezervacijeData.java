package net.etfbl.ip.jsp.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import net.etfbl.ip.jsp.dao.RezervacijaPutnickogLetaDAO;
import net.etfbl.ip.jsp.dao.RezervacijaTeretnogLetaDAO;
import net.etfbl.ip.jsp.dto.KorisnikDTO;


@WebServlet("/MojeRezervacijeData")
public class MojeRezervacijeData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public MojeRezervacijeData() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		KorisnikDTO korisnik = (KorisnikDTO) request.getSession().getAttribute("user");
		Gson gson = new Gson();
		try
		{
			if(korisnik.getTipNaloga().equals("Putnicki"))
				response.getWriter().print(gson.toJson(RezervacijaPutnickogLetaDAO.selectUsersFlights(korisnik.getId())));
			else
				response.getWriter().print(gson.toJson(RezervacijaTeretnogLetaDAO.selectUsersFlights(korisnik.getId())));
		
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

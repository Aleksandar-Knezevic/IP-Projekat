package net.etfbl.ip.jsp.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.etfbl.ip.jsp.dao.PutnickiLetDAO;
import net.etfbl.ip.jsp.dao.RezervacijaPutnickogLetaDAO;
import net.etfbl.ip.jsp.dao.RezervacijaTeretnogLetaDAO;
import net.etfbl.ip.jsp.dao.TeretniLetDAO;
import net.etfbl.ip.jsp.dto.KorisnikDTO;
import net.etfbl.ip.jsp.dto.RezervacijaPutnickogLetaDTO;
import net.etfbl.ip.jsp.dto.RezervacijaTeretnogLetaDTO;


@WebServlet("/OtkaziRezervacijuServlet")
public class OtkaziRezervacijuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public OtkaziRezervacijuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		try
		{
			KorisnikDTO korisnik = (KorisnikDTO) request.getSession().getAttribute("user");
			if(korisnik.getTipNaloga().equals("Putnicki"))
			{
				RezervacijaPutnickogLetaDTO rezervacija = RezervacijaPutnickogLetaDAO.selecetOne(korisnik.getId(), id);
				PutnickiLetDAO.azurirajSlobodnaMjesta(rezervacija.getPutnickiLet().getBrojSlobodnihMjesta()+rezervacija.getBrojMjesta(), id);
				RezervacijaPutnickogLetaDAO.obrisi(korisnik.getId(), id);
				
			}
			else
			{
				RezervacijaTeretnogLetaDTO rezervacija = RezervacijaTeretnogLetaDAO.selecetOne(korisnik.getId(), id);
				TeretniLetDAO.dodajOpisTereta(null, id);
				RezervacijaTeretnogLetaDAO.obrisi(korisnik.getId(), id);
			}
		}
		catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		
		response.getWriter().write("OK");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package net.etfbl.ip.jsp.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.etfbl.ip.jsp.dao.KorisnikDAO;
import net.etfbl.ip.jsp.dto.KorisnikDTO;


@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("user")!=null)
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/pages/index.jsp");
			dispatcher.forward(request, response);
		}
		else
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/pages/register.jsp");
			dispatcher.forward(request, response);
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ime = request.getParameter("ime");
		String prezime = request.getParameter("prezime");
		String korisnickoIme = request.getParameter("korisnickoIme");
		String adresa = request.getParameter("adresa");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");
		String drzava = request.getParameter("drzava");
		String nalog = request.getParameter("nalog");
		if(ime==null ||
		   prezime==null ||
		   korisnickoIme==null ||
		   adresa==null ||
		   email==null ||
		   password==null ||
		   confirmPassword==null ||
		   drzava==null ||
		   nalog==null)
		{
		try {
		if(KorisnikDAO.checkUnique(korisnickoIme, email))
		{
			int a = KorisnikDAO.insert(ime, prezime, korisnickoIme, email, password,drzava,nalog,adresa);
			KorisnikDTO korisnik = KorisnikDAO.selectOne(a);
			request.getSession().setAttribute("errorMsg", "");
		}
		else
		{
			request.getSession().setAttribute("errorMsg", "Korisnicko ime ili email je u upotrebi");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pages/register.jsp");
			dispatcher.forward(request, response);
			return;
		}


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pages/index.jsp");
		dispatcher.forward(request, response);
	}

}

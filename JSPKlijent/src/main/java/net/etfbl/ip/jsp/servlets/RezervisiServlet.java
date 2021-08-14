package net.etfbl.ip.jsp.servlets;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import net.etfbl.ip.jsp.dao.PutnickiLetDAO;
import net.etfbl.ip.jsp.dao.RezervacijaPutnickogLetaDAO;
import net.etfbl.ip.jsp.dao.RezervacijaTeretnogLetaDAO;
import net.etfbl.ip.jsp.dao.TeretniLetDAO;
import net.etfbl.ip.jsp.dto.KorisnikDTO;
import net.etfbl.ip.jsp.dto.PutnickiLetDTO;


@WebServlet("/RezervisiServlet")
@MultipartConfig
public class RezervisiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public RezervisiServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		KorisnikDTO korisnik = (KorisnikDTO)request.getSession().getAttribute("user");
		int id = Integer.parseInt(request.getParameter("reservationId"));
		if(korisnik.getTipNaloga().equals("Putnicki"))
		{
			
			int brojMjesta = Integer.parseInt(request.getParameter("brojMjesta"));
			System.out.println(brojMjesta);
			try
			{
				RezervacijaPutnickogLetaDAO.insert(korisnik.getId(), id, brojMjesta);
				PutnickiLetDTO let = PutnickiLetDAO.selectOne(id);
				PutnickiLetDAO.azurirajSlobodnaMjesta(let.getBrojMjesta()-brojMjesta, id);
			}
			 catch (Exception e) {
				e.printStackTrace();
			 }
			
		}
		else
		{
			String opis = request.getParameter("opisTereta");
			Part filePart = request.getPart("specifikacijaRobe");
			String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
			Path path = Paths.get(getServletContext().getResource("WEB-INF").getPath().substring(1));
			String rootPath = path.toString();
			File file = new File("specifikacije"+File.separator+fileName);
			InputStream fileContent = filePart.getInputStream();
			byte[] data = fileContent.readAllBytes();
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(data);
			try
			{
				RezervacijaTeretnogLetaDAO.insert(korisnik.getId(), id);
				TeretniLetDAO.dodajOpisTereta(opis, id);
			}
			catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/pages/rezervacija.jsp");
		dispatcher.forward(request, response);
	}

}

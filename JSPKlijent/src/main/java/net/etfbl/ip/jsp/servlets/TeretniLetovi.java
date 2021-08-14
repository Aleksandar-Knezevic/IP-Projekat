package net.etfbl.ip.jsp.servlets;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import net.etfbl.ip.jsp.dao.TeretniLetDAO;
import net.etfbl.ip.jsp.dto.TeretniLetDTO;


@WebServlet("/TeretniLetovi")
public class TeretniLetovi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public TeretniLetovi() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Gson gson = new Gson();
		String date = request.getParameter("date");
		String type = request.getParameter("type");
		String source = request.getParameter("source");
		String destination = request.getParameter("destination");
		try
		{
		List<TeretniLetDTO> sviLetovi = TeretniLetDAO.selectAll();
		if(date!=null)
			sviLetovi = sviLetovi.stream().filter(e -> e.getDatumLeta().toString().equals(date)).collect(Collectors.toList());
		if(type!=null && type.equals("odlasci"))
		{
			sviLetovi = sviLetovi.stream().filter(e -> e.getPolazniGrad().getNazivGrada().equals("Banja Luka")).collect(Collectors.toList());
			if(destination!=null)
				sviLetovi = sviLetovi.stream().filter(e -> e.getOdredisniGrad().getNazivGrada().equals(destination)).collect(Collectors.toList());
		}
		else if(type!=null && type.equals("dolasci"))
		{
			sviLetovi = sviLetovi.stream().filter(e -> e.getOdredisniGrad().getNazivGrada().equals("Banja Luka")).collect(Collectors.toList());
			if(source!=null)
				sviLetovi = sviLetovi.stream().filter(e -> e.getPolazniGrad().getNazivGrada().equals(source)).collect(Collectors.toList());
		}
		response.getWriter().print(gson.toJson(sviLetovi));
		
		}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

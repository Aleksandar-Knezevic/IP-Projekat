package net.etfbl.ip.jsp.servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.etfbl.ip.jsp.dao.PutnickiLetDAO;
import net.etfbl.ip.jsp.dao.TeretniLetDAO;
import net.etfbl.ip.jsp.dto.PutnickiLetDTO;
import net.etfbl.ip.jsp.dto.TeretniLetDTO;

/**
 * Servlet implementation class DanasnjiLetoviRSS
 */
@WebServlet("/DanasnjiLetoviRSS")
public class DanasnjiLetoviRSS extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DanasnjiLetoviRSS() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
			String today = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
			
			List<PutnickiLetDTO> danasnjiPutnickiLetovi = 
					PutnickiLetDAO
					.selectAll()
					.stream()
					.filter(e -> e.getDatumLeta().toString().equals(today))
					.collect(Collectors.toList());
			List<TeretniLetDTO> danasnjiTeretniLetovi = 
					TeretniLetDAO
					.selectAll()
					.stream()
					.filter(e -> e.getDatumLeta().toString().equals(today))
					.collect(Collectors.toList());
		}
		catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
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

package net.etfbl.ip.jsp.servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rometools.rome.feed.synd.SyndContent;
import com.rometools.rome.feed.synd.SyndContentImpl;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndEntryImpl;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.feed.synd.SyndFeedImpl;
import com.rometools.rome.io.SyndFeedOutput;

import net.etfbl.ip.jsp.dao.PutnickiLetDAO;
import net.etfbl.ip.jsp.dao.TeretniLetDAO;
import net.etfbl.ip.jsp.dto.PutnickiLetDTO;
import net.etfbl.ip.jsp.dto.TeretniLetDTO;

@WebServlet("/DanasnjiLetoviRSS")
public class DanasnjiLetoviRSS extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public DanasnjiLetoviRSS() {
        super();
        // TODO Auto-generated constructor stub
    }

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
			SyndFeed feed = new SyndFeedImpl();
			feed.setFeedType("rss_2.0");
			feed.setTitle("ETFBL-Aero");
			feed.setDescription("Danasnji letovi");
			feed.setLink("http://localhost:8080/JSPKlijent");
			List<SyndEntry> entries = new ArrayList<>();
			for(PutnickiLetDTO let : danasnjiPutnickiLetovi)
			{
				SyndEntry item = new SyndEntryImpl();
				SyndContent content = new SyndContentImpl();
				content.setValue(let.toString());
				item.setDescription(content);
				entries.add(item);
			}
			for(TeretniLetDTO let : danasnjiTeretniLetovi)
			{
				SyndEntry item = new SyndEntryImpl();
				SyndContent content = new SyndContentImpl();
				content.setValue(let.toString());
				item.setDescription(content);
				entries.add(item);
			}
			feed.setEntries(entries);
			response.getWriter().println(new SyndFeedOutput().outputString(feed));
		}
		catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

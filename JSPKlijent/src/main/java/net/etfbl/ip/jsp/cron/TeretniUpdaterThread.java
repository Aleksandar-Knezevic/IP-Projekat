package net.etfbl.ip.jsp.cron;

import java.util.Date;

import net.etfbl.ip.jsp.dao.TeretniLetDAO;
import net.etfbl.ip.jsp.dto.TeretniLetDTO;

public class TeretniUpdaterThread extends Thread {

	@SuppressWarnings("deprecation")
	@Override
	public void run()
	{
		try
		{
			Date danas = new Date();
			for(TeretniLetDTO l : TeretniLetDAO.selectAll())
			{
				Date datumPolaska = new Date(l.getDatumLeta().getYear(),
									 l.getDatumLeta().getMonth(),
									 l.getDatumLeta().getDate(),
									 l.getVrijemePolaska().getHours(),
									 l.getVrijemePolaska().getMinutes(),
									 l.getVrijemePolaska().getSeconds());
				Date datumDolaska = new Date(l.getDatumLeta().getYear(),
						 					 l.getDatumLeta().getMonth(),
						 					 l.getDatumLeta().getDate(),
						 					 l.getVrijemeDolaska().getHours(),
						 					 l.getVrijemeDolaska().getMinutes(),
						 					 l.getVrijemeDolaska().getSeconds());
				if(danas.after(datumDolaska))
				{
					//postavio kao sletio
					TeretniLetDAO.postaviStatus("Sletio", l.getId());
				}
	
				else if(danas.after(datumPolaska) && danas.before(datumDolaska))
				{
					//postavi kao poletio
					TeretniLetDAO.postaviStatus("Poletio", l.getId());
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
	}

}

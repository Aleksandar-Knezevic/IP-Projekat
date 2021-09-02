package net.etfbl.ip.jsp.cron;

import java.util.Date;

import net.etfbl.ip.jsp.dao.PutnickiLetDAO;
import net.etfbl.ip.jsp.dto.PutnickiLetDTO;

public class PutnickiUpdaterThread extends Thread {



	@SuppressWarnings("deprecation")
	@Override
	public void run()
	{
		try
		{
			Date danas = new Date();
			for(PutnickiLetDTO l : PutnickiLetDAO.selectAll())
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
					PutnickiLetDAO.postaviStatus("Sletio", l.getId());
				}
	
				else if(danas.after(datumPolaska) && danas.before(datumDolaska))
				{
					//postavi kao poletio
					PutnickiLetDAO.postaviStatus("Poletio", l.getId());
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
	}

}

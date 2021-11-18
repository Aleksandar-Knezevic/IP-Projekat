package net.etfbl.ip.jsp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import net.etfbl.ip.jsp.dto.PutnickiLetDTO;

public class PutnickiLetDAO {

	private static final String SELECT_ALL = "SELECT * FROM putnickilet";
	private static final String SELECT_ONE = "SELECT * FROM putnickilet WHERE id=?";
	private static final String UPDATE_AVAILABLE_SEATS = "UPDATE putnickilet SET brojSlobodnihMjesta=? where id=?";
	private static final String UPDATE_STATUS = "UPDATE putnickilet SET status=? WHERE id=?";
	
	private static Connection getConnection() throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?serverTimezone=UTC&useSSL=false", "", "");
	}
	
	public static ArrayList<PutnickiLetDTO> selectAll() throws Exception
	{
		ArrayList<PutnickiLetDTO> sviLetovi = new ArrayList();
		Connection c = getConnection();
		Statement s = c.createStatement();
		ResultSet rs = s.executeQuery(SELECT_ALL);
		while(rs.next())
		{
			PutnickiLetDTO putnickiLet = new PutnickiLetDTO(rs.getInt("id"), rs.getDate("datumLeta"), rs.getInt("brojMjesta"), GradDAO.selectOne(rs.getInt("polazniGrad")), GradDAO.selectOne(rs.getInt("odredisniGrad")), DrzavaDAO.selectOne(rs.getInt("polaznaDrzava")), DrzavaDAO.selectOne(rs.getInt("odredisnaDrzava")), rs.getString("status"), rs.getTime("vrijemePolaska"), rs.getTime("vrijemeDolaska"), rs.getInt("brojSlobodnihMjesta"));
			sviLetovi.add(putnickiLet);
		}
		rs.close();
		s.close();
		c.close();
		return sviLetovi;
	}
	
	public static PutnickiLetDTO selectOne(int id) throws Exception
	{
		Connection c= getConnection();
		PreparedStatement ps = c.prepareStatement(SELECT_ONE);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		PutnickiLetDTO putnickiLet = null;
		if(rs.next())
			putnickiLet = new PutnickiLetDTO(rs.getInt("id"), rs.getDate("datumLeta"), rs.getInt("brojMjesta"), GradDAO.selectOne(rs.getInt("polazniGrad")), GradDAO.selectOne(rs.getInt("odredisniGrad")), DrzavaDAO.selectOne(rs.getInt("polaznaDrzava")), DrzavaDAO.selectOne(rs.getInt("odredisnaDrzava")), rs.getString("status"), rs.getTime("vrijemePolaska"), rs.getTime("vrijemeDolaska"), rs.getInt("brojSlobodnihMjesta"));
		
		rs.close();
		ps.close();
		c.close();
		return putnickiLet;
	}
	
	
	public static boolean azurirajSlobodnaMjesta(int slobodnaMjesta, int id) throws Exception
	{
		Connection c = getConnection();
		PreparedStatement ps = c.prepareStatement(UPDATE_AVAILABLE_SEATS);
		ps.setInt(1, slobodnaMjesta);
		ps.setInt(2, id);
		int affected = ps.executeUpdate();
		ps.close();
		c.close();
		if(affected == 0)
			return false;
		else 
			return true;
	}
	
	public static void postaviStatus(String status, int id) throws Exception
	{
		Connection c = getConnection();
		PreparedStatement ps = c.prepareStatement(UPDATE_STATUS);
		ps.setString(1, status);
		ps.setInt(2, id);
		ps.executeUpdate();
		ps.close();
		c.close();
	}

}

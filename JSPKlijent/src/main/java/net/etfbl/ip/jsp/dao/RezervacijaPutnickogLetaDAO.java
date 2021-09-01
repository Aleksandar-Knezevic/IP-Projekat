package net.etfbl.ip.jsp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import net.etfbl.ip.jsp.dto.RezervacijaPutnickogLetaDTO;
import net.etfbl.ip.jsp.model.PutnickaRezervacija;

public class RezervacijaPutnickogLetaDAO {

	private static final String SELECT_ALL = "SELECT * FROM rezervacijaputnickogleta";
	private static final String SELECT_ONE = "SELECT * FROM rezervacijaputnickogleta WHERE korisnik_id=? AND putnickiLet_id=?";
	private static final String INSERT = "INSERT INTO rezervacijaputnickogleta (korisnik_id, putnickiLet_id, status, datumKreiranja, razlogPonistavanja, brojMjesta) VALUES (?,?,?,?,?,?)";
	private static final String DELETE = "DELETE FROM rezervacijaputnickogleta WHERE korisnik_id=? AND putnickiLet_id=?";
	
	private static Connection getConnection() throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?serverTimezone=UTC&useSSL=false", "root", "nokia2700");
	}
	
	public static ArrayList<RezervacijaPutnickogLetaDTO> selectAll() throws Exception
	{
		ArrayList<RezervacijaPutnickogLetaDTO> sveRezervacije = new ArrayList();
		Connection c = getConnection();
		Statement s = c.createStatement();
		ResultSet rs = s.executeQuery(SELECT_ALL);
		while(rs.next())
		{
			RezervacijaPutnickogLetaDTO rezervacija = new RezervacijaPutnickogLetaDTO(KorisnikDAO.selectOne(rs.getInt("korisnik_id")), PutnickiLetDAO.selectOne(rs.getInt("putnickiLet_id")), rs.getString("status"), rs.getDate("datumKreiranja"), rs.getString("razlogPonistavanja"), rs.getInt("brojMjesta"));
			sveRezervacije.add(rezervacija);
		}
		rs.close();
		s.close();
		c.close();
		return sveRezervacije;
	}
	
	public static RezervacijaPutnickogLetaDTO selecetOne(int korisnikId, int putnickiLetId) throws Exception
	{
		Connection c =getConnection();
		PreparedStatement ps = c.prepareStatement(SELECT_ONE);
		ps.setInt(1, korisnikId);
		ps.setInt(2, putnickiLetId);
		ResultSet rs = ps.executeQuery();
		RezervacijaPutnickogLetaDTO rezervacija = null;
		if(rs.next())
			rezervacija = new RezervacijaPutnickogLetaDTO(KorisnikDAO.selectOne(rs.getInt("korisnik_id")), PutnickiLetDAO.selectOne(rs.getInt("putnickiLet_id")), rs.getString("status"), rs.getDate("datumKreiranja"), rs.getString("razlogPonistavanja"), rs.getInt("brojMjesta"));
		
		rs.close();
		ps.close();
		c.close();
		return rezervacija;
	}
	
	public static boolean insert(int korisnikId, int putnickiLetId, int brojMjesta) throws Exception
	{
		Connection c = getConnection();
		PreparedStatement ps = c.prepareStatement(INSERT);
		ps.setInt(1, korisnikId);
		ps.setInt(2, putnickiLetId);
		ps.setString(3, "Nova");
		ps.setDate(4, new java.sql.Date(System.currentTimeMillis()));
		ps.setString(5, "");
		ps.setInt(6,  brojMjesta);
		int affected = ps.executeUpdate();
		ps.close();
		c.close();
		if(affected == 0)
			return false;
		else
			return true;
	}
	
	public static List<PutnickaRezervacija> selectUsersFlights(int id) throws Exception
	{
		return selectAll()
				.stream()
				.filter(e -> e.getKorisnik().getId()==id)
				.sorted((a,b) -> a.getDatumKreiranja().compareTo(b.getDatumKreiranja()))
				.map(e -> new PutnickaRezervacija(e.getPutnickiLet(), e.getStatus(), e.getRazlogPonistavanja()==null?"":e.getRazlogPonistavanja()))
				.collect(Collectors.toList());
	}
	
	
	public static boolean obrisi(int korisnikId, int letId) throws Exception
	{
		Connection c = getConnection();
		PreparedStatement ps = c.prepareStatement(DELETE);
		ps.setInt(1, korisnikId);
		ps.setInt(2, letId);
		int affected = ps.executeUpdate();
		ps.close();
		c.close();
		if(affected==0)
			return false;
		else
			return true;
	}

}

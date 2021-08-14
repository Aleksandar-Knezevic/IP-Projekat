package net.etfbl.ip.jsp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import net.etfbl.ip.jsp.dto.RezervacijaTeretnogLetaDTO;
import net.etfbl.ip.jsp.model.TeretnaRezervacija;

public class RezervacijaTeretnogLetaDAO {

	private static final String SELECT_ALL = "SELECT * FROM rezervacijateretnogleta";
	private static final String SELECT_ONE = "SELECT * FROM rezervacijateretnogleta WHERE korisnik_id=? AND teretniLet_id=?";
	private static final String INSERT = "INSERT INTO rezervacijateretnogleta (korisnik_id, teretniLet_id, status, datumKreiranja, razlogPonistavanja) VALUES (?,?,?,?,?)";
	private static final String DELETE = "DELETE FROM rezervacijateretnogleta WHERE korisnik_id=? AND teretniLet_id=?";
	
	private static Connection getConnection() throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?serverTimezone=UTC", "root", "nokia2700");
	}
	
	public static ArrayList<RezervacijaTeretnogLetaDTO> selectAll() throws Exception
	{
		ArrayList<RezervacijaTeretnogLetaDTO> sveRezervacije = new ArrayList();
		Connection c = getConnection();
		Statement s = c.createStatement();
		ResultSet rs = s.executeQuery(SELECT_ALL);
		while(rs.next())
		{
			RezervacijaTeretnogLetaDTO rezervacija = new RezervacijaTeretnogLetaDTO(KorisnikDAO.selectOne(rs.getInt("korisnik_id")), TeretniLetDAO.selectOne(rs.getInt("teretniLet_id")), rs.getString("status"), rs.getDate("datumKreiranja"), rs.getString("razlogPonistavanja"));
			sveRezervacije.add(rezervacija);
		}

		return sveRezervacije;
	}
	
	public static RezervacijaTeretnogLetaDTO selecetOne(int korisnikId, int letId) throws Exception
	{
		Connection c =getConnection();
		PreparedStatement ps = c.prepareStatement(SELECT_ONE);
		ps.setInt(1, korisnikId);
		ps.setInt(2, letId);
		ResultSet rs = ps.executeQuery();
		RezervacijaTeretnogLetaDTO rezervacija = null;
		if(rs.next())
			rezervacija = new RezervacijaTeretnogLetaDTO(KorisnikDAO.selectOne(rs.getInt("korisnik_id")), TeretniLetDAO.selectOne(rs.getInt("teretniLet_id")), rs.getString("status"), rs.getDate("datumKreiranja"), rs.getString("razlogPonistavanja"));

		return rezervacija;
	}
	
	public static boolean insert(int korisnikId, int teretniLetId) throws Exception
	{
		Connection c = getConnection();
		PreparedStatement ps = c.prepareStatement(INSERT);
		ps.setInt(1, korisnikId);
		ps.setInt(2, teretniLetId);
		ps.setString(3, "Nova");
		ps.setDate(4, new java.sql.Date(System.currentTimeMillis()));
		ps.setString(5, "");
		int affected = ps.executeUpdate();

		if(affected == 0)
			return false;
		else
			return true;
	}
	
	public static List<TeretnaRezervacija> selectUsersFlights(int id) throws Exception
	{
		return selectAll()
				.stream()
				.filter(e -> e.getKorisnik().getId()==id)
				.sorted((a,b) -> a.getDatumKreiranja().compareTo(b.getDatumKreiranja()))
				.map(e -> new TeretnaRezervacija(e.getTeretniLet(), e.getStatus()))
				.collect(Collectors.toList());
	}
	
	public static boolean obrisi(int korisnikId, int teretniLetId) throws Exception
	{
		Connection c =getConnection();
		PreparedStatement ps = c.prepareStatement(DELETE);
		ps.setInt(1, korisnikId);
		ps.setInt(2, teretniLetId);
		int affected = ps.executeUpdate();
		if(affected==0)
			return false;
		else
			return true;
	}
}

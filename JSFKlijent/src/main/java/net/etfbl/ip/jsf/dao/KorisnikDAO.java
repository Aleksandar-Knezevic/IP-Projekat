package net.etfbl.ip.jsf.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import net.etfbl.ip.jsp.dto.Korisnik;


public class KorisnikDAO
{
	private static final String SELECT_ALL = "SELECT * FROM korisnik";
	private static final String SELECT_ONE = "SELECT * FROM korisnik WHERE id=?";
	private static final String INSERT = "INSERT INTO korisnik (ime, prezime, korisnickoIme, email, lozinka, drzava, tipNaloga, adresa) VALUES (?,?,?,?,?,?,?,?)";
	private static final String DELETE = "DELETE FROM korisnik WHERE id=?";
	private static final String UPDATE = "UPDATE korisnik SET ime=?, prezime=?, korisnickoIme=?, email=?, lozinka=?, drzava=?, tipNaloga=?, adresa=? WHERE id=?";

	private static Connection getConnection() throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?serverTimezone=UTC&useSSL=false", "root", "nokia2700");
	}
	
	public static ArrayList<Korisnik> selectAll() throws Exception
	{
		ArrayList<Korisnik> korisnici = new ArrayList();
		Connection c = getConnection();
		Statement s = c.createStatement();
		ResultSet rs = s.executeQuery(SELECT_ALL);
		while(rs.next())
		{
			Korisnik korisnik = new Korisnik(rs.getInt("id"), rs.getString("ime"), rs.getString("prezime"), rs.getString("korisnickoIme"), rs.getString("email"), rs.getString("lozinka"), rs.getString("drzava"), rs.getString("tipNaloga"), rs.getString("adresa"));
			korisnici.add(korisnik);
		}
		rs.close();
		s.close();
		c.close();
		return korisnici;
	}
	
	public static Korisnik selectOne(int id) throws Exception
	{
		Connection c = getConnection();
		PreparedStatement ps = c.prepareStatement(SELECT_ONE);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		Korisnik korisnik = null;
		if(rs.next())
			korisnik = new Korisnik(rs.getInt("id"), rs.getString("ime"), rs.getString("prezime"), rs.getString("korisnickoIme"), rs.getString("email"), rs.getString("lozinka"), rs.getString("drzava"), rs.getString("tipNaloga"), rs.getString("adresa"));
		rs.close();
		ps.close();
		c.close();
		return korisnik;
	}
	
	public static int insert(String ime, String prezime, String korisnickoIme, String email, String lozinka, String drzava, String tipNaloga, String adresa) throws Exception
	{
		Connection c = getConnection();
		PreparedStatement ps = c.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, ime);
		ps.setString(2, prezime);
		ps.setString(3, korisnickoIme);
		ps.setString(4, email);
		ps.setString(5, lozinka);
		ps.setString(6, drzava);
		ps.setString(7, tipNaloga);
		ps.setString(8, adresa);
		ps.executeUpdate();
		ResultSet rs = ps.getGeneratedKeys();
		if(rs.next())
			return rs.getInt(1);
		else
			return -1;
		
	}
	
	public static void delete(int id) throws Exception
	{
		Connection c = getConnection();
		PreparedStatement ps = c.prepareStatement(DELETE);
		ps.setInt(1, id);
		ps.executeUpdate();
		ps.close();
		c.close();
	}
	
	public static void update(String ime, String prezime, String korisnickoIme, String email, String lozinka, String drzava, String tipNaloga, String adresa, int id) throws Exception
	{
		Connection c = getConnection();
		PreparedStatement ps = c.prepareStatement(UPDATE);
		ps.setString(1, ime);
		ps.setString(2, prezime);
		ps.setString(3, korisnickoIme);
		ps.setString(4, email);
		ps.setString(5, lozinka);
		ps.setString(6, drzava);
		ps.setString(7, tipNaloga);
		ps.setString(8, adresa);
		ps.setInt(9, id);
		ps.executeUpdate();
		ps.close();
		c.close();
		
	}
	


}
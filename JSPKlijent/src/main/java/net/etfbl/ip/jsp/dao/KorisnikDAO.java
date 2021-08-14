package net.etfbl.ip.jsp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import net.etfbl.ip.jsp.dto.KorisnikDTO;

public class KorisnikDAO {
	
	private static final String SELECT_ALL = "SELECT * FROM korisnik";
	private static final String SELECT_ONE = "SELECT * FROM korisnik WHERE id=?";
	private static final String INSERT = "INSERT INTO korisnik (ime, prezime, korisnickoIme, email, lozinka, drzava, tipNaloga, adresa) VALUES (?,?,?,?,?,?,?,?)";
	private static final String LOGIN = "SELECT * FROM korisnik WHERE korisnickoIme=? AND lozinka=?";

	private static Connection getConnection() throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?serverTimezone=UTC", "root", "nokia2700");
	}
	
	public static ArrayList<KorisnikDTO> selectAll() throws Exception
	{
		ArrayList<KorisnikDTO> korisnici = new ArrayList();
		Connection c = getConnection();
		Statement s = c.createStatement();
		ResultSet rs = s.executeQuery(SELECT_ALL);
		while(rs.next())
		{
			KorisnikDTO korisnik = new KorisnikDTO(rs.getInt("id"), rs.getString("ime"), rs.getString("prezime"), rs.getString("korisnickoIme"), rs.getString("email"), rs.getString("lozinka"), rs.getString("drzava"), rs.getString("tipNaloga"), rs.getString("adresa"));
			korisnici.add(korisnik);
		}
		return korisnici;
	}
	
	public static KorisnikDTO selectOne(int id) throws Exception
	{
		Connection c = getConnection();
		PreparedStatement ps = c.prepareStatement(SELECT_ONE);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		KorisnikDTO korisnik = null;
		if(rs.next())
			korisnik = new KorisnikDTO(rs.getInt("id"), rs.getString("ime"), rs.getString("prezime"), rs.getString("korisnickoIme"), rs.getString("email"), rs.getString("lozinka"), rs.getString("drzava"), rs.getString("tipNaloga"), rs.getString("adresa"));
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
	
	public static KorisnikDTO login(String korisnickoIme, String lozinka) throws Exception
	{
		Connection c = getConnection();
		PreparedStatement ps = c.prepareStatement(LOGIN);
		ps.setString(1, korisnickoIme);
		ps.setString(2, lozinka);
		ResultSet rs = ps.executeQuery();
		KorisnikDTO korisnik = null;
		if(rs.next())
			korisnik = new KorisnikDTO(rs.getInt("id"), rs.getString("ime"), rs.getString("prezime"), rs.getString("korisnickoIme"), rs.getString("email"), rs.getString("lozinka"), rs.getString("drzava"), rs.getString("tipNaloga"), rs.getString("adresa"));
		return korisnik;
		
	}

}

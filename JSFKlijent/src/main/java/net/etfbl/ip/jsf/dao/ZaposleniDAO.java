package net.etfbl.ip.jsf.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import net.etfbl.ip.jsp.dto.Zaposleni;

public class ZaposleniDAO {
	
	private static final String SELECT_ALL = "SELECT * FROM zaposleni";
	private static final String INSERT = "INSERT INTO zaposleni (ime, prezime, korisnickoIme, lozinka) VALUES (?, ?, ?, ?)";
	private static final String DELETE = "DELETE FROM zaposleni WHERE id=?";
	private static final String UPDATE = "UPDATE zaposleni SET ime=?, prezime=?, korisnickoIme=?, lozinka=? WHERE id=?";

	private static Connection getConnection() throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?serverTimezone=UTC&useSSL=false", "root", "nokia2700");
	}
	
	public static ArrayList<Zaposleni> selectAll() throws Exception
	{
		ArrayList<Zaposleni> sviZaposleni = new ArrayList<Zaposleni>();
		Connection c = getConnection();
		PreparedStatement ps = c.prepareStatement(SELECT_ALL);
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			Zaposleni z = new Zaposleni(rs.getInt("id"), rs.getString("ime"), rs.getString("prezime"), rs.getString("korisnickoIme"), rs.getString("lozinka"));
			sviZaposleni.add(z);
		}
		
		return sviZaposleni;
	}
	
	public static void insert(String ime, String prezime, String korisnickoIme, String lozinka) throws Exception
	{
		Connection c = getConnection();
		PreparedStatement ps = c.prepareStatement(INSERT);
		ps.setString(1, ime);
		ps.setString(2, prezime);
		ps.setString(3, korisnickoIme);
		ps.setString(4, lozinka);
		ps.executeUpdate();
		ps.close();
		c.close();
		
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
	
	public static void update(String ime, String prezime, String korisnickoIme, String lozinka, int id) throws Exception
	{
		Connection c = getConnection();
		PreparedStatement ps = c.prepareStatement(UPDATE);
		ps.setString(1, ime);
		ps.setString(2, prezime);
		ps.setString(3, korisnickoIme);
		ps.setString(4, lozinka);
		ps.setInt(5, id);
		ps.executeUpdate();
		ps.close();
		c.close();
		
	}
}

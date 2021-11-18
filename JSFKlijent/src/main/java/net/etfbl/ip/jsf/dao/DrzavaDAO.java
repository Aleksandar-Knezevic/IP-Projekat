package net.etfbl.ip.jsf.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import net.etfbl.ip.jsp.dto.Drzava;

public class DrzavaDAO {
	
	public static String SELECT_ALL = "SELECT * FROM drzava";
	public static String INSERT = "INSERT INTO drzava (nazivDrzave) VALUES (?)";
	public static String DELETE = "DELETE FROM drzava WHERE id=?";
	public static String UPDATE = "UPDATE drzava SET nazivDrzave=? WHERE id=?";
	public static String SELECT_ONE = "SELECT * FROM drzava WHERE id=?";

	private static Connection getConnection() throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?serverTimezone=UTC&useSSL=false", "", "");
	}

	public static ArrayList<Drzava> selectAll() throws Exception
	{
		ArrayList<Drzava> sveDrzave = new ArrayList<Drzava>();
		Connection c = getConnection();
		PreparedStatement ps = c.prepareStatement(SELECT_ALL);
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			Drzava drzava = new Drzava(rs.getInt("id"), rs.getString("nazivDrzave"));
			sveDrzave.add(drzava);
		}
		rs.close();
		ps.close();
		c.close();
		return sveDrzave;
	}
	
	public static void insert(String nazivDrzave) throws Exception
	{
		Connection c = getConnection();
		PreparedStatement ps = c.prepareStatement(INSERT);
		ps.setString(1, nazivDrzave);
		ps.executeUpdate();
		ps.close();
		c.close();
	}
	
	public static void obrisiDrzavu(int id) throws Exception
	{
		Connection c = getConnection();
		PreparedStatement ps = c.prepareStatement(DELETE);
		ps.setInt(1, id);
		ps.executeUpdate();
	}
	
	public static void update(Drzava d) throws Exception
	{
		Connection c = getConnection();
		PreparedStatement ps = c.prepareStatement(UPDATE);
		ps.setString(1, d.getNazivDrzave());
		ps.setInt(2, d.getId());
		ps.executeUpdate();
		ps.close();
		c.close();
	}
	
	public static Drzava selectOne(int id) throws Exception
	{
		Connection c = getConnection();
		PreparedStatement ps = c.prepareStatement(SELECT_ONE);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		Drzava drzava = null;
		if(rs.next())
			drzava = new Drzava(rs.getInt("id"), rs.getString("nazivDrzave"));
		return drzava;
		
	}
}

package net.etfbl.ip.jsp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import net.etfbl.ip.jsp.dto.DrzavaDTO;

public class DrzavaDAO {
	
	private static final String SELECT_ALL = "SELECT * FROM drzava";
	private static final String SELECT_ONE = "SELECT * FROM drzava WHERE id=?";

	private static Connection getConnection() throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?serverTimezone=UTC&useSSL=false", "root", "nokia2700");
	}
	
	public static ArrayList<DrzavaDTO> selectAll() throws Exception
	{
		ArrayList<DrzavaDTO> sveDrzave = new ArrayList<>();
		Connection c= getConnection();
		Statement s = c.createStatement();
		ResultSet rs = s.executeQuery(SELECT_ALL);
		while(rs.next())
		{
			DrzavaDTO d = new DrzavaDTO(rs.getInt("id"), rs.getString("nazivDrzave"));
			sveDrzave.add(d);
		}
		return sveDrzave;
	}
	
	public static DrzavaDTO selectOne(int id) throws Exception
	{
		Connection c = getConnection();
		PreparedStatement ps = c.prepareStatement(SELECT_ONE);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		DrzavaDTO drzava = null;
		if(rs.next())
			drzava = new DrzavaDTO(rs.getInt("id"), rs.getString("nazivDrzave"));
		return drzava;
		
	}
	
	
	
}

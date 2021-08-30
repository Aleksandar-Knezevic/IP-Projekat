package net.etfbl.ip.jsp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class PorukaDAO {

	private static final String INSERT = "INSERT INTO poruka (email, naslov, sadrzaj, status) values (?,?,?,?)";
	private static Connection getConnection() throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?serverTimezone=UTC&useSSL=false", "root", "nokia2700");
	}
	
	public static boolean insert(String email, String naslov, String sadrzaj) throws Exception
	{
		Connection c = getConnection();
		PreparedStatement ps = c.prepareStatement(INSERT);
		ps.setString(1, email);
		ps.setString(2, naslov);
		ps.setString(3, sadrzaj);
		ps.setString(4, "Neprocitana");
		int affected = ps.executeUpdate();
		ps.close();
		c.close();
		if(affected == 0)
			return false;
		else
			return true;
	}

}

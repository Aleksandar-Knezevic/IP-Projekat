package net.etfbl.ip.jsf.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import net.etfbl.ip.jsp.dto.Administrator;

public class AdministratorDAO {

	private static String LOGIN = "SELECT * FROM administrator WHERE korisnickoIme=? AND lozinka=?";
	
	private static Connection getConnection() throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?serverTimezone=UTC&useSSL=false", "", "");
	}
	
	public static Administrator login(String username, String password) throws Exception
	{
		Administrator admin = null;
		Connection c = getConnection();
		PreparedStatement ps = c.prepareStatement(LOGIN);
		ps.setString(1, username);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
		if(rs.next())
			admin = new Administrator(rs.getInt("id"), rs.getString("ime"), rs.getString("prezime"), rs.getString("korisnickoIme"), rs.getString("lozinka"));
		return admin;
	}

}

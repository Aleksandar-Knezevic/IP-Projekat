package net.etfbl.ip.jsf.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import net.etfbl.ip.jsf.model.GraphModel;

public class PristupiDAO {
	
	private static String GET_DATA = "SELECT * FROM pristupi order by datum desc limit 30";

	private static Connection getConnection() throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?serverTimezone=UTC&useSSL=false", "root", "nokia2700");
	}
	
	public static ArrayList<GraphModel> getData() throws Exception
	{
		ArrayList<GraphModel> data = new ArrayList<GraphModel>();
		Connection c = getConnection();
		PreparedStatement ps = c.prepareStatement(GET_DATA);
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			GraphModel model = new GraphModel(rs.getDate("datum"), rs.getInt("brojPristupa"));
			data.add(model);
		}
		return data;
		
	}

}

package net.etfbl.ip.jsp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import net.etfbl.ip.jsp.dto.GradDTO;

public class GradDAO {

	private static final String SELECT_ALL = "SELECT * FROM grad";
	private static final String SELECT_ONE = "SELECT * FROM grad WHERE id=?";
	private static final String SELECT_BY_STATE = "SELECT * FROM grad WHERE drzava_id=?";
	
	private static Connection getConnection() throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?serverTimezone=UTC&useSSL=false", "root", "nokia2700");
	}
	
	public static ArrayList<GradDTO> selectAll() throws Exception
	{
		ArrayList<GradDTO> sviGradovi = new ArrayList();
		Connection c = getConnection();
		Statement s = c.createStatement();
		ResultSet rs = s.executeQuery(SELECT_ALL);
		while(rs.next())
		{
			GradDTO grad = new GradDTO(rs.getInt("id"), rs.getString("nazivGrada"), DrzavaDAO.selectOne(rs.getInt("drzava_id")));
			sviGradovi.add(grad);
		}
		rs.close();
		s.close();
		c.close();
		return sviGradovi;
	}
	
	public static GradDTO selectOne(int id) throws Exception
	{
		Connection c = getConnection();
		PreparedStatement ps = c.prepareStatement(SELECT_ONE);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		GradDTO grad = null;
		if(rs.next())
		{
			grad = new GradDTO(rs.getInt("id"), rs.getString("nazivGrada"), DrzavaDAO.selectOne(rs.getInt("drzava_id")));
		}
		rs.close();
		ps.close();
		c.close();
		return grad;
	}
	
	public static ArrayList<GradDTO> selectByState(int drzava_id) throws Exception
	{
		ArrayList<GradDTO> gradoviUDrzavi = new ArrayList<GradDTO>();
		Connection c = getConnection();
		PreparedStatement ps = c.prepareStatement(SELECT_BY_STATE);
		ps.setInt(1, drzava_id);
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			GradDTO grad = new GradDTO(rs.getInt("id"), rs.getString("nazivGrada"), DrzavaDAO.selectOne(rs.getInt("drzava_id")));
			gradoviUDrzavi.add(grad);
		}
		rs.close();
		ps.close();
		c.close();
		return gradoviUDrzavi;
	}

}

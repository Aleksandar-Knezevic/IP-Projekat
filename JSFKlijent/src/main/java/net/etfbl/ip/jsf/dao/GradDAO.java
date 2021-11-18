package net.etfbl.ip.jsf.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import net.etfbl.ip.jsp.dto.Grad;


public class GradDAO {

	private static final String SELECT_ALL = "SELECT * FROM grad";
	private static final String SELECT_ONE = "SELECT * FROM grad WHERE id=?";
	private static final String SELECT_BY_STATE = "SELECT * FROM grad WHERE drzava_id=?";
	private static final String INSERT = "INSERT INTO grad (nazivGrada, drzava_id) VALUES (?, ?)";
	private static final String DELETE = "DELETE FROM grad WHERE id=?";
	private static final String UPDATE = "UPDATE grad SET nazivGrada=?, drzava_id=? WHERE id=?";
	
	private static Connection getConnection() throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?serverTimezone=UTC&useSSL=false", "", "");
	}
	
	public static ArrayList<Grad> selectAll() throws Exception
	{
		ArrayList<Grad> sviGradovi = new ArrayList<Grad>();
		Connection c = getConnection();
		Statement s = c.createStatement();
		ResultSet rs = s.executeQuery(SELECT_ALL);
		while(rs.next())
		{
			Grad grad = new Grad(rs.getInt("id"), rs.getString("nazivGrada"), DrzavaDAO.selectOne(rs.getInt("drzava_id")));
			sviGradovi.add(grad);
		}
		rs.close();
		s.close();
		c.close();
		return sviGradovi;
	}
	
	public static Grad selectOne(int id) throws Exception
	{
		Connection c = getConnection();
		PreparedStatement ps = c.prepareStatement(SELECT_ONE);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		Grad grad = null;
		if(rs.next())
		{
			grad = new Grad(rs.getInt("id"), rs.getString("nazivGrada"), DrzavaDAO.selectOne(rs.getInt("drzava_id")));
		}
		rs.close();
		ps.close();
		c.close();
		return grad;
	}
	
	public static ArrayList<Grad> selectByState(int drzava_id) throws Exception
	{
		ArrayList<Grad> gradoviUDrzavi = new ArrayList<Grad>();
		Connection c = getConnection();
		PreparedStatement ps = c.prepareStatement(SELECT_BY_STATE);
		ps.setInt(1, drzava_id);
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			Grad grad = new Grad(rs.getInt("id"), rs.getString("nazivGrada"), DrzavaDAO.selectOne(rs.getInt("drzava_id")));
			gradoviUDrzavi.add(grad);
		}
		rs.close();
		ps.close();
		c.close();
		return gradoviUDrzavi;
	}
	
	public static void insert(String nazivGrada, int idDrzave) throws Exception
	{
		Connection c = getConnection();
		PreparedStatement ps = c.prepareStatement(INSERT);
		ps.setString(1, nazivGrada);
		ps.setInt(2, idDrzave);
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
	
	public static void update(String nazivGrada, int drzavaId, int gradId) throws Exception
	{
		Connection c = getConnection();
		PreparedStatement ps = c.prepareStatement(UPDATE);
		ps.setString(1, nazivGrada);
		ps.setInt(2, drzavaId);
		ps.setInt(3, gradId);
		ps.executeUpdate();
		ps.close();
		c.close();
	}


}


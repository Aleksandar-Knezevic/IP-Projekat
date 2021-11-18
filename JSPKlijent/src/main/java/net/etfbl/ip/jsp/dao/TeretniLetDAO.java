package net.etfbl.ip.jsp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import net.etfbl.ip.jsp.dto.TeretniLetDTO;

public class TeretniLetDAO {

	private static final String SELECT_ALL = "SELECT * FROM teretnilet";
	private static final String SELECT_ONE = "SELECT * FROM teretnilet WHERE id=?";
	private static final String ADD_CARGO_DESC = "UPDATE teretnilet SET opisTereta=? WHERE id=?";
	private static final String UPDATE_STATUS = "UPDATE teretnilet SET status=? WHERE id=?";
	
	private static Connection getConnection() throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?serverTimezone=UTC&useSSL=false", "", "");
	}
	
	public static ArrayList<TeretniLetDTO> selectAll() throws Exception
	{
		ArrayList<TeretniLetDTO> sviLetovi = new ArrayList();
		Connection c = getConnection();
		Statement s = c.createStatement();
		ResultSet rs = s.executeQuery(SELECT_ALL);
		while(rs.next())
		{
			TeretniLetDTO teretniLet = new TeretniLetDTO(rs.getInt("id"), rs.getDate("datumLeta"), rs.getString("opisTereta"), GradDAO.selectOne(rs.getInt("polazniGrad")), GradDAO.selectOne(rs.getInt("odredisniGrad")), DrzavaDAO.selectOne(rs.getInt("polaznaDrzava")), DrzavaDAO.selectOne(rs.getInt("odredisnaDrzava")), rs.getString("status"), rs.getTime("vrijemePolaska"), rs.getTime("vrijemeDolaska"));
			sviLetovi.add(teretniLet);
		}
		rs.close();
		s.close();
		c.close();

		return sviLetovi;
	}
	
	public static TeretniLetDTO selectOne(int id) throws Exception
	{
		Connection c= getConnection();
		PreparedStatement ps = c.prepareStatement(SELECT_ONE);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		TeretniLetDTO teretniLet = null;
		if(rs.next())
			teretniLet = new TeretniLetDTO(rs.getInt("id"), rs.getDate("datumLeta"), rs.getString("opisTereta"), GradDAO.selectOne(rs.getInt("polazniGrad")), GradDAO.selectOne(rs.getInt("odredisniGrad")), DrzavaDAO.selectOne(rs.getInt("polaznaDrzava")), DrzavaDAO.selectOne(rs.getInt("odredisnaDrzava")), rs.getString("status"), rs.getTime("vrijemePolaska"), rs.getTime("vrijemeDolaska"));

		rs.close();
		ps.close();
		c.close();
		return teretniLet;
	}
	
	public static boolean dodajOpisTereta(String opisTereta, int id) throws Exception
	{
		Connection c = getConnection();
		PreparedStatement ps = c.prepareStatement(ADD_CARGO_DESC);
		ps.setString(1, opisTereta);
		ps.setInt(2, id);
		int affected = ps.executeUpdate();
		ps.close();
		c.close();
		if(affected==0)
			return false;
		else 
			return true;
	}
	
	public static void postaviStatus(String status, int id) throws Exception
	{
		Connection c = getConnection();
		PreparedStatement ps = c.prepareStatement(UPDATE_STATUS);
		ps.setString(1, status);
		ps.setInt(2, id);
		ps.executeUpdate();
		ps.close();
		c.close();
	}

}

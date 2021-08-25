package net.etfbl.ip.jsf.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

import net.etfbl.ip.jsf.dao.PristupiDAO;
import net.etfbl.ip.jsf.model.GraphModel;

@ManagedBean(name = "graphBean")
@SessionScoped
public class GraphBean implements Serializable{


	private static final long serialVersionUID = -245991209353340284L;

	private BarChartModel model = new BarChartModel();
	
	
	public BarChartModel getModel() {
		return model;
	}


	public void setModel(BarChartModel model) {
		this.model = model;
	}


	public GraphBean() {
		
	}
	
	public String refreshData()
	{
		try
		{
			model = new BarChartModel();
			ChartSeries pristupi = new ChartSeries();
			pristupi.setLabel("Pristupi");
			for(GraphModel g : PristupiDAO.getData())
				pristupi.set(g.getDatum(), g.getBrojPristupa());
			model.addSeries(pristupi);
			model.setTitle("Pristupi");
		}
		catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		
		
		return null;
	}

}

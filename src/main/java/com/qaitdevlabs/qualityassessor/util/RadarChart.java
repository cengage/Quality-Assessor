package com.qaitdevlabs.qualityassessor.util;

import java.awt.*;
import org.jfree.ui.*;
import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.chart.labels.*;
import org.jfree.chart.title.*;
import org.jfree.data.category.*;

public class RadarChart extends ApplicationFrame {
	public DefaultCategoryDataset dataset;
	public SpiderWebPlot plot;

	public RadarChart(String title) {
		super(title);
	
		String category1 = "Category 1";
		String category2 = "Category 2";
		String category3 = "Category 3";
		String category4 = "Category 4";
		String category5 = "Category 5";
		String category6 = "Category 6";

		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.addValue(1.33, "unit", category1);
		dataset.addValue(1.00, "javascript", category1);
		dataset.addValue(2.0, "Code smells", category1);
		dataset.addValue(1.0, "Clean code", category1);
		dataset.addValue(1.0, "Component Tests", category1);

		dataset.addValue(0.0, "Customer Facing Tests", category2);
		dataset.addValue(1.0, "3rd Party API's", category2);
		dataset.addValue(1.0, "Design", category2);
		
		dataset.addValue(0.0, "Exploratory Testing", category3);
		dataset.addValue(1.0, "Usablility Testing", category3);
		dataset.addValue(1.75, "Accessibility", category3);

		dataset.addValue(1.0, "Load Performance Tests", category4);
		dataset.addValue(0.60, "Other non-functional Tests", category4);
		
		dataset.addValue(1.0, "Tecnical Debt", category5);
		dataset.addValue(2.0, "Documentation", category5);
		
		dataset.addValue(3.0, "Ongoing Support", category6);
		dataset.addValue(1.67, "Follow on releases", category6);
		
		SpiderWebPlot plot = new SpiderWebPlot(dataset);
		plot.setStartAngle(54);
		plot.setInteriorGap(0.40);
		plot.setToolTipGenerator(new StandardCategoryToolTipGenerator());
		JFreeChart chart = new JFreeChart("", TextTitle.DEFAULT_FONT, plot,
				false);
		ChartUtilities.applyCurrentTheme(chart);
		ChartPanel chartPanel = new ChartPanel(chart);
		this.plot = (SpiderWebPlot) chartPanel.getChart().getPlot();
		this.dataset = (DefaultCategoryDataset) plot.getDataset();
		chartPanel.setPreferredSize(new Dimension(500, 270));
		setContentPane(chartPanel);
	}

	public static void main(String[] args) {
		RadarChart demo = new RadarChart("Chart");
		demo.pack();
		RefineryUtilities.centerFrameOnScreen(demo);
		demo.setVisible(true);
	}
}
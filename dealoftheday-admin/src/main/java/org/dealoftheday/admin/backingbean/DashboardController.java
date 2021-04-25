package org.dealoftheday.admin.backingbean;

import java.util.*;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.axes.cartesian.CartesianScales;
import org.primefaces.model.charts.axes.cartesian.linear.CartesianLinearAxes;
import org.primefaces.model.charts.axes.cartesian.linear.CartesianLinearTicks;
import org.primefaces.model.charts.bar.BarChartDataSet;
import org.primefaces.model.charts.bar.BarChartModel;
import org.primefaces.model.charts.bar.BarChartOptions;
import org.primefaces.model.charts.optionconfig.legend.Legend;
import org.primefaces.model.charts.optionconfig.legend.LegendLabel;

@ManagedBean
@SessionScoped
public class DashboardController {

	private BarChartModel barModel;

	private int customersCount;

	@PostConstruct
	public void init() {
		createBarModel();
		refreshCustomersCount();
	}

	public void createBarModel() {
		Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
		ResourceBundle bundle = ResourceBundle.getBundle("messages.messages", locale);
		refreshCustomersCount();

		barModel = new BarChartModel();
		ChartData data = new ChartData();

		BarChartDataSet barDataSet = new BarChartDataSet();
		barDataSet.setLabel(bundle.getString("dashboard.title"));

		List<Number> values = Arrays.asList(customersCount);
		barDataSet.setData(values);

		List<String> bgColor = Arrays.asList("rgba(255, 99, 132, 0.2)");
		barDataSet.setBackgroundColor(bgColor);

		List<String> borderColor = Arrays.asList("rgb(255, 99, 132)");
		barDataSet.setBorderColor(borderColor);
		barDataSet.setBorderWidth(1);

		data.addChartDataSet(barDataSet);

		List<String> labels = Arrays.asList(bundle.getString("dashboard.nrCustomers"));
		data.setLabels(labels);
		barModel.setData(data);

		// Options
		BarChartOptions options = new BarChartOptions();
		CartesianScales cScales = new CartesianScales();
		CartesianLinearAxes linearAxes = new CartesianLinearAxes();
		linearAxes.setOffset(true);
		CartesianLinearTicks ticks = new CartesianLinearTicks();
		ticks.setBeginAtZero(true);
		linearAxes.setTicks(ticks);
		cScales.addYAxesData(linearAxes);
		options.setScales(cScales);

		Legend legend = new Legend();
		legend.setDisplay(true);
		legend.setPosition("top");
		LegendLabel legendLabels = new LegendLabel();
		legendLabels.setFontStyle("bold");
		legendLabels.setFontColor("#2980B9");
		legendLabels.setFontSize(24);
		legend.setLabels(legendLabels);
		options.setLegend(legend);

		barModel.setOptions(options);
	}

	public BarChartModel getBarModel() {
		return barModel;
	}

	public void setBarModel(BarChartModel barModel) {
		this.barModel = barModel;
	}

	public void refreshCustomersCount() {
		customersCount = getRandomNumber();
	}

	private int getRandomNumber() {
		Random r = new Random();
		int low = 10;
		int high = 100;
		int randomNum = r.nextInt(high-low) + low;
		return randomNum;
	}
}

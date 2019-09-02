package com.metacube.Parking.utility;

import java.text.DecimalFormat;

import com.metacube.Parking.model.Plan;

public class SelectPlanHtml {
	
	public static String getSelectPlanHtml(Plan plan){
		DecimalFormat format = new DecimalFormat("##.00");
		double daily = plan.getDaily();
		double monthly = plan.getMonthly();
		double yearly = plan.getYearly();
		return "<html>"+
				"<head>"+
				"<title>Insert title here</title></head>"+
				"<body><div align='center'>"+
		"<form action='savePlan' method='post'>"+
			"<table>"+
			"<tr>"+
			"<td>Select Plan</td>"+
			"<td><input type='radio' name='plan' id='plan' value='"+daily+"'>"+daily+" USD Daily"+
				"<input type='radio' name='paln' id='plan' value='"+monthly+"'>"+monthly+" USD Montly"+
				"<input type='radio' name='plan' id='plan' value='"+yearly+"' checked>"+yearly+" USD Yearly"+
			"</td></tr><tr><td>Price In INR</td>"
			+ "<td>"+format.format(daily*71.50)+" INR Daily "+format.format(monthly* 71.50)+" INR Monthly "+format.format(yearly* 71.50)+" INR Yearly</td></tr>"+
			"<tr><td>Price In YEN</td><td>"+format.format(daily*106.42)+" YEN Daily "+format.format(monthly*106.42)+" YEN Monthly "+format.format(yearly* 106.42)+" YEN Yearly</td>"+
			"</tr><tr>"+
			"<td></td>"+
			"<td><input type='submit' value='slectPlan'></td>"+
			"</tr></table></form></div></body></html>";
	}
}

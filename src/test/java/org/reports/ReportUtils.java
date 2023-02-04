package org.reports;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class ReportUtils {

	public static void generateJvmReport(String jsonFilePath) {

		// 1.Mention the Destination folder for generating jvm reports

		File f = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\Reports\\JvmReports");

		// 2.Create configuration class and add arguments

		Configuration con = new Configuration(f, "Facebook Automation");

		con.addClassifications("Browsername", "Chrome");
		con.addClassifications("BrowserVersion", "108.0");
		con.addClassifications("platform", "Windows");
		con.addClassifications("SprintNumber", "19");

		// 3. Create a list to store your jsonFilePath(String)

		List<String> li = new ArrayList<String>();

		li.add(jsonFilePath);

		// 4. Create Object for ReportBuilder class and call generate Reports.

		ReportBuilder r = new ReportBuilder(li, con);

		r.generateReports();
	}
}

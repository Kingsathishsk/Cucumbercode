package org.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.reports.ReportUtils;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

//features-----> To mention the feature file folder location.

//glue---------> To mention the Stepdefinition package name.

@CucumberOptions(features="src\\test\\resources\\Featurefile",glue="org.stepdefinition",dryRun=false,
plugin = {"pretty","html:src\\test\\resources\\Reports",
		"json:src\\test\\resources\\Reports\\fboutput.json","junit:src\\test\\resources\\Reports\\fb.xml"},monochrome=true)

public class TestRunner {
	
	
@AfterClass
public static void jvmReportGeneration() {
	
ReportUtils.generateJvmReport(System.getProperty("user.dir")+"\\src\\test\\resources\\Reports\\fboutput.json");	
}
}

package org.stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.utilities.BaseClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginSteps extends BaseClass {
	
	public WebDriver driver;
	
	@Given("user launch Facebook application")
	public void user_launch_Facebook_application() {
		
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.get("https://www.facebook.com/");
	}

	@When("user enter {string} and {string}")
	public void user_enter_and(String userid, String passkey) {
	 
	WebElement txtUser = driver.findElement(By.id("email"));
	txtUser.sendKeys(userid);
	
	WebElement txtPass = driver.findElement(By.id("pass"));
	txtPass.sendKeys(passkey);
	}

	@When("user click Login button")
	public void user_click_Login_button() {

	WebElement btnLogin = driver.findElement(By.name("login"));
	btnLogin.click();
	}

	@Then("user see the results based on {string}")
	public void user_see_the_results_based_on(String credentialtype) {
		
	if (credentialtype.equals("negative")) {
		
	WebElement txtErrorMessage = driver.findElement(By.xpath("//div[contains(text(),\"mobile number you entered isn't connected to\")]"));
	Assert.assertTrue("Error message not dispalyed after Invalid Login", txtErrorMessage.isDisplayed());
	}
	else { 	
		
	WebElement userlogo = driver.findElement(By.xpath("//img[@id='userlogo']"));
	Assert.assertTrue("user logo not displayed in the home page", userlogo.isDisplayed());
	}
	
	}
	}

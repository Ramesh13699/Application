package com.OrangeHrmLogin;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginTest {
	
	WebDriver driver=null;
	String url="https://opensource-demo.orangehrmlive.com/";


@Given("^Open chrome and navigate to orange hrm application$")
public void Open_chrome_and_navigate_to_orange_hrm_application() {
	System.setProperty("webdriver.chrome.driver", "./driverFiles/chromedriver.exe");
	driver=new ChromeDriver();
	driver.get(url);
	
	
   }

@When("^user enter \"([^\"]*)\" and \"([^\"]*)\" and click on login button$")
public void user_enter_and_and_click_on_login_button(String UserName, String Password) {
	WebElement username=driver.findElement(By.id("txtUsername"));
	username.sendKeys(UserName);
	
	WebElement password=driver.findElement(By.id("txtPassword"));
	password.sendKeys(Password);
	WebElement login=driver.findElement(By.id("btnLogin"));
	login.click();
	
	
}

@Then("^user should be able to successfully login and close the application$")
public void user_should_be_able_to_successfully_login_and_close_the_application() throws IOException {
	try
	{
		String expected_text="Welcome Admin";
		System.out.println("The expected text is:"+expected_text);
		String actual_text=driver.findElement(By.id("welcome")).getText();
		System.out.println("The actual text is:"+actual_text);
		if(actual_text.contains(expected_text))
		{
			System.out.println("Successfully login-Pass");
		}}
		catch(Exception e)
		{
			if(driver.findElement(By.id("spanMessage")).getText().equals("Invalid credentials"))
			{
				File screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(screenshot,new File("./Screenshot/img.png"));
				System.out.println("Login failed - Fail");
				driver.quit();
			}
		}
	driver.quit();
	}}



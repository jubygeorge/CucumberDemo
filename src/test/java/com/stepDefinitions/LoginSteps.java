package com.stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginSteps {
	WebDriver driver;

	@SuppressWarnings("deprecation")
	@Given("user is in Login Page")
	public void user_is_in_login_page() throws InterruptedException {
		System.out.println("Step 1:User is in Login Page");
		System.out.println("Step 1':User is in Login Page");
		WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

	}

//	@When("user enters username and password")
//	public void user_enters_username_and_password() {
//		System.out.println("Step 2:User enters username and password");
//		driver.findElement(By.name("username")).sendKeys("Admin");
//		driver.findElement(By.name("password")).sendKeys("admin123");
//	}
	@When("user enters (.*) and (.*)$")
	public void user_enters_username_and_password(String uname,String pwd) {
		System.out.println("Step 2:User enters username and password");
		driver.findElement(By.name("username")).sendKeys("uname");
		driver.findElement(By.name("password")).sendKeys("pwd");
	}

	@And("user clicks on Login button")
	public void user_clicks_on_login_button() {

		System.out.println("Step 3:User clicks on Login button");
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
	}

	@Then("user will be forwarded to the Home Page")
	public void user_will_be_forwarded_to_the_home_page() {
		System.out.println("Step 4:User lands on Home Page");
		driver.close();
	}

}

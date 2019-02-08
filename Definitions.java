package permanenttsb.steps;

import java.util.logging.Logger;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Definitions {
	
	private final static Logger LOGGER = Logger.getLogger(Definitions.class.getName());
	
	WebDriver driver = new ChromeDriver();
	
	
	@Before
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver","chromedriver");
		driver.manage().window().maximize();
	}
	
	@After
	public void closeBrowser() {
		driver.close();
	}
	
	@Given("permanenttsb online user is successfully able to launch the web application")
	public void permanenttsb_online_user_is_successfully_able_to_launch_the_web_application() {
	    driver.get("https://www.permanenttsb.ie/");
	    Assert.assertEquals("Navigated to the invalid Page or Page is not properly loaded. Please check the url once !!!","Personal and Business Banking | permanent tsb",driver.getTitle());
	}

	@When("user is able to navigate to Current Accounts")
	public void user_is_able_to_navigate_to_Current_Accounts() throws InterruptedException {
		driver.navigate().to("https://www.permanenttsb.ie/everyday-banking/");
		Assert.assertEquals("Navigated to the invalid Page or Page is not properly loaded. Please check the url once !!!","For All your Banking Needs - Everyday Banking | permanent tsb",driver.getTitle());
		Thread.sleep(2000);
	}

	@When("user wants to explore current accounts more")
	public void user_wants_to_explore_current_accounts_more() {
		WebElement CrntAccount = driver.findElement(By.xpath("/html[1]/body[1]/div[6]/section[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/a[1]"));
		CrntAccount.click();
	}

	@When("user tries to book an appointment by submitting the details {string} {string} {string} {string} {string} {string} {string} {string}")
	public void user_tries_to_book_an_appointment_by_submitting_the_details(String firstName, String surName, String dobDay, String dobMonth, String dobYear, String address1, String address2, String town) {
		WebElement clickStartSwitchNow = driver.findElement(By.xpath("/html[1]/body[1]/div[6]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/a[1]"));
		clickStartSwitchNow.click();
		
		WebElement selectYourDetailsTitle = driver.findElement(By.xpath("/html[1]/body[1]/div[5]/section[2]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/label[1]/div[1]/ins[1]"));
		selectYourDetailsTitle.click();
		
		WebElement setYourDetailsFirstName = driver.findElement(By.id("Step1_FirstName"));
		setYourDetailsFirstName.sendKeys(firstName);
		
		WebElement setYourDetailsSurName = driver.findElement(By.id("Step1_Surname"));
		setYourDetailsSurName.sendKeys(surName);
		
		WebElement setYourDetailsDate = driver.findElement(By.id("Step1_DOBDay"));
		setYourDetailsDate.sendKeys(dobDay);
		
		WebElement setYourDetailsMonth = driver.findElement(By.id("Step1_DOBMonth"));
		setYourDetailsMonth.sendKeys(dobMonth);

		WebElement setYourDetailsYear = driver.findElement(By.id("Step1_DOBYear"));
		setYourDetailsYear.sendKeys(dobYear);
		
		WebElement setYourDetailsAddress1 = driver.findElement(By.id("Step1_Address_NumberStreet"));
		setYourDetailsAddress1.sendKeys(address1);
		
		WebElement setYourDetailsAddress2 = driver.findElement(By.id("Addressline2"));
		setYourDetailsAddress2.sendKeys(address2);

		WebElement setYourDetailsAddress3 = driver.findElement(By.id("Step1_Address_TownCity"));
		setYourDetailsAddress3.sendKeys(town);
		
		setYourDetailsAddress3.sendKeys(Keys.TAB);
		
	}

	@Then("system successfully alerts the user to enter mandatory details")
	public void verifyTheAlerts() {
		driver.findElement(By.name("next")).sendKeys(Keys.ENTER);
		String expectedErrorMessage = "Please select a county.";
		String actualErrorMessage = driver.findElement(By.xpath("/html[1]/body[1]/div[5]/section[2]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[2]/span[7]/span[1]")).getText();
		Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
		LOGGER.info("-------------------------------------------------------------------------------------");
		LOGGER.info("Expected Error Message : " + expectedErrorMessage);
		LOGGER.info("Actual Error Message : " + actualErrorMessage);
		LOGGER.info("-------------------------------------------------------------------------------------");
	}


}

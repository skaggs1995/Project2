package pomtest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import driver.DriverFactory;
import pom.HomePom;
import pom.ManageCreatePom;
import pom.ManagePom;

public class ManageCreateTest {
	WebDriver driver;
	WebDriverWait wait;
	HomePom home;
	ManagePom manage;
	ManageCreatePom create;
	
	LocalDate today;
	DateTimeFormatter format;

	@BeforeSuite
	public void beforeSuite() {
		driver = DriverFactory.get("chrome");
		wait = new WebDriverWait(driver, 1);
		home = new HomePom(driver);
		manage = new ManagePom(driver);
		create = new ManageCreatePom(driver);
		
		today = LocalDate.now();
		format = DateTimeFormatter.ofPattern("MM dd yyyy");
		
		home.anchorManage().click();
		manage.anchorCreate().click();
	}
	
	@Test(priority=1)
	public void inputName() {
		WebElement input = create.inputName();
		input.sendKeys("1611 Jul11 Java");
	}
	
	@Test(priority=2, dataProvider="trainingtype")
	public void selectTraining(String string) {
		create.selectTraining(string);
	}
	
	@Test(priority=3, dataProvider="skill")
	public void selectSkill(String string) {
		create.selectSkill(string);
	}
	
	@Test(priority=4, dataProvider="location")
	public void selectLocation(String state, String address) {
		create.selectLocation(state, address);
	}
	
	@Test(priority=5, dataProvider="trainers")
	public void selectTrainer(String string) {
		create.selectTrainer(string);
	}
	
	@Test(priority=6, dataProvider="trainers")
	public void selectCotrainer(String string) {
		create.selectCotrainer(string);
	}
	
	@Test(priority=7)
	public void selectStart() {
		WebElement element = create.inputStart();	
		String date = today.format(format);
		element.sendKeys(date);
	}
	
	@Test(priority=8)
	public void selectEnd() {
		WebElement element = create.inputEnd();
		today = today.plusMonths(3);
		String date = today.format(format);
		element.sendKeys(date);
	}
	
	@Test(priority=9)
	public void inputGood() {
		WebElement element = create.inputGood();
		element.sendKeys("80");
	}
	
	@Test(priority=10)
	public void inputPassing() {
		WebElement element = create.inputPassing();
		element.sendKeys("50");
	}
	
	@Test(priority=11)
	public void buttonSave() {
		create.buttonSave().click();
	}
	
	@Test(priority=12)
	public void buttonClose() {
		WebElement anchor = manage.anchorCreate();
		WebElement button = create.buttonClose();
		WebElement modal = create.modal();
		
		modal(modal, anchor);
		anchor.click();
		
		modal(modal, button);
		button.click();
	}
	
	@Test(priority=13)
	public void buttonX() {
		WebElement anchor = manage.anchorCreate();
		WebElement button = create.buttonX();
		WebElement modal = create.modal();
		
		modal(modal, anchor);
		anchor.click();
		
		modal(modal, button);
		button.click();
	}
	
	@AfterSuite
	public void afterSuite() {
		driver.close();
	}
	
	@DataProvider(name="trainingtype")
	public Object[][] trainingType(){
		return new Object[][] {
			new Object[] { "Revature" },
			new Object[] { "Corporate" },
			new Object[] { "University" },
			new Object[] { "Other" }
		};
	}
	
	@DataProvider(name="skill")
	public Object[][] skillType(){
		return new Object[][] {
			new Object[] { "J2EE" },
			new Object[] { ".NET" },
			new Object[] { "SDET" },
			new Object[] { "BPM" },
			new Object[] { "Appian BPM" },
			new Object[] { "PEGA BPM" },
			new Object[] { "Microsoft Dynamics 365" },
			new Object[] { "JTA" },
			new Object[] { "Microservices" },
			new Object[] { "Oracle Fusion" },
			new Object[] { "Salesforce" },
			new Object[] { "Business Analyst" },
			new Object[] { "System Admin" },
			new Object[] { "QA" },
			new Object[] { "Other" }
		};		
	}
	
	@DataProvider(name="location")
	public Object[][] location(){
		return new Object[][] {
			new Object[] { "NY", "Tech Incubator at Queens College, 65-30 Kissena Blvd, CEP Hall 2 Queens NY 11367" },
			new Object[] { "VA", "Revature LLC, 11730 Plaza America Drive, 2nd Floor Reston VA 20190" }
		};
	}
	
	@DataProvider(name="trainers")
	public Object[][] trainers(){
		return new Object[][] {
			new Object[] { "123" },
			new Object[] { "Name" },
			new Object[] { "bfs" },
			new Object[] { "Patrick Walsh" },
			new Object[] { "Dan Pickles" },
			new Object[] { "Karan Dhirar" },
			new Object[] { "Brian Connolly" },
			new Object[] { "Genesis Bonds" },
			new Object[] { "Ankit Garg" },
			new Object[] { "Ryan Lessley" },
			new Object[] { "Steven Kelsey" },
			new Object[] { "Emily Higgins" },
			new Object[] { "Taylor Kemper" },
			new Object[] { "Richard Orr" },
			new Object[] { "Nickolas Jurczak" },
			new Object[] { "August Duet" },
			new Object[] { "Yuvaraj Damodaran" },
			new Object[] { "Fred Belotte" },
			new Object[] { "Mehrab Rahman" },
			new Object[] { "Peter Alagna" },
			new Object[] { "Mehrab Rahman" },
			new Object[] { "Peter Alagna" },
			new Object[] { "Stanley Medikonda" },
			new Object[] { "Gray Wynne" },
			new Object[] { "Orson Wallace" },
			new Object[] { "Shelby Levinson" },
			new Object[] { "Gray Wynne" },
			new Object[] { "Orson Wallace" },
			new Object[] { "Shelby Levinson" },
			new Object[] { "Walter Payne" },
			new Object[] { "Natalie Church" },
			new Object[] { "Archer Radcliff" },
			new Object[] { "Rajesh Yamunachari" },
			new Object[] { "Raghavan Swaminathan" },
			new Object[] { "Marvin" },
			new Object[] { "Spongebob Squarepants" },
			new Object[] { "Kermit Frog" },
			new Object[] { "!@#$%^&*()" }
		};
	}
	
	private void modal(WebElement modal, WebElement anchor) {
		ExpectedCondition<Boolean> modalCondition =
				ExpectedConditions.invisibilityOf(modal);
		ExpectedCondition<WebElement> anchorCondition =
				ExpectedConditions.elementToBeClickable(anchor);
		
		wait.until(modalCondition);
		wait.until(anchorCondition);
	}
}

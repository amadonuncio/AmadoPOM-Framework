package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.DashboardPage;
import page.LoginPage;
import page.NewDespositPage;
import util.BrowserFactory;

public class AddDepositTest {
	WebDriver driver;
	
	@Test
	public void validUserShouldBeAbleToAddDeposit() throws InterruptedException {
		driver = BrowserFactory.init();
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUsername("demo@techfios.com");
		loginPage.insertPassword("abc123");
		loginPage.clickSignInButton();
		
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.validateDashboardPage("Dashboard");
		dashboardPage.clickTransactionButton();
		Thread.sleep(1000);
		dashboardPage.clickNewDepositButton();
		
		NewDespositPage newDepositPage = PageFactory.initElements(driver, NewDespositPage.class);
		newDepositPage.validateNewDepositPage("Add Deposit");
		newDepositPage.selectAccount("Johnson");
		newDepositPage.insertDescription("Office supplies.");
		newDepositPage.insertAmount("50");
		newDepositPage.clickSubmitButton();
		
		Thread.sleep(1000);
		BrowserFactory.tearDown();
	}

}

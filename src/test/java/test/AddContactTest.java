package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddContactPage;
import page.DashboardPage;
import page.ListCustomerPage;
import page.LoginPage;
import util.BrowserFactory;

public class AddContactTest {
	WebDriver driver;
	@Test
	public void validUserShouldBeAbleToAddContact() throws InterruptedException {
		driver = BrowserFactory.init();
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUsername("demo@techfios.com");
		loginPage.insertPassword("abc123");
		loginPage.clickSignInButton();
		
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.validateDashboardPage("Dashboard");
		dashboardPage.clickCustomersButton();
		dashboardPage.clickAddCustomerButton();
		
		AddContactPage addContactPage = PageFactory.initElements(driver, AddContactPage.class);
		addContactPage.validateAddContactPage("Add Contact");
		addContactPage.insertFullName("Bruce Wayne");
		addContactPage.selectCompanyFromDropDown("Techfios");
		addContactPage.insertEmail("brucew@gotham.com");
		addContactPage.insertPhone("050-812-1939");
		addContactPage.insertAddress("Wayne Manor");
		addContactPage.insertCity("Gotham City");
		addContactPage.insertState("Gotham");
		addContactPage.insertZipCode("5812");
		addContactPage.selectCountryFromDropDown("United States");
		addContactPage.selectTagFromDropdown("IT Training");
		addContactPage.selectCurrencyFromDropDown("USD");
		addContactPage.selectGroupFromDropDown("Selenium");
		addContactPage.insertPassword("parents");
		addContactPage.insertPasswrodAgainToConfirm("parents");
		addContactPage.clickEmailButton();
		addContactPage.clickSaveButton();
		
		dashboardPage.clickListCustomerButton();
		
		addContactPage.validateCreatedCustomerAndDelete();
		
		ListCustomerPage listCustomerPage = PageFactory.initElements(driver, ListCustomerPage.class);
		listCustomerPage.deleteConfirmCreatedCustomer();
	} 

}

package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;


public class DashboardPage {
	WebDriver driver;
	//Element List
	@FindBy(how = How.XPATH, using = "//h2[contains(text(), 'Dashboard')]") WebElement DASHBOARD_HEADER_ELEMENT;
	
	
	
	public void validateDashboardPage(String dashboard) {
		Assert.assertEquals(DASHBOARD_HEADER_ELEMENT.getText(), dashboard, "Wrong Page");
	}
}

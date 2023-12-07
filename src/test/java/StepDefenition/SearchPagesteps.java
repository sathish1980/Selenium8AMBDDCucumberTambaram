package StepDefenition;



import com.relevantcodes.extentreports.LogStatus;

import BrowserDriver.intilaizeBrowser;
import Commons.ElementUtils;
import Pages.SearcResultPage;
import Pages.SearchPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.PropertyFileHandle;

public class SearchPagesteps extends intilaizeBrowser{

	@Given("Open the browser and enter the url")
	public void open_the_browser_and_enter_the_url() throws InterruptedException
	{
		Launch();
		String url = PropertyFileHandle.propreaddata().getProperty("URL");
		driver.get(url);
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();
		Thread.sleep(5000);
	}

	@When("i see a popup click on it")
	public void i_see_a_popup_click_on_it() throws InterruptedException {
		ElementUtils E = new ElementUtils();
		driver.navigate().refresh();
		E.ClearPopups(driver);
	}

	@When("Any popup Occurs please close that popup")
	public void any_popup_occurs_please_close_that_popup() throws InterruptedException {
		ElementUtils E = new ElementUtils();
		driver.navigate().refresh();
		E.ClearPopups(driver);
	}

	@When("select the From location")
	public void select_the_from_location() throws InterruptedException {
		test.log(LogStatus.INFO, "Sucessfully launched");
		SearchPage s = new SearchPage(driver);
		s.ClickFromLocation();
		s.SelectLocation("MAA");
		test.log(LogStatus.INFO, "Sucessfully selected the from Location as " +"MAA");


	}

	@When("select the to location")
	public void select_the_to_location() throws InterruptedException {
		SearchPage s = new SearchPage(driver);
		s.ClickToLocation();
		s.SelectLocation("BOM");
		test.log(LogStatus.INFO, "Sucessfully selected the to Location as " +"BOM");

	}

	@When("select the date")
	public void select_the_date() {
		SearchPage s = new SearchPage(driver);
		s.SelectADate("17");
		test.log(LogStatus.INFO, "Sucessfully selected the Date as " +"17");

	}

	@When("I Click on SearchButton")
	public void I_click_on_search_button() {
		SearchPage s = new SearchPage(driver);
		s.ClickOnSearchButton();
		test.log(LogStatus.INFO, "Sucessfully clicked the search button ");

	}

	@When("i see a OKGOTIT Popup click on it")
	public void i_see_okgoit_popup_click_on_it() throws InterruptedException {
		SearcResultPage srp = new SearcResultPage(driver);
		srp.waitForOkayGotIt();
		test.log(LogStatus.INFO, "Sucessfully clicked the okGOtIT popup ");

	}

	@Then("i validate the search text with the expected Text")
	public void validate_the_search_text_with_the_expected_text() {
		SearcResultPage srp = new SearcResultPage(driver);

		String searchResult = srp.WaitAndGetSearchText();
		SearchPage s = new SearchPage(driver);
		String screenshotPath= s.takescreenshot(driver);


		System.out.println(searchResult);
		s.ClickOnBackButton(driver);
		test.log(LogStatus.INFO, s.GetSearchResultValue());
		test.log(LogStatus.PASS, test.addScreenCapture(screenshotPath));

	}
}

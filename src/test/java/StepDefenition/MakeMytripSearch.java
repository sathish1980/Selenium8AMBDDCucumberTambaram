package StepDefenition;

import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import BrowserDriver.intilaizeBrowser;
import Commons.ElementUtils;
import Pages.SearcResultPage;
import Pages.SearchPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.PropertyFileHandle;

public class MakeMytripSearch extends intilaizeBrowser {

	String expectedResult = null;
	String actualResult = null;
	ElementUtils E = new ElementUtils();
	@Given("Launch the Browser and Enter the URL")
	public void launch_the_browser_and_enter_the_url() {
		Launch();
	}

	@Given("Click On Adds If Exist")
	public void click_on_adds_if_exist() throws InterruptedException {
		String URL = PropertyFileHandle.propreaddata().getProperty("URL");
		driver.get(URL);
		ElementUtils E = new ElementUtils();
		driver.navigate().refresh();
		E.CloseAdds(driver);
		E.ClearPopups(driver);

	}

	@When("I Select From Location From FromDropdown")
	public void i_select_from_location_from_from_dropdown() throws InterruptedException{
		SearchPage s = new SearchPage(driver);

		test.log(LogStatus.INFO, "Browser is Launched sucessfully");
		Assert.assertEquals(s.GetApplicationTitle(), "MakeMyTrip - #1 Travel Website 50% OFF on Hotels, Flights & Holiday");
		s.ClickFromLocation();
		s.SelectLocation("MAA");
		test.log(LogStatus.INFO, "From location is sucessfully clicked and the selected value is : "+"MAA");

	}

	@When("I Select To Location From ToDropdown")
	public void i_select_to_location_from_to_dropdown() throws InterruptedException {
		SearchPage s = new SearchPage(driver);
		s.ClickToLocation();
		s.SelectLocation("BLR");
		test.log(LogStatus.INFO, "To location is sucessfully clicked and the selected value is : "+"BLR");
		expectedResult = s.GetSearchResultValue();

	}

	@When("I Select Depature Date From Depature")
	public void i_select_depature_date_from_depature() {
		SearchPage s = new SearchPage(driver);
		s.SelectADate("30");
		test.log(LogStatus.INFO, "Date selection is sucessfully clicked and the selected value is : "+"30");

	}

	@When("I Click On Search Button")
	public void i_click_on_search_button() {
		SearchPage s = new SearchPage(driver);

		s.ClickOnSearchButton();
		test.log(LogStatus.INFO, "Search button is clicked sucessfully");

	}

	@When("I should get a OKGOTIT Popup and Upcon clicking OK")
	public void i_should_get_a_okgotit_popup_and_upcon_clicking_ok() throws InterruptedException {
		SearchPage s = new SearchPage(driver);
		SearcResultPage sp = new SearcResultPage(driver);
		sp.waitForOkayGotIt();
		test.log(LogStatus.INFO, "POP up is clicked sucessfully");
		actualResult = sp.WaitAndGetSearchText();

	}

	@Then("I Should get the Search Result based on the given input")
	public void i_should_get_the_search_result_based_on_the_given_input() throws InterruptedException {
		SearchPage s = new SearchPage(driver);
		String screenShot = s.takescreenshot(driver);
		Assert.assertEquals(actualResult, expectedResult);
		E.ClickOnBackButton(driver);
		test.log(LogStatus.INFO, "Back button clicked sucessfuly");
		E.ClearPopups(driver);
		// test.log(LogStatus.INFO, "All Steps are executed sucessfully");
		test.log(LogStatus.PASS, test.addScreenCapture(screenShot));
	}


}

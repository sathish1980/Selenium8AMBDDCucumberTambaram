package StepDefenition;

import com.relevantcodes.extentreports.LogStatus;

import BrowserDriver.intilaizeBrowser;
import Pages.SearchPage;
import io.cucumber.java.en.When;

public class makemytripmultisdata extends intilaizeBrowser{

	String expectedResult= null;


	@When("I Select From ([^\"]*)$ FromDropdown")
	public void i_select_from_from_dropdown(String FromLocation) throws InterruptedException {
		SearchPage s = new SearchPage(driver);

		test.log(LogStatus.INFO, "Browser is Launched sucessfully");
		// Assert.assertEquals(s.GetApplicationTitle(), "MakeMyTrip - #1 Travel Website 50% OFF on Hotels, Flights & Holiday");
		s.ClickFromLocation();
		s.SelectLocation(FromLocation);
		test.log(LogStatus.INFO, "From location is sucessfully clicked and the selected value is : "+FromLocation);

	}

	@When("I Select To ([^\"]*)$ From ToDropdown")
	public void i_select_to_from_to_dropdown(String ToLocation) throws InterruptedException {
		SearchPage s = new SearchPage(driver);
		s.ClickToLocation();
		s.SelectLocation(ToLocation);
		test.log(LogStatus.INFO, "To location is sucessfully clicked and the selected value is : "+ToLocation);
		expectedResult = s.GetSearchResultValue();

	}

	@When("I Select Depature ([^\"]*)$ From Depature")
	public void i_select_depature_from_depature(Integer int1) {
		SearchPage s = new SearchPage(driver);
		s.SelectADate(int1.toString());
		test.log(LogStatus.INFO, "Date selection is sucessfully clicked and the selected value is : "+"30");
	}

}

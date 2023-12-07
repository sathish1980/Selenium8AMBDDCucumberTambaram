package Commons;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils
{

	public void EnterInToTextBox(WebElement elementToEnter, String textToBeEnter)
	{
		if(elementToEnter.isDisplayed())
		{
			elementToEnter.clear();
			elementToEnter.sendKeys(textToBeEnter);
		}
	}

	public void ButtonClick(WebElement buttonWebelement)
	{
		if(buttonWebelement.isDisplayed())
		{
			buttonWebelement.click();
		}

	}

	public void RadioButtonClick(WebElement buttonWebelement)
	{
		if(buttonWebelement.isSelected()==false)
		{
			buttonWebelement.click();
		}

	}

	public void checkBoxClick(WebElement buttonWebelement)
	{
		if(buttonWebelement.isSelected()==false)
		{
			buttonWebelement.click();
		}

	}

	public void uncheckBoxClick(WebElement buttonWebelement)
	{
		if(buttonWebelement.isSelected()==true)
		{
			buttonWebelement.click();
		}

	}

	public void Explicitwaitforelementobeclickable(WebDriver driver,WebElement elementobeclickableWebelement)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable(elementobeclickableWebelement));

	}

	public void Explicitwaitforvisibilityofelement(WebDriver driver,WebElement elementobeclickableWebelement)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfAllElements(elementobeclickableWebelement));

	}

	public void Explicitwaitforpresencefelement(WebDriver driver,By elementobeclickableWebelement)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.presenceOfElementLocated(elementobeclickableWebelement));

	}

	public static String takescreenshot(WebDriver driver)
	{
		Date date = new Date();
		//This method returns the time in millis
		long timeMilli = date.getTime();
		String date_v= String.valueOf(timeMilli);
		//System.out.println(date_v);
		TakesScreenshot ts =(TakesScreenshot)driver;
		File sourcefile= ts.getScreenshotAs(OutputType.FILE);
		File Destinationfile= new File(System.getProperty("user.dir")+"//Screenshot//"+date_v+".png");
		try {
			FileUtils.copyFile(sourcefile, Destinationfile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return Destinationfile.toString();
	}


	public void SelectAValueFromList(WebDriver driver, String expectedloaction)
	{
		List<WebElement> AllValues = driver.findElements(By.xpath("//*[@class='react-autosuggest__suggestions-list']//li"));
		for (WebElement eachElement : AllValues )
		{
			String actualFromLocation = eachElement.findElement(By.cssSelector("div[class*='makeFlex']>div[class*='pushRight']")).getText();
			if(expectedloaction.equalsIgnoreCase(actualFromLocation))
			{
				eachElement.click();
				break;
			}
		}
	}

	public void ClickOnBackButton(WebDriver driver)
	{
		driver.navigate().back();
	}

	public String GetAttribute(WebElement elementToRetrive,String retriveAttribute)
	{
		if(elementToRetrive.isDisplayed())
		{
			return elementToRetrive.getAttribute(retriveAttribute);
		}
		return null;
	}

	public String GetText(WebElement elementToRetrive)
	{
		if(elementToRetrive.isDisplayed())
		{
			return elementToRetrive.getText();
		}
		return null;
	}


	public void CloseAdds(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(2000);
		List<WebElement> elementExist = driver.findElements(By.xpath("//*[@data-cy='closeModal']"));
		if(elementExist.size()>0)
		{
			Explicitwaitforelementobeclickable(driver,driver.findElement(By.xpath("//*[@data-cy='closeModal']")));
			driver.findElement(By.xpath("//*[@data-cy='closeModal']")).click();

		}

	}

	public void ClearPopups(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(5000);
		List<WebElement> AllFrames =driver.findElements(By.tagName("iframe"));
		for(int i=0;i<AllFrames.size();i++)
		{
			driver.switchTo().frame(i);
			List<WebElement> elementExist = driver.findElements(By.xpath("//*[@class='close']"));
			if(elementExist.size()>0)
			{
				Explicitwaitforelementobeclickable(driver,driver.findElement(By.xpath("//*[@class='close']")));
				driver.findElement(By.xpath("//*[@class='close']")).click();
				driver.switchTo().defaultContent();
			}
			driver.switchTo().defaultContent();
		}
	}
}

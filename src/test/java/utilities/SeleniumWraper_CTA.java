package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class SeleniumWraper_CTA {

	int seconds;

	protected static WebDriver driver;

	public SeleniumWraper_CTA(WebDriver driver) {
		SeleniumWraper_CTA.driver = driver;
	}

	public abstract boolean isPageLoaded();

	public boolean isPageLoaded(By locator, String textToSearch) {
		WebDriverWait wait = new WebDriverWait(driver, 60, 200);
		try {
			wait.until(ExpectedConditions.textToBe(locator, textToSearch));
		} catch (Exception e) {
			return false;

		}
		return true;

	}

	// Wrapper
	public void writeToElement(By locator, String text) {

		driver.findElement(locator).clear();
		driver.findElement(locator).sendKeys(text);
	}

	public void writeToElementWithoutClear(By locator, String text) throws InterruptedException {
		waitForElement(locator);
		driver.findElement(locator).sendKeys(text);
	}

	// Wrapper
	public void hitEnterToElement(By locator) {
		// wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		driver.findElement(locator).sendKeys(Keys.chord(Keys.RETURN));

	}

	public void hitTabToElement(By locator) {
		// wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		driver.findElement(locator).sendKeys(Keys.chord(Keys.TAB));

	}

	public void hitBackspaceToElement(By locator) {
		// wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		driver.findElement(locator).sendKeys(Keys.chord(Keys.BACK_SPACE));

	}

	// Wrapper
	public void clickElement(By locator) throws InterruptedException {

		waitForElement(locator);
		driver.findElement(locator).click();
	}

	public void FileInputElement(By locator, String text) {
		driver.findElement(locator).sendKeys(text);
		;

	}

	public void scrollToelement(By locator) {
		WebElement element = driver.findElement(locator);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", element);
	}

	public void selectFromListByVisibleText(By locator, String vText) {
		Select listObj = new Select(driver.findElement(locator));
		listObj.selectByVisibleText(vText);
	}

	public void selectFromListByValue(By locator, String value) {
		Select listObj = new Select(driver.findElement(locator));
		listObj.selectByValue(value);
	}

	public String getElementText(By locator) {
		return driver.findElement(locator).getText();
	}

	public void waitForElement(By by) throws InterruptedException {
		seconds = 0;
		while (seconds < 60) {
			try {
				driver.findElement(by).isDisplayed();
				Exception e = new Exception();
				if (!driver.findElement(by).isEnabled())
					throw e;
				return;
			} catch (Exception e) {
				Thread.sleep(1000);
				seconds++;
				waitForElement(by);
			}
		}
	}

	
	
	public void selectFirstValue(By locator)
	{
		//driver.findElement(locator).sendKeys(Keys.chord(Keys.ARROW_DOWN));
		driver.findElement(locator).sendKeys(Keys.chord(Keys.RETURN));
	}
	
	public void switchToFrame(String frame) {
		driver.switchTo().frame(frame);
	}
	public void clickElementJS(By locator) throws InterruptedException {
		//waitForElement(locator);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(locator));
		}

}

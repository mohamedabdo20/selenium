package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class testNG 
{
	@Test
	public void publicvoid() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://google.com");
		driver.close();

	}
}

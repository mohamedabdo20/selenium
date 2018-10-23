package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.SeleniumWraper_CTA;


public class GeneralPages extends SeleniumWraper_CTA {

	private By Iagree = By.id("cbTncVehicleRenewal");
	private By StartProcessbtn = By.id("btnStartProcess");
	private By closeHappiniesbtn = By.xpath("//*[@class='fancybox-item fancybox-close']");
	
	

	public void applyForService() throws InterruptedException {
		clickElement(Iagree);
		clickElement(StartProcessbtn);
	}
	
	public void closehappinies() throws InterruptedException {
		clickElement(closeHappiniesbtn);
	}
	
	

	public GeneralPages(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isPageLoaded() {
		// TODO Auto-generated method stub
		return false;
	}

}
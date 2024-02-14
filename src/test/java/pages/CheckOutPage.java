package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage {
	@FindBy(id="s-name")
	WebElement name;
	
	@FindBy(id="s-surname")
	WebElement surname;
	
	@FindBy(id="s-address")
	WebElement address;
	
	@FindBy(id="s-zipcode")
	WebElement zipcode;
	
	@FindBy(id="s-city")
	WebElement city;
	
	@FindBy(id="s-company")
	WebElement company;
	
	@FindBy(xpath="//input[@id='asap']")
	WebElement rad;
	
	@FindBy(xpath="//button[text()='Buy']")
	WebElement buyBtn;
	
	@FindBy(xpath="//h1[text()='Checkout']")
	WebElement chkT;
	
	@FindBy(xpath="//p[text()=\"All good, order is on the way. Thank you!!\"]")
	WebElement cofrm;
	public CheckOutPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void buy() {
		name.sendKeys("Praga");
		surname.sendKeys("sayee");
		address.sendKeys("chennai");
		zipcode.sendKeys("34667");
		city.sendKeys("chennai");
		company.sendKeys("zuci");
		rad.click();
		buyBtn.click();
	}
	
	public String checkHeading()
	{
		 return chkT.getText();
	}
	
	public String confirm() {
		return cofrm.getText();
	}

}

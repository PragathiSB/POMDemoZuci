package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {
	@FindBy(css="ul li.preview")
	WebElement itemIcon;
	
	@FindBy(xpath="//button[contains(text(),'Add to cart')]")
	WebElement addToBtn;
	
	public SearchResultPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void viewItemDetail()
	{
		itemIcon.click();
	}
	public void addToCart()
	{
		addToBtn.click();
	}
	

}

package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {

	@FindAll(value= {@FindBy(css="ul li")})
	List<WebElement> items;
	
	@FindBy(id="billing-coupon")
	WebElement includeCoupon;
	
	@FindBy(xpath="//button[contains(text(),'Empty Cart')]")
	WebElement emptyCart;
	
	@FindBy(xpath="//button[contains(text(),'Checkout')]")
	WebElement chkOutBtn;
	
	public ShoppingCartPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public boolean isItemAdded()
	{
		if(items.size()>0)
		{
			return true;
		}
		else
			return false;
	}
	public void addCoupon()
	{
		includeCoupon.click();
	}
	
	public void doCheckout()
	{
		chkOutBtn.click();
	}
	
	public void emptyCheckout() {
		emptyCart.click();
	}
	
	}



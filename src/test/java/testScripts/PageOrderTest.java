package testScripts;
 
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
 
import base.TestBase;
import pages.CheckOutPage;
import pages.HomePage;
import pages.SearchResultPage;
import pages.ShoppingCartPage;
 
public class PageOrderTest {
	WebDriver driver;
	HomePage homePage;
	SearchResultPage resultPage;
    ShoppingCartPage cartPage;
    CheckOutPage chk;
  public PageOrderTest() {
	  TestBase.initDriver();
	  driver = TestBase.getDriver();
	  homePage = new HomePage(driver);
	  resultPage=new SearchResultPage(driver);
	  cartPage=new ShoppingCartPage(driver);
	  chk=new CheckOutPage(driver);
  }
  @BeforeTest
  public void setup()
  {
	  TestBase.openUrl("http://danube-webshop.herokuapp.com/");
  }
  @Test(priority=1)
  public void addToCartTest()
  {
	  homePage.searchItem("Parry Hotter");
	  resultPage.viewItemDetail();
	  resultPage.addToCart();
	  boolean isAdded=cartPage.isItemAdded();
	  Assert.assertTrue(isAdded);
 
  }
  @Test(priority=2)
  public void checkoutTest() {
	  cartPage.addCoupon();
	  cartPage.doCheckout();
  }
  @Test(priority=3)
  public void checkoutForm()
  {
	  String hed=chk.checkHeading();
	 Assert.assertEquals(hed, "Checkout");
	 chk.buy();
	 String cfrm=chk.confirm();
	 Assert.assertEquals(cfrm, "All good, order is on the way. Thank you!!");
	
  } 
}
 
